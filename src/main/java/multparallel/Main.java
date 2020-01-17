package multparallel;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Please input the size of matrices");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if ((n < 1) || (n > 10000)) {
            System.out.println("Matrix size must be in the range [1...10000]");
            return;
        } else {

            int mSize = n;

            int[][] m1 = new int[mSize][mSize];
            int[][] m2 = new int[mSize][mSize];

            // for check purposes, we initialize all elements of m1 with 1
            // likewise, we initialize diagonal elements of m2 with 1, and others with 0
            // the result matrix should be equal to m1

            for (int i = 0; i < mSize; ++i) {
                for (int j = 0; j < mSize; ++j) {
                    if (i == j) {
                        m2[i][j] = 1;
                    } else {
                        m2[i][j] = 0;
                    }
                    m1[i][j] = 1;
                }
            }

            System.out.println("Sequential matrix multiplication starts...");
            long start = System.currentTimeMillis();

            SequentialMatrixMultiplication smm = new SequentialMatrixMultiplication(m1,m2,mSize);
            smm.multiplyMatrices();
            long finish = System.currentTimeMillis();
            System.out.format("Time elapsed: %d ms\n", finish - start);

            // for small matrices we can print the sresult to check the logic
//            int[][] sresult = smm.getResult();
//            System.out.println(Arrays.deepToString(sresult));


            System.out.println("Parallel matrix multiplication starts...");
            long startTime = System.currentTimeMillis();

            ParallelMatrixMultiplication pmm = new ParallelMatrixMultiplication(m1,m2,mSize);
            pmm.multiplyMatrices();

            long stopTime = System.currentTimeMillis();
            System.out.format("Time elapsed: %d ms\n", stopTime - startTime);

            // for small matrices we can print the presult to check the logic
//            int [][] presult = pmm.getResult();
//            System.out.println(Arrays.deepToString(presult));

        }
    }
}
