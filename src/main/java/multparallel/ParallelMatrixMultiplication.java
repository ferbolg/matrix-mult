package multparallel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ParallelMatrixMultiplication {

    private int[][] a;
    private int[][] b;
    private int[][] c;

    private int mSize;

    private static final int POOL_SIZE = Runtime.getRuntime().availableProcessors();

    public ParallelMatrixMultiplication(int[][] a, int[][] b, int mSize) {
        this.a = a;
        this.b = b;
        this.mSize = mSize;
        this.c = new int[mSize][mSize];
    }

    public int[][] getResult() {
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
            executor.awaitTermination(1, TimeUnit.HOURS);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
