//<p>定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例:</strong></p>
//
//<pre>MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.min();   --&gt; 返回 -3.
//minStack.pop();
//minStack.top();      --&gt; 返回 0.
//minStack.min();   --&gt; 返回 -2.
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ol>
//	<li>各函数的调用总次数不超过 20000 次</li>
//</ol>
//
//<p>&nbsp;</p>
//
//<p>注意：本题与主站 155 题相同：<a href="https://leetcode-cn.com/problems/min-stack/">https://leetcode-cn.com/problems/min-stack/</a></p>
//<div><div>Related Topics</div><div><li>栈</li><li>设计</li></div></div><br><div><li>👍 326</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

/**
 * [剑指 Offer 30]包含min函数的栈
 * @author 秦笑笑
 * @date 2022-04-15 18:05:44
 */
public class BaoHanMinhanShuDeZhanLcof {
    public static void main(String[] args) {
        MinStack solution = new BaoHanMinhanShuDeZhanLcof().new MinStack();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack {
        Deque<Integer> xStack;
        Deque<Integer> minStack;

        public MinStack() {
            xStack = new LinkedList<Integer>();
            minStack = new LinkedList<Integer>();
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int x) {
            xStack.push(x);
            minStack.push(Math.min(minStack.peek(), x));
        }

        public void pop() {
            xStack.pop();
            minStack.pop();
        }

        public int top() {
            return xStack.peek();
        }

        public int min() {
            return minStack.peek();
        }
    }


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
