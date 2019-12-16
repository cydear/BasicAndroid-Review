package com.basic.android.arithmetic;

import java.util.Arrays;

/**
 * [类功能说明]
 *
 * @author lary.huang
 * @version v 1.4.8 2019-12-12 XLXZ Exp $
 */
public class SumArithmetic {
    public static void main(String[] args) {
        int[] data = {1, 5, 9, -1, 4, 6, -2, 3, -8};

        Arrays.sort(data);

        for (int value : data) {
            System.out.print(value + " ");
        }

        System.out.println("---------------");

        int firstIndex = 0;
        int lastIndex = data.length - 1;
        int temp = 0;
        int sum = 11;
        while (firstIndex < lastIndex) {
            temp = data[firstIndex] + data[lastIndex];
            if (temp == sum) {
                System.out.println(data[firstIndex] + "+" + data[lastIndex] + "=" + sum);
                firstIndex++;
                lastIndex--;
            } else if (temp < sum) {
                firstIndex++;
            } else {
                lastIndex--;
            }
        }
    }
}
