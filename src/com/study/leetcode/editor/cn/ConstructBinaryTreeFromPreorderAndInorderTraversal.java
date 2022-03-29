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
//<div><div>Related Topics</div><div><li>树</li><li>数组</li><li>哈希表</li><li>分治</li><li>二叉树</li></div></div><br><div><li>👍 1505</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

import com.study.leetcode.editor.cn.helpClass.TreeNode;

import java.util.HashMap;

/**
 * [105]从前序与中序遍历序列构造二叉树
 *
 * @author 秦笑笑
 * @date 2022-03-29 14:45:21
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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
        // 用于获取每一次的头结点
        int[] preorder;
        // 用于获取每一次的子树长度，辅助获取头结点
        HashMap<Integer, Integer> idx = new HashMap<>();

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (inorder.length == 0) return null;
            this.preorder = preorder;
            for (int i = 0; i < inorder.length; i++) {
                idx.put(inorder[i], i);
            }
            return search(0, 0, inorder.length - 1);
        }

        public TreeNode search(int root, int start, int end) {
            if (start > end) return null;
            TreeNode node = new TreeNode(preorder[root]);
            // 获取中序遍历中当前判断根节点的位置，用其左右区间辅助，获取当前节点的左右子树长度
            int index = idx.get(node.val);
            // 左子树的头结点为当前左子树的第一个
            // 左右区间用于在中序遍历数组中获取子数组的长度
            node.left = search(root + 1, start, index - 1);
            // 右子树的头结点=== 当前根节点下标（root）+左子树长度（index-start）+1
            node.right = search(root + index - start + 1, index + 1, end);
            return node;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
