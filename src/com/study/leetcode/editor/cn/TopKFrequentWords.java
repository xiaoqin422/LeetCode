//<p>给定一个单词列表&nbsp;<code>words</code>&nbsp;和一个整数 <code>k</code> ，返回前&nbsp;<code>k</code><em>&nbsp;</em>个出现次数最多的单词。</p>
//
//<p>返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率， <strong>按字典顺序</strong> 排序。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入:</strong> words = ["i", "love", "leetcode", "i", "love", "coding"], k = 2
//<strong>输出:</strong> ["i", "love"]
//<strong>解析:</strong> "i" 和 "love" 为出现次数最多的两个单词，均为2次。
//    注意，按字母顺序 "i" 在 "love" 之前。
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入:</strong> ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
//<strong>输出:</strong> ["the", "is", "sunny", "day"]
//<strong>解析:</strong> "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
//    出现次数依次为 4, 3, 2 和 1 次。
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>注意：</strong></p>
//
//<ul>
//	<li><code>1 &lt;= words.length &lt;= 500</code></li>
//	<li><code>1 &lt;= words[i] &lt;= 10</code></li>
//	<li><code>words[i]</code>&nbsp;由小写英文字母组成。</li>
//	<li><code>k</code> 的取值范围是&nbsp;<code>[1, <strong>不同</strong> words[i] 的数量]</code></li>
//</ul>
//
//<p>&nbsp;</p>
//
//<p><strong>进阶：</strong>尝试以&nbsp;<code>O(n log k)</code> 时间复杂度和&nbsp;<code>O(n)</code> 空间复杂度解决。</p>
//<div><div>Related Topics</div><div><li>字典树</li><li>哈希表</li><li>字符串</li><li>桶排序</li><li>计数</li><li>排序</li><li>堆（优先队列）</li></div></div><br><div><li>👍 445</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

import java.util.*;

/**
 * [692]前K个高频单词
 *
 * @author 秦笑笑
 * @date 2022-04-17 17:05:11
 */
public class TopKFrequentWords {
    public static void main(String[] args) {
        Solution solution = new TopKFrequentWords().new Solution();
        solution.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"},2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> topKFrequent(String[] words, int k) {
            HashMap<String, Integer> map = new HashMap<>();
            for (String word : words) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }

            PriorityQueue<String> queue = new PriorityQueue<>((s1, s2) ->{
                if (map.get(s1).equals(map.get(s2))) {
                    return s2.compareTo(s1);
                } else {
                    return map.get(s1) - map.get(s2);
                }
            }
            );
            for (String key : map.keySet()) {
                queue.offer(key);
                if (queue.size() > k) queue.poll();
            }
            List<String> s = new ArrayList<>();
            while (!queue.isEmpty()){
                s.add(queue.poll());
            }
            Collections.reverse(s);
            return s;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
