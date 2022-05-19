package com.study.leetcode.editor.cn;
//<p>序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。</p>
//
//<p>请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。</p>
//
//<p><strong>提示: </strong>输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 <a href="/faq/#binary-tree">LeetCode 序列化二叉树的格式</a>。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。</p>
//
//<p> </p>
//
//<p><strong>示例 1：</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2020/09/15/serdeser.jpg" style="width: 442px; height: 324px;" />
//<pre>
//<strong>输入：</strong>root = [1,2,3,null,null,4,5]
//<strong>输出：</strong>[1,2,3,null,null,4,5]
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
//<strong>输入：</strong>root = [1]
//<strong>输出：</strong>[1]
//</pre>
//
//<p><strong>示例 4：</strong></p>
//
//<pre>
//<strong>输入：</strong>root = [1,2]
//<strong>输出：</strong>[1,2]
//</pre>
//
//<p> </p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li>树中结点数在范围 <code>[0, 10<sup>4</sup>]</code> 内</li>
//	<li><code>-1000 <= Node.val <= 1000</code></li>
//</ul>
//<div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>广度优先搜索</li><li>设计</li><li>字符串</li><li>二叉树</li></div></div><br><div><li>👍 872</li><li>👎 0</li></div>

import com.study.leetcode.editor.cn.help.TreeNode;

/**
 * [297]serialize-and-deserialize-binary-tree
 *
 * @author 秦笑笑
 * @date 2022-05-17 09:55:26
 */
public class P297_SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {
        // Solution solution = new P297_SerializeAndDeserializeBinaryTree().new Solution();
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
    public class Codec {
        private StringBuilder ans = new StringBuilder();
        private String[] arr;
        private int index = 0;
        private final String SPLIT = ",";
        private final String NULL = "#";

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            tran(root);
            return ans.substring(0, ans.length() - 1);
        }

        public void tran(TreeNode treeNode) {
            if (treeNode == null) {
                ans.append(NULL).append(SPLIT);
                return;
            }
            ans.append(treeNode.val).append(SPLIT);
            tran(treeNode.left);
            tran(treeNode.right);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            index = 0;
            arr = data.split(SPLIT);
            return deTran();
        }

        public TreeNode deTran() {
            if (index >= arr.length || "#".equals(arr[index])) {
                index++;
                return null;
            }
            TreeNode node = new TreeNode(Integer.parseInt(arr[index]));
            index ++;
            node.left = deTran();
            node.right = deTran();
            return node;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}
