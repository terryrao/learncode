package org.raowei.test.algorithms.sort;

import java.util.Arrays;

/**
 * 计数排序，只能对整数或者有限位数的实数进行排序
 *
 * @author raowei
 * @date 2019-05-22
 */
public class CountSort {

    public static void main(String[] args) {

        int[] A = {-1, 2, 0, 4, 3, 8, 5, 8, -2, 1, 3, 0, 3, 6, 5, 2};
        int[] B = countSort1(A);
        System.out.print("辅助数组的值：");
        for (int index = 0; index < B.length; index++)
            System.out.print(B[index] + "  ");
        System.out.println();
        System.out.print("排序后的值： ");
        for (int index = 0; index < A.length; index++)
            System.out.print(A[index] + "  ");


        int[] C = {-1, 2, 0, 4, 3, 8, 5, 8, -2, 1, 3, 0, 3, 6, 5, 2};
        countSort2(C);
        System.out.println(Arrays.toString(C));
    }


    private static int[] countSort1(int[] A) {
        int max = 0, min = 0;
        for (int value : A) {
            if (value > max) {
                max = value;
            }
            if (value < min) {
                min = value;
            }

        }

        int[] B = new int[max - min + 1];

        for (int i = 0; i < A.length; i++) {
            B[A[i] - min] += 1;
        }
        //A的索引
        int index = 0;
        for (int i = 0; i < B.length; i++) {
            int v = B[i];
            while (v > 0) {
                A[index++] = i + min;
                v--;
            }
        }
        return B;

    }


    private static void countSort2(int[] A) {
        int max, min;
        max = min = 0;

        for (int i : A) {
            if (i > max) {
                max = i;
            }

            if (min > i) {
                min = i;
            }
        }

        int[] tmp = new int[max - min + 1];
        for (int i : A) {
            tmp[i - min]++;
        }

        //与 A 的位置对齐

        for (int i = 1; i < tmp.length; i++) {
            tmp[i] += tmp[i - 1];
        }

        for (int i = 0; i < tmp.length; i++) {
            int last = tmp[i];
            int first = i == 0 ? 0 : tmp[i - 1];
            int step = last - first;
            for (int j = 1; j <= step; j++) {
                A[first] = i + min;
                first ++;
            }
        }
    }


}



