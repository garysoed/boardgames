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
public class PlayView extends ScrollView {

  private final ViewGroup container;

  public PlayView(Context context, AttributeSet attrs) {
    super(context, attrs);
    LayoutInflater.from(context).inflate(R.layout.hand, this, true /* attachToRoot */);
    this.container = (ViewGroup) this.findViewById(R.id.container);
  }

  public void playCard(CardSpec card) {
  }

  public void unplayLastCard() {
    this.container.removeViewAt(this.container.getChildCount() - 1);
  }
}
