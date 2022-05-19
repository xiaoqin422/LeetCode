package com.study.leetcode.editor.cn;
//<p>给定两个整数数组&nbsp;<code>preorder</code> 和 <code>inorder</code>&nbsp;，其中&nbsp;<code>preorder</code> 是二叉树的<strong>先序遍历</strong>， <code>inorder</code>&nbsp;是同一棵树的<strong>中序遍历</strong>，请构造二叉树并返回其根节点。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1:</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/tree.jpg" style="height: 302px; width: 277px;" />
//<pre>
//<strong>输入</strong><strong>:</strong> preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//<strong>输出:</strong> [3,9,20,null,null,15,7]
//</pre>
//
//<p><strong>示例 2:</strong></p>
//
//<pre>
//<strong>输入:</strong> preorder = [-1], inorder = [-1]
//<strong>输出:</strong> [-1]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示:</strong></p>
//
//<ul>
//	<li><code>1 &lt;= preorder.length &lt;= 3000</code></li>
//	<li><code>inorder.length == preorder.length</code></li>
//	<li><code>-3000 &lt;= preorder[i], inorder[i] &lt;= 3000</code></li>
//	<li><code>preorder</code>&nbsp;和&nbsp;<code>inorder</code>&nbsp;均 <strong>无重复</strong> 元素</li>
//	<li><code>inorder</code>&nbsp;均出现在&nbsp;<code>preorder</code></li>
//	<li><code>preorder</code>&nbsp;<strong>保证</strong> 为二叉树的前序遍历序列</li>
//	<li><code>inorder</code>&nbsp;<strong>保证</strong> 为二叉树的中序遍历序列</li>
//</ul>
//<div><div>Related Topics</div><div><li>树</li><li>数组</li><li>哈希表</li><li>分治</li><li>二叉树</li></div></div><br><div><li>👍 1591</li><li>👎 0</li></div>

import com.study.leetcode.editor.cn.help.TreeNode;

import java.io.PipedOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * [105]construct-binary-tree-from-preorder-and-inorder-traversal
 * @author 秦笑笑
 * @date 2022-05-16 21:27:14
 */
public class P105_ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P105_ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        solution.buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});
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
    Map<Integer,Integer> dp = new HashMap<>();
    int[] preorder;
    int[] inorder;
    // 递归分解子问题  左右分治
    // 子问题 在前序中确定根节点
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        for (int i = 0; i < inorder.length; i++) {
            dp.put(inorder[i],i);
        }
        return build(0,preorder.length - 1,0);
    }

    /**
     *
     * @param start 前序遍历的起始位置
     * @param end 前序遍历的最终位置
     * @param left 中序遍历的起始位置  用于计算每次  前序遍历的长度
     * @return
     */
    public TreeNode build(int start,int end,int left){
        if (start > end) return null;
        int root = preorder[start];//根节点的值
        TreeNode node = new TreeNode(root);
        Integer index = dp.get(root);
        // 前序遍历下一轮数组的长度
        int len = index - left;
        // 每一个问题对应数组中长度相等
        node.left = build(start + 1,start + len,left);
        node.right = build(start + len + 1,end,index + 1);
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
