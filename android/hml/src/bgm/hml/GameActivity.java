package bgm.hml;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridLayout;
import bgm.hml.data.CardSpec;
import bgm.hml.data.card.*;
import bgm.hml.view.DraftView;
import bgm.hml.view.HandView;
import com.google.common.collect.ImmutableSet;

/**
 *x
 */
public class GameActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.game);

    DraftView draftDeck1 = new DraftView(this);
    draftDeck1.placeAtTop(ImmutableSet.of(new Automate(this)));

    DraftView draftDeck2 = new DraftView(this);
    draftDeck2.placeAtTop(ImmutableSet.of(new Automate(this)));

    DraftView draftDeck3 = new DraftView(this);
    draftDeck3.placeAtTop(ImmutableSet.of(new Automate(this)));

    DraftView draftDeck4 = new DraftView(this);
    draftDeck4.placeAtTop(ImmutableSet.of(new Automate(this)));

    DraftView bananaDeck = new DraftView(this);
    bananaDeck.placeAtTop(CardSpec.generateCopies(new Banana(this)));

    DraftView waterBottleDeck = new DraftView(this);
    waterBottleDeck.placeAtTop(CardSpec.generateCopies(new WaterBottle(this)));

    DraftView rainCheckDeck = new DraftView(this);
    rainCheckDeck.placeAtTop(CardSpec.generateCopies(new RainCheck(this)));

    DraftView sadMemoryDeck = new DraftView(this);
    sadMemoryDeck.placeAtTop(CardSpec.generateCopies(new SadMemory(this)));

    GridLayout gridLayout = (GridLayout) findViewById(R.id.shopGrid);
    gridLayout.addView(draftDeck1);
    gridLayout.addView(draftDeck2);
    gridLayout.addView(draftDeck3);
    gridLayout.addView(draftDeck4);
    gridLayout.addView(bananaDeck);
    gridLayout.addView(waterBottleDeck);
    gridLayout.addView(rainCheckDeck);
    gridLayout.addView(sadMemoryDeck);

    HandView hand = (HandView) this.findViewById(R.id.hand);
    hand.addCard(new Banana(this));
  }
}
