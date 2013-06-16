package bgm.hml.data;

import bgm.hml.R;

/**
 * In order of display order
 */
public enum CardType {
  ACTION(R.string.action),
  CONSUMABLE(R.string.consumable),
  FRIEND(R.string.friend),
  MEMORY(R.string.memory);

  private final int stringResourceId;

  private CardType(int stringResourceId) {
    this.stringResourceId = stringResourceId;
  }

  public int getStringResourceId() {
    return stringResourceId;
  }
}
