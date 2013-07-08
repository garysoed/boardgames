package bgm.hml.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import bgm.hml.R;
import bgm.hml.data.CardSpec;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 *
 */
public class HandView extends ListView {

  private final HandAdapter adapter;

  public HandView(Context context, AttributeSet attrs) {
    super(context, attrs);
    this.adapter = new HandAdapter(context);
    this.setAdapter(adapter);
  }

  public void addCard(CardSpec cardSpec) {
    adapter.add(cardSpec);
  }

  private static class HandAdapter extends ArrayAdapter<CardSpec> {

    private final List<CardSpec> cardSpecs;
    private final Ordering<CardSpec> cardSpecOrdering;

    public HandAdapter(Context context) {
      this(context, Lists.<CardSpec>newArrayList());
    }

    private HandAdapter(Context context, List<CardSpec> cardSpecs) {
      super(context, R.layout.card, cardSpecs);
      this.cardSpecs = checkNotNull(cardSpecs, "cardSpecs");
      this.cardSpecOrdering = CardSpec.getOrdering();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      CardView view;
      if (convertView == null) {
        view = new CardView(this.getContext(), (AttributeSet) null);
      } else {
        view = (CardView) convertView;
      }
      view.setCardSpec(cardSpecs.get(position));
      return view;
    }

    @Override
    public void add(CardSpec object) {
      super.add(object);
      this.sort();
    }

    private void sort() {
      this.sort(cardSpecOrdering);
    }
  }
}
