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

    private final int[][] dollRepo = new int[X_SIZE][Y_SIZE];

    private int score = 0;

    private int repoY = Y_SIZE;

    public int[][] getDollRepo() {
        return dollRepo;
    }

    public int getScore() {
        return score;
    }

    public void increaseScore() {
        this.score += 1;
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
        int repoY = Y_SIZE - 1;
        while (repoY > 0) {
            if (repoY - 1 > 0) {
                if (dollRepo[0][repoY] == dollRepo[0][repoY - 1]) {
                    dollRepo[0][repoY] = 0;
                    dollRepo[0][repoY - 1] = 0;
                    resetMyRepo(repoY, repoY - 1);
                    increaseScore();
                }
            }
            repoY -= 1;
        }
    }

    public void resetMyRepo(int currentY, int nextY) {
        if (nextY == 0) {
            return;
        }

        int swapCv = nextY - 1;
        int swapNv = nextY - 2;

        if (swapCv > 0 && swapNv >= 0) {
            while (true) {
                // 현재 자리에 이전 값 넣고
                dollRepo[0][currentY] = dollRepo[0][swapCv];
                dollRepo[0][nextY] = dollRepo[0][swapNv];

                // 현재 인덱스를 이전으로 초기화
                currentY = swapCv;
                nextY = swapNv;

                // 윗칸으로 이동
                swapCv -= 1;
                swapNv -= 1;

                if (swapNv == 0) {
                    return;
                }
            }
        }
    }
}
