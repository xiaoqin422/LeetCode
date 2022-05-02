package com.study.leetcode.editor.cn;
//<p>给定一个已排序的链表的头&nbsp;<code>head</code> ，&nbsp;<em>删除原始链表中所有重复数字的节点，只留下不同的数字</em>&nbsp;。返回 <em>已排序的链表</em>&nbsp;。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2021/01/04/linkedlist1.jpg" style="height: 142px; width: 500px;" />
//<pre>
//<strong>输入：</strong>head = [1,2,3,3,4,4,5]
//<strong>输出：</strong>[1,2,5]
//</pre>
//
//<p><strong>示例 2：</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2021/01/04/linkedlist2.jpg" style="height: 164px; width: 400px;" />
//<pre>
//<strong>输入：</strong>head = [1,1,1,2,3]
//<strong>输出：</strong>[2,3]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li>链表中节点数目在范围 <code>[0, 300]</code> 内</li>
//	<li><code>-100 &lt;= Node.val &lt;= 100</code></li>
//	<li>题目数据保证链表已经按升序 <strong>排列</strong></li>
//</ul>
//<div><div>Related Topics</div><div><li>链表</li><li>双指针</li></div></div><br><div><li>👍 879</li><li>👎 0</li></div>

import com.study.leetcode.editor.cn.help.ListNode;

/**
 * [82]remove-duplicates-from-sorted-list-ii
 * @author 秦笑笑
 * @date 2022-05-02 19:32:15
 */
public class P082_RemoveDuplicatesFromSortedListIi {
    public static void main(String[] args) {
        Solution solution = new P082_RemoveDuplicatesFromSortedListIi().new Solution();
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(-101,head);
        // 记录不被删除的节点
        ListNode pre = head;
        ListNode cur = dummy;
        while (cur != null && cur.next != null){
            if(cur.val == cur.next.val){
                int val = cur.val;
                // 如果当前节点重复，则一直向后遍历，直到该节点的值不重复
                // 此时pre为上一个不重复的节点
                while(cur != null && cur.val == val){
                    cur = cur.next;
                }
                // 将pre指向下一个不重复的节点（删除重复的所有节点）
                pre.next = cur;
            }else{
                pre = cur;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
