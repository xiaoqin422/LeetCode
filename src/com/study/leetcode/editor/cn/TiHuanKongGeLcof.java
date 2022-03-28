//<p>请实现一个函数，把字符串 <code>s</code> 中的每个空格替换成&quot;%20&quot;。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre><strong>输入：</strong>s = &quot;We are happy.&quot;
//<strong>输出：</strong>&quot;We%20are%20happy.&quot;</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>限制：</strong></p>
//
//<p><code>0 &lt;= s 的长度 &lt;= 10000</code></p>
//<div><div>Related Topics</div><div><li>字符串</li></div></div><br><div><li>👍 249</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

/**
 * [剑指 Offer 05]替换空格
 * @author 秦笑笑
 * @date 2022-03-28 17:03:07
 */
public class TiHuanKongGeLcof {
    public static void main(String[] args) {
        Solution solution = new TiHuanKongGeLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String replaceSpace(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char item = s.charAt(i);
            if (item == ' '){
                sb.append("%20");
            }else {
                sb.append(item);
            }
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
