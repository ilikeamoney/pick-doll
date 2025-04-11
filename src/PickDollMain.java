import pick_doll.CrawMachine;
import pick_doll.User;


public class PickDollMain {
    public static void main(String[] args) {
        User user = User.getInstance();
        CrawMachine m = new CrawMachine(user);
        m.operating();
    }
}