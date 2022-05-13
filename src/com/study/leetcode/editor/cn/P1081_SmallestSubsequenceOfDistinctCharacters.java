package com.study.leetcode.editor.cn;
//<p>返回 <code>s</code> 字典序最小的子序列，该子序列包含 <code>s</code> 的所有不同字符，且只包含一次。</p>
//
//<p><strong>注意：</strong>该题与 316 <a href="https://leetcode.com/problems/remove-duplicate-letters/">https://leetcode.com/problems/remove-duplicate-letters/</a> 相同</p>
//
//<p> </p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong><code>s = "bcabc"</code>
//<strong>输出<code>：</code></strong><code>"abc"</code>
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong><code>s = "cbacdcbc"</code>
//<strong>输出：</strong><code>"acdb"</code></pre>
//
//<p> </p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>1 <= s.length <= 1000</code></li>
//	<li><code>s</code> 由小写英文字母组成</li>
//</ul>
//<div><div>Related Topics</div><div><li>栈</li><li>贪心</li><li>字符串</li><li>单调栈</li></div></div><br><div><li>👍 152</li><li>👎 0</li></div>

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * [1081]smallest-subsequence-of-distinct-characters
 *
 * @author 秦笑笑
 * @date 2022-05-13 17:19:09
 */
public class P1081_SmallestSubsequenceOfDistinctCharacters {
    public static void main(String[] args) {
        Solution solution = new P1081_SmallestSubsequenceOfDistinctCharacters().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String smallestSubsequence(String s) {
            Deque<Character> stack = new LinkedList<>();
            char[] chars = s.toCharArray();
            int[] count = new int[26];
            boolean[] have = new boolean[26];
            for (int i = 0; i < chars.length; i++) {
                count[chars[i] - 'a']++;
            }
            for (int i = 0; i < chars.length; i++) {
                char item = chars[i];
                if (!have[item - 'a']){
                    while (!stack.isEmpty() && stack.peekLast() > item) {
                        if (count[stack.peekLast() - 'a'] > 0) {
                            have[stack.peekLast() - 'a'] = false;
                            stack.pollLast();
                        }else {
                            break;
                        }
                    }
                    stack.offerLast(item);
                    have[item - 'a'] = true;
                }
                count[item - 'a']--;
            }
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.poll());
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
