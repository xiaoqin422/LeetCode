//<p>输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。</p>
//
//<p>例如：</p>
//
//<p>给定二叉树 <code>[3,9,20,null,null,15,7]</code>，</p>
//
//<pre>    3
//   / \
//  9  20
//    /  \
//   15   7</pre>
//
//<p>返回它的最大深度&nbsp;3 。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ol>
//	<li><code>节点总数 &lt;= 10000</code></li>
//</ol>
//
//<p>注意：本题与主站 104&nbsp;题相同：<a href="https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/">https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/</a></p>
//<div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>广度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 186</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

import com.study.leetcode.editor.cn.helpClass.TreeNode;

import java.lang.reflect.Modifier;
import java.util.LinkedList;
import java.util.Queue;

/**
 * [剑指 Offer 55 - I]二叉树的深度
 * @author 秦笑笑
 * @date 2022-04-24 12:54:28
 */
public class ErChaShuDeShenDuLcof {
    public static void main(String[] args) {
        Solution solution = new ErChaShuDeShenDuLcof().new Solution();
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
class Solution {
    // DFS
    public int maxDepth(TreeNode root){
        if (root == null){
            return 0;
        }else {
            int l = maxDepth(root.left);
            int r = maxDepth(root.right);
            return Math.max(l,r) + 1;
        }
    }
    // BFS
    public int maxDepth1(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int len = 0;
        while (!queue.isEmpty()){
            // 处理完一层
            int size = queue.size();
            while (size > 0){
                TreeNode node = queue.poll();
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
                size --;
            }
            // 深度+1
            len ++;
        }
        return len;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
