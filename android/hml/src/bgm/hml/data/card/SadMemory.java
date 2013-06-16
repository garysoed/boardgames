package bgm.hml.data.card;

import android.content.Context;
import bgm.hml.R;
import bgm.hml.data.CardClass;
import bgm.hml.data.CardSpec;
import bgm.hml.data.CardTribe;

import static bgm.hml.data.CardType.MEMORY;

/**
 *
 */
public class SadMemory extends CardSpec {

  public SadMemory(Context context) {
    super(
        context.getString(R.string.smemory_name),
        context.getString(R.string.smemory_desc),
        CardClass.STAPLE,
        MEMORY,
        (CardTribe) null,
        -1,
        10);
  }
}
