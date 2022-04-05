//<p>输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。</p>
//
//<p>假设输入的前序遍历和中序遍历的结果中都不含重复的数字。</p>
//
//<p> </p>
//
//<p><strong>示例 1:</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/tree.jpg" />
//<pre>
//<strong>Input:</strong> preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//<strong>Output:</strong> [3,9,20,null,null,15,7]
//</pre>
//
//<p><strong>示例 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> preorder = [-1], inorder = [-1]
//<strong>Output:</strong> [-1]
//</pre>
//
//<p> </p>
//
//<p><strong>限制：</strong></p>
//
//<p><code>0 <= 节点个数 <= 5000</code></p>
//
//<p> </p>
//
//<p><strong>注意</strong>：本题与主站 105 题重复：<a href="https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/">https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/</a></p>
//<div><div>Related Topics</div><div><li>树</li><li>数组</li><li>哈希表</li><li>分治</li><li>二叉树</li></div></div><br><div><li>👍 730</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

import com.study.leetcode.editor.cn.helpClass.TreeNode;

import java.util.HashMap;

/**
 * [剑指 Offer 07]重建二叉树
 *
 * @author 秦笑笑
 * @date 2022-03-28 17:23:52
 */
public class ZhongJianErChaShuLcof {
    public static void main(String[] args) {
        Solution solution = new ZhongJianErChaShuLcof().new Solution();
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
        int[] preorder;
        HashMap<Integer, Integer> rec = new HashMap<>();

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            this.preorder = preorder;
            for (int i = 0; i < inorder.length; i++) {
                rec.put(inorder[i], i);
            }
            return search(0,0,preorder.length - 1);
        }

        public TreeNode search(int root, int start, int end) {
            if (start > end) return null;
            TreeNode node = new TreeNode(preorder[root]);
            int index = rec.get(node.val);
            node.left = search(root + 1,start,index - 1);
            node.right = search(index  - start + root + 1,index + 1,end);
            return node;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
