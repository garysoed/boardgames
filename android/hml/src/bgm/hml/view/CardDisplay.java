package bgm.hml.view;

import bgm.hml.decorator.HasCardSpec;
import bgm.hml.decorator.HasNameField;

/**
 *
 */
public interface CardDisplay extends HasCardSpec, HasNameField {

  void setName(CharSequence name);
}
