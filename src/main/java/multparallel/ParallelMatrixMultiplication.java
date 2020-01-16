package multparallel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ParallelMatrixMultiplication {

    private long[][] a;
    private long[][] b;
    private long[][] c;

    private int mSize;

    private static final int
            POOL_SIZE = 10;

    ParallelMatrixMultiplication(long[][] a, long[][] b, int msize) {

        this.a = a;
        this.b = b;
        this.mSize = msize;
        this.c = new long[msize][msize];
    }

    public long[][] getResult() {
        return c;
    }

    public void multiplyMatrices() {
        try {
            ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);

            for (int i = 0; i < mSize; i++) {
                for (int j = 0; j < mSize; j++) {
                    CellTask ct = new CellTask(i, j, mSize, a, b, c);
                    executor.execute(ct);
                }
            }

            executor.shutdown();
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
            while (!executor.isTerminated()) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
