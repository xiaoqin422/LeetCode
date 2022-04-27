package com.study.leetcode.editor.cn;
//<p>给你一个链表数组，每个链表都已经按升序排列。</p>
//
//<p>请你将所有链表合并到一个升序链表中，返回合并后的链表。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre><strong>输入：</strong>lists = [[1,4,5],[1,3,4],[2,6]]
//<strong>输出：</strong>[1,1,2,3,4,4,5,6]
//<strong>解释：</strong>链表数组如下：
//[
//  1-&gt;4-&gt;5,
//  1-&gt;3-&gt;4,
//  2-&gt;6
//]
//将它们合并到一个有序链表中得到。
//1-&gt;1-&gt;2-&gt;3-&gt;4-&gt;4-&gt;5-&gt;6
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre><strong>输入：</strong>lists = []
//<strong>输出：</strong>[]
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre><strong>输入：</strong>lists = [[]]
//<strong>输出：</strong>[]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>k == lists.length</code></li>
//	<li><code>0 &lt;= k &lt;= 10^4</code></li>
//	<li><code>0 &lt;= lists[i].length &lt;= 500</code></li>
//	<li><code>-10^4 &lt;= lists[i][j] &lt;= 10^4</code></li>
//	<li><code>lists[i]</code> 按 <strong>升序</strong> 排列</li>
//	<li><code>lists[i].length</code> 的总和不超过 <code>10^4</code></li>
//</ul>
//<div><div>Related Topics</div><div><li>链表</li><li>分治</li><li>堆（优先队列）</li><li>归并排序</li></div></div><br><div><li>👍 1909</li><li>👎 0</li></div>

import com.study.leetcode.editor.cn.help.ListNode;

import java.util.PriorityQueue;

/**
 * [23]merge-k-sorted-lists
 * @author 秦笑笑
 * @date 2022-04-27 15:36:35
 */
public class P023_MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new P023_MergeKSortedLists().new Solution();
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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode root = new ListNode(),p = root;
        if (lists.length == 0) return root.next;
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(lists.length, (a, b)->(a.val - b.val));
        for (ListNode head : lists) {
            // 将k个有序链表对应的头结点入堆*（最小堆 堆顶为最小的）
            if (head != null) priorityQueue.offer(head);
        }
        while (!priorityQueue.isEmpty()){
            // 将k个列表中最小的加入链表（即最小的节点加入链表）
            ListNode node  = priorityQueue.poll();
            p.next = node;
            // 将最小头节点之后的****（一个）****节点入堆，保证整理链表有序
            // 1237   459  68 头结点分别为 1、5、8 不能直接都把头结点加入链表！！！！
            if (node.next != null){
                priorityQueue.offer(node.next);
            }
            p = p.next;
        }
        return root.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
