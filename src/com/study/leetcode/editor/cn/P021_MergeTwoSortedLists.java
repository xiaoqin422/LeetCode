package com.study.leetcode.editor.cn;
//<p>将两个升序链表合并为一个新的 <strong>升序</strong> 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 </p>
//
//<p> </p>
//
//<p><strong>示例 1：</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/merge_ex1.jpg" style="width: 662px; height: 302px;" />
//<pre>
//<strong>输入：</strong>l1 = [1,2,4], l2 = [1,3,4]
//<strong>输出：</strong>[1,1,2,3,4,4]
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>l1 = [], l2 = []
//<strong>输出：</strong>[]
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre>
//<strong>输入：</strong>l1 = [], l2 = [0]
//<strong>输出：</strong>[0]
//</pre>
//
//<p> </p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li>两个链表的节点数目范围是 <code>[0, 50]</code></li>
//	<li><code>-100 <= Node.val <= 100</code></li>
//	<li><code>l1</code> 和 <code>l2</code> 均按 <strong>非递减顺序</strong> 排列</li>
//</ul>
//<div><div>Related Topics</div><div><li>递归</li><li>链表</li></div></div><br><div><li>👍 2391</li><li>👎 0</li></div>

import com.study.leetcode.editor.cn.help.ListNode;

/**
 * [21]merge-two-sorted-lists
 * @author 秦笑笑
 * @date 2022-04-27 15:28:12
 */
public class P021_MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new P021_MergeTwoSortedLists().new Solution();
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 虚拟头结点
        ListNode root = new ListNode();
        // 虚拟头结点的指针，用于尾插创建链表
        ListNode head = root;
        ListNode p1 = list1,p2 = list2;
        while (p1 != null && p2 != null){
            if (p1.val <= p2.val){
                head.next = p1;
                p1 = p1.next;
            }else {
                head.next = p2;
                p2 = p2.next;
            }
            head = head.next;
        }
        while (p1 != null){
            head.next = p1;
            p1 = p1.next;
            head = head.next;
        }
        while (p2 != null){
            head.next = p2;
            p2 = p2.next;
            head = head.next;
        }
        return root.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
