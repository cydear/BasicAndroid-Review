package com.basic.android.arithmetic;

/**
 * 插入排序
 */
public class ChaRuSort {

    //算法思路：
    //1、从第一个元素开始，该元素可以认为已经被排序；
    //2、取出下一个元素，在已经排序的元素序列中从后向前扫描；
    //3、如果该元素（已排序）大于新元素，将该元素移到下一位置；
    //4、重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
    //5、将新元素插入到该位置后；
    //6、重复步骤2~5。
    public static void main(String[] args) {
        int array[] = {1, 2, 4, 3, 9, 7, 8, 6};
        int index = 0;
        int current = 0;
        for (int i = 1; i < array.length; i++) {
            index = i - 1;
            current = array[i];
            while (index >= 0 && array[index] > current) {
                array[index + 1] = array[index];
                index--;
            }
            array[index + 1] = current;
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
