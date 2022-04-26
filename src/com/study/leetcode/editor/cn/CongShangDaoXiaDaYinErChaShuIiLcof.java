//<p>从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。</p>
//
//<p>&nbsp;</p>
//
//<p>例如:<br>
//给定二叉树:&nbsp;<code>[3,9,20,null,null,15,7]</code>,</p>
//
//<pre>    3
//   / \
//  9  20
//    /  \
//   15   7
//</pre>
//
//<p>返回其层次遍历结果：</p>
//
//<pre>[
//  [3],
//  [9,20],
//  [15,7]
//]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ol>
//	<li><code>节点总数 &lt;= 1000</code></li>
//</ol>
//
//<p>注意：本题与主站 102 题相同：<a href="https://leetcode-cn.com/problems/binary-tree-level-order-traversal/">https://leetcode-cn.com/problems/binary-tree-level-order-traversal/</a></p>
//<div><div>Related Topics</div><div><li>树</li><li>广度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 214</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

import com.study.leetcode.editor.cn.helpClass.TreeNode;

import java.util.*;

/**
 * [剑指 Offer 32 - II]从上到下打印二叉树 II
 * @author 秦笑笑
 * @date 2022-04-15 20:02:24
 */
public class CongShangDaoXiaDaYinErChaShuIiLcof {
    public static void main(String[] args) {
        Solution solution = new CongShangDaoXiaDaYinErChaShuIiLcof().new Solution();
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if (root != null) deque.add(root);
        while (!deque.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            for (int i = deque.size(); i > 0; i--) {
                TreeNode node = deque.poll();
                temp.add(node.val);
                if (node.left != null) deque.add(node.left);
                if (node.right != null) deque.add(node.right);
            }
            list.add(temp);
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
