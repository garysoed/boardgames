package bgm.hml.data.card;

import android.content.Context;
import bgm.hml.R;
import bgm.hml.data.CardClass;
import bgm.hml.data.CardSpec;
import bgm.hml.data.CardTribe;

import static bgm.hml.data.CardType.CONSUMABLE;

/**
 *
 */
public class WaterBottle extends CardSpec {

  public WaterBottle(Context context) {
    super(
        context.getString(R.string.wbottle_name),
        String.format(
            context.getString(R.string.wbottle_desc),
            context.getString(R.string.cat),
            context.getString(R.string.spirit),
            context.getString(R.string.robot),
            context.getString(R.string.teacher)),
        CardClass.STAPLE, CONSUMABLE,
        (CardTribe) null,
        1,
        30);
  }
}
