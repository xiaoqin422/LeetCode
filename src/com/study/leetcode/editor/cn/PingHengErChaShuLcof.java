//<p>输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。</p>
//
//<p> </p>
//
//<p><strong>示例 1:</strong></p>
//
//<p>给定二叉树 <code>[3,9,20,null,null,15,7]</code></p>
//
//<pre>
//    3
//   / \
//  9  20
//    /  \
//   15   7</pre>
//
//<p>返回 <code>true</code> 。<br />
//<br />
//<strong>示例 2:</strong></p>
//
//<p>给定二叉树 <code>[1,2,2,3,3,null,null,4,4]</code></p>
//
//<pre>
//       1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
//</pre>
//
//<p>返回 <code>false</code> 。</p>
//
//<p> </p>
//
//<p><strong>限制：</strong></p>
//
//<ul>
//	<li><code>0 <= 树的结点个数 <= 10000</code></li>
//</ul>
//
//<p>注意：本题与主站 110 题相同：<a href="https://leetcode-cn.com/problems/balanced-binary-tree/">https://leetcode-cn.com/problems/balanced-binary-tree/</a></p>
//
//<p> </p>
//<div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 269</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

import com.study.leetcode.editor.cn.helpClass.TreeNode;

/**
 * [剑指 Offer 55 - II]平衡二叉树
 *
 * @author 秦笑笑
 * @date 2022-04-24 13:09:20
 */
public class PingHengErChaShuLcof {
    public static void main(String[] args) {
        Solution solution = new PingHengErChaShuLcof().new Solution();
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
        public boolean isBalanced(TreeNode root) {
            if (root == null) return true;
            else {
                int l = Depth(root.left);
                int r = Depth(root.right);
                if (Math.abs(l - r) > 1){
                    return false;
                }
                return isBalanced(root.right) && isBalanced(root.left);
            }
        }

        private int Depth(TreeNode treeNode) {
            if (treeNode == null) {
                return 0;
            } else {
                int l = Depth(treeNode.left);
                int r = Depth(treeNode.right);
                return Math.max(l, r) + 1;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
