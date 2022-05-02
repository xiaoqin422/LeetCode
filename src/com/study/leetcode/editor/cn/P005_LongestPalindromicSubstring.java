package com.study.leetcode.editor.cn;
//<p>给你一个字符串 <code>s</code>，找到 <code>s</code> 中最长的回文子串。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>s = "babad"
//<strong>输出：</strong>"bab"
//<strong>解释：</strong>"aba" 同样是符合题意的答案。
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>s = "cbbd"
//<strong>输出：</strong>"bb"
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>1 &lt;= s.length &lt;= 1000</code></li>
//	<li><code>s</code> 仅由数字和英文字母组成</li>
//</ul>
//<div><div>Related Topics</div><div><li>字符串</li><li>动态规划</li></div></div><br><div><li>👍 5159</li><li>👎 0</li></div>

/**
 * [5]longest-palindromic-substring
 *
 * @author 秦笑笑
 * @date 2022-05-02 20:34:58
 */
public class P005_LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new P005_LongestPalindromicSubstring().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            String res = "";
            for (int i = 0; i < s.length(); i++) {
                // 以 s[i] 为中心的最长回文子串
                String s1 = palindrome(s, i, i);
                // 以 s[i] 和 s[i+1] 为中心的最长回文子串
                String s2 = palindrome(s, i, i + 1);
                // res = longest(res, s1, s2)
                res = res.length() > s1.length() ? res : s1;
                res = res.length() > s2.length() ? res : s2;
            }
            return res;
        }

        String palindrome(String s, int l, int r) {
            // 防止索引越界
            while (l >= 0 && r < s.length()
                    && s.charAt(l) == s.charAt(r)) {
                // 双指针，向两边展开
                l--;
                r++;
            }
            // 返回以 s[l] 和 s[r] 为中心的最长回文串
            return s.substring(l + 1, r);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
