package secondlesson;

public class RockMusic implements Music {
    @Override
    public String getSong() {
        return "Bulletproof heart";
    }

    public void doInit() {
        System.out.println("Init");
    }

    public void doDestroy() {
        System.out.println("Destroy");
    }
}
