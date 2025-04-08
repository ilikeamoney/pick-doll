import pick_doll.CrawMachine;
import pick_doll.Doll;
import pick_doll.Machine;

import java.util.HashMap;
import java.util.Map;

public class PickDollMain {
    public static void main(String[] args) {
        CrawMachine m = new CrawMachine();
        m.init();
        int[][] field = m.getField();

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j] + "     ");
            }
            System.out.println();
        }

    }
}