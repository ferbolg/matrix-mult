package multparallel;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        int mSize = 1024;
        long[][] m1 = new long[mSize][mSize];
        long[][] m2 = new long[mSize][mSize];

        for (int i = 0; i < mSize; ++i) {
            for (int j = 0; j < mSize; ++j) {
                if (i==j) {
                    m1[i][j] = 1;
                    m2[i][j] = 1;
                } else {
                    m1[i][j] = 0;
                    m2[i][j] = 0;
                }
            }
        }

        long start1 = System.currentTimeMillis();

        long[][] result = Arrays.stream(m1).parallel().map(row ->
                IntStream.range(0, m2[0].length).mapToLong(i ->
                        IntStream.range(0, m2.length).mapToLong(j -> (row[j] * m2[j][i]) % 2).reduce(0, StatisticsUtility::addIntData)
                ).toArray()).toArray(long[][]::new);

        long finish1 = System.currentTimeMillis();
        System.out.format("Stream parallel Time elapsed: %d ms\n", finish1 - start1);

       // System.out.println(Arrays.deepToString(result));

        long start2 = System.currentTimeMillis();

        long[][] result2 = Arrays.stream(m1).map(row ->
                IntStream.range(0, m2[0].length).mapToLong(i ->
                        IntStream.range(0, m2.length).mapToLong(j -> (row[j] * m2[j][i]) % 2).reduce(0, StatisticsUtility::addIntData)
                ).toArray()).toArray(long[][]::new);

        long finish2 = System.currentTimeMillis();
        System.out.format("Stream Time elapsed: %d ms\n", finish2 - start2);

       // System.out.println(Arrays.deepToString(result2));
    }
}
