//<p>如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。</p>
//
//<p>例如，</p>
//
//<p>[2,3,4]&nbsp;的中位数是 3</p>
//
//<p>[2,3] 的中位数是 (2 + 3) / 2 = 2.5</p>
//
//<p>设计一个支持以下两种操作的数据结构：</p>
//
//<ul>
//	<li>void addNum(int num) - 从数据流中添加一个整数到数据结构中。</li>
//	<li>double findMedian() - 返回目前所有元素的中位数。</li>
//</ul>
//
//<p><strong>示例 1：</strong></p>
//
//<pre><strong>输入：
//</strong>[&quot;MedianFinder&quot;,&quot;addNum&quot;,&quot;addNum&quot;,&quot;findMedian&quot;,&quot;addNum&quot;,&quot;findMedian&quot;]
//[[],[1],[2],[],[3],[]]
//<strong>输出：</strong>[null,null,null,1.50000,null,2.00000]
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre><strong>输入：
//</strong>[&quot;MedianFinder&quot;,&quot;addNum&quot;,&quot;findMedian&quot;,&quot;addNum&quot;,&quot;findMedian&quot;]
//[[],[2],[],[3],[]]
//<strong>输出：</strong>[null,null,2.00000,null,2.50000]</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>限制：</strong></p>
//
//<ul>
//	<li>最多会对&nbsp;<code>addNum、findMedian</code> 进行&nbsp;<code>50000</code>&nbsp;次调用。</li>
//</ul>
//
//<p>注意：本题与主站 295 题相同：<a href="https://leetcode-cn.com/problems/find-median-from-data-stream/">https://leetcode-cn.com/problems/find-median-from-data-stream/</a></p>
//<div><div>Related Topics</div><div><li>设计</li><li>双指针</li><li>数据流</li><li>排序</li><li>堆（优先队列）</li></div></div><br><div><li>👍 304</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * [剑指 Offer 41]数据流中的中位数
 *
 * @author 秦笑笑
 * @date 2022-04-19 00:32:57
 */
public class ShuJuLiuZhongDeZhongWeiShuLcof {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MedianFinder {
        PriorityQueue<Integer> A;
        PriorityQueue<Integer> B;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            A = new PriorityQueue<>();//小顶堆，保存大的一半  （出队）4,5,6
            B = new PriorityQueue<>((x,y) ->y-x);//大顶堆，保存小的一半  （出队）3,2,1
        }

        public void addNum(int num) {
            if (A.size() != B.size()){
                A.offer(num); //数据从加入A，调整AB优先级队列顺序
                B.offer(A.poll());
            }else {
                B.offer(num); //数据从加入A，调整AB优先级队列顺序
                A.offer(B.poll());
            }
        }

        public double findMedian() {
            return A.size() != B.size()? (double) A.peek() : (double)(A.peek() + B.peek()) / 2;
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
