package com.study.leetcode.editor.cn;
//<p>给定一个链表的头节点 &nbsp;<code>head</code>&nbsp;，返回链表开始入环的第一个节点。&nbsp;<em>如果链表无环，则返回&nbsp;<code>null</code>。</em></p>
//
//<p>如果链表中有某个节点，可以通过连续跟踪 <code>next</code> 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 <code>pos</code> 来表示链表尾连接到链表中的位置（<strong>索引从 0 开始</strong>）。如果 <code>pos</code> 是 <code>-1</code>，则在该链表中没有环。<strong>注意：<code>pos</code> 不作为参数进行传递</strong>，仅仅是为了标识链表的实际情况。</p>
//
//<p><strong>不允许修改 </strong>链表。</p>
//
//<ul>
//</ul>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<p><img src="https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist.png" /></p>
//
//<pre>
//<strong>输入：</strong>head = [3,2,0,-4], pos = 1
//<strong>输出：</strong>返回索引为 1 的链表节点
//<strong>解释：</strong>链表中有一个环，其尾部连接到第二个节点。
//</pre>
//
//<p><strong>示例&nbsp;2：</strong></p>
//
//<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist_test2.png" /></p>
//
//<pre>
//<strong>输入：</strong>head = [1,2], pos = 0
//<strong>输出：</strong>返回索引为 0 的链表节点
//<strong>解释：</strong>链表中有一个环，其尾部连接到第一个节点。
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist_test3.png" /></p>
//
//<pre>
//<strong>输入：</strong>head = [1], pos = -1
//<strong>输出：</strong>返回 null
//<strong>解释：</strong>链表中没有环。
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li>链表中节点的数目范围在范围 <code>[0, 10<sup>4</sup>]</code> 内</li>
//	<li><code>-10<sup>5</sup> &lt;= Node.val &lt;= 10<sup>5</sup></code></li>
//	<li><code>pos</code> 的值为 <code>-1</code> 或者链表中的一个有效索引</li>
//</ul>
//
//<p>&nbsp;</p>
//
//<p><strong>进阶：</strong>你是否可以使用 <code>O(1)</code> 空间解决此题？</p>
//<div><div>Related Topics</div><div><li>哈希表</li><li>链表</li><li>双指针</li></div></div><br><div><li>👍 1546</li><li>👎 0</li></div>

import com.study.leetcode.editor.cn.help.ListNode;

/**
 * [142]linked-list-cycle-ii
 * @author 秦笑笑
 * @date 2022-04-27 17:12:45
 */
public class P142_LinkedListCycleIi {
    public static void main(String[] args) {
        Solution solution = new P142_LinkedListCycleIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head,low = head;
        while (fast != null && fast.next != null){
            low = low.next;
            fast = fast.next.next;
            // 快指针追赶上慢指针 有重合
            if (low == fast) break;
        }
        // 判断循环跳出条件，如果遇到空指针则无重合跳出
        if (fast == null || fast.next == null){
            return null;
        }
        // 有环，此时快指针比慢指针多走了k步 环起点到相遇点距离m  则环长度为K-m  起点到环起点也为k-m ！！！！
        // 则慢指针复位   快慢指针渐进，相遇即为环起点
        low = head;
        while (low != fast){
            low = low.next;
            fast = fast.next;
        }
        return low;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
