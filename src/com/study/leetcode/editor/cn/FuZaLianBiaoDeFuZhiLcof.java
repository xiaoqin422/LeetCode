//<p>请实现 <code>copyRandomList</code> 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 <code>next</code> 指针指向下一个节点，还有一个 <code>random</code> 指针指向链表中的任意节点或者 <code>null</code>。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/01/09/e1.png"></p>
//
//<pre><strong>输入：</strong>head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//<strong>输出：</strong>[[7,null],[13,0],[11,4],[10,2],[1,0]]
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/01/09/e2.png"></p>
//
//<pre><strong>输入：</strong>head = [[1,1],[2,1]]
//<strong>输出：</strong>[[1,1],[2,1]]
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/01/09/e3.png"></strong></p>
//
//<pre><strong>输入：</strong>head = [[3,null],[3,0],[3,null]]
//<strong>输出：</strong>[[3,null],[3,0],[3,null]]
//</pre>
//
//<p><strong>示例 4：</strong></p>
//
//<pre><strong>输入：</strong>head = []
//<strong>输出：</strong>[]
//<strong>解释：</strong>给定的链表为空（空指针），因此返回 null。
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>-10000 &lt;= Node.val &lt;= 10000</code></li>
//	<li><code>Node.random</code>&nbsp;为空（null）或指向链表中的节点。</li>
//	<li>节点数目不超过 1000 。</li>
//</ul>
//
//<p>&nbsp;</p>
//
//<p><strong>注意：</strong>本题与主站 138 题相同：<a href="https://leetcode-cn.com/problems/copy-list-with-random-pointer/">https://leetcode-cn.com/problems/copy-list-with-random-pointer/</a></p>
//
//<p>&nbsp;</p>
//<div><div>Related Topics</div><div><li>哈希表</li><li>链表</li></div></div><br><div><li>👍 502</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;


import java.util.*;

/**
 * [剑指 Offer 35]复杂链表的复制
 *
 * @author 秦笑笑
 * @date 2022-04-18 20:13:38
 */
public class FuZaLianBiaoDeFuZhiLcof {
    public static void main(String[] args) {
        Solution solution = new FuZaLianBiaoDeFuZhiLcof().new Solution();
    }
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)


    // Definition for a Node.


    class Solution {
        Map<Node, Integer> map = new HashMap<>();

        public Node copyRandomList(Node head) {
            if (head == null) return null;

            // 记录node的数组下标
            int index = 0;
            Node p = head;
            while (p != null) {
                map.put(p, index);
                index ++;
                p = p.next;
            }

            Node[] arr = new Node[map.size()];
            Queue<Integer> queue = new LinkedList<>();
            index = 0;
            p = head;
            Node root = new Node(0);
            while (p != null) {
                Node node = new Node(p.val);
                root.next = node;
                arr[index++] = node;
                queue.offer(map.get(p.random));
                p = p.next;
                root = root.next;
            }
            for (Node node : arr) {
                Integer i = queue.poll();
                node.random = i == null ? null : arr[i];
            }
            return arr[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
