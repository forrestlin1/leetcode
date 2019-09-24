package org.forrestlin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @program: leetcode
 * @description: 三数之和
 * @author: forrestlin
 * @create: 2019-09-23 17:04
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum t = new ThreeSum();
        t.threeSum(new int[]{-1, 0, 1});

    }

    /**
     * 排序后双指针法
     *
     * 先将数组进行排序
     * 从左侧开始，选定一个值为 定值 ，右侧进行求解，获取与其相加为 00 的两个值
     * 类似于快排，定义首和尾
     * 首尾与 定值 相加
     * 等于 00，记录这三个值
     * 小于 00，首部右移
     * 大于 00，尾部左移
     * 定值右移，重复该步骤
     */
    public List<List<Integer>> threeSum1(int[] nums) {

        List<List<Integer>> resLst = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return resLst;
        }

        Arrays.sort(nums);

        int l, r;
        for (int i = 0; i < nums.length - 2; i++) {
            l = i + 1;
            r = nums.length - 1;
            //nums[i]都大于0,后面不用再运行了
            if (nums[i] > 0) {
                break;
            }
            //去重
            if (i > 0 && nums[i] == nums[i - 1]) {

                continue;
            }
            while (l < r) {

                if (nums[i] + nums[l] + nums[r] == 0) {
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[i]);
                    res.add(nums[l]);
                    res.add(nums[r]);
                    resLst.add(res);
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++; // 去重
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--; // 去重
                    }
                    r--;
                    l++;
                } else if (nums[i] + nums[l] + nums[r] > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }

        return resLst;

    }


    /**
     * 暴力法
     */
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> resLst = new ArrayList<>();
        if (nums == null || nums.length > 3) {
            return resLst;
        }

        Arrays.sort(nums);

        if (nums[0] == nums[nums.length - 1] && nums[0] == 0) {

            resLst.add(new ArrayList<>());
            resLst.get(0).add(0);
            resLst.get(0).add(0);
            resLst.get(0).add(0);
            return resLst;
        }

        for (int i = 0; i < nums.length - 2; i++) {
            List<List<Integer>> resL = twoSum(Arrays.copyOfRange(nums, i + 1, nums.length), -1 * nums[i]);
            if (resL != null && resL.size() > 0) {
                for (List<Integer> twoSums : resL) {
                    List<Integer> resTmp = new ArrayList<>(2);
                    resTmp.add(nums[i]);
                    resTmp.addAll(twoSums);
                    resLst.add(resTmp);
                }


            }
        }

        //去重
        Set<String> distinctSet = new HashSet<>();
        Iterator<List<Integer>> iterator = resLst.iterator();
        while (iterator.hasNext()) {
            List<Integer> tmp = iterator.next();
           /* Integer[] tmpArr = tmp.toArray(new Integer[3]);
            Arrays.sort(tmpArr);*/
            String key = String.valueOf(tmp.get(0)) + String.valueOf(tmp.get(1)) + String.valueOf(tmp.get(2));
            if (distinctSet.contains(key)) {
                iterator.remove();
            } else {
                distinctSet.add(key);
            }

        }

        return resLst;

    }


    List<List<Integer>> twoSum(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = indexMap.get(target - nums[i]);
            if (index != null) {
                List<Integer> resL = new ArrayList<>(2);
                resL.add(nums[i]);
                resL.add(nums[index]);
                res.add(resL);
            }

            indexMap.put(nums[i], i);
        }
        return res;

    }


}
