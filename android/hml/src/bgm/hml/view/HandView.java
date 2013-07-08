package bgm.hml.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ScrollView;
import bgm.common.util.ReusingCache;
import bgm.hml.R;
import bgm.hml.data.CardSpec;
import com.google.common.base.Supplier;

/**
 *
 */
public class HandView extends ScrollView {

  private final ViewGroup container;
  private final ReusingCardCache cache;

  public HandView(Context context, AttributeSet attrs) {
    super(context, attrs);
    LayoutInflater.from(context).inflate(R.layout.hand, this, true /* attachToRoot */);
    this.container = (ViewGroup) this.findViewById(R.id.container);
    this.cache = new ReusingCardCache(context);
  }

  public void addCard(CardSpec cardSpec) {
    CardView cardView = cache.get();
    cardView.setCardSpec(cardSpec);
    container.addView(cardView);
  }

  private static class ReusingCardCache extends ReusingCache<CardView> {

    public ReusingCardCache(final Context context) {
      super(new Supplier<CardView>() {

        @Override
        public CardView get() {
          return new CardView(context, (AttributeSet) null);
        }
      });
    }
  }
}
