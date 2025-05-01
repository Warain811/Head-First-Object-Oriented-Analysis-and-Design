import java.util.Iterator;
import java.util.List;

public class FindGuitarAndMandolinTester {

  public static void main(String[] args) {
    // Set up Rick's guitar inventory
    Inventory inventory = new Inventory();
    initializeInventory(inventory);

    GuitarSpec whatGuitarErinLikes = 
      new GuitarSpec(Builder.FENDER, "Stratocastor", 
                    Type.ELECTRIC, 6, Wood.ALDER, Wood.ALDER);

    MandolinSpec whatMandolinErinLikes =
      new MandolinSpec(Builder.GIBSON, "Stratosphere",
                    Type.ELECTRIC, Style.A, Wood.ALDER, Wood.ALDER);

    List<Guitar> matchingGuitars = inventory.search(whatGuitarErinLikes);
    List<Mandolin> matchingMandolins = inventory.search(whatMandolinErinLikes);

    if (!matchingGuitars.isEmpty()) {
      System.out.println("Erin, you might like these guitars:");
      for (Iterator<Guitar> i = matchingGuitars.iterator(); i.hasNext(); ) {
        Guitar guitar = (Guitar)i.next();
        GuitarSpec spec = guitar.getSpec();
        System.out.println("  We have a " +
          spec.getBuilder() + " " + spec.getModel() + " " +
          spec.getType() + " guitar:\n     " +
          spec.getBackWood() + " back and sides,\n     " +
          spec.getNumStrings() + " strings,\n     " +
          spec.getTopWood() + " top.\n  You can have it for only $" +
          guitar.getPrice() + "!\n  ----");
      }
    } else {
      System.out.println("Sorry, Erin, we have no matching guitars for you.");
    }

    if (!matchingMandolins.isEmpty()) {
      System.out.println("Erin, you might like these mandolins:");
      for (Iterator<Mandolin> i = matchingMandolins.iterator(); i.hasNext(); ) {
        Mandolin mandolin = (Mandolin)i.next();
        MandolinSpec spec = mandolin.getSpec();
        System.out.println("  We have a " +
          spec.getBuilder() + " " + spec.getModel() + " " +
          spec.getType() + " mandolin:\n     " +
          spec.getBackWood() + " back and sides,\n     " +
          spec.getStyle() + " style,\n     " +
          spec.getTopWood() + " top.\n  You can have it for only $" +
          mandolin.getPrice() + "!\n  ----");
      }
    } else {
      System.out.println("Sorry, Erin, we have no matching mandolins for you.");
    }
  }

  private static void initializeInventory(Inventory inventory) {
    inventory.addInstrument("11277", 3999.95, 
      new GuitarSpec(Builder.COLLINGS, "CJ", Type.ACOUSTIC, 6,
                    Wood.INDIAN_ROSEWOOD, Wood.SITKA));
    inventory.addInstrument("V95693", 1499.95, 
      new GuitarSpec(Builder.FENDER, "Stratocastor", Type.ELECTRIC, 6,
                    Wood.ALDER, Wood.ALDER));
    inventory.addInstrument("V9512", 1549.95, 
      new GuitarSpec(Builder.FENDER, "Stratocastor", Type.ELECTRIC, 6,
                    Wood.ALDER, Wood.ALDER));
    inventory.addInstrument("BabajiEkisEkis", 1000, 
      new MandolinSpec(Builder.GIBSON, "Stratosphere", Type.ELECTRIC, Style.A,
                  Wood.ALDER, Wood.ALDER));
  }
}
