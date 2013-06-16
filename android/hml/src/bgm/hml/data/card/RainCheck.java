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
public class RainCheck extends CardSpec {

  public RainCheck(Context context) {
    super(
        context.getString(R.string.rcheck_name),
        String.format(
            context.getString(R.string.rcheck_desc),
            context.getString(R.string.nonstaple)),
        CardClass.STAPLE, CONSUMABLE,
        (CardTribe) null,
        0,
        20);
  }
}
