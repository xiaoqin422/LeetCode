//<p>给定一棵二叉搜索树，请找出其中第 <code>k</code> 大的节点的值。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1:</strong></p>
//
//<pre>
//<strong>输入:</strong> root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//&nbsp;  2
//<strong>输出:</strong> 4</pre>
//
//<p><strong>示例 2:</strong></p>
//
//<pre>
//<strong>输入:</strong> root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//<strong>输出:</strong> 4</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>限制：</strong></p>
//
//<ul>
//	<li>1 ≤ k ≤ 二叉搜索树元素个数</li>
//</ul>
//<div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>二叉搜索树</li><li>二叉树</li></div></div><br><div><li>👍 290</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

import com.study.leetcode.editor.cn.helpClass.TreeNode;

import java.util.Stack;

/**
 * [剑指 Offer 54]二叉搜索树的第k大节点
 *
 * @author 秦笑笑
 * @date 2022-04-24 12:38:43
 */
public class ErChaSouSuoShuDeDiKdaJieDianLcof {
    public static void main(String[] args) {
        Solution solution = new ErChaSouSuoShuDeDiKdaJieDianLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public int kthLargest(TreeNode root, int k) {
            Stack<TreeNode> stack = new Stack<>();
            int index = 0;
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.right;
                }
                root = stack.pop();
                if (++index == k) {
                    return root.val;
                }
                root = root.left;
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
