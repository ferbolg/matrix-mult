package multparallel;

public class CellTask implements Runnable {

    private int i, j, mSize;

    private long[][] m1;
    private long[][] m2;
    private long[][] m3;


    CellTask(final int ii, final int jj, final int mSize, final long[][] m1, final long[][] m2, long[][] m3) {

        this.i = ii;
        this.j = jj;
        this.mSize = mSize;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;

    }

    /**
     * Here we perform multiplications and additions to calculate the value for resultant matrix cell
     */

    public void run() {

        long sum = 0;

        for (int k = 0; k < this.mSize; k++) {

            sum = (sum + (m1[i][k] * m2[k][j]) % 2) % 2;
        }

        this.m3[i][j] = sum;

    }
}
