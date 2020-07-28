package algorithm.LeetCode;

import java.util.*;

public class combinationSum {
    /**
     * @return java.util.List<java.util.List<java.lang.Integer>>
     * @author chy
     * @creed: Talk is cheap,show me the code
     * @date 9/4/2019 3:10 PM
     * @desc: 39. 组合总和
     * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * <p>
     * candidates 中的数字可以无限制重复被选取。
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        LinkedHashSet<ArrayList<Integer>> re = new LinkedHashSet<ArrayList<Integer>>();//首先，新建一个二维的列表用来存放结果，且使用set来对结果进行去重
        Arrays.sort(candidates);//对候选词进行排序可以减少重复
//        dfs(candidates, target, new ArrayList<>(), re, 0);
        dfs(candidates, target, new ArrayList<>(), 0, re, 0);//进入递归
        List<List<Integer>> list = new ArrayList<>();
        for (ArrayList item : re) {
            list.add(new ArrayList<>(item));
        }
        return list;
    }

    /*
     *
      * @return void
     * @author chy
     * @creed: Talk is cheap,show me the code
     * @date 10/4/2019 2:50 PM
     * @desc:
     * 参数说明： cans为候选数字列表，target为当前递归层的目标，temp为存放候选结果序列，re为存放结果的二维列表，num为当前所指向的候选中的下标
     */
    public void dfs(int[] cans, int target, List<Integer> temp, LinkedHashSet<ArrayList<Integer>> re, int num) {
        if (target == 0) {//递归结束条件，dfs到达叶节点
            re.add(new ArrayList<>(temp));//这里注意需要新建一个列表对象将temp包裹进去，因为这边不是基础类型，为引用传递
            return;
        } else {
            //还没有到达叶子节点时，对当前层的节点进行遍历，分别判断便进入相应子树
            for (int i = num; i < cans.length; i++) {
                //当当前层的结点值小于等于目标时，说明还需要进入子节点
                if (cans[i] != -1 && cans[i] <= target) {
                    //递归需要注意，对于当前层状态的保留，在从当前层进去，再从子树中回退回来时，当前层的一些变量需要还原
                    temp.add(cans[i]);
                    Integer t = cans[i];
                    cans[i] = -1;
                    dfs(cans, target - t, temp, re, i);
                    cans[i] = t;
                    temp.remove(temp.size() - 1);
                }
            }

        }

    }

    public void dfs(int[] cans, int target, List<Integer> temp, int tempSum, LinkedHashSet<ArrayList<Integer>> re, int num) {
        for (int i = num; i < cans.length; i++) {
            if (cans[i] == -1)
                continue;
            if (cans[i] + tempSum == target) {
                temp.add(cans[i]);
                re.add(new ArrayList<>(temp));
                if (temp.size() > 0)
                    temp.remove(temp.size() - 1);
            } else if (tempSum + cans[i] > target) {
                if (temp.size() > 0)
                    temp.remove(temp.size() - 1);
                break;
            } else {
                List<Integer> tt = new ArrayList<>(temp);
                tt.add(cans[i]);
                int t = cans[i];
                cans[i] = -1;
                dfs(cans, target, tt, tempSum + t, re, i);
                cans[i] = t;

            }
        }


    }

    public static void main(String argc[]) {
        List<List<Integer>> re = new combinationSum().combinationSum(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        for (List<Integer> item : re) {
            for (Integer i : item)
                System.out.print(i);
            System.out.println("");
        }
    }
}

