/* World class for modeling the entire in-game world
 */

class World {

    Space entry;
    Space frugtOgGroent;
    Space koed;
    Space maelk;
    Space mejeriprodukter;
    Space udgang;

    World () {
        Space entry = new Space("Indgang");
        Space frugtOgGroent = new Space("Frugt og grønt");
        Space koed = new Space ("Kød");
        Space mejeriprodukter = new Space ("Mejeriprodukter");
        Space udgang = new Space ("Udgang");


        entry.addEdge("Frugt og grønt", frugtOgGroent);

        frugtOgGroent.addEdge("Kød", koed);
        koed.addEdge("Mejeriprodukter", mejeriprodukter);
        mejeriprodukter.addEdge("Udgang", udgang);

        this.entry = entry;


    }

    Space getEntry () {
        return entry;
    }

}
