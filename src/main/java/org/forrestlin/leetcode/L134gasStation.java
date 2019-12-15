package org.forrestlin.leetcode;

/*
* 加油站

在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。

你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。

如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。

说明:

    如果题目有解，该答案即为唯一答案。
    输入数组均为非空数组，且长度相同。
    输入数组中的元素均为非负数。

示例 1:

输入:
gas  = [1,2,3,4,5]
cost = [3,4,5,1,2]

输出: 3



* */
public class L134gasStation {

    /***
     * 1. 如果 sum(gas) < sum(cost) ，那么不可能环行一圈，这种情况下答案是 -1 。
     * 我们可以用这个式子计算环行过程中邮箱里剩下的油：total_tank = sum(gas) - sum(cost) ，如果 total_tank < 0 则返回 -1 。
     *
     *
     * 2. 对于加油站 i ，如果 gas[i] - cost[i] < 0 ，则不可能从这个加油站出发，因为在前往 i + 1 的过程中，汽油就不够了。
     * 第二个规则可以被一般化，我们引入变量 curr_tank ，记录当前油箱里剩余的总油量。如果在某一个加油站 curr_tank比 0 小，意味着我们无法到达这个加油站。
     *
     * 下一步我们把这个加油站当做新的起点，并将 curr_tank 重置为 0 ，因为重新出发，油箱中的油为 0 。（从上一次重置的加油站到当前加油站的任意一个加油站出发，到达当前加油站之前， curr_tank 也一定会比 0 小）
     *
     *
     * */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int total_tank = 0;
        int curr_tank = 0;
        int starting_station = 0;
        for (int i = 0; i < n; ++i) {
            total_tank += gas[i] - cost[i];
            curr_tank += gas[i] - cost[i];
            // If one couldn't get here,
            if (curr_tank < 0) {
                // Pick up the next station as the starting one.
                starting_station = i + 1;
                // Start with an empty tank.
                curr_tank = 0;
            }
        }
        return total_tank >= 0 ? starting_station : -1;
    }

}
