/* World class for modeling the entire in-game world
 */

class World {

    Space entry;
    Space frugtOgGroent;
    Space koed;
    Space maelk;
    Space mejeriprodukter;
    Space sliksektion;
    Ending udgang;

    World () {
        entry = new Space("Indgang");
        frugtOgGroent = new Space("Frugt og grønt");
        koed = new Space ("Kød");
        mejeriprodukter = new Space ("Mejeriprodukter");
        udgang = new Ending ("Udgang");


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

        this.entry = entry;


    }

    Space getEntry () {
        return entry;
    }

}
