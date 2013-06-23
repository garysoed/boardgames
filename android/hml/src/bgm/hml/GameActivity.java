package bgm.hml;

import android.app.Activity;
import android.os.Bundle;
import bgm.hml.data.card.*;
import bgm.hml.view.CardView;

/**
 *
 */
public class GameActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.game);

    ((CardView) findViewById(R.id.bananaDraft)).setCardSpec(new Banana(this));
    ((CardView) findViewById(R.id.waterBottleDraft)).setCardSpec(new WaterBottle(this));
    ((CardView) findViewById(R.id.rainCheckDraft)).setCardSpec(new RainCheck(this));
    ((CardView) findViewById(R.id.sadMemoryDraft)).setCardSpec(new SadMemory(this));
  }
}
