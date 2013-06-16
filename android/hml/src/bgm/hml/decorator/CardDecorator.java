package bgm.hml.decorator;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Html;
import android.view.View;
import bgm.hml.R;
import bgm.hml.data.CardSpec;
import bgm.hml.data.card.Banana;
import bgm.hml.data.card.RainCheck;
import bgm.hml.data.card.SadMemory;
import bgm.hml.data.card.WaterBottle;
import bgm.hml.view.CardDisplay;

import static android.graphics.Color.argb;
import static bgm.hml.data.CardClass.ACTIVITY;
import static bgm.hml.data.CardTribe.*;
import static bgm.hml.data.CardType.CONSUMABLE;

/**
 *
 */
public class CardDecorator {

  public static <T extends View & CardDisplay> void decorate(T view) {
    CardSpec cardSpec = view.getCardSpec();
    int backgroundColor;

    // Staples
    if (cardSpec instanceof Banana) {
      backgroundColor = argb(255, 255, 255, 0);
    } else if (cardSpec instanceof WaterBottle) {
      backgroundColor = argb(255, 0, 255, 255);
    } else if (cardSpec instanceof RainCheck) {
      backgroundColor = argb(255, 255, 0, 255);
    } else if (cardSpec instanceof SadMemory) {
      backgroundColor = argb(255, 128, 128, 128);

      // Friends
    } else if (cardSpec.getCardTribe() == CAT) {
      backgroundColor = argb(255, 150, 75, 75);
    } else if (cardSpec.getCardTribe() == ROBOT) {
      backgroundColor = argb(255, 192, 192, 192);
    } else if (cardSpec.getCardTribe() == SPIRIT) {
      backgroundColor = argb(255, 116, 195, 101);
    } else if (cardSpec.getCardTribe() == TEACHER) {
      backgroundColor = argb(255, 233, 150, 122);

    } else if (cardSpec.getCardClass() == ACTIVITY) {
      backgroundColor = argb(255, 0, 0, 255);
    } else if (cardSpec.getCardType() == CONSUMABLE) {
      backgroundColor = argb(255, 0, 255, 0);
    } else {
      // Assume action card
      backgroundColor = argb(255, 255, 0, 0);
    }

    view.setBackgroundColor(backgroundColor);
    view.setName(cardSpec.getName());
    view.setOnLongClickListener(new RealLongClickListener());
  }

  private static class RealLongClickListener implements View.OnLongClickListener {

    private static final String SEPARATOR = " - ";

    @Override
    public boolean onLongClick(View view) {
      CardDisplay cardDisplay = (CardDisplay) view;
      CardSpec cardSpec = cardDisplay.getCardSpec();

      Context context = view.getContext();
      AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
      dialogBuilder.setTitle(cardSpec.getName());
      dialogBuilder.setMessage(
          Html.fromHtml(String.format(
              context.getString(R.string.card_desc),
              renderCardSpec(context, cardSpec),
              cardSpec.getHappiness(),
              cardSpec.getDescription())));
      dialogBuilder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) { }
      });
      dialogBuilder.create().show();
      return true;
    }

    private String renderCardSpec(Context context, CardSpec cardSpec) {
      StringBuilder builder = new StringBuilder();
      builder
          .append(context.getString(cardSpec.getCardClass().getStringResourceId()))
          .append(SEPARATOR)
          .append(context.getString(cardSpec.getCardType().getStringResourceId()));
      if (cardSpec.getCardTribe() != null) {
        builder
            .append(SEPARATOR)
            .append(context.getString(cardSpec.getCardTribe().getStringResourceId()));
      }
      return builder.toString();
    }
  }
}
