package com.study.leetcode.editor.cn;
//<p>给你一个链表，删除链表的倒数第&nbsp;<code>n</code><em>&nbsp;</em>个结点，并且返回链表的头结点。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/remove_ex1.jpg" style="width: 542px; height: 222px;" />
//<pre>
//<strong>输入：</strong>head = [1,2,3,4,5], n = 2
//<strong>输出：</strong>[1,2,3,5]
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>head = [1], n = 1
//<strong>输出：</strong>[]
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre>
//<strong>输入：</strong>head = [1,2], n = 1
//<strong>输出：</strong>[1]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li>链表中结点的数目为 <code>sz</code></li>
//	<li><code>1 &lt;= sz &lt;= 30</code></li>
//	<li><code>0 &lt;= Node.val &lt;= 100</code></li>
//	<li><code>1 &lt;= n &lt;= sz</code></li>
//</ul>
//
//<p>&nbsp;</p>
//
//<p><strong>进阶：</strong>你能尝试使用一趟扫描实现吗？</p>
//<div><div>Related Topics</div><div><li>链表</li><li>双指针</li></div></div><br><div><li>👍 1998</li><li>👎 0</li></div>

import com.study.leetcode.editor.cn.help.ListNode;

/**
 * [19]remove-nth-node-from-end-of-list
 * @author 秦笑笑
 * @date 2022-04-27 16:01:23
 */
public class P019_RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new P019_RemoveNthNodeFromEndOfList().new Solution();
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
    // 解法：①双指针（最优） ②栈，遍历结束计数出栈
    // 双指针+步长，特别注意倒数第n个节点等于步长的情况！！！！
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 链表增加、删除
        // 虚拟头结点可以解决空指针等特殊问题！！！！
        // 增加----头结点（起点）标志位  删除----删除头结点
        ListNode dummy = new ListNode(0,head); //慢指针起点
        ListNode first = head; //快指针
        ListNode second = dummy; //指向需要删除的节点
        // 快指针走满步长
        // n肯定小于等于链表长度 不考虑空指针问题
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        // 如果此时快指针为null  则表示需要删除头部
        while (first != null){
            first = first.next;
            second = second.next;
        }
        // dummy节点的作用体现出来了，  删除头部情况直接解决！！！！
        second.next = second.next.next;
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
