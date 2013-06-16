package bgm.hml.data.card;

import android.content.Context;
import bgm.hml.R;
import bgm.hml.data.CardSpec;
import bgm.hml.data.CardTribe;

import static bgm.hml.data.CardClass.DRAFT;
import static bgm.hml.data.CardType.ACTION;

/**
 *
 */
public class Automate extends CardSpec {

  public Automate(Context context) {
    super(
        context.getString(R.string.automate_name),
        String.format(
            context.getString(R.string.automate_desc),
            context.getString(R.string.activity),
            context.getString(R.string.effort)),
        DRAFT,
        ACTION,
        (CardTribe) null,
        1,
        4);
  }
}
