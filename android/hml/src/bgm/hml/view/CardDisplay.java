package bgm.hml.view;

import bgm.hml.decorator.CardOnLongClickListener;
import bgm.hml.decorator.HasCardSpec;
import bgm.hml.decorator.HasNameField;

/**
 *
 */
public interface CardDisplay extends HasCardSpec, HasNameField {

  void setName(CharSequence name);

  /**
   * Sets the {@link CardOnLongClickListener}. The implementor must update the view with this listener.
   * @param listener the {@link CardOnLongClickListener} to set.
   */
  void setCardOnLongClickListener(CardOnLongClickListener listener);

  CardOnLongClickListener getCardOnLongClickListener();
}
