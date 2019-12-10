package com.basic.android.arithmetic;

/**
 * 冒泡排序算法 O(n2)
 */
public class BubbleSort {
    //算法思路：
    //1、比较相邻的元素。如果第一个比第二个大，就交换它们两个；
    //2、对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
    //3、针对所有的元素重复以上的步骤，除了最后一个；
    //4、重复步骤1~3，直到排序完成。

    public static void main(String[] args) {
        int array[] = {1, 2, 4, 3, 9, 7, 8, 6};
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
