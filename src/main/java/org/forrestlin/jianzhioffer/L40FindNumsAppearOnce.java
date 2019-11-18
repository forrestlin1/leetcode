package org.forrestlin.jianzhioffer;

/**
 * @program: leetcode
 * @description: 数组中只出现一次的数字
 * @author: forrestlin
 * @create: 2019-11-18 16:47
 */
public class L40FindNumsAppearOnce {

    /*
    *
首先：位运算中异或的性质：两个相同数字异或=0，一个数和0异或还是它本身。
当只有一个数出现一次时，我们把数组中所有的数，依次异或运算，最后剩下的就是落单的数，因为成对儿出现的都抵消了。

依照这个思路，我们来看两个数（我们假设是AB）出现一次的数组。我们首先还是先异或，剩下的数字肯定是A、B异或的结果，这个结果的二进制中的1，表现的是A和B的不同的位。我们就取第一个1所在的位数，假设是第3位，接着把原数组分成两组，分组标准是第3位是否为1。如此，相同的数肯定在一个组，因为相同数字所有位都相同，而不同的数，肯定不在一组。然后把这两个组按照最开始的思路，依次异或，剩余的两个结果就是这两个只出现一次的数字。
    * */
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {

        int xor1 = 0;
        for (int i = 0; i < array.length; i++) {
            xor1 = xor1 ^ array[i];
        }
        //在xor1中找到第一个不同的位对数据进行分类，分类为两个队列对数据进行异或求和找到我们想要的结果
        int index = 1;
        while ((index & xor1) == 0) {
            index = index << 1;//因为可能有多个位为1所以需要求一下位置
        }
        int result1 = 0;
        int result2 = 0;
        for (int i = 0; i < array.length; i++) {
            if ((index & array[i]) == 0) {
                result1 = result1 ^ array[i];
            } else {
                result2 = result2 ^ array[i];
            }
        }
        num1[0] = result1;
        num2[0] = result2;
    }
}
