package Domain;

public class Ending extends Space {
    Ending (String name) {
        super(name);
    }
    @Override
    public void welcome () {
        Score.CalculateScore();
    }
}
