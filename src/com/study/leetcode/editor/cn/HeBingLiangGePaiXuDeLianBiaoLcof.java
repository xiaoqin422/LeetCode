//<p>输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。</p>
//
//<p><strong>示例1：</strong></p>
//
//<pre><strong>输入：</strong>1-&gt;2-&gt;4, 1-&gt;3-&gt;4
//<strong>输出：</strong>1-&gt;1-&gt;2-&gt;3-&gt;4-&gt;4</pre>
//
//<p><strong>限制：</strong></p>
//
//<p><code>0 &lt;= 链表长度 &lt;= 1000</code></p>
//
//<p>注意：本题与主站 21 题相同：<a href="https://leetcode-cn.com/problems/merge-two-sorted-lists/">https://leetcode-cn.com/problems/merge-two-sorted-lists/</a></p>
//<div><div>Related Topics</div><div><li>递归</li><li>链表</li></div></div><br><div><li>👍 230</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

import com.study.leetcode.editor.cn.helpClass.ListNode;

/**
 * [剑指 Offer 25]合并两个排序的链表
 * @author 秦笑笑
 * @date 2022-04-04 16:33:03
 */
public class HeBingLiangGePaiXuDeLianBiaoLcof {
    public static void main(String[] args) {
        Solution solution = new HeBingLiangGePaiXuDeLianBiaoLcof().new Solution();
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode root = new ListNode(0);
        ListNode tail = root;
        while (node1 != null && node2 != null){
            if (node1.val <= node2.val){
                tail.next = new ListNode(node1.val);
                node1 = node1.next;
            }else {
                tail.next = new ListNode(node2.val);
                node2= node2.next;
            }
            tail = tail.next;
        }
        while (node1 != null){
            tail.next = node1;
            node1 = node1.next;
            tail = tail.next;
        }
        while (node2 != null){
            tail.next = node2;
            node2 = node2.next;
            tail = tail.next;
        }
        return root.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
