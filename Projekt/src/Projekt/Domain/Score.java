package Projekt.Domain;

public class Score {
    private static double score;
    static String[] scoreTxt;


    public static void CalculateScore() {
        int shoppingScore = 0;
        int scoreGoal = 70;
        int intervals = 13;
        score = InventoryManager.ScoreGet();
        String[] Keyset = InventoryManager.shoppingList.ItemsMissing.keySet().toArray(new String[4]);
        for (int i = 0; i < Keyset.length; i++) {
            score += 10 * InventoryManager.shoppingList.ItemsMissing.get(Keyset[i]);
            shoppingScore += 10 * InventoryManager.shoppingList.ItemsMissing.get(Keyset[i]);
        }
        if (score > scoreGoal) {

            String[] megetHøjt = {"Du har fået et meget højt antal point, og derfor en meget dårlig score.",
                    "Du fik " + shoppingScore + " point for ikke at købe varer der var på shoppinglisten",
                    "Du fik " + InventoryManager.ScoreGet() + " point for bæredygtigheden af de varer du valgte",
                    "Du fik " + score + " point i alt",
                    "Det ville hjælpe stort, hvis du vil tilgå dette link ",
                    "' https://forms.gle/gwMDuvA9RkN285jt9 ' og besvare et spørgsmål.",
                    "Tak for at spille! Skriv 'afslut' for at lukke spillet."};
            scoreTxt = megetHøjt;

        } else if (score > (scoreGoal - intervals)) {
            String[] højt = {"Du har fået et højt antal point, og derfor en dårlig score.",
                    "Du fik " + shoppingScore + " point for ikke at købe varer der var på shoppinglisten",
                    "Du fik " + InventoryManager.ScoreGet() + " point for bæredygtigheden af de varer du valgte",
                    "Du fik " + score + " point i alt",
                    "Det ville hjælpe stort, hvis du vil tilgå dette link ' https://forms.gle/gwMDuvA9RkN285jt9 ' og besvare et spørgsmål.",
                    "Tak for at spille! Skriv 'afslut' for at lukke spillet."};
            scoreTxt = højt;


        } else if (score > (scoreGoal - intervals * 2)) {
            String[] middel = {"Du har fået et middel antal point, og derfor en middel score.",
                    "Du fik " + shoppingScore + " point for ikke at købe varer der var på shoppinglisten",
                    "Du fik " + InventoryManager.ScoreGet() + " point for bæredygtigheden af de varer du valgte",
                    "Du fik " + score + " point i alt",
                    "Det ville hjælpe stort, hvis du vil tilgå dette link ' https://forms.gle/gwMDuvA9RkN285jt9 ' og besvare et spørgsmål."
                    , "Tak for at spille! Skriv 'afslut' for at lukke spillet."};
            scoreTxt = middel;


        } else if (score > (scoreGoal - intervals * 3)) {
            String[] lavt = {"Du har fået et lavt antal point, og derfor en god score.",
                    "Du fik " + shoppingScore + " point for ikke at købe varer der var på shoppinglisten",
                    "Du fik " + InventoryManager.ScoreGet() + " point for bæredygtigheden af de varer du valgte",
                    "Du fik " + score + " point i alt",
                    "Det ville hjælpe stort, hvis du vil tilgå dette link ' https://forms.gle/gwMDuvA9RkN285jt9 ' og besvare et spørgsmål.",
                    "Tak for at spille! Skriv 'afslut' for at lukke spillet."};
            scoreTxt = lavt;


        } else {
            String[] megetLavt = {
                    "Du har fået et meget lavt antal point, og derfor en meget god score.",
                    "Du fik " + shoppingScore + " point for ikke at købe varer der var på shoppinglisten",
                    "Du fik " + InventoryManager.ScoreGet() + " point for bæredygtigheden af de varer du valgte",
                    "Du fik " + score + " point i alt",
                    "Det ville hjælpe stort, hvis du vil tilgå dette link ' https://forms.gle/gwMDuvA9RkN285jt9 ' og besvare et spørgsmål.",
                    "Tak for at spille! Skriv 'afslut' for at lukke spillet."};
            scoreTxt = megetLavt;


        }
    }
}

