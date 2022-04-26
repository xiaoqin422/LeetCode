//<p>写一个函数，求两个整数之和，要求在函数体内不得使用 &ldquo;+&rdquo;、&ldquo;-&rdquo;、&ldquo;*&rdquo;、&ldquo;/&rdquo; 四则运算符号。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例:</strong></p>
//
//<pre><strong>输入:</strong> a = 1, b = 1
//<strong>输出:</strong> 2</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>a</code>,&nbsp;<code>b</code>&nbsp;均可能是负数或 0</li>
//	<li>结果不会溢出 32 位整数</li>
//</ul>
//<div><div>Related Topics</div><div><li>位运算</li><li>数学</li></div></div><br><div><li>👍 306</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

import java.sql.SQLOutput;

/**
 * [剑指 Offer 65]不用加减乘除做加法
 *
 * @author 秦笑笑
 * @date 2022-04-26 10:42:14
 */
public class BuYongJiaJianChengChuZuoJiaFaLcof {
    public static void main(String[] args) {
        Solution solution = new BuYongJiaJianChengChuZuoJiaFaLcof().new Solution();
        System.out.println(solution.add(1, 9));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int add(int a, int b) {
            while (b !=0){ //当进位为0 直接返回当前非进位
                int c = (a & b) << 1; //计算进位
                a ^= b; //计算非进位和
                b = c; //转换为新的：下一轮进行相加
            }
            return a;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
