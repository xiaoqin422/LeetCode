//<p>从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。</p>
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
//<p>返回：</p>
//
//<pre>[3,9,20,15,7]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ol>
//	<li><code>节点总数 &lt;= 1000</code></li>
//</ol>
//<div><div>Related Topics</div><div><li>树</li><li>广度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 187</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

import com.study.leetcode.editor.cn.helpClass.TreeNode;

import java.util.*;

/**
 * [剑指 Offer 32 - I]从上到下打印二叉树
 *
 * @author 秦笑笑
 * @date 2022-04-15 19:04:11
 */
public class CongShangDaoXiaDaYinErChaShuLcof {
    public static void main(String[] args) {
        Solution solution = new CongShangDaoXiaDaYinErChaShuLcof().new Solution();
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
        public int[] levelOrder(TreeNode root) {
            if (root == null) return new int[0];
            List<Integer> list = new ArrayList<>();
            Deque<TreeNode> deque = new LinkedList<>();
            deque.add(root);
            while (!deque.isEmpty()) {
                TreeNode node = deque.pop();
                list.add(node.val);
                if (node.left != null) deque.add(node.left);
                if (node.right != null) deque.add(node.right);
            }
            int[] res = new int[list.size()];
            int index = 0;
            for (Integer item : list) {
                res[index++] = item;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
