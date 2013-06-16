package bgm.hml.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import bgm.hml.R;
import bgm.hml.data.CardSpec;
import bgm.hml.decorator.CardDecorator;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 *
 */
public class CardView extends LinearLayout implements CardDisplay {

  private final CardSpec cardSpec;

  public CardView(Context context, CardSpec cardSpec) {
    super(context);
    this.cardSpec = checkNotNull(cardSpec, "cardSpec");

    LayoutInflater.from(context).inflate(R.layout.card, this, true /* attachToRoot */);
    CardDecorator.decorate(this);
  }

  @Override
  public void setName(CharSequence name) {
    ((TextView) this.findViewById(R.id.cardName)).setText(name);
  }

  @Override
  public CardSpec getCardSpec() {
    return cardSpec;
  }
}
