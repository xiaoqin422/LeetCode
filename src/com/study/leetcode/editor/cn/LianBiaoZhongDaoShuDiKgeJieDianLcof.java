//<p>输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。</p>
//
//<p>例如，一个链表有 <code>6</code> 个节点，从头节点开始，它们的值依次是 <code>1、2、3、4、5、6</code>。这个链表的倒数第 <code>3</code> 个节点是值为 <code>4</code> 的节点。</p>
//
//<p> </p>
//
//<p><strong>示例：</strong></p>
//
//<pre>
//给定一个链表: <strong>1->2->3->4->5</strong>, 和 <em>k </em><strong>= 2</strong>.
//
//返回链表 4<strong>->5</strong>.</pre>
//<div><div>Related Topics</div><div><li>链表</li><li>双指针</li></div></div><br><div><li>👍 343</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

import com.study.leetcode.editor.cn.helpClass.ListNode;

import java.util.Stack;

/**
 * [剑指 Offer 22]链表中倒数第k个节点
 * @author 秦笑笑
 * @date 2022-04-04 16:17:51
 */
public class LianBiaoZhongDaoShuDiKgeJieDianLcof {
    public static void main(String[] args) {
        Solution solution = new LianBiaoZhongDaoShuDiKgeJieDianLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        int index = 0;
        ListNode res = null;
        Stack<ListNode> stack = new Stack<>();
        while (head != null){
            stack.push(head);
            head = head.next;
        }
        while (!stack.isEmpty() && index != k){
            res = stack.pop();
            index++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
