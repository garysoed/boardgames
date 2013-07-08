package bgm.hml.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Html;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import bgm.hml.R;
import bgm.hml.data.CardSpec;
import bgm.hml.decorator.CardDecorator;
import bgm.hml.decorator.CardOnLongClickListener;
import org.jetbrains.annotations.Nullable;

import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Displays a single card.
 */
public class CardView extends LinearLayout implements CardDisplay {

  private CardSpec cardSpec;
  private CardOnLongClickListener cardOnLongClickListener;

  public CardView(Context context, AttributeSet attrs) {
    super(context, attrs);
    LayoutInflater.from(context).inflate(R.layout.card, this, true /* attachToRoot */);
  }

  @Override
  public void setName(CharSequence name) {
    ((TextView) this.findViewById(R.id.cardName)).setText(name);
  }

  @Override
  public void setCardOnLongClickListener(CardOnLongClickListener listener) {
    this.cardOnLongClickListener = listener;
    this.setOnLongClickListener(listener);
  }

  @Override
  public CardOnLongClickListener getCardOnLongClickListener() {
    return cardOnLongClickListener;
  }

  @Override
  @Nullable
  public CardSpec getCardSpec() {
    return cardSpec;
  }

  @Override
  public void setCardSpec(@Nullable CardSpec cardSpec) {
    this.cardSpec = cardSpec;
    CardDecorator.decorate(this);
  }
}
