package bgm.hml.data;

import com.google.common.base.Objects;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMultiset;
import org.jetbrains.annotations.Nullable;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Represents information and logic about a card
 */
public abstract class CardSpec implements Cloneable {

  private final CharSequence shortName;
  private final CharSequence name;
  private final CharSequence description;
  private final CardType cardType;
  private final CardClass cardClass;
  @Nullable private final CardTribe cardTribe;
  private final int happiness;
  private final int copyCount;

  protected CardSpec(
      CharSequence name,
      CharSequence description,
      CardClass cardClass,
      CardType cardType,
      @Nullable CardTribe cardTribe,
      int happiness,
      int copyCount) {
    this(
        name,
        name,
        description,
        cardClass,
        cardType,
        cardTribe,
        happiness,
        copyCount);
  }

  protected CardSpec(
      CharSequence shortName,
      CharSequence name,
      CharSequence description,
      CardClass cardClass,
      CardType cardType,
      @Nullable CardTribe cardTribe,
      int happiness,
      int copyCount) {
    this.shortName = checkNotNull(shortName, "shortName");
    this.name = checkNotNull(name, "name");
    this.cardType = checkNotNull(cardType, "cardType");
    this.cardClass = checkNotNull(cardClass, "cardClass");
    this.cardTribe = cardTribe;
    this.description = checkNotNull(description, "description");
    this.happiness = happiness;
    this.copyCount = copyCount;
  }

  public CardType getCardType() {
    return cardType;
  }

  public CharSequence getShortName() {
    return shortName;
  }

  public CharSequence getName() {
    return name;
  }

  public CharSequence getDescription() {
    return description;
  }

  public int getHappiness() {
    return happiness;
  }

  public CardClass getCardClass() {
    return cardClass;
  }

  @Nullable
  public CardTribe getCardTribe() {
    return cardTribe;
  }

  public static ImmutableMultiset<CardSpec> generateCopies(CardSpec cardSpec) {
    try {
      ImmutableMultiset.Builder<CardSpec> builder = ImmutableMultiset.builder();
      for (int i = 0; i < cardSpec.copyCount; i++) {
        builder.add((CardSpec) cardSpec.clone());
      }
      return builder.build();
    } catch (CloneNotSupportedException e) {
      throw Throwables.propagate(e);
    }
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(
        name, description, cardType, cardClass, cardTribe, happiness, copyCount);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    final CardSpec other = (CardSpec) obj;
    return Objects.equal(this.name, other.name)
        && Objects.equal(this.description, other.description)
        && Objects.equal(this.cardType, other.cardType)
        && Objects.equal(this.cardClass, other.cardClass)
        && Objects.equal(this.cardTribe, other.cardTribe)
        && Objects.equal(this.happiness, other.happiness)
        && Objects.equal(this.copyCount, other.copyCount);
  }
}
