package com.study.leetcode.editor.cn;
//<p>给你两个字符串&nbsp;<code>s1</code>&nbsp;和&nbsp;<code>s2</code> ，写一个函数来判断 <code>s2</code> 是否包含 <code>s1</code><strong>&nbsp;</strong>的排列。如果是，返回 <code>true</code> ；否则，返回 <code>false</code> 。</p>
//
//<p>换句话说，<code>s1</code> 的排列之一是 <code>s2</code> 的 <strong>子串</strong> 。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>s1 = "ab" s2 = "eidbaooo"
//<strong>输出：</strong>true
//<strong>解释：</strong>s2 包含 s1 的排列之一 ("ba").
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>s1= "ab" s2 = "eidboaoo"
//<strong>输出：</strong>false
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>1 &lt;= s1.length, s2.length &lt;= 10<sup>4</sup></code></li>
//	<li><code>s1</code> 和 <code>s2</code> 仅包含小写字母</li>
//</ul>
//<div><div>Related Topics</div><div><li>哈希表</li><li>双指针</li><li>字符串</li><li>滑动窗口</li></div></div><br><div><li>👍 657</li><li>👎 0</li></div>

import java.util.HashSet;
import java.util.Set;

/**
 * [567]permutation-in-string
 *
 * @author 秦笑笑
 * @date 2022-05-04 09:04:12
 */
public class P567_PermutationInString {
    public static void main(String[] args) {
        Solution solution = new P567_PermutationInString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            int[] need = new int[26];
            int[] window = new int[26];
            Set<Character> count = new HashSet<>();
            char[] target = s1.toCharArray();
            for (char c : target) {
                need[c - 'a']++;
                count.add(c);
            }
            int left = 0, right = 0;
            int valid = 0;
            char[] chars = s2.toCharArray();
            while (right < chars.length) {
                char cur = chars[right];
                right++;
                int index = cur - 'a';
                // 如果进入窗口的字符为需要的目标字符串并且窗口中该目标字符串还未匹配完毕，则进行匹配
                if (need[index] != 0) {
                    window[index]++;
                    if (window[index] == need[index]) {
                        valid++;
                    }
                }
                // 当窗口达到最大大小时，需要进行左滑
                while (right - left >= target.length) {
                    if (valid == count.size()) {
                        return true;
                    }
                    cur = chars[left];
                    left++;
                    index = cur - 'a';
                    // 窗口中一定有该记录
                    if (need[index] != 0) {
                        if (window[index] == need[index]) valid--;
                        // window[index] = Math.max(0, window[index] - 1); 没有必要
                        window[index] --;
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
