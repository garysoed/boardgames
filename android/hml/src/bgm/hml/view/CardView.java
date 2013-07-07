package bgm.hml.view;

import android.app.AlertDialog;
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
import org.jetbrains.annotations.Nullable;

import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 *
 */
public class CardView extends LinearLayout implements CardDisplay, View.OnLongClickListener {

  private CardSpec cardSpec;
  private AlertDialog descriptionDialog;

  public CardView(Context context, AttributeSet attrs) {
    super(context, attrs);
    LayoutInflater.from(context).inflate(R.layout.card, this, true /* attachToRoot */);
    this.setOnLongClickListener(this);
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
      this.setName(cardSpec.getShortName());
      this.setBackgroundColor(CardDecorator.getCardBackground(cardSpec));
    } else {
      this.setName("");
      this.setBackgroundColor(0);
    }
    if (this.descriptionDialog != null) {
      this.descriptionDialog = null;
    }
  }

  @Override
  public boolean onLongClick(View view) {
    CardDisplay cardDisplay = (CardDisplay) view;

    if (this.descriptionDialog == null) {
      this.descriptionDialog = createDialog(cardDisplay.getCardSpec(), view.getContext());
    }
    this.descriptionDialog.show();
    return true;
  }

  private AlertDialog createDialog(CardSpec cardSpec, Context context) {
    AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
    dialogBuilder.setTitle(cardSpec.getName());
    dialogBuilder.setMessage(CardDecorator.renderCardDescription(
        cardSpec, this.getContext()));
    dialogBuilder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialogInterface, int i) { }
    });
    return dialogBuilder.create();
  }
}
