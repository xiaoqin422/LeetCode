//<p>定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例:</strong></p>
//
//<pre><strong>输入:</strong> 1-&gt;2-&gt;3-&gt;4-&gt;5-&gt;NULL
//<strong>输出:</strong> 5-&gt;4-&gt;3-&gt;2-&gt;1-&gt;NULL</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>限制：</strong></p>
//
//<p><code>0 &lt;= 节点个数 &lt;= 5000</code></p>
//
//<p>&nbsp;</p>
//
//<p><strong>注意</strong>：本题与主站 206 题相同：<a href="https://leetcode-cn.com/problems/reverse-linked-list/">https://leetcode-cn.com/problems/reverse-linked-list/</a></p>
//<div><div>Related Topics</div><div><li>递归</li><li>链表</li></div></div><br><div><li>👍 415</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

import com.study.leetcode.editor.cn.helpClass.ListNode;

/**
 * [剑指 Offer 24]反转链表
 *
 * @author 秦笑笑
 * @date 2022-04-04 16:24:11
 */
public class FanZhuanLianBiaoLcof {
    public static void main(String[] args) {
        Solution solution = new FanZhuanLianBiaoLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode pre = null;
            ListNode next = null;
            ListNode root = head;
            while (root != null) {
                next = root.next;
                root.next = pre;
                pre = root;
                if (next == null) break;
                root = next;
            }
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
