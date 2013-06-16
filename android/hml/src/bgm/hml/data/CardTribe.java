package bgm.hml.data;

import bgm.hml.R;

/**
 *
 */
public enum CardTribe {
  CAT(R.string.cat),
  ROBOT(R.string.robot),
  SPIRIT(R.string.spirit),
  TEACHER(R.string.teacher);

  private final int stringResourceId;

  private CardTribe(int stringResourceId) {
    this.stringResourceId = stringResourceId;
  }

  public int getStringResourceId() {
    return stringResourceId;
  }
}
