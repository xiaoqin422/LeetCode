//<p>字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串&quot;abcdefg&quot;和数字2，该函数将返回左旋转两位得到的结果&quot;cdefgab&quot;。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre><strong>输入:</strong> s = &quot;abcdefg&quot;, k = 2
//<strong>输出:&nbsp;</strong>&quot;cdefgab&quot;
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre><strong>输入:</strong> s = &quot;lrloseumgh&quot;, k = 6
//<strong>输出:&nbsp;</strong>&quot;umghlrlose&quot;
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>限制：</strong></p>
//
//<ul>
//	<li><code>1 &lt;= k &lt; s.length &lt;= 10000</code></li>
//</ul>
//<div><div>Related Topics</div><div><li>数学</li><li>双指针</li><li>字符串</li></div></div><br><div><li>👍 234</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

/**
 * [剑指 Offer 58 - II]左旋转字符串
 * @author 秦笑笑
 * @date 2022-04-25 13:08:46
 */
public class ZuoXuanZhuanZiFuChuanLcof {
    public static void main(String[] args) {
        Solution solution = new ZuoXuanZhuanZiFuChuanLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseLeftWords(String s, int n) {
        int l = 0, r = 0;
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = n; i < s.length(); i++) {
            sb.append(chars[i]);
        }
        for (int i = 0; i < n; i++) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
