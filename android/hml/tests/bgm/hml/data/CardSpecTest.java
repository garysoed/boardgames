package bgm.hml.data;

import com.google.common.collect.Iterables;
import org.jetbrains.annotations.Nullable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static bgm.hml.data.CardClass.DRAFT;
import static bgm.hml.data.CardTribe.SPIRIT;
import static bgm.hml.data.CardType.ACTION;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotSame;

/**
 *
 */
@RunWith(JUnit4.class)
public class CardSpecTest {

  @Test
  public void generateCopiesGeneratesCopiesCorrectly() {
    int cloneCount = 5;
    TestCardSpec cardSpec = new TestCardSpec(
        "name",
        "description",
        DRAFT,
        ACTION,
        SPIRIT,
        23,
        cloneCount);
    Iterable<CardSpec> clones = CardSpec.generateCopies(cardSpec);
    assertEquals(cloneCount, Iterables.size(clones));
    for (CardSpec clone : clones) {
      assertNotSame(cardSpec, clone);
      assertEquals(cardSpec, clone);
    }
  }

  @Test
  public void allNamesHaveSufficientArguments() {
  }

  private static class TestCardSpec extends CardSpec {

    protected TestCardSpec(
        CharSequence name,
        CharSequence description,
        CardClass cardClass,
        CardType cardType,
        @Nullable CardTribe cardTribe,
        int happiness,
        int copyCount) {
      super(name, description, cardClass, cardType, cardTribe, happiness, copyCount);
    }
  }
}
