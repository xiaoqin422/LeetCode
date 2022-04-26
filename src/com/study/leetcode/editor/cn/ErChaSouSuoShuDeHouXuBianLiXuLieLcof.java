//<p>输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回&nbsp;<code>true</code>，否则返回&nbsp;<code>false</code>。假设输入的数组的任意两个数字都互不相同。</p>
//
//<p>&nbsp;</p>
//
//<p>参考以下这颗二叉搜索树：</p>
//
//<pre>     5
//    / \
//   2   6
//  / \
// 1   3</pre>
//
//<p><strong>示例 1：</strong></p>
//
//<pre><strong>输入: </strong>[1,6,3,2,5]
//<strong>输出: </strong>false</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre><strong>输入: </strong>[1,3,2,6,5]
//<strong>输出: </strong>true</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ol>
//	<li><code>数组长度 &lt;= 1000</code></li>
//</ol>
//<div><div>Related Topics</div><div><li>栈</li><li>树</li><li>二叉搜索树</li><li>递归</li><li>二叉树</li><li>单调栈</li></div></div><br><div><li>👍 483</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

/**
 * [剑指 Offer 33]二叉搜索树的后序遍历序列
 *
 * @author 秦笑笑
 * @date 2022-04-15 20:54:26
 */
public class ErChaSouSuoShuDeHouXuBianLiXuLieLcof {
    public static void main(String[] args) {
        Solution solution = new ErChaSouSuoShuDeHouXuBianLiXuLieLcof().new Solution();
        System.out.println(solution.verifyPostorder(new int[]{4, 8, 6, 12, 16, 14, 10}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] postorder = null;

        public boolean verifyPostorder(int[] postorder) {
            this.postorder = postorder;
            return help(0, postorder.length - 1);
        }

        private boolean help(int start, int end) {
            //当 start >= end ，说明此子树节点数量小于1 ，无需判别正确性，因此直接返回 true ；
            if (start >= end) return true;
            // 划分左右子树
            // 左子树最后一个  左子树【start，p - 1】  右子树【p，end-1】
            int p = start;
            while (postorder[p] < postorder[end]) {
                p++;
            }
            int m = p - 1;
            while (postorder[p] > postorder[end]) {
                p++;
            }
            return p == end && help(start, m) && help(m + 1, end - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
