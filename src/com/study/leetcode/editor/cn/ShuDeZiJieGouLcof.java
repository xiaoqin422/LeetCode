//<p>输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)</p>
//
//<p>B是A的子结构， 即 A中有出现和B相同的结构和节点值。</p>
//
//<p>例如:<br>
//给定的树 A:</p>
//
//<p><code>&nbsp; &nbsp; &nbsp;3<br>
//&nbsp; &nbsp; / \<br>
//&nbsp; &nbsp;4 &nbsp; 5<br>
//&nbsp; / \<br>
//&nbsp;1 &nbsp; 2</code><br>
//给定的树 B：</p>
//
//<p><code>&nbsp; &nbsp;4&nbsp;<br>
//&nbsp; /<br>
//&nbsp;1</code><br>
//返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre><strong>输入：</strong>A = [1,2,3], B = [3,1]
//<strong>输出：</strong>false
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre><strong>输入：</strong>A = [3,4,5,1,2], B = [4,1]
//<strong>输出：</strong>true</pre>
//
//<p><strong>限制：</strong></p>
//
//<p><code>0 &lt;= 节点个数 &lt;= 10000</code></p>
//<div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 528</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

import com.study.leetcode.editor.cn.helpClass.TreeNode;

import java.util.Stack;

/**
 * [剑指 Offer 26]树的子结构
 *
 * @author 秦笑笑
 * @date 2022-04-04 16:44:14
 */
public class ShuDeZiJieGouLcof {
    public static void main(String[] args) {
        Solution solution = new ShuDeZiJieGouLcof().new Solution();
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
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            if (B == null) return false;
            TreeNode a = A;
            TreeNode b = B;
            Stack<TreeNode> stack = new Stack<>();
            while (a != null || !stack.isEmpty()) {
                if (a == null) {
                    a = stack.pop();
                    a = a.right;
                    continue;
                }
                if (a.val == b.val && isSame(a, b)) {
                    return true;
                } else {
                    stack.push(a);
                    a = a.left;
                }
            }
            return false;
        }

        private boolean isSame(TreeNode a, TreeNode b) {
            if (b == null) return true;
            if (a==null || a.val != b.val) return false;
            return isSame(a.left,b.left) && isSame(a.right,b.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
