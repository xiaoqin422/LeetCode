//<p>给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。</p>
//
//<p>返回删除后的链表的头节点。</p>
//
//<p><strong>注意：</strong>此题对比原题有改动</p>
//
//<p><strong>示例 1:</strong></p>
//
//<pre><strong>输入:</strong> head = [4,5,1,9], val = 5
//<strong>输出:</strong> [4,1,9]
//<strong>解释: </strong>给定你链表中值为&nbsp;5&nbsp;的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -&gt; 1 -&gt; 9.
//</pre>
//
//<p><strong>示例 2:</strong></p>
//
//<pre><strong>输入:</strong> head = [4,5,1,9], val = 1
//<strong>输出:</strong> [4,5,9]
//<strong>解释: </strong>给定你链表中值为&nbsp;1&nbsp;的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -&gt; 5 -&gt; 9.
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>说明：</strong></p>
//
//<ul>
//	<li>题目保证链表中节点的值互不相同</li>
//	<li>若使用 C 或 C++ 语言，你不需要 <code>free</code> 或 <code>delete</code> 被删除的节点</li>
//</ul>
//<div><div>Related Topics</div><div><li>链表</li></div></div><br><div><li>👍 210</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

import com.study.leetcode.editor.cn.helpClass.ListNode;

import java.util.List;

/**
 * [剑指 Offer 18]删除链表的节点
 * @author 秦笑笑
 * @date 2022-04-04 15:30:38
 */
public class ShanChuLianBiaoDeJieDianLcof {
    public static void main(String[] args) {
        Solution solution = new ShanChuLianBiaoDeJieDianLcof().new Solution();
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
    public ListNode deleteNode(ListNode head, int val) {
        ListNode node = head;
        ListNode pre = null;
        while (node != null){
            if (node.val == val){
                if (pre != null){//非头节点
                    pre.next = node.next;
                }else {// 删除头节点
                    head = head.next;
                }
                node.next = null;
                break;
            }
            pre = node;
            node = node.next;
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
