package com.study.leetcode.editor.cn;
//<p>给你链表的头结点&nbsp;<code>head</code>&nbsp;，请将其按 <strong>升序</strong> 排列并返回 <strong>排序后的链表</strong> 。</p>
//
//<ul>
//</ul>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2020/09/14/sort_list_1.jpg" style="width: 450px;" />
//<pre>
//<b>输入：</b>head = [4,2,1,3]
//<b>输出：</b>[1,2,3,4]
//</pre>
//
//<p><strong>示例 2：</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2020/09/14/sort_list_2.jpg" style="width: 550px;" />
//<pre>
//<b>输入：</b>head = [-1,5,3,4,0]
//<b>输出：</b>[-1,0,3,4,5]
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre>
//<b>输入：</b>head = []
//<b>输出：</b>[]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><b>提示：</b></p>
//
//<ul>
//	<li>链表中节点的数目在范围&nbsp;<code>[0, 5 * 10<sup>4</sup>]</code>&nbsp;内</li>
//	<li><code>-10<sup>5</sup>&nbsp;&lt;= Node.val &lt;= 10<sup>5</sup></code></li>
//</ul>
//
//<p>&nbsp;</p>
//
//<p><b>进阶：</b>你可以在&nbsp;<code>O(n&nbsp;log&nbsp;n)</code> 时间复杂度和常数级空间复杂度下，对链表进行排序吗？</p>
//<div><div>Related Topics</div><div><li>链表</li><li>双指针</li><li>分治</li><li>排序</li><li>归并排序</li></div></div><br><div><li>👍 1579</li><li>👎 0</li></div>

import com.study.leetcode.editor.cn.help.ListNode;

/**
 * [148]sort-list
 *
 * @author 秦笑笑
 * @date 2022-04-28 13:12:57
 */
public class P148_SortList {
    public static void main(String[] args) {
        Solution solution = new P148_SortList().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            // 快慢指针不同起点，让慢指停留在偶数节点的第一个 ！！！
            ListNode low = head, fast = head.next;
            while (fast != null && fast.next != null) {
                low = low.next;
                fast = fast.next.next;
            }
            ListNode temp = low.next;
            low.next = null;
            ListNode left = sortList(head);
            ListNode right = sortList(temp);
            ListNode  p = new ListNode();
            ListNode ans = p;
            while (left != null && right != null) {
                if (left.val <= right.val) {
                    p.next = left;
                    left = left.next;
                } else {
                    p.next = right;
                    right = right.next;
                }
                p = p.next;
            }
            // 左右连边长度始终相等
            p.next = left == null ? right : left;
            return ans.next;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
