package pick_doll;


/**
 * 0    1
 * 1    2
 * 2    4
 * 3    3
 * 4    3
 * 5    8
 * 6    1
 * 7    1
 * 8    3
 * 9    4
 */


public class User {
    private final int X_SIZE = 1;
    private final int Y_SIZE = 10;
    private static User instance;
    private int[][] dollRepo = new int[X_SIZE][Y_SIZE];

    private int score = 0;

    private int repoY = Y_SIZE - 1;

    public int[][] getDollRepo() {
        return dollRepo;
    }

    public int getScore() {
        return score;
    }

    public void increaseScore() {
        this.score += 1;
    }

    public static  User getInstance() {
        if (instance == null) {
            instance = new User();
            return instance;
        }
        return instance;
    }

    // if max repository not correct thing than game over
    public boolean addDollMyRepo(int dollType) {
        if (repoY < 0) {
            repoY = 0;
            System.out.println("바구니가 가득 찼어요 ㅠ");
            return false;
        }

        // 인형 넣기
        dollRepo[0][repoY] = dollType;
        repoY -= 1;
        return true;
    }

    public void resetAddPoint() {
        for (int i = 0; i < dollRepo.length; i++) {
            for (int j = dollRepo[i].length - 1; j >= 0; j--) {
                if (dollRepo[i][j] == 0) {
                    repoY = j;
                    break;
                }
            }
        }
    }

    public void checkMyRepo() {
        int currentVal = Y_SIZE - 1;
        int nextVal = currentVal - 1;

        while (true) {
            if (dollRepo[0][currentVal] != 0 &&  dollRepo[0][nextVal] != 0) {
                if (dollRepo[0][currentVal] == dollRepo[0][nextVal]) {
                    dollRepo[0][currentVal] = 0;
                    dollRepo[0][nextVal] = 0;
                    increaseScore();
                    System.out.println("같은 인형 두개 히트!! 1점 추가!");
                }
            }

            currentVal -= 1;
            nextVal -= 1;

            if (nextVal <= 0) {
                break;
            }
        }

        resetMyRepo();
    }

    public void resetMyRepo() {
        int[][] temp = new int[1][Y_SIZE];
        int cnt = Y_SIZE - 1;

        for (int i = Y_SIZE - 1; i >= 0; i--) {
            if (dollRepo[0][i] != 0) {
                temp[0][cnt] = dollRepo[0][i];
                cnt -= 1;
            }
        }

        dollRepo = temp;
    }

    public void printMyRepo() {
        System.out.println("현재 사용자의 인형 저장소입니다!");
        for (int i = 0; i < dollRepo.length; i++) {
            for (int j = 0; j < dollRepo[i].length; j++) {
                System.out.println(dollRepo[i][j]);
            }
        }
    }
}
