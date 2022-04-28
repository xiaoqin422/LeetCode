package com.study.leetcode.editor.cn;
//<p>给你一个单链表的头节点 <code>head</code> ，请你判断该链表是否为回文链表。如果是，返回 <code>true</code> ；否则，返回 <code>false</code> 。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2021/03/03/pal1linked-list.jpg" style="width: 422px; height: 62px;" />
//<pre>
//<strong>输入：</strong>head = [1,2,2,1]
//<strong>输出：</strong>true
//</pre>
//
//<p><strong>示例 2：</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2021/03/03/pal2linked-list.jpg" style="width: 182px; height: 62px;" />
//<pre>
//<strong>输入：</strong>head = [1,2]
//<strong>输出：</strong>false
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li>链表中节点数目在范围<code>[1, 10<sup>5</sup>]</code> 内</li>
//	<li><code>0 &lt;= Node.val &lt;= 9</code></li>
//</ul>
//
//<p>&nbsp;</p>
//
//<p><strong>进阶：</strong>你能否用&nbsp;<code>O(n)</code> 时间复杂度和 <code>O(1)</code> 空间复杂度解决此题？</p>
//<div><div>Related Topics</div><div><li>栈</li><li>递归</li><li>链表</li><li>双指针</li></div></div><br><div><li>👍 1363</li><li>👎 0</li></div>

import com.study.leetcode.editor.cn.help.ListNode;

/**
 * [234]palindrome-linked-list
 * @author 秦笑笑
 * @date 2022-04-28 11:55:25
 */
public class P234_PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new P234_PalindromeLinkedList().new Solution();
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
    public boolean isPalindrome(ListNode head) {
        ListNode low = head,fast = head;
        // 递归  low为中点  翻转中点开始的后续链表
        while (fast != null && fast.next != null){
            low = low.next;
            fast = fast.next.next;
        }
        // 有奇数个节点
        if (fast != null){
            low = low.next;
        }
        ListNode right = reverse(low);
        while (right != null){
            if (right.val != head.val){
                return false;
            }
            right = right.next;
            head = head.next;
        }
        return true;
    }
    // 翻转链表
    private ListNode reverse(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
// 递归后续遍历解法
class Solution1 {
    ListNode left = null;
    public boolean isPalindrome(ListNode head) {
        this.left = head;
        return dfs(head);
    }

    // 递归解法
    private boolean dfs(ListNode head){
        if (head == null){
            return true;
        }
        boolean res = dfs(head.next);
        // 后续遍历  递归合并子问题的解
        res = res && (left.val == head.val);
        left = left.next;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
