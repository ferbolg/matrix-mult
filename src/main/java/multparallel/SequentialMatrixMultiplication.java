package multparallel;

public class SequentialMatrixMultiplication {

    private int[][] a;
    private int[][] b;
    private int[][] c;

    private int mSize;

    SequentialMatrixMultiplication(int[][] a, int[][] b, int mSize) {
        this.a = a;
        this.b = b;
        this.mSize = mSize;
        this.c = new int[mSize][mSize];
    }

    public int[][] getResult() {
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
