package com.basic.android.arithmetic;

/**
 * 选择排序
 */
public class XuanZeSort {
    //算法思路：
    //首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
    // 然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
    // 以此类推，直到所有元素均排序完毕。
    public static void main(String[] args) {
        int array[] = {1, 2, 4, 3, 9, 7, 8, 6};
        //最小元素的索引
        int minIndex = 0;
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            //假设第一个元素就是最小值
            minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                //寻找最小数
                if (array[j] < array[minIndex]) {
                    //将最小数保存
                    minIndex = j;
                }
            }
            //将此轮的最小数和最开始的元素交换
            temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
