import java.util.Random;

public class Pet {
  protected String name;

  private double weight;

  private int age;

  public void Say(){}

  public enum FeedType
  {
    chip,
    expensive
  }
}

class Cat extends Pet{

  private Breed breed;

  private FeedType feedType;

  @Override
  public void Say() {
    System.out.println("Meow");
  }

  public void Walk()
  {
    System.out.println("Cat " + this.name + " is walking with owner");
  }

  public void Walk(String ownerName)
  {
    System.out.println("Cat " + this.name + " is walking with " + ownerName);
  }

  public enum Breed
  {
    Siamese,
    BritishShorthair,
    MaineCoon,
    Persian,
    Sphynx,
    Bengal,
    Ragdoll,
    ScottishFold,
    RussianBlue,
    NorwegianForestCat,
    Siberian,
    Abyssinian,
    Birman,
    DevonRex,
    CornishRex,
    AmericanShorthair,
    TurkishVan,
    Himalayan,
    OrientalShorthair,
    ExoticShorthair
  }
}

class Dog extends Pet{

  private Breed breed;

  private FeedType feedType;

  @Override
  public void Say() {
    System.out.println("bark");
  }

  public void Walk()
  {
    System.out.println("Dog " + this.name + " is walking with owner");
  }

  public void Walk(String ownerName)
  {
    System.out.println("Dog " + this.name + " is walking with " + ownerName);
  }

  public enum Breed
  {
    LabradorRetriever,
    GermanShepherd,
    GoldenRetriever,
    Bulldog,
    Poodle,
    Boxer,
    SiberianHusky,
    DobermanPinscher,
    Rottweiler,
    Beagle,
    Dachshund,
    Chihuahua,
    YorkshireTerrier,
    GreatDane,
    AustralianShepherd,
    BichonFrise,
    BorderCollie,
    CavalierKing,
    CharlesSpaniel,
    ShihTzu,
    BostonTerrier
  }
}

class Parrot extends Pet{

  public Country country;

  private boolean hasDocuments = false;
  @Override
  public void Say() {
    System.out.println("squawk");
  }

  public void Fly()
  {
    int min = 1;
    int max = 60;
    int minutes = min + (int)(Math.random() * ((max - min) + 1));

    System.out.println("A parrot " + name + " flew away, but "
        + "promised to return after " + minutes + " minutes");
  }

  public enum Country
  {
    Afghanistan,
    Albania,
    Algeria,
    Andorra,
    Angola,
    AntiguaandBarbuda,
    Argentina,
    Armenia,
    Australia,
    Austria,
    Azerbaijan,
    Bahamas,
    Bahrain,
    Bangladesh,
    Barbados,
    Belarus,
    Belgium,
    Belize,
    Benin,
    Bhutan,
    Bolivia,
    BosniaandHerzegovina,
    Botswana,
    Brazil,
    Brunei,
    Bulgaria,
    BurkinaFaso,
    Burundi,
    CaboVerde,
    Cambodia,
    Cameroon,
    Canada,
    CentralAfricanRepublic,
    Chad,
    Chile,
    China,
    Colombia,
    Comoros,
    Congo,
    CostaRica,
    CotedIvoire,
    Croatia,
    Cuba,
    Cyprus,
    Czechia,
    DemocraticRepublicoftheCongo,
    Denmark,
    Djibouti,
    Dominica,
    DominicanRepublic,
    EastTimor,
    Ecuador,
    Egypt,
    ElSalvador,
    EquatorialGuinea,
    Eritrea,
    Estonia,
    Eswatini,
    Ethiopia,
    Fiji,
    Finland,
    France,
    Gabon,
    Gambia,
    Georgia,
    Germany,
    Ghana,
    Greece,
    Grenada,
    Guatemala,
    Guinea,
    GuineaBissau,
    Guyana,
    Haiti,
    Honduras,
    Hungary,
    Iceland,
    India,
    Indonesia,
    Iran,
    Iraq,
    Ireland,
    Israel,
    Italy,
    Jamaica,
    Japan,
    Jordan,
    Kazakhstan,
    Kenya,
    Kiribati,
    Kuwait,
    Kyrgyzstan,
    Laos,
    Latvia,
    Lebanon,
    Lesotho,
    Liberia,
    Libya,
    Liechtenstein,
    Lithuania,
    Luxembourg,
    Madagascar,
    Malawi,
    Malaysia,
    Maldives,
    Mali,
    Malta,
    MarshallIslands,
    Mauritania,
    Mauritius,
    Mexico,
    Micronesia,
    Moldova,
    Monaco,
    Mongolia,
    Montenegro,
    Morocco,
    Mozambique,
    Myanmar,
    Namibia,
    Nauru,
    Nepal,
    Netherlands,
    NewZealand,
    Nicaragua,
    Niger,
    Nigeria,
    NorthKorea,
    NorthMacedonia,
    Norway,
    Oman,
    Pakistan,
    Palau,
    Panama,
    PapuaNewGuinea,
    Paraguay,
    Peru,
    Philippines,
    Poland,
    Portugal,
    Qatar,
    Romania,
    Russia,
    Rwanda,
    SaintKittsandNevis,
    SaintLucia,
    SaintVincentandtheGrenadines,
    Samoa,
    SanMarino,
    SaoTomeandPrincipe,
    SaudiArabia,
    Senegal,
    Serbia,
    Seychelles,
    SierraLeone,
    Singapore,
    Slovakia,
    Slovenia,
    SolomonIslands,
    Somalia,
    SouthAfrica,
    SouthKorea,
    SouthSudan,
    Spain,
    SriLanka,
    Sudan,
    Suriname,
    Sweden,
    Switzerland,
    Syria,
    Taiwan,
    Tajikistan,
    Tanzania,
    Thailand,
    Togo,
    Tonga,
    TrinidadandTobago,
    Tunisia,
    Turkey,
    Turkmenistan,
    Tuvalu,
    Uganda,
    Ukraine,
    UnitedArabEmirates,
    UnitedKingdom,
    UnitedStates,
    Uruguay,
    Uzbekistan,
    Vanuatu,
    VaticanCity,
    Venezuela,
    Vietnam,
    Yemen,
    Zambia,
    Zimbabwe
  }
}
