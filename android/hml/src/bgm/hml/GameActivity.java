package bgm.hml;

import android.app.Activity;
import android.os.Bundle;
import bgm.hml.data.card.Banana;
import bgm.hml.data.card.RainCheck;
import bgm.hml.data.card.SadMemory;
import bgm.hml.data.card.WaterBottle;
import bgm.hml.view.CardPileView;
import bgm.hml.view.HandView;

/**
 *
 */
public class GameActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.game);

    CardPileView bananaPileView = (CardPileView) findViewById(R.id.bananaDraft);
    bananaPileView.setCardSpec(new Banana(this));
    bananaPileView.setCopies(10);
    CardPileView waterBottleView = (CardPileView) findViewById(R.id.waterBottleDraft);
    waterBottleView.setCardSpec(new WaterBottle(this));
    waterBottleView.setCopies(10);
    CardPileView rainCheckView = (CardPileView) findViewById(R.id.rainCheckDraft);
    rainCheckView.setCardSpec(new RainCheck(this));
    rainCheckView.setCopies(5);
    CardPileView sadMemoryView = (CardPileView) findViewById(R.id.sadMemoryDraft);
    sadMemoryView.setCardSpec(new SadMemory(this));
    sadMemoryView.setCopies(5);

    HandView handView = (HandView) findViewById(R.id.hand);
    handView.addCard(new Banana(this));
    handView.addCard(new Banana(this));
  }
}
