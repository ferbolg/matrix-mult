package multparallel;

public class SequentialMatrixMultiplication {

    private long[][] a;
    private long[][] b;
    private long[][] c;

    private int mSize;

    SequentialMatrixMultiplication(long[][] a, long[][] b, int mSize) {

        this.a = a;
        this.b = b;
        this.mSize = mSize;
        this.c = new long[mSize][mSize];
    }

    public long[][] getResult() {
        return c;
    }

    public void multiplyMatrices() {

        for (int i = 0; i < mSize; ++i) {
            for (int j = 0; j < mSize; ++j) {
                for (int k = 0; k < mSize; ++k) {
                    c[i][j] = (c[i][j] + (a[i][k] * b[k][j]) % 2) % 2;
                }
            }
        }
    }
}
