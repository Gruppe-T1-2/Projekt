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
        entry = new Space("Indgang");
        frugtOgGroent = new Space("Frugt og grønt");
        koed = new Space ("Kød");
        mejeriprodukter = new Space ("Mejeriprodukter");
        sliksektion = new Space ("Sliksektion");
        udgang = new Ending ("Udgang");

        spaceList.put("Indgang", entry);
        spaceList.put("Frugt og grønt", frugtOgGroent);
        spaceList.put("Kød", koed);
        spaceList.put("Mejeriprodukter", mejeriprodukter);
        spaceList.put("Sliksektion", sliksektion);

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

}

