package bgm.hml.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import bgm.hml.R;
import bgm.hml.data.CardSpec;
import bgm.hml.decorator.CardDecorator;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.util.ArrayList;

import static android.graphics.Color.BLACK;

/**
 *
 */
public class DraftView extends LinearLayout implements CardDisplay {

  // Cards in the deck. 0 = top of deck.
  private final ArrayList<CardSpec> cardSpecs;

  public DraftView(Context context) {
    super(context);
    cardSpecs = Lists.newArrayList();

    LayoutInflater.from(context).inflate(R.layout.deck, this, true /* attachToRoot */);
    this.decorate();
  }

  private void decorate() {
    if (!cardSpecs.isEmpty()) {
      CardDecorator.decorate(this);
    } else {
      setBackgroundColor(BLACK);
    }
    this.setLongClickable(!cardSpecs.isEmpty());

    TextView deckCount = (TextView) this.findViewById(R.id.deckCount);
    deckCount.setText(Integer.toString(cardSpecs.size()));
  }

  public ImmutableSet<CardSpec> draw(int count) {
    ImmutableSet.Builder<CardSpec> builder = ImmutableSet.builder();
    for (int i = 0; i < count && !cardSpecs.isEmpty(); i++) {
      builder.add(cardSpecs.remove(0));
    }
    this.decorate();
    return builder.build();
  }

  public void placeAtTop(Iterable<? extends CardSpec> cardSpecsToPlace) {
    for (CardSpec cardSpec : cardSpecsToPlace) {
      cardSpecs.add(0, cardSpec);
    }
    this.decorate();
  }

  @Override
  public CardSpec getCardSpec() {
    return Iterables.get(cardSpecs, 0);
  }

  @Override
  public void setName(CharSequence name) {
    ((TextView) this.findViewById(R.id.cardName)).setText(name);
  }
}
