package com.study.leetcode.editor.cn;
//<p>给你二叉树的根结点 <code>root</code> ，请你将它展开为一个单链表：</p>
//
//<ul>
//	<li>展开后的单链表应该同样使用 <code>TreeNode</code> ，其中 <code>right</code> 子指针指向链表中下一个结点，而左子指针始终为 <code>null</code> 。</li>
//	<li>展开后的单链表应该与二叉树 <a href="https://baike.baidu.com/item/%E5%85%88%E5%BA%8F%E9%81%8D%E5%8E%86/6442839?fr=aladdin" target="_blank"><strong>先序遍历</strong></a> 顺序相同。</li>
//</ul>
//
//<p> </p>
//
//<p><strong>示例 1：</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2021/01/14/flaten.jpg" style="width: 500px; height: 226px;" />
//<pre>
//<strong>输入：</strong>root = [1,2,5,3,4,null,6]
//<strong>输出：</strong>[1,null,2,null,3,null,4,null,5,null,6]
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>root = []
//<strong>输出：</strong>[]
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre>
//<strong>输入：</strong>root = [0]
//<strong>输出：</strong>[0]
//</pre>
//
//<p> </p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li>树中结点数在范围 <code>[0, 2000]</code> 内</li>
//	<li><code>-100 <= Node.val <= 100</code></li>
//</ul>
//
//<p> </p>
//
//<p><strong>进阶：</strong>你可以使用原地算法（<code>O(1)</code> 额外空间）展开这棵树吗？</p>
//<div><div>Related Topics</div><div><li>栈</li><li>树</li><li>深度优先搜索</li><li>链表</li><li>二叉树</li></div></div><br><div><li>👍 1160</li><li>👎 0</li></div>

import com.study.leetcode.editor.cn.help.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * [114]flatten-binary-tree-to-linked-list
 * @author 秦笑笑
 * @date 2022-04-28 15:53:36
 */
public class P114_FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        Solution solution = new P114_FlattenBinaryTreeToLinkedList().new Solution();
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
    private TreeNode p;
    public void flatten(TreeNode root) {
        // p = new TreeNode();
        // TreeNode ans = p;
        // dfs(root);
        // root = ans.right;
        // 解法②分解子问题
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode p = root;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = left;
        // 核心！！！！不能是简单的赋值，
        // 保证左子树的最右边跟右子树连接！！！！
        while (p.right != null){
            p = p.right;
        }
        p.right = right;
    }
    // 解法①遍历
    private void dfs(TreeNode head){
        if (head == null) return;
        TreeNode right = head.right;
        p.right = head;
        p = p.right;
        dfs(head.left);
        head.left = null;
        dfs(right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
