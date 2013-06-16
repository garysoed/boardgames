package bgm.hml.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ScrollView;
import bgm.hml.R;
import bgm.hml.data.CardSpec;

/**
 *
 */
public class HandView extends ScrollView {

  private final ViewGroup container;

  public HandView(Context context, AttributeSet attrs) {
    super(context, attrs);
    LayoutInflater.from(context).inflate(R.layout.hand, this, true /* attachToRoot */);
    this.container = (ViewGroup) this.findViewById(R.id.container);
  }

  public void addCard(CardSpec card) {
    CardView cardView = new CardView(this.getContext(), card);
    this.container.addView(cardView);
  }
}
