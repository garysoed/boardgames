package bgm.hml.decorator;

import bgm.hml.data.CardSpec;
import org.jetbrains.annotations.Nullable;

/**
 *
 */
public interface HasCardSpec {

  @Nullable CardSpec getCardSpec();

  void setCardSpec(@Nullable CardSpec cardSpec);
}
