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
//<div><div>Related Topics</div><div><li>树</li><li>数组</li><li>哈希表</li><li>分治</li><li>二叉树</li></div></div><br><div><li>👍 705</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

import com.study.leetcode.editor.cn.helpClass.TreeNode;

import java.util.HashMap;

/**
 * [106]从中序与后序遍历序列构造二叉树
 * @author 秦笑笑
 * @date 2022-03-29 13:24:20
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
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
    int[] postorder;
    HashMap<Integer,Integer> idx = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) return null;
        this.postorder = postorder;
        for (int i = 0; i < inorder.length; i++) {
            idx.put(inorder[i],i);
        }
        return search(postorder.length - 1,0, postorder.length - 1);
    }
    public TreeNode search(int root ,int start, int end){
        if (start > end) return null;
        TreeNode node = new TreeNode(postorder[root]);
        if (start == end) return node;
        // 划分左右子树的长度和区间
        int index = idx.get(node.val);
    //   1、确定左右子树长度----中序遍历 左子树长度 [index - start]  右子树长度[end - index]
    //   2、确定下一次的头结点，
    //   3、确定下一次的区间范围（！！！！相对于终须遍历）
        node.left = search(root - end + index - 1,start,index - 1);
        node.right = search(root - 1,index + 1,end);
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
