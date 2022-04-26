//<p>请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例&nbsp;1:</strong></p>
//
//<pre><strong>输入: </strong>&quot;abcabcbb&quot;
//<strong>输出: </strong>3 
//<strong>解释:</strong> 因为无重复字符的最长子串是 <code>&quot;abc&quot;，所以其</code>长度为 3。
//</pre>
//
//<p><strong>示例 2:</strong></p>
//
//<pre><strong>输入: </strong>&quot;bbbbb&quot;
//<strong>输出: </strong>1
//<strong>解释: </strong>因为无重复字符的最长子串是 <code>&quot;b&quot;</code>，所以其长度为 1。
//</pre>
//
//<p><strong>示例 3:</strong></p>
//
//<pre><strong>输入: </strong>&quot;pwwkew&quot;
//<strong>输出: </strong>3
//<strong>解释: </strong>因为无重复字符的最长子串是&nbsp;<code>&quot;wke&quot;</code>，所以其长度为 3。
//&nbsp;    请注意，你的答案必须是 <strong>子串 </strong>的长度，<code>&quot;pwke&quot;</code>&nbsp;是一个<em>子序列，</em>不是子串。
//</pre>
//
//<p>&nbsp;</p>
//
//<p>提示：</p>
//
//<ul>
//	<li><code>s.length &lt;= 40000</code></li>
//</ul>
//
//<p>注意：本题与主站 3 题相同：<a href="https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/">https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/</a></p>
//<div><div>Related Topics</div><div><li>哈希表</li><li>字符串</li><li>滑动窗口</li></div></div><br><div><li>👍 419</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

import java.util.*;

/**
 * [剑指 Offer 48]最长不含重复字符的子字符串
 * @author 秦笑笑
 * @date 2022-04-23 12:17:20
 */
public class ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof {
    public static void main(String[] args) {
        Solution solution = new ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();
        Map<Character,Integer> map = new HashMap<>();
        int dp = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            Integer index = map.get(cur);
            map.put(cur,i);
            if (index != null){
                if (i - index <= dp){
                    max = Math.max(max,dp);
                    dp = i - index;
                    continue;
                }
            }
            dp += 1;
        }
        return Math.max(max,dp);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
