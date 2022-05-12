package com.study.leetcode.editor.cn;
//<p>给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 :</strong><br>
//给定二叉树</p>
//
//<pre>          1
//         / \
//        2   3
//       / \     
//      4   5    
//</pre>
//
//<p>返回&nbsp;<strong>3</strong>, 它的长度是路径 [4,2,1,3] 或者&nbsp;[5,2,1,3]。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>注意：</strong>两结点之间的路径长度是以它们之间边的数目表示。</p>
//<div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 1024</li><li>👎 0</li></div>

import com.study.leetcode.editor.cn.help.TreeNode;

/**
 * [543]diameter-of-binary-tree
 * @author 秦笑笑
 * @date 2022-05-11 10:19:35
 */
public class P543_DiameterOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P543_DiameterOfBinaryTree().new Solution();
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
    private int ans = 0;
    //核心 最大直径为 左右子树最大深度之和
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return ans;
    }
    private int maxDepth(TreeNode root){
        // 递归返回条件① 当节点为null时，跳出
        if (root == null) return 0;
        // 求解左右子树的最大深度
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        // 记录该子树对应的直径
        int sum = left + right;
        // 记录最优情况
        ans = Math.max(ans,sum);
        // 递归返回条件②  返回该节点的深度（左右子树的深度最大值+ 自己这一层的深度）
        return Math.max(left,right) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
