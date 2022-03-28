//<p>输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre><strong>输入：</strong>head = [1,3,2]
//<strong>输出：</strong>[2,3,1]</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>限制：</strong></p>
//
//<p><code>0 &lt;= 链表长度 &lt;= 10000</code></p>
//<div><div>Related Topics</div><div><li>栈</li><li>递归</li><li>链表</li><li>双指针</li></div></div><br><div><li>👍 264</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

import com.study.leetcode.editor.cn.helpClass.ListNode;

import java.util.Stack;

/**
 * [剑指 Offer 06]从尾到头打印链表
 * @author 秦笑笑
 * @date 2022-03-28 17:12:54
 */
public class CongWeiDaoTouDaYinLianBiaoLcof {
    public static void main(String[] args) {
        Solution solution = new CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
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
    public int[] reversePrint(ListNode head) {
        ListNode root = head;
        Stack<Integer> stack = new Stack<>();
        while (root != null){
            stack.push(root.val);
            root = root.next;

        }
        int[] result = new int[stack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.pop();
        }
        return result;
    }
    /**
     * 链表遍历
     * @param head
     * @return
     */
    public int[] reversePrint1(ListNode head) {
        ListNode root = head;
        Stack<Integer> stack = new Stack<>();
        while (root != null){
            stack.push(root.val);
            root = root.next;

        }
        int[] result = new int[stack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.pop();
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
