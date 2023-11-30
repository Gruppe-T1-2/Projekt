package Domain;
public class Score {
    private static double score;



    public static void CalculateScore() {
        int shoppingScore = 0;
        int scoreGoal = 70;
        int intervals = 13;
        score = InventoryManager.ScoreGet();
        String[] Keyset = InventoryManager.shoppingList.ItemsMissing.keySet().toArray(new String[4]);
        for (int i = 0; i < Keyset.length; i++) {
            score += 10*InventoryManager.shoppingList.ItemsMissing.get(Keyset[i]);
            shoppingScore += 10*InventoryManager.shoppingList.ItemsMissing.get(Keyset[i]);
        }
        if (score > scoreGoal) {
            System.out.println("Du har fået et meget højt antal point, og derfor en meget dårlig score.");
            System.out.println("Du fik " + shoppingScore + " point for ikke at købe varer der var på shoppinglisten");
            System.out.println("Du fik " + InventoryManager.ScoreGet() +" point for bæredygtigheden af de varer du valgte");
            System.out.println("Du fik " + score + " point i alt");
            System.out.println();
            System.out.println("Det ville hjælpe stort, hvis du vil tilgå dette link ' https://forms.gle/gwMDuvA9RkN285jt9 ' og besvare et spørgsmål.");
            System.out.println();
            System.out.println("Tak for at spille! Skriv afslut for at lukke spillet.");
        } else if (score > (scoreGoal - intervals)) {
            System.out.println("Du har fået et højt antal point, og derfor en dårlig score.");
            System.out.println("Du fik " + shoppingScore + " point for ikke at købe varer der var på shoppinglisten");
            System.out.println("Du fik " + InventoryManager.ScoreGet() +" point for bæredygtigheden af de varer du valgte");
            System.out.println("Du fik " + score + " point i alt");
            System.out.println();
            System.out.println("Det ville hjælpe stort, hvis du vil tilgå dette link ' https://forms.gle/gwMDuvA9RkN285jt9 ' og besvare et spørgsmål.");
            System.out.println();
            System.out.println("Tak for at spille! Skriv afslut for at lukke spillet.");
        } else if (score > (scoreGoal - intervals*2)) {
            System.out.println("Du har fået et middel antal point, og derfor en middel score.");
            System.out.println("Du fik " + shoppingScore + " point for ikke at købe varer der var på shoppinglisten");
            System.out.println("Du fik " + InventoryManager.ScoreGet() +" point for bæredygtigheden af de varer du valgte");
            System.out.println("Du fik " + score + " point i alt");
            System.out.println();
            System.out.println("Det ville hjælpe stort, hvis du vil tilgå dette link ' https://forms.gle/gwMDuvA9RkN285jt9 ' og besvare et spørgsmål.");
            System.out.println();
            System.out.println("Tak for at spille! Skriv afslut for at lukke spillet.");
        } else if (score > (scoreGoal - intervals*3)) {
            System.out.println("Du har fået et lavt antal point, og derfor en god score.");
            System.out.println("Du fik " + shoppingScore + " point for ikke at købe varer der var på shoppinglisten");
            System.out.println("Du fik " + InventoryManager.ScoreGet() +" point for bæredygtigheden af de varer du valgte");
            System.out.println("Du fik " + score + " point i alt");
            System.out.println();
            System.out.println("Det ville hjælpe stort, hvis du vil tilgå dette link ' https://forms.gle/gwMDuvA9RkN285jt9 ' og besvare et spørgsmål.");
            System.out.println();
            System.out.println("Tak for at spille! Skriv afslut for at lukke spillet.");
        } else {
            System.out.println("Du har fået et meget lavt antal point, og derfor en meget god score.");
            System.out.println("Du fik " + shoppingScore + " point for ikke at købe varer der var på shoppinglisten");
            System.out.println("Du fik " + InventoryManager.ScoreGet() +" point for bæredygtigheden af de varer du valgte");
            System.out.println("Du fik " + score + " point i alt");
            System.out.println();
            System.out.println("Det ville hjælpe stort, hvis du vil tilgå dette link ' https://forms.gle/gwMDuvA9RkN285jt9 ' og besvare et spørgsmål.");
            System.out.println();
            System.out.println("Tak for at spille! Skriv afslut for at lukke spillet.");
        }
    }
}

