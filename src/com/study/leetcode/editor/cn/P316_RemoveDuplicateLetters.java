package com.study.leetcode.editor.cn;
//<p>给你一个字符串 <code>s</code> ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 <strong>返回结果的字典序最小</strong>（要求不能打乱其他字符的相对位置）。</p>
//
//<p>&nbsp;</p>
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
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>1 &lt;= s.length &lt;= 10<sup>4</sup></code></li>
//	<li><code>s</code> 由小写英文字母组成</li>
//</ul>
//
//<p>&nbsp;</p>
//
//<p><strong>注意：</strong>该题与 1081 <a href="https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters">https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters</a> 相同</p>
//<div><div>Related Topics</div><div><li>栈</li><li>贪心</li><li>字符串</li><li>单调栈</li></div></div><br><div><li>👍 729</li><li>👎 0</li></div>

import java.util.Stack;

/**
 * [316]remove-duplicate-letters
 * @author 秦笑笑
 * @date 2022-05-07 10:22:32
 */
public class P316_RemoveDuplicateLetters {
    public static void main(String[] args) {
        Solution solution = new P316_RemoveDuplicateLetters().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        int[] count = new int[26];
        boolean[] isHave = new boolean[26];
        // 记录一下对应字符出现的次数
        for (char item : chars) {
            int index = item - 'a';
            count[index] ++;
        }
        for (char item : chars) {
            int index = item - 'a';
            // 当前元素没有出现过，考虑进栈
            if (!isHave[index]){
                //进栈前需要判定字典序 如果小于当前字典序，并且后续还有第二个该元素，则出栈。
                // 反之不能出栈，直接加入
                while (!stack.isEmpty() && stack.peek() > item && count[(stack.peek() - 'a')] > 0){
                    isHave[stack.pop() - 'a'] = false;
                }
                stack.push(item);
                isHave[index] = true;
            }
            count[index] --;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
