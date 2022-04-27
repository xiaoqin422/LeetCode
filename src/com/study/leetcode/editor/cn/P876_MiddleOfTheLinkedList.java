package com.study.leetcode.editor.cn;
//<p>给定一个头结点为 <code>head</code> 的非空单链表，返回链表的中间结点。</p>
//
//<p>如果有两个中间结点，则返回第二个中间结点。</p>
//
//<p> </p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>[1,2,3,4,5]
//<strong>输出：</strong>此列表中的结点 3 (序列化形式：[3,4,5])
//返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
//注意，我们返回了一个 ListNode 类型的对象 ans，这样：
//ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>[1,2,3,4,5,6]
//<strong>输出：</strong>此列表中的结点 4 (序列化形式：[4,5,6])
//由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
//</pre>
//
//<p> </p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li>给定链表的结点数介于 <code>1</code> 和 <code>100</code> 之间。</li>
//</ul>
//<div><div>Related Topics</div><div><li>链表</li><li>双指针</li></div></div><br><div><li>👍 553</li><li>👎 0</li></div>

import com.study.leetcode.editor.cn.help.ListNode;
import com.sun.xml.internal.ws.util.exception.LocatableWebServiceException;

/**
 * [876]middle-of-the-linked-list
 * @author 秦笑笑
 * @date 2022-04-27 17:06:58
 */
public class P876_MiddleOfTheLinkedList {
    public static void main(String[] args) {
        Solution solution = new P876_MiddleOfTheLinkedList().new Solution();
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
    // 快慢指针
    // 快节点一次走两步，慢节点一次走一步，快节点总是慢节点的两倍
    // 当快节点都尾部的时候，慢节点即为中点
    public ListNode middleNode(ListNode head) {
        ListNode fast = head,low = head;
        // 注意循环条件问题
        // 当节点数量为偶数时，low为中间两个位置的靠后一个
        while (fast != null && fast.next != null){
            low = low.next;
            fast = fast.next.next;
        }
        return low;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
