//<p>写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。</p>
//
//<p>&nbsp;</p>
//
//<p>首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。</p>
//
//<p>当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。</p>
//
//<p>该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。</p>
//
//<p>注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。</p>
//
//<p>在任何情况下，若函数不能进行有效的转换时，请返回 0。</p>
//
//<p><strong>说明：</strong></p>
//
//<p>假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为&nbsp;[&minus;2<sup>31</sup>,&nbsp; 2<sup>31&nbsp;</sup>&minus; 1]。如果数值超过这个范围，请返回 &nbsp;INT_MAX (2<sup>31&nbsp;</sup>&minus; 1) 或&nbsp;INT_MIN (&minus;2<sup>31</sup>) 。</p>
//
//<p><strong>示例&nbsp;1:</strong></p>
//
//<pre><strong>输入:</strong> &quot;42&quot;
//<strong>输出:</strong> 42
//</pre>
//
//<p><strong>示例&nbsp;2:</strong></p>
//
//<pre><strong>输入:</strong> &quot;   -42&quot;
//<strong>输出:</strong> -42
//<strong>解释: </strong>第一个非空白字符为 &#39;-&#39;, 它是一个负号。
//&nbsp;    我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
//</pre>
//
//<p><strong>示例&nbsp;3:</strong></p>
//
//<pre><strong>输入:</strong> &quot;4193 with words&quot;
//<strong>输出:</strong> 4193
//<strong>解释:</strong> 转换截止于数字 &#39;3&#39; ，因为它的下一个字符不为数字。
//</pre>
//
//<p><strong>示例&nbsp;4:</strong></p>
//
//<pre><strong>输入:</strong> &quot;words and 987&quot;
//<strong>输出:</strong> 0
//<strong>解释:</strong> 第一个非空字符是 &#39;w&#39;, 但它不是数字或正、负号。
//     因此无法执行有效的转换。</pre>
//
//<p><strong>示例&nbsp;5:</strong></p>
//
//<pre><strong>输入:</strong> &quot;-91283472332&quot;
//<strong>输出:</strong> -2147483648
//<strong>解释:</strong> 数字 &quot;-91283472332&quot; 超过 32 位有符号整数范围。 
//&nbsp;    因此返回 INT_MIN (&minus;2<sup>31</sup>) 。
//</pre>
//
//<p>&nbsp;</p>
//
//<p>注意：本题与主站 8 题相同：<a href="https://leetcode-cn.com/problems/string-to-integer-atoi/">https://leetcode-cn.com/problems/string-to-integer-atoi/</a></p>
//<div><div>Related Topics</div><div><li>字符串</li></div></div><br><div><li>👍 158</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

/**
 * [剑指 Offer 67]把字符串转换成整数
 * @author 秦笑笑
 * @date 2022-04-26 20:56:14
 */
public class BaZiFuChuanZhuanHuanChengZhengShuLcof {
    public static void main(String[] args) {
        Solution solution = new BaZiFuChuanZhuanHuanChengZhengShuLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strToInt(String str) {
        char[] chars = str.trim().toCharArray();
        if (chars.length == 0) return 0;
        int sign = 1;
        int j = 1;
        // 判断第一个字符是不是符号位  是->记录符号位，从下一位开始遍历  不是->从当前位置开始遍历
        if (chars[0] == '-') {
            sign = -1;
        }else if (chars[0] != '+'){
            j = 0;
        }

        int res = 0;
        int max = Integer.MAX_VALUE / 10;
        for (int i = j; i < chars.length; i++) {
            char cur = chars[i];
            if (cur < '0' || cur > '9') break;
            // 如果本次操作之前已经越界，直接返回（必须处理之前的符号位）
            // res == max && chars[i] > '7'   Integer.MAX_VALUE / 10 丢失余数7
            if (res > max || res == max && chars[i] > '7') return sign == 1? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = 10 * res + (cur - '0');
        }
        return res * sign;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
