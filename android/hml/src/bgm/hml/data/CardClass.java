package bgm.hml.data;

import bgm.hml.R;

/**
 *
 */
public enum CardClass {
  STAPLE(R.string.staple),
  REWARDS(R.string.activity),
  DRAFT(R.string.draft);

  private final int stringResourceId;

  private CardClass(int stringResourceId) {
    this.stringResourceId = stringResourceId;
  }

  public int getStringResourceId() {
    return stringResourceId;
  }
}
