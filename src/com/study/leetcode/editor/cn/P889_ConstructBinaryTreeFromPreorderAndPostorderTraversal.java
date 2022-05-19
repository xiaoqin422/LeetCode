package com.study.leetcode.editor.cn;
//<p>给定两个整数数组，<code>preorder</code>&nbsp;和 <code>postorder</code> ，其中 <code>preorder</code> 是一个具有 <strong>无重复</strong> 值的二叉树的前序遍历，<code>postorder</code> 是同一棵树的后序遍历，重构并返回二叉树。</p>
//
//<p>如果存在多个答案，您可以返回其中 <strong>任何</strong> 一个。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<p><img src="https://assets.leetcode.com/uploads/2021/07/24/lc-prepost.jpg" style="height: 265px; width: 304px;" /></p>
//
//<pre>
//<strong>输入：</strong>preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
//<strong>输出：</strong>[1,2,3,4,5,6,7]
//</pre>
//
//<p><strong>示例 2:</strong></p>
//
//<pre>
//<strong>输入:</strong> preorder = [1], postorder = [1]
//<strong>输出:</strong> [1]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>1 &lt;= preorder.length &lt;= 30</code></li>
//	<li><code>1 &lt;= preorder[i] &lt;= preorder.length</code></li>
//	<li><code>preorder</code>&nbsp;中所有值都 <strong>不同</strong></li>
//	<li><code>postorder.length == preorder.length</code></li>
//	<li><code>1 &lt;= postorder[i] &lt;= postorder.length</code></li>
//	<li><code>postorder</code>&nbsp;中所有值都 <strong>不同</strong></li>
//	<li>保证 <code>preorder</code>&nbsp;和 <code>postorder</code>&nbsp;是同一棵二叉树的前序遍历和后序遍历</li>
//</ul>
//<div><div>Related Topics</div><div><li>树</li><li>数组</li><li>哈希表</li><li>分治</li><li>二叉树</li></div></div><br><div><li>👍 248</li><li>👎 0</li></div>

import com.study.leetcode.editor.cn.help.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * [889]construct-binary-tree-from-preorder-and-postorder-traversal
 *
 * @author 秦笑笑
 * @date 2022-05-17 08:26:05
 */
public class P889_ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P889_ConstructBinaryTreeFromPreorderAndPostorderTraversal().new Solution();
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
        Map<Integer, Integer> dp = new HashMap<>();
        int[] preorder;
        int[] postorder;
        HashMap<Integer, Integer> map = new HashMap<>();

        public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
            this.preorder = preorder;
            this.postorder = postorder;
            for (int i = 0; i < postorder.length; i++) {
                map.put(postorder[i], i);
            }
            return build(0,preorder.length - 1,0,postorder.length - 1);
        }

        private TreeNode build(int start, int end, int l, int r) {
            if (start > end) return null;
            TreeNode node = new TreeNode(preorder[start]);
            int lIndex = start + 1;
            // 在有限边界中构建左子树（如果无法构建 说明没有子树）直接返回
            if (lIndex > end) return node;
            int left = preorder[lIndex];//左子树的值
            Integer index = map.get(left);
            // node 的 left 的 左子树有多长
            int len = index - l ;
            node.left = build(lIndex, lIndex + len, l,index);
            node.right = build(lIndex + len + 1, end, index + 1,r);
            return node;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
