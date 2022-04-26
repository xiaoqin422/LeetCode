//<p>请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。</p>
//
//<p>例如，二叉树&nbsp;[1,2,2,3,4,4,3] 是对称的。</p>
//
//<p><code>&nbsp; &nbsp; 1<br>
//&nbsp; &nbsp;/ \<br>
//&nbsp; 2 &nbsp; 2<br>
//&nbsp;/ \ / \<br>
//3 &nbsp;4 4 &nbsp;3</code><br>
//但是下面这个&nbsp;[1,2,2,null,3,null,3] 则不是镜像对称的:</p>
//
//<p><code>&nbsp; &nbsp; 1<br>
//&nbsp; &nbsp;/ \<br>
//&nbsp; 2 &nbsp; 2<br>
//&nbsp; &nbsp;\ &nbsp; \<br>
//&nbsp; &nbsp;3 &nbsp; &nbsp;3</code></p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre><strong>输入：</strong>root = [1,2,2,3,4,4,3]
//<strong>输出：</strong>true
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre><strong>输入：</strong>root = [1,2,2,null,3,null,3]
//<strong>输出：</strong>false</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>限制：</strong></p>
//
//<p><code>0 &lt;= 节点个数 &lt;= 1000</code></p>
//
//<p>注意：本题与主站 101 题相同：<a href="https://leetcode-cn.com/problems/symmetric-tree/">https://leetcode-cn.com/problems/symmetric-tree/</a></p>
//<div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>广度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 323</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

import com.study.leetcode.editor.cn.helpClass.TreeNode;

import java.net.HttpRetryException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * [剑指 Offer 28]对称的二叉树
 * @author 秦笑笑
 * @date 2022-04-05 16:53:16
 */
public class DuiChengDeErChaShuLcof {
    public static void main(String[] args) {
        Solution solution = new DuiChengDeErChaShuLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
    /**
     * 递归深度遍历进行比较
     */
    class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root == null || help(root.left, root.right);
    }

    private boolean help(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if(left == null || right == null || left.val != right.val) return false;
        return help(left.left,right.right) && help(left.right,right.left);
    }

}
/*
 翻转右子树，然后中序遍历进行比较。
 */
class Solution1 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        help(root.right);
        List<Integer> left = DFS(root.left);
        List<Integer> right = DFS(root.right);
        if (left.size() != right.size()) return false;
        for (int i = 0; i < left.size(); i++) {
            if (!Objects.equals(left.get(i), right.get(i))) return false;
        }
        return true;
    }
    public void help(TreeNode node){
        if (node == null) return;
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        help(node.right);
        help(node.left);
    }
    public List<Integer> DFS(TreeNode node){
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()){
            if (node == null){
                list.add(null);
                node = stack.pop().right;
                continue;
            }
            list.add(node.val);
            stack.push(node);
            node = node.left;
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
