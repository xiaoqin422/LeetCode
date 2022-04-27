package com.study.leetcode.editor.cn;
//给你单链表的头节点 <code>head</code> ，请你反转链表，并返回反转后的链表。
//<div class="original__bRMd">
//<div>
//<p> </p>
//
//<p><strong>示例 1：</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/rev1ex1.jpg" style="width: 542px; height: 222px;" />
//<pre>
//<strong>输入：</strong>head = [1,2,3,4,5]
//<strong>输出：</strong>[5,4,3,2,1]
//</pre>
//
//<p><strong>示例 2：</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/rev1ex2.jpg" style="width: 182px; height: 222px;" />
//<pre>
//<strong>输入：</strong>head = [1,2]
//<strong>输出：</strong>[2,1]
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre>
//<strong>输入：</strong>head = []
//<strong>输出：</strong>[]
//</pre>
//
//<p> </p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li>链表中节点的数目范围是 <code>[0, 5000]</code></li>
//	<li><code>-5000 <= Node.val <= 5000</code></li>
//</ul>
//
//<p> </p>
//
//<p><strong>进阶：</strong>链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？</p>
//</div>
//</div>
//<div><div>Related Topics</div><div><li>递归</li><li>链表</li></div></div><br><div><li>👍 2481</li><li>👎 0</li></div>

import com.study.leetcode.editor.cn.help.ListNode;

/**
 * [206]reverse-linked-list
 * @author 秦笑笑
 * @date 2022-04-27 23:25:31
 */
public class P206_ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new P206_ReverseLinkedList().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    // 第一种  while循环
    public ListNode reverseList1(ListNode head) {
        ListNode root = null,next = null;
        while (head != null){
            next = head.next;
            head.next = root;
            root = head;
            head = next;
        }
        return root;
    }

    //第二种  递归翻转链表
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
