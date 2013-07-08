package bgm.common.util;

import com.google.common.base.Supplier;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Queues;

import java.util.Queue;

/**
 * Cache that keeps a collection of reusable objects. If there are not enough objects marked as
 * unused in the collection, the cache will create a new instance using the given {@link Supplier}.
 */
public class ReusingCache<T> {

  private final Supplier<T> supplier;
  private final Queue<T> unusedObjects;
  private final HashMultiset<T> usedObjects;

  public ReusingCache(Supplier<T> supplier) {
    this.supplier = supplier;
    unusedObjects = Queues.newPriorityQueue();
    usedObjects = HashMultiset.create();
  }

  public T get() {
    T toReturn;
    if (unusedObjects.isEmpty()) {
      toReturn = supplier.get();
    } else {
      toReturn = unusedObjects.remove();
    }
    usedObjects.add(toReturn);
    return toReturn;
  }

  public void markUnused(T object) {
    if (usedObjects.contains(object)) {
      usedObjects.remove(object);
      unusedObjects.add(object);
    } else {
      throw new IllegalArgumentException("Cannot find used object: " + object);
    }
  }
}
