package bgm.hml.decorator;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import bgm.hml.data.CardSpec;
import bgm.hml.view.CardDisplay;

/**
* {@link View.OnLongClickListener} for {@link CardDecorator}.
*/
public class CardOnLongClickListener implements View.OnLongClickListener {

  @org.jetbrains.annotations.Nullable private Dialog descriptionDialog;

  @Override
  public boolean onLongClick(View view) {
    CardDisplay cardDisplay = (CardDisplay) view;

    if (this.descriptionDialog == null && cardDisplay.getCardSpec() != null) {
      this.descriptionDialog = createDialog(cardDisplay.getCardSpec(), view.getContext());
    }
    this.descriptionDialog.show();
    return true;
  }

  private AlertDialog createDialog(CardSpec cardSpec, Context context) {
    AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
    dialogBuilder.setTitle(cardSpec.getName());
    dialogBuilder.setMessage(CardDecorator.renderCardDescription(
        cardSpec, context));
    dialogBuilder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialogInterface, int i) { }
    });
    return dialogBuilder.create();
  }

  public void reset() {
    this.descriptionDialog = null;
  }
}
