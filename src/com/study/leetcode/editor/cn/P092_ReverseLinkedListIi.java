package com.study.leetcode.editor.cn;
//给你单链表的头指针 <code>head</code> 和两个整数 <code>left</code> 和 <code>right</code> ，其中 <code>left <= right</code> 。请你反转从位置 <code>left</code> 到位置 <code>right</code> 的链表节点，返回 <strong>反转后的链表</strong> 。
//<p> </p>
//
//<p><strong>示例 1：</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/rev2ex2.jpg" style="width: 542px; height: 222px;" />
//<pre>
//<strong>输入：</strong>head = [1,2,3,4,5], left = 2, right = 4
//<strong>输出：</strong>[1,4,3,2,5]
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>head = [5], left = 1, right = 1
//<strong>输出：</strong>[5]
//</pre>
//
//<p> </p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li>链表中节点数目为 <code>n</code></li>
//	<li><code>1 <= n <= 500</code></li>
//	<li><code>-500 <= Node.val <= 500</code></li>
//	<li><code>1 <= left <= right <= n</code></li>
//</ul>
//
//<p> </p>
//
//<p><strong>进阶：</strong> 你可以使用一趟扫描完成反转吗？</p>
//<div><div>Related Topics</div><div><li>链表</li></div></div><br><div><li>👍 1252</li><li>👎 0</li></div>

import com.study.leetcode.editor.cn.help.ListNode;

/**
 * [92]reverse-linked-list-ii
 * @author 秦笑笑
 * @date 2022-04-28 00:53:49
 */
public class P092_ReverseLinkedListIi {
    public static void main(String[] args) {
        Solution solution = new P092_ReverseLinkedListIi().new Solution();
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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1){
            return reverseN(head,right);
        }
        // 局部以head的下一个节点为头节点进行翻转，最后分解对翻转前个节点
        head.next = reverseBetween(head.next,left - 1,right - 1);
        return head;
    }
    // 用来记录第n个节点
    // ListNode curNode = null;
    // 翻转链表前n个节点
    public ListNode reverseN(ListNode head, int n) {
        if (n == 1){
            // curNode = head.next;
            return head;
        }
        // last节点为头部节点
        ListNode last = reverseN(head.next,n - 1);
        // head.next.next = head;
        // head.next = curNode;

        // 指向last节点的指针（后续用head节点的存放第n个节点时递归传递）
        ListNode N = head.next;
        // 将第N个节点放到head.next指针指向 ！！！等效于 head.next = curNode;
        head.next = N.next;
        // last指向head  翻转 ！！！等效于 head.next.next = head;
        N.next = head;

        return last;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
