package com.study.leetcode.editor.cn;
//<p>给定两个字符串&nbsp;<code>s</code>&nbsp;和 <code>p</code>，找到&nbsp;<code>s</code><strong>&nbsp;</strong>中所有&nbsp;<code>p</code><strong>&nbsp;</strong>的&nbsp;<strong>异位词&nbsp;</strong>的子串，返回这些子串的起始索引。不考虑答案输出的顺序。</p>
//
//<p><strong>异位词 </strong>指由相同字母重排列形成的字符串（包括相同的字符串）。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例&nbsp;1:</strong></p>
//
//<pre>
//<strong>输入: </strong>s = "cbaebabacd", p = "abc"
//<strong>输出: </strong>[0,6]
//<strong>解释:</strong>
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
//</pre>
//
//<p><strong>&nbsp;示例 2:</strong></p>
//
//<pre>
//<strong>输入: </strong>s = "abab", p = "ab"
//<strong>输出: </strong>[0,1,2]
//<strong>解释:</strong>
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示:</strong></p>
//
//<ul>
//	<li><code>1 &lt;= s.length, p.length &lt;= 3 * 10<sup>4</sup></code></li>
//	<li><code>s</code>&nbsp;和&nbsp;<code>p</code>&nbsp;仅包含小写字母</li>
//</ul>
//<div><div>Related Topics</div><div><li>哈希表</li><li>字符串</li><li>滑动窗口</li></div></div><br><div><li>👍 870</li><li>👎 0</li></div>

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * [438]find-all-anagrams-in-a-string
 *
 * @author 秦笑笑
 * @date 2022-05-03 20:57:34
 */
public class P438_FindAllAnagramsInAString {
    public static void main(String[] args) {
        Solution solution = new P438_FindAllAnagramsInAString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 滑动窗口，窗口满足条件①满足题目需求②无要求外的其他字符  ③窗口长度最大为目标串长度
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> ans = new ArrayList<>();
            Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
            char[] target = p.toCharArray();
            // 初始化达成条件①
            for (char c : target) {
                need.put(c, need.getOrDefault(c, 0) + 1);
            }
            int valid = 0;//达成条件①满足标志
            int left = 0, right = 0;
            char[] chars = s.toCharArray();
            while (right < chars.length) {
                char cur = chars[right];
                right++;
                // 如果满足条件②，则进行窗口右滑动
                if (need.get(cur) != null && (right - left) < target.length) {
                    window.put(cur, window.getOrDefault(cur, 0) + 1);
                    if (window.get(cur).equals(need.get(cur))) {
                        valid++;
                    }
                } else {//不满足条件，则当前窗口失效，清空条件②
                    window.clear();
                    left = right;
                    valid = 0;
                    // TODO 窗口重置
                }
                // 满足条件
                if (valid == need.size() && (right - left + 1) == target.length) {
                    ans.add(left);
                    // TODO 窗口重置
                    window.clear();
                    left = right;
                    valid = 0;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
