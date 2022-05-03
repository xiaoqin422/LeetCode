package com.study.leetcode.editor.cn;
//<p>给你一个字符串 <code>s</code> 、一个字符串 <code>t</code> 。返回 <code>s</code> 中涵盖 <code>t</code> 所有字符的最小子串。如果 <code>s</code> 中不存在涵盖 <code>t</code> 所有字符的子串，则返回空字符串 <code>""</code> 。</p>
//
//<p> </p>
//
//<p><strong>注意：</strong></p>
//
//<ul>
//	<li>对于 <code>t</code> 中重复字符，我们寻找的子字符串中该字符数量必须不少于 <code>t</code> 中该字符数量。</li>
//	<li>如果 <code>s</code> 中存在这样的子串，我们保证它是唯一的答案。</li>
//</ul>
//
//<p> </p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>s = "ADOBECODEBANC", t = "ABC"
//<strong>输出：</strong>"BANC"
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>s = "a", t = "a"
//<strong>输出：</strong>"a"
//</pre>
//
//<p><strong>示例 3:</strong></p>
//
//<pre>
//<strong>输入:</strong> s = "a", t = "aa"
//<strong>输出:</strong> ""
//<strong>解释:</strong> t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。</pre>
//
//<p> </p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>1 <= s.length, t.length <= 10<sup>5</sup></code></li>
//	<li><code>s</code> 和 <code>t</code> 由英文字母组成</li>
//</ul>
//
//<p> </p>
//<strong>进阶：</strong>你能设计一个在 <code>o(n)</code> 时间内解决此问题的算法吗？<div><div>Related Topics</div><div><li>哈希表</li><li>字符串</li><li>滑动窗口</li></div></div><br><div><li>👍 1843</li><li>👎 0</li></div>

import java.util.HashMap;
import java.util.Map;

/**
 * [76]minimum-window-substring
 *
 * @author 秦笑笑
 * @date 2022-05-03 20:35:04
 */
public class P076_MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new P076_MinimumWindowSubstring().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            // 存放各字符需要的个数  / 窗口中已经存在的字符的个数
            Map<Character, Integer> need = new HashMap<>(), windows = new HashMap<>();
            char[] target = t.toCharArray();
            // 初始化达成条件
            for (int i = 0; i < target.length; i++) {
                need.put(target[i], need.getOrDefault(target[i], 0) + 1);
            }
            // 最小子串的起始位置和长度
            int start = 0, len = Integer.MAX_VALUE;
            // 滑动窗口的左右区间
            int left = 0, right = 0;
            // 用来判断是否达成条件（满足子串条件，此时需要寻找最优解）
            int valid = 0;
            char[] chars = s.toCharArray();
            while (right < chars.length) {
                // 无条件加入窗口，之后会进行后续优化
                char cur = chars[right];
                right++;
                // 如果当前字符是需要的条件字符，则需要进行状态保存
                if (need.get(cur) != null) {
                    // 记录窗口中已经达成条件的状态
                    windows.put(cur, windows.getOrDefault(cur, 0) + 1);
                    // 如果对该字符的要求满足，则验证数字+1
                    if (windows.get(cur).equals(need.get(cur))) {
                        valid++;
                    }
                }
                // 必须是和满足条件的map比较！！！
                // 不采用目标字符串的原因，目标字符串存在重复。
                // windows和need排断达成条件是对不同字符进行判断的！！！
                while (valid == need.size()) {
                    //此时的窗口都是满足条件的解（非最优解，后续会进行优化）
                    // 考虑到滑窗之后解可能丢失，所以需要先进行解的保存
                    if (right - left < len) { //如果已经存在的解是更优解，则不进行保存!!!
                        start = left;
                        len = right - left;
                    }
                    // 因为状态已经保存，直接无条件进行窗口滑动，后续进行状态判断
                    cur = chars[left];
                    left++;
                    // 如果滑窗减小的是一个需要的条件，则需要进行达成条件判断
                    if (need.get(cur) != null) {
                        //如果不满足条件，则循环（优化解空间结束）
                        if (windows.get(cur).equals(need.get(cur))) {
                            valid--;
                        }
                        // 此时达成的条件减少，需要对窗口中的状态进行保存
                        windows.put(cur, windows.get(cur) - 1);
                    }
                }
            }
            return len == Integer.MAX_VALUE ? "" : new String(chars, start, len);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
