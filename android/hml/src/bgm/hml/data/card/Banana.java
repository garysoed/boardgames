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
public class Banana extends CardSpec {

  public Banana(Context context) {
    super(
        context.getString(R.string.banana_name),
        String.format(
            context.getString(R.string.banana_desc),
            context.getString(R.string.energy)),
        CardClass.STAPLE, CONSUMABLE,
        (CardTribe) null,
        1,
        25);
  }
}
