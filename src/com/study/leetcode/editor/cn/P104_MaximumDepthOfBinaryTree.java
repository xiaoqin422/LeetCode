package com.study.leetcode.editor.cn;
//<p>给定一个二叉树，找出其最大深度。</p>
//
//<p>二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。</p>
//
//<p><strong>说明:</strong>&nbsp;叶子节点是指没有子节点的节点。</p>
//
//<p><strong>示例：</strong><br>
//给定二叉树 <code>[3,9,20,null,null,15,7]</code>，</p>
//
//<pre>    3
//   / \
//  9  20
//    /  \
//   15   7</pre>
//
//<p>返回它的最大深度&nbsp;3 。</p>
//<div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>广度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 1232</li><li>👎 0</li></div>

import com.study.leetcode.editor.cn.help.TreeNode;

/**
 * [104]maximum-depth-of-binary-tree
 * @author 秦笑笑
 * @date 2022-05-07 13:56:40
 */
public class P104_MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P104_MaximumDepthOfBinaryTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
