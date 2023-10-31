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
        Space slikChokolade = new Space ("Slik og chokolade");
        Space udgang = new Space ("Udgang");


        entry.addEdge("Frugt og grønt", frugtOgGroent);
        entry.addEdge( "Kød", koed);
        entry.addEdge("Mejeriprodukter", mejeriprodukter);
        entry.addEdge("slik og Chokolade", slikChokolade);

        frugtOgGroent.addEdge("Kød", koed);
        frugtOgGroent.addEdge("Mejeriprodukter", mejeriprodukter);
        frugtOgGroent.addEdge("slik og Chokolade", slikChokolade);
        frugtOgGroent.addEdge("Udgang", udgang);

        koed.addEdge("Mejeriprodukter", mejeriprodukter);
        koed.addEdge("Frugt og grønt", frugtOgGroent);
        koed.addEdge("slik og Chokolade", slikChokolade);
        koed.addEdge("Udgang", udgang);


        mejeriprodukter.addEdge("Kød", koed);
        mejeriprodukter.addEdge("Frugt og grønt", frugtOgGroent);
        mejeriprodukter.addEdge("slik og Chokolade", slikChokolade);
        mejeriprodukter.addEdge("Udgang", udgang);


        slikChokolade.addEdge("Kød", koed);
        slikChokolade.addEdge("Frugt og grønt", frugtOgGroent);
        slikChokolade.addEdge("mejeriprodukter",mejeriprodukter);
        slikChokolade.addEdge("Udgang", udgang);


        this.entry = entry;


    }

    Space getEntry () {
        return entry;
    }

}
