package multparallel;

public class CellTask implements Runnable {

    private int i, j, mSize;

    private int[][] m1;
    private int[][] m2;
    private int[][] m3;


    CellTask(int ii, int jj, int mSize, int[][] m1, int[][] m2, int[][] m3) {

        this.i = ii;
        this.j = jj;
        this.mSize = mSize;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;

    }

    /**
     * Here we perform multiplication and addition to calculate the value
     * for matrix cell
     */

    public void run() {

        int sum = 0;

        for (int k = 0; k < mSize; k++) {

            sum = (sum + (m1[i][k] * m2[k][j]) % 2) % 2;
        }

        this.m3[i][j] = sum;

    }
}
