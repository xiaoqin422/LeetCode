//<p>请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。</p>
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
//  [20,9],
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
//<div><div>Related Topics</div><div><li>树</li><li>广度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 212</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

import com.study.leetcode.editor.cn.helpClass.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * [剑指 Offer 32 - III]从上到下打印二叉树 III
 * @author 秦笑笑
 * @date 2022-04-15 20:24:20
 */
public class CongShangDaoXiaDaYinErChaShuIiiLcof {
    public static void main(String[] args) {
        Solution solution = new CongShangDaoXiaDaYinErChaShuIiiLcof().new Solution();
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
        boolean flag = true;
        while (!deque.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            for (int i = deque.size(); i > 0; i--) {
                TreeNode node;
                if (flag){
                    node = deque.poll();
                    if (node.left != null) deque.add(node.left);
                    if (node.right != null) deque.add(node.right);
                }else {
                    node = deque.pollLast();
                    if (node.right != null) deque.addFirst(node.right);
                    if (node.left != null) deque.addFirst(node.left);
                }
                temp.add(node.val);
            }
            flag = !flag;
            list.add(temp);
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
