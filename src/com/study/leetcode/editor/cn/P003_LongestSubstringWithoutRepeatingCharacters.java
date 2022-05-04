package com.study.leetcode.editor.cn;
//<p>给定一个字符串 <code>s</code> ，请你找出其中不含有重复字符的&nbsp;<strong>最长子串&nbsp;</strong>的长度。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例&nbsp;1:</strong></p>
//
//<pre>
//<strong>输入: </strong>s = "abcabcbb"
//<strong>输出: </strong>3 
//<strong>解释:</strong> 因为无重复字符的最长子串是 <code>"abc"，所以其</code>长度为 3。
//</pre>
//
//<p><strong>示例 2:</strong></p>
//
//<pre>
//<strong>输入: </strong>s = "bbbbb"
//<strong>输出: </strong>1
//<strong>解释: </strong>因为无重复字符的最长子串是 <code>"b"</code>，所以其长度为 1。
//</pre>
//
//<p><strong>示例 3:</strong></p>
//
//<pre>
//<strong>输入: </strong>s = "pwwkew"
//<strong>输出: </strong>3
//<strong>解释: </strong>因为无重复字符的最长子串是&nbsp;<code>"wke"</code>，所以其长度为 3。
//&nbsp;    请注意，你的答案必须是 <strong>子串 </strong>的长度，<code>"pwke"</code>&nbsp;是一个<em>子序列，</em>不是子串。
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>0 &lt;= s.length &lt;= 5 * 10<sup>4</sup></code></li>
//	<li><code>s</code>&nbsp;由英文字母、数字、符号和空格组成</li>
//</ul>
//<div><div>Related Topics</div><div><li>哈希表</li><li>字符串</li><li>滑动窗口</li></div></div><br><div><li>👍 7499</li><li>👎 0</li></div>

import java.util.HashMap;
import java.util.Map;

/**
 * [3]longest-substring-without-repeating-characters
 * @author 秦笑笑
 * @date 2022-05-04 08:43:09
 */
public class P003_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new P003_LongestSubstringWithoutRepeatingCharacters().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left =0,right = 0;
        char[] chars = s.toCharArray();
        // Map<Character,Integer> window = new HashMap<>();
        int[] window = new int[128];
        int ans = 0;
        while (right < chars.length){
            char cur = chars[right];
            right++;
            window[cur] ++;
            // window.put(cur,window.getOrDefault(cur,0) + 1);
            // 如果新加入的字符串不重复，满足条件，记录最优解
            if (window[cur] <= 1){
                ans = Math.max(right - left,ans);
            }
            // 当不满足条件时进行窗口左滑
            while (window[cur] > 1){
                char l = chars[left];
                left++;
                // 最左边移除后条件
                // 更新窗口记录
                window[l]--;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
