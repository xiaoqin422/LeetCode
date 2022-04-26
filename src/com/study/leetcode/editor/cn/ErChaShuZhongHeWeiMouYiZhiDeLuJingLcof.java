//<p>给你二叉树的根节点 <code>root</code> 和一个整数目标和 <code>targetSum</code> ，找出所有 <strong>从根节点到叶子节点</strong> 路径总和等于给定目标和的路径。</p>
//
//<p><strong>叶子节点</strong> 是指没有子节点的节点。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<p><img alt="" src="https://assets.leetcode.com/uploads/2021/01/18/pathsumii1.jpg" /></p>
//
//<pre>
//<strong>输入：</strong>root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//<strong>输出：</strong>[[5,4,11,2],[5,8,4,5]]
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<p><img alt="" src="https://assets.leetcode.com/uploads/2021/01/18/pathsum2.jpg" /></p>
//
//<pre>
//<strong>输入：</strong>root = [1,2,3], targetSum = 5
//<strong>输出：</strong>[]
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre>
//<strong>输入：</strong>root = [1,2], targetSum = 0
//<strong>输出：</strong>[]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li>树中节点总数在范围 <code>[0, 5000]</code> 内</li>
//	<li><code>-1000 &lt;= Node.val &lt;= 1000</code></li>
//	<li><code>-1000 &lt;= targetSum &lt;= 1000</code></li>
//</ul>
//
//<p>注意：本题与主站 113&nbsp;题相同：<a href="https://leetcode-cn.com/problems/path-sum-ii/">https://leetcode-cn.com/problems/path-sum-ii/</a></p>
//<div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>回溯</li><li>二叉树</li></div></div><br><div><li>👍 321</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

import com.study.leetcode.editor.cn.helpClass.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * [剑指 Offer 34]二叉树中和为某一值的路径
 * @author 秦笑笑
 * @date 2022-04-17 23:00:27
 */
public class ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof {
    public static void main(String[] args) {
        Solution solution = new ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof().new Solution();
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
    List<List<Integer>> res;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        res = new ArrayList<>();
        this.target = target;
        if (root == null) return res;
        List<Integer> status = new ArrayList<>();
        help(status,0,root);
        return res;
    }
    private void help(List<Integer> list,int sum,TreeNode node){
        if (node == null)  return;
        sum += node.val;
        list.add(node.val);
        if (sum == target && node.left == null && node.right == null){
            res.add(new ArrayList<>(list));
            return;
        }
        int size = list.size(); //记录
        help(list,sum,node.left); //
        if (list.size() > size){
            list.remove(list.size() - 1);// 回溯
        }
        help(list,sum,node.right);
        if (list.size() > size){
            list.remove(list.size() - 1);// 回溯
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
