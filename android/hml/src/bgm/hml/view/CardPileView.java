package bgm.hml.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import bgm.hml.R;
import bgm.hml.data.CardSpec;
import bgm.hml.decorator.CardDecorator;
import bgm.hml.decorator.CardOnLongClickListener;
import org.jetbrains.annotations.Nullable;

/**
 *
 */
public class CardPileView extends LinearLayout implements CardDisplay {

  private int copies = 0;
  private CardOnLongClickListener onLongClickListener;
  private CardSpec cardSpec;

  public CardPileView(Context context, AttributeSet attrs) {
    super(context, attrs);
    LayoutInflater.from(context).inflate(R.layout.pile, this, true /* attachToRoot */);
  }

  public void setCopies(int copies) {
    this.copies = copies;
    updateCopies();
  }

  private void updateCopies() {
    ((TextView) this.findViewById(R.id.pileSize)).setText(Integer.toString(copies));
  }

  @Override
  public void setName(CharSequence name) {
    ((TextView) this.findViewById(R.id.cardName)).setText(name);
  }

  @Override
  public void setCardOnLongClickListener(CardOnLongClickListener listener) {
    this.onLongClickListener = listener;
    this.setOnLongClickListener(listener);
  }

  @Override
  public CardOnLongClickListener getCardOnLongClickListener() {
    return this.onLongClickListener;
  }

  @Nullable
  @Override
  public CardSpec getCardSpec() {
    return cardSpec;
  }

  @Override
  public void setCardSpec(@Nullable CardSpec cardSpec) {
    this.cardSpec = cardSpec;
    CardDecorator.decorate(this);
  }
}
