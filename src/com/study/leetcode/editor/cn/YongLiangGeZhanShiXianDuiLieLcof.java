//<p>用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 <code>appendTail</code> 和 <code>deleteHead</code> ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，<code>deleteHead</code>&nbsp;操作返回 -1 )</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre><strong>输入：</strong>
//[&quot;CQueue&quot;,&quot;appendTail&quot;,&quot;deleteHead&quot;,&quot;deleteHead&quot;]
//[[],[3],[],[]]
//<strong>输出：</strong>[null,null,3,-1]
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre><strong>输入：</strong>
//[&quot;CQueue&quot;,&quot;deleteHead&quot;,&quot;appendTail&quot;,&quot;appendTail&quot;,&quot;deleteHead&quot;,&quot;deleteHead&quot;]
//[[],[],[5],[2],[],[]]
//<strong>输出：</strong>[null,-1,null,null,5,2]
//</pre>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>1 &lt;= values &lt;= 10000</code></li>
//	<li><code>最多会对&nbsp;appendTail、deleteHead 进行&nbsp;10000&nbsp;次调用</code></li>
//</ul>
//<div><div>Related Topics</div><div><li>栈</li><li>设计</li><li>队列</li></div></div><br><div><li>👍 490</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

import java.util.Stack;

/**
 * [剑指 Offer 09]用两个栈实现队列
 * @author 秦笑笑
 * @date 2022-03-28 19:02:45
 */
public class YongLiangGeZhanShiXianDuiLieLcof {
    public static void main(String[] args) {
        CQueue solution = new YongLiangGeZhanShiXianDuiLieLcof().new CQueue();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class CQueue {
    final Stack<Integer> in;
    final Stack<Integer> out;
    public CQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }
    
    public void appendTail(int value) {
        in.push(value);
    }
    
    public int deleteHead() {
        if (out.isEmpty()){
            if (in.isEmpty()) return -1;
            while (!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.pop();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
