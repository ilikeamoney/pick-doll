package pick_doll;

import java.util.Random;

public class CrawMachine implements Machine {

    private final int X_SIZE = 10;
    private final int Y_SIZE = 10;
    private final int[][] field = new int[X_SIZE][Y_SIZE];
    private final int[] dollType = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    private final Random r = new Random();

    @Override
    public void init() {
        setDolls();
    }

    @Override
    public void operating() {

    }

    public void pickDoll(User user, int userPick) {
        // field position y
        int fpy = 0;

        if (userPick > X_SIZE - 1) {
            System.out.println("범위를 초과하였습니다.");
            return;
        }

        // now craw start
        while (true) {
            int doll = field[userPick][fpy];

            if (doll != 0) {
                boolean l = luckyPoint();

                if (!l) {
                    System.out.println("인형을 놓쳤어요 ㅜㅂㅜ");
                    return;
                }

                System.out.println("인형이 뽑혔습니다! 사용자 Repo에 인형을 추가합니다!");
                boolean c = user.addDollMyRepo(doll);
                field[userPick][fpy] = 0;

                if (!c) {
                    System.out.println("장바구니가 가득 찼습니다 Game Over!");
                    return;
                }

                user.checkMyRepo();
                user.resetAddPoint();
                System.out.println("현재 스코어 = " + user.getScore());
            }

            // size over end
            if (fpy > Y_SIZE - 1) {
                return;
            }

            fpy += 1;
        }
    }

    private boolean luckyPoint() {
        int r = this.r.nextInt(10);

        // 3 = false, 5 = false, 4 = false
        if (r == 4 || r + 1 == 4 || r - 1 == 4) {
            return false;
        }

        return true;
    }

    private void setDolls() {
        int setCnt = 50;

        while (setCnt > 0) {
            // fpx = filed position x
            // fpy = filed position y
            int fpx = r.nextInt(X_SIZE);
            int fpy = r.nextInt(Y_SIZE);

            if (field[fpx][fpy] == 0) {
                // dti = doll type index
                int dti = r.nextInt(dollType.length);
                field[fpx][fpy] = dollType[dti];
            } else {
                continue;
            }

            setCnt -= 1;
        }
    }

    public int[][] getField() {
        return field;
    }
}
