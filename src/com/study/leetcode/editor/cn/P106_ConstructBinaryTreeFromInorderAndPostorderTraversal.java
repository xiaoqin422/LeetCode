package com.study.leetcode.editor.cn;
//<p>给定两个整数数组 <code>inorder</code> 和 <code>postorder</code> ，其中 <code>inorder</code> 是二叉树的中序遍历， <code>postorder</code> 是同一棵树的后序遍历，请你构造并返回这颗&nbsp;<em>二叉树</em>&nbsp;。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1:</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/tree.jpg" />
//<pre>
//<b>输入：</b>inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//<b>输出：</b>[3,9,20,null,null,15,7]
//</pre>
//
//<p><strong>示例 2:</strong></p>
//
//<pre>
//<b>输入：</b>inorder = [-1], postorder = [-1]
//<b>输出：</b>[-1]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示:</strong></p>
//
//<ul>
//	<li><code>1 &lt;= inorder.length &lt;= 3000</code></li>
//	<li><code>postorder.length == inorder.length</code></li>
//	<li><code>-3000 &lt;= inorder[i], postorder[i] &lt;= 3000</code></li>
//	<li><code>inorder</code>&nbsp;和&nbsp;<code>postorder</code>&nbsp;都由 <strong>不同</strong> 的值组成</li>
//	<li><code>postorder</code>&nbsp;中每一个值都在&nbsp;<code>inorder</code>&nbsp;中</li>
//	<li><code>inorder</code>&nbsp;<strong>保证</strong>是树的中序遍历</li>
//	<li><code>postorder</code>&nbsp;<strong>保证</strong>是树的后序遍历</li>
//</ul>
//<div><div>Related Topics</div><div><li>树</li><li>数组</li><li>哈希表</li><li>分治</li><li>二叉树</li></div></div><br><div><li>👍 746</li><li>👎 0</li></div>

import com.study.leetcode.editor.cn.help.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * [106]construct-binary-tree-from-inorder-and-postorder-traversal
 *
 * @author 秦笑笑
 * @date 2022-05-17 09:19:59
 */
public class P106_ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P106_ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
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
        Map<Integer, Integer> map = new HashMap<>();
        int[] postorder;

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            this.postorder = postorder;
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            return build(0, postorder.length - 1, 0);
        }

        public TreeNode build(int start, int end, int l) {
            if (start > end) return null;
            TreeNode node = new TreeNode(postorder[end]);
            Integer index = map.get(node.val);
            //左子树长度
            int len = index - l;
            node.right = build(start + len, end - 1, index + 1);
            node.left = build(start,start + len - 1, l);
            return node;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
