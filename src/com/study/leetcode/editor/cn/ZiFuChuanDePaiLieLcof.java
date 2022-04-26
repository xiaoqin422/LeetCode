//<p>输入一个字符串，打印出该字符串中字符的所有排列。</p>
//
//<p>&nbsp;</p>
//
//<p>你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例:</strong></p>
//
//<pre><strong>输入：</strong>s = &quot;abc&quot;
//<strong>输出：[</strong>&quot;abc&quot;,&quot;acb&quot;,&quot;bac&quot;,&quot;bca&quot;,&quot;cab&quot;,&quot;cba&quot;<strong>]</strong>
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>限制：</strong></p>
//
//<p><code>1 &lt;= s 的长度 &lt;= 8</code></p>
//<div><div>Related Topics</div><div><li>字符串</li><li>回溯</li></div></div><br><div><li>👍 541</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

import java.util.*;

/**
 * [剑指 Offer 38]字符串的排列
 *
 * @author 秦笑笑
 * @date 2022-04-18 22:40:34
 */
public class ZiFuChuanDePaiLieLcof {
    public static void main(String[] args) {
        Solution solution = new ZiFuChuanDePaiLieLcof().new Solution();
        System.out.println(Arrays.toString(solution.permutation("abc")));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Set<String> set = new HashSet<>();
        int[] te;
        public String[] permutation(String s) {
            te  = new int[s.length()];
            DFS(s, new StringBuilder());
            return set.toArray(new String[0]);
        }

        private void DFS(String s, StringBuilder res) {
            if (res.length() > s.length()) return;
            if (res.length() == s.length()) {
                set.add(res.toString());
                return;
            }
            for (int i = 0; i < s.length(); i++) {
                if (te[i] != 1){
                    char item = s.charAt(i);
                    res.append(item);
                    te[i] = 1;
                    DFS(s, res);
                    res.deleteCharAt(res.length() - 1);//回溯
                    te[i] = 0;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
