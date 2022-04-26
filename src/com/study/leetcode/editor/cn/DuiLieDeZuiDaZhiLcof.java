//<p>请定义一个队列并实现函数 <code>max_value</code> 得到队列里的最大值，要求函数<code>max_value</code>、<code>push_back</code> 和 <code>pop_front</code> 的<strong>均摊</strong>时间复杂度都是O(1)。</p>
//
//<p>若队列为空，<code>pop_front</code> 和 <code>max_value</code>&nbsp;需要返回 -1</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre><strong>输入:</strong> 
//[&quot;MaxQueue&quot;,&quot;push_back&quot;,&quot;push_back&quot;,&quot;max_value&quot;,&quot;pop_front&quot;,&quot;max_value&quot;]
//[[],[1],[2],[],[],[]]
//<strong>输出:&nbsp;</strong>[null,null,null,2,1,2]
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre><strong>输入:</strong> 
//[&quot;MaxQueue&quot;,&quot;pop_front&quot;,&quot;max_value&quot;]
//[[],[],[]]
//<strong>输出:&nbsp;</strong>[null,-1,-1]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>限制：</strong></p>
//
//<ul>
//	<li><code>1 &lt;= push_back,pop_front,max_value的总操作数&nbsp;&lt;= 10000</code></li>
//	<li><code>1 &lt;= value &lt;= 10^5</code></li>
//</ul>
//<div><div>Related Topics</div><div><li>设计</li><li>队列</li><li>单调队列</li></div></div><br><div><li>👍 358</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

import java.util.*;

/**
 * [剑指 Offer 59 - II]队列的最大值
 * @author 秦笑笑
 * @date 2022-04-25 14:55:31
 */
public class DuiLieDeZuiDaZhiLcof {
    public static void main(String[] args) {
        MaxQueue queue = new DuiLieDeZuiDaZhiLcof().new MaxQueue();
        queue.push_back(5);
        queue.push_back(-1);
        queue.push_back(3);
        System.out.println(queue.max_value());
        queue.pop_front();
        System.out.println(queue.max_value());
        queue.pop_front();
        System.out.println(queue.max_value());

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class MaxQueue {
    private Deque<Integer> deque;
    private Queue<Integer> queue;
    public MaxQueue() {
        deque = new LinkedList<>();
        queue = new LinkedList<>();
    }
    
    public int max_value() {
       if (deque.isEmpty()){
           return -1;
       }else {
           return deque.peekFirst();
       }
    }
    
    public void push_back(int value) {
        queue.offer(value);
        // 若i元素比j元素先入队，且i元素小于j元素。则最大值一定不是i，则i可以删除！！！
        while (!deque.isEmpty() && deque.peekLast() < value){
            deque.pollLast();
        }
        deque.offerLast(value);
    }
    
    public int pop_front() {
        if (queue.isEmpty()){
            return -1;
        }else {
            if (queue.peek().equals(deque.peekFirst()))
                deque.pollFirst();
            return queue.poll();
        }
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
