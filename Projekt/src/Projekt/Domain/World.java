/* World class for modeling the entire in-game world
 */
package Projekt.Domain;

import java.util.HashMap;
import java.util.Set;

class World {

    Space entry;
    Space frugtOgGroent;
    Space koed;
    Space mejeriprodukter;
    Space sliksektion;
    Ending udgang;

    public HashMap<String, Space> spaceList = new HashMap<>();

    World () {
        entry = new Tutorial("Indgang");
        frugtOgGroent = new Space("Frugt og grønt");
        koed = new Space ("Kød");
        mejeriprodukter = new Space ("Mejeriprodukter");
        sliksektion = new Space ("Sliksektion");
        udgang = new Ending ("Udgang");

        spaceList.put("Indgang", entry);
        spaceList.put("Frugt og grønt", frugtOgGroent);
        spaceList.put("Kød", koed);
        spaceList.put("Mejeriprodukter", mejeriprodukter);
        spaceList.put("Udgang", sliksektion);

        entry.addEdge("Frugt og grønt", frugtOgGroent);
        entry.addEdge( "Kød", koed);
        entry.addEdge("Mejeriprodukter", mejeriprodukter);

        frugtOgGroent.addEdge("Kød", koed);
        frugtOgGroent.addEdge("Mejeriprodukter", mejeriprodukter);
        frugtOgGroent.addEdge("Udgang", udgang);

        koed.addEdge("Mejeriprodukter", mejeriprodukter);
        koed.addEdge("Frugt og grønt", frugtOgGroent);
        koed.addEdge("Sliksektion", sliksektion);
        koed.addEdge("Udgang", udgang);

        mejeriprodukter.addEdge("Udgang", udgang);
        mejeriprodukter.addEdge("Kød", koed);
        mejeriprodukter.addEdge("Sliksektion", sliksektion);
        mejeriprodukter.addEdge("Frugt og grønt", frugtOgGroent);

        sliksektion.addEdge("Kød", koed);
        sliksektion.addEdge("Mejeriprodukter", mejeriprodukter);

        this.entry = entry;


    }

    Space getEntry () {
        return entry;
    }

    public static class Tutorial extends Space {

        Tutorial(String name) {
            super(name);
        }

        @Override
        public void welcome() {
            System.out.println("Velkommen Spiller. Dette er et spil, som har til formål, at gøre dig klogere på, hvordan man kan"
            );
            System.out.println("formindske sit eget CO2-aftryk. Alle CO2-scores er taget ud fra DCA - Nationalt Center for Fødevarer og Landbrug og scoren kan oversættes til 'Klimaaftryk, kg CO2-ækv. pr kg fødevare'");
            System.out.println("Ledetråde du kan tage med, på din indkøbstur er: ");
            System.out.println("Importering af varer fra udlandet tilføjer som regel 0.2 til deres CO2-score ");
            System.out.println("Mejeriprodukter med mere fedt har som regel en højere CO2-score. Dette skyldes blandt andet, at mere koncentrering af mælk er et krav, for at øge fedtindholdet. Derfor kræver det også flere ressourcer.");
            System.out.println("Kødafdelingen er der hvor den højeste CO2-score findes. Det er dog også der den største difference i varene er. Tænk gerne over faktorer som udledning af gasser og hvor mange ressourcer der skal bruges pr kg fødevare."


            );
            System.out.println("Du er nu ved " + name);
            Set<String> exits = edges.keySet();
            System.out.println("Du er på indkøbstur, og har taget en shoppingliste med, som du kan tilgå når som helst.");
            System.out.println("Du har et begrænset budget på " + InventoryManager.MoneyGet() + " DKK og skal forsøge at handle så bæredygtigt som muligt.");
            System.out.println("Skriv 'hjælp' for at se en liste over gyldige kommandoer. Held og lykke!");

            System.out.println("De nuværende udgange er:");
            for (String exit : exits) {
                System.out.println(" - " + exit);
            }
        }

    }
}
