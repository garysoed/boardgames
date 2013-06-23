package bgm.hml.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import bgm.hml.R;
import bgm.hml.data.CardSpec;
import bgm.hml.decorator.CardDecorator;
import org.jetbrains.annotations.Nullable;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 *
 */
public class CardView extends LinearLayout implements CardDisplay {

  private CardSpec cardSpec;

  public CardView(Context context, AttributeSet attrs) {
    super(context, attrs);
    LayoutInflater.from(context).inflate(R.layout.card, this, true /* attachToRoot */);
  }

  @Override
  public void setName(CharSequence name) {
    ((TextView) this.findViewById(R.id.cardName)).setText(name);
  }

  @Override
  @Nullable
  public CardSpec getCardSpec() {
    return cardSpec;
  }

  @Override
  public void setCardSpec(@Nullable CardSpec cardSpec) {
    this.cardSpec = cardSpec;
    if (cardSpec != null) {
      this.setName(cardSpec.getName());
      this.setBackgroundColor(CardDecorator.getCardBackground(cardSpec));
    } else {
      this.setName("");
      this.setBackgroundColor(0);
    }
  }
}
