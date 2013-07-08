package bgm.hml.data;

import bgm.hml.data.card.Banana;
import bgm.hml.data.card.RainCheck;
import bgm.hml.data.card.WaterBottle;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.Ordering;

import javax.annotation.Nullable;

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

  public static Ordering<CardSpec> getOrdering() {
    return Ordering.compound(ImmutableList.of(getOrderingByType(), getOrderingByShortName()));
  }

  /**
   * <ol>
   *   <li>Rewards - Consumable</li>
   *   <li>Rain Check</li>
   *   <li>Banana</li>
   *   <li>Water Bottle</li>
   *   <li>Friend - Cat</li>
   *   <li>Friend - Robot</li>
   *   <li>Friend - Spirit</li>
   *   <li>Friend - Teacher</li>
   *   <li>Action</li>
   *   <li>Rewards - Memory</li>
   *   <li>Memory</li>
   * </ol>
   * @return
   */
  private static Ordering<CardSpec> getOrderingByType() {
    return Ordering.natural()
        .onResultOf(new Function<CardSpec, Integer>() {

          @Override
          public Integer apply(CardSpec cardSpec) {
            CardClass cardClass = cardSpec.getCardClass();
            CardType cardType = cardSpec.getCardType();
            CardTribe cardTribe = cardSpec.getCardTribe();
            if (cardClass == CardClass.REWARDS && cardType == CardType.CONSUMABLE) {
              return 0;
            } else if (cardSpec instanceof RainCheck) {
              return 1;
            } else if (cardSpec instanceof Banana) {
              return 2;
            } else if (cardSpec instanceof WaterBottle) {
              return 3;
            } else if (cardTribe == CardTribe.CAT) {
              return 4;
            } else if (cardTribe == CardTribe.ROBOT) {
              return 5;
            } else if (cardTribe == CardTribe.SPIRIT) {
              return 6;
            } else if (cardTribe == CardTribe.TEACHER) {
              return 7;
            } else if (cardType == CardType.ACTION) {
              return 8;
            } else if (cardClass == CardClass.REWARDS && cardType == CardType.MEMORY) {
              return 9;
            } else if (cardType == CardType.MEMORY) {
              return 10;
            }
            return 11;
          }
        });
  }

  private static Ordering<CardSpec> getOrderingByShortName() {
    return Ordering.natural()
        .onResultOf(new Function<CardSpec, String>() {

          @Override
          public String apply(CardSpec cardSpec) {
            return cardSpec.getShortName().toString();
          }
        });
  }
}
