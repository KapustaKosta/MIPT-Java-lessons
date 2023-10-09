package pet;

public class Cat extends Pet{

  private Breed breed;

  private FeedType feedType;

  @Override
  public void say() {
    System.out.println("Meow");
  }

  public void walk()
  {
    System.out.println("Cat " + this.name + " is walking with owner");
  }

  public void walk(String ownerName)
  {
    System.out.println("Cat " + this.name + " is walking with " + ownerName);
  }

  public enum Breed
  {
    SIAMESE,
    BRITISH_SHORTHAIR,
    MAINECOON,
    PERSIAN,
    SPHYNX,
    BENGAL,
    RAGDOLL,
    SCOTTISH_FOLD,
    RUSSIAN_BLUE,
    NORWEGIAN_FOREST_CAT,
    SIBERIAN,
    ABYSSINIAN,
    BIRMAN,
    DEVONREX,
    CORNISHREX,
    AMERICAN_SHORTHAIR,
    TURKISH_VAN,
    HIMALAYAN,
    ORIENTAL_SHORTHAIR,
    EXOTIC_SHORTHAIR
  }
}