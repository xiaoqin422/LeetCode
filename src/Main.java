
abstract class Game{
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();
    //模板
    public final void play(){
        initialize();
        startPlay();
        endPlay();
    }
}

class Cricket extends Game{
    @Override
    void endPlay(){
        System.out.println("Cricket Game Finished!");
    }
    @Override
    void initialize(){
        System.out.println("Cricket Game Initialize!");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket Game Started!");
    }
}

class Football extends Game{
    @Override
    void initialize() {
        System.out.println("Football Game Initialize!");
    }

    @Override
    void startPlay() {
        System.out.println("Football Game Started!");
    }

    @Override
    void endPlay(){
        System.out.println("Football Game Finished!");
    }

}
public class Main {
    public static void main(String[] args) {
        Game game = new Cricket();
        game.play();
        System.out.println("------------------------");
        game = new Football();
        game.play();
    }
}