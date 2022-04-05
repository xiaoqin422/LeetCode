//<p>编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为 <a href="http://en.wikipedia.org/wiki/Hamming_weight" target="_blank">汉明重量</a>).）。</p>
//
//<p> </p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li>请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。</li>
//	<li>在 Java 中，编译器使用 <a href="https://baike.baidu.com/item/二进制补码/5295284">二进制补码</a> 记法来表示有符号整数。因此，在上面的 <strong>示例 3 </strong>中，输入表示有符号整数 <code>-3</code>。</li>
//</ul>
//
//<p> </p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>n = 11 (控制台输入 00000000000000000000000000001011)
//<strong>输出：</strong>3
//<strong>解释：</strong>输入的二进制串 <code><strong>00000000000000000000000000001011</strong> 中，共有三位为 '1'。</code>
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>n = 128 (控制台输入 00000000000000000000000010000000)
//<strong>输出：</strong>1
//<strong>解释：</strong>输入的二进制串 <strong>00000000000000000000000010000000</strong> 中，共有一位为 '1'。
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre>
//<strong>输入：</strong>n = 4294967293 (控制台输入 11111111111111111111111111111101，部分语言中 n = -3）
//<strong>输出：</strong>31
//<strong>解释：</strong>输入的二进制串 <strong>11111111111111111111111111111101</strong> 中，共有 31 位为 '1'。</pre>
//
//<p> </p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li>输入必须是长度为 <code>32</code> 的 <strong>二进制串</strong> 。</li>
//</ul>
//
//<p> </p>
//
//<p>注意：本题与主站 191 题相同：<a href="https://leetcode-cn.com/problems/number-of-1-bits/">https://leetcode-cn.com/problems/number-of-1-bits/</a></p>
//<div><div>Related Topics</div><div><li>位运算</li></div></div><br><div><li>👍 237</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

/**
 * [剑指 Offer 15]二进制中1的个数
 * @author 秦笑笑
 * @date 2022-03-29 22:35:36
 */
public class ErJinZhiZhong1deGeShuLcof {
    public static void main(String[] args) {
        Solution solution = new ErJinZhiZhong1deGeShuLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                count++;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
