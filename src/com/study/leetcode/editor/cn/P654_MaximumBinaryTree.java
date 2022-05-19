package com.study.leetcode.editor.cn;
//<p>给定一个不重复的整数数组&nbsp;<code>nums</code> 。&nbsp;<strong>最大二叉树</strong>&nbsp;可以用下面的算法从&nbsp;<code>nums</code> 递归地构建:</p>
//
//<ol>
//	<li>创建一个根节点，其值为&nbsp;<code>nums</code> 中的最大值。</li>
//	<li>递归地在最大值&nbsp;<strong>左边</strong>&nbsp;的&nbsp;<strong>子数组前缀上</strong>&nbsp;构建左子树。</li>
//	<li>递归地在最大值 <strong>右边</strong> 的&nbsp;<strong>子数组后缀上</strong>&nbsp;构建右子树。</li>
//</ol>
//
//<p>返回&nbsp;<em><code>nums</code> 构建的 </em><strong><em>最大二叉树</em> </strong>。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2020/12/24/tree1.jpg" />
//<pre>
//<strong>输入：</strong>nums = [3,2,1,6,0,5]
//<strong>输出：</strong>[6,3,5,null,2,0,null,null,1]
//<strong>解释：</strong>递归调用如下所示：
//- [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
//    - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
//        - 空数组，无子节点。
//        - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
//            - 空数组，无子节点。
//            - 只有一个元素，所以子节点是一个值为 1 的节点。
//    - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
//        - 只有一个元素，所以子节点是一个值为 0 的节点。
//        - 空数组，无子节点。
//</pre>
//
//<p><strong>示例 2：</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2020/12/24/tree2.jpg" />
//<pre>
//<strong>输入：</strong>nums = [3,2,1]
//<strong>输出：</strong>[3,null,2,null,1]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>1 &lt;= nums.length &lt;= 1000</code></li>
//	<li><code>0 &lt;= nums[i] &lt;= 1000</code></li>
//	<li><code>nums</code> 中的所有整数 <strong>互不相同</strong></li>
//</ul>
//<div><div>Related Topics</div><div><li>栈</li><li>树</li><li>数组</li><li>分治</li><li>二叉树</li><li>单调栈</li></div></div><br><div><li>👍 421</li><li>👎 0</li></div>

import com.study.leetcode.editor.cn.help.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * [654]maximum-binary-tree
 *
 * @author 秦笑笑
 * @date 2022-05-12 18:36:12
 */
public class P654_MaximumBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P654_MaximumBinaryTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            // return traverse(nums,0,nums.length - 1);
            // 单调栈
            Deque<TreeNode> stack = new LinkedList<>();
            if (nums.length == 0) return null;
            for (int item : nums) {
                TreeNode node = new TreeNode(item);
                if (stack.isEmpty() || stack.peekLast().val > item) {
                    stack.offerLast(node);
                } else {
                    while (!stack.isEmpty() && stack.peekLast().val < node.val) {
                        TreeNode pop = stack.pollLast();
                        if (!stack.isEmpty()) {
                            TreeNode peek = stack.peekLast();
                            if (peek.val < item) {
                                peek.right = pop;
                            } else {
                                node.left = pop;
                            }
                        } else {
                            node.left = pop;
                        }
                    }
                    stack.offerLast(node);
                }
            }
            TreeNode ans = stack.pollFirst();
            TreeNode p = ans;
            while (!stack.isEmpty()) {
                p.right = stack.pollFirst();
                p = p.right;
            }
            return ans;
        }

        // 递归遍历子问题解决
        private TreeNode traverse(int[] nums, int start, int end) {
            if (start > end) return null;
            int max = -1;
            int maxIndex = start;
            for (int i = start; i <= end; i++) {
                if (nums[i] > max) {
                    maxIndex = i;
                    max = nums[i];
                }
            }
            TreeNode treeNode = new TreeNode(max);
            treeNode.left = traverse(nums, start, maxIndex - 1);
            treeNode.right = traverse(nums, maxIndex + 1, end);
            return treeNode;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
