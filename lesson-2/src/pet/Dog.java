package pet;

public class Dog extends Pet {

  private Breed breed;

  private FeedType feedType;

  @Override
  public void say() {
    System.out.println("bark");
  }

  public void Walk() {
    System.out.println("Dog " + this.name + " is walking with owner");
  }

  public void Walk(String ownerName) {
    System.out.println("Dog " + this.name + " is walking with " + ownerName);
  }

  public enum Breed {
    LABRADOR_RETRIEVER,
    GERMAN_SHEPHERD,
    GOLDEN_RETRIEVER,
    BULLDOG,
    POODLE,
    BOXER,
    SIBERIAN_HUSKY,
    DOBERMAN_PINSCHER,
    ROTTWEILER,
    BEAGLE,
    DACHSHUND,
    CHIHUAHUA,
    YORKSHIRE_TERRIER,
    GREATDANE,
    AUSTRALIAN_SHEPHERD,
    BICHON_FRISE,
    BORDERCOLLIE,
    CAVALIERKING,
    CHARLES_SPANIEL,
    SHIHTZU,
    BOSTON_TERRIER
  }
}
