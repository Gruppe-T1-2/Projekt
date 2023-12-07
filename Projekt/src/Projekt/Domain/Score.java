package Projekt.Domain;

public class Score {
    private static double score;
    static String[] scoreTxt;
    static int GFXscore;


    public static void CalculateScore() {
        int shoppingScore = 0;
        int scoreGoal = 70;
        int intervals = 18;
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
                    "Det ville hjælpe stort, hvis du vil tilgå linket og besvare et spørgsmål.","Du kan kopiere linket ved at klikke på det",
                    "Tak for at spille!"};
            scoreTxt = megetHøjt;
            GFXscore = 1;

        } else if (score > (scoreGoal - intervals)) {
            String[] højt = {"Du har fået et højt antal point, og derfor en dårlig score.",
                    "Du fik " + shoppingScore + " point for ikke at købe varer der var på shoppinglisten",
                    "Du fik " + InventoryManager.ScoreGet() + " point for bæredygtigheden af de varer du valgte",
                    "Du fik " + score + " point i alt",
                    "Det ville hjælpe stort, hvis du vil tilgå linket og besvare et spørgsmål.","Du kan kopiere linket ved at klikke på det",
                    "Tak for at spille!"};
            scoreTxt = højt;
            GFXscore = 1;


        } else if (score > (scoreGoal - intervals * 2)) {
            String[] middel = {"Du har fået et middel antal point, og derfor en middel score.",
                    "Du fik " + shoppingScore + " point for ikke at købe varer der var på shoppinglisten",
                    "Du fik " + InventoryManager.ScoreGet() + " point for bæredygtigheden af de varer du valgte",
                    "Du fik " + score + " point i alt",
                    "Det ville hjælpe stort, hvis du vil tilgå linket og besvare et spørgsmål."
                    ,"Du kan kopiere linket ved at klikke på det", "Tak for at spille!"};
            scoreTxt = middel;
            GFXscore = 2;


        } else if (score > (scoreGoal - intervals * 3)) {
            String[] lavt = {"Du har fået et lavt antal point, og derfor en god score.",
                    "Du fik " + shoppingScore + " point for ikke at købe varer der var på shoppinglisten",
                    "Du fik " + InventoryManager.ScoreGet() + " point for bæredygtigheden af de varer du valgte",
                    "Du fik " + score + " point i alt",
                    "Det ville hjælpe stort, hvis du vil tilgå linket og besvare et spørgsmål.","Du kan kopiere linket ved at klikke på det",
                    "Tak for at spille!"};
            scoreTxt = lavt;
            GFXscore = 3;


        } else {
            String[] megetLavt = {
                    "Du har fået et meget lavt antal point, og derfor en meget god score.",
                    "Du fik " + shoppingScore + " point for ikke at købe varer der var på shoppinglisten",
                    "Du fik " + InventoryManager.ScoreGet() + " point for bæredygtigheden af de varer du valgte",
                    "Du fik " + score + " point i alt",
                    "Det ville hjælpe stort, hvis du vil tilgå linket og besvare et spørgsmål.","Du kan kopiere linket ved at klikke på det",
                    "Tak for at spille!"};
            scoreTxt = megetLavt;
            GFXscore = 3;


        }
    }
}

