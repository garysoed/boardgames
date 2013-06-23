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

    ((CardView) findViewById(R.id.view)).setCardSpec(new Banana(this));
    ((CardView) findViewById(R.id.view1)).setCardSpec(new WaterBottle(this));
  }
}
