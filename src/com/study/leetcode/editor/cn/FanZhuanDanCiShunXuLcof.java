//<p>输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串&quot;I am a student. &quot;，则输出&quot;student. a am I&quot;。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre><strong>输入:</strong> &quot;<code>the sky is blue</code>&quot;
//<strong>输出:&nbsp;</strong>&quot;<code>blue is sky the</code>&quot;
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre><strong>输入:</strong> &quot; &nbsp;hello world! &nbsp;&quot;
//<strong>输出:&nbsp;</strong>&quot;world! hello&quot;
//<strong>解释: </strong>输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre><strong>输入:</strong> &quot;a good &nbsp; example&quot;
//<strong>输出:&nbsp;</strong>&quot;example good a&quot;
//<strong>解释: </strong>如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>说明：</strong></p>
//
//<ul>
//	<li>无空格字符构成一个单词。</li>
//	<li>输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。</li>
//	<li>如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。</li>
//</ul>
//
//<p><strong>注意：</strong>本题与主站 151 题相同：<a href="https://leetcode-cn.com/problems/reverse-words-in-a-string/">https://leetcode-cn.com/problems/reverse-words-in-a-string/</a></p>
//
//<p><strong>注意：</strong>此题对比原题有改动</p>
//<div><div>Related Topics</div><div><li>双指针</li><li>字符串</li></div></div><br><div><li>👍 202</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * [剑指 Offer 58 - I]翻转单词顺序
 *
 * @author 秦笑笑
 * @date 2022-04-25 12:23:02
 */
public class FanZhuanDanCiShunXuLcof {
    public static void main(String[] args) {
        Solution solution = new FanZhuanDanCiShunXuLcof().new Solution();
        System.out.println(solution.reverseWords("a good   example"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            Stack<String> stack = new Stack<>();
            StringBuilder sb = new StringBuilder();
            String[] s1 = s.split(" ");
            for (String value : s1) {
                if (value.length() != 0){
                    stack.push(value);
                }
            }
            while (!stack.isEmpty()){
                sb.append(stack.pop()).append(' ');
            }
            return sb.toString().trim();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
