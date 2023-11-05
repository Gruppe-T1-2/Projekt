import java.util.Set;

public class Tutorial extends Space {

    Tutorial (String name) {
        super(name);
    }

    @Override
    public void welcome () {
        System.out.println("Du er nu ved "+name);
        Set<String> exits = edges.keySet();
        System.out.println("Du er på indkøbstur, og har taget en shoppingliste med, som du kan tilgå når som helst.");
        System.out.println("Du har et begrænset budget på " + InventoryManager.MoneyGet() + " DKK og skal forsøge at handle så bæredygtigt som muligt.");
        System.out.println("Skriv 'hjælp' for at se en liste over gyldige kommandoer. Held og lykke!");

        System.out.println("De nuværende udgange er:");
        for (String exit: exits) {
            System.out.println(" - "+exit);
        }
    }

}
