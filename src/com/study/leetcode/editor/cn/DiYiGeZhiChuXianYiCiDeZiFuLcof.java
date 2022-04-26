//<p>在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。</p>
//
//<p><strong>示例 1:</strong></p>
//
//<pre>
//输入：s = "abaccdeff"
//输出：'b'
//</pre>
//
//<p><strong>示例 2:</strong></p>
//
//<pre>
//输入：s = "" 
//输出：' '
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>限制：</strong></p>
//
//<p><code>0 &lt;= s 的长度 &lt;= 50000</code></p>
//<div><div>Related Topics</div><div><li>队列</li><li>哈希表</li><li>字符串</li><li>计数</li></div></div><br><div><li>👍 215</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * [剑指 Offer 50]第一个只出现一次的字符
 * @author 秦笑笑
 * @date 2022-04-23 13:56:15
 */
public class DiYiGeZhiChuXianYiCiDeZiFuLcof {
    public static void main(String[] args) {
        Solution solution = new DiYiGeZhiChuXianYiCiDeZiFuLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char firstUniqChar(String s) {
        if (s.length() == 0) return ' ';
        int[] arr = new int[26];
        List<String> characters = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            int index = cur - 'a';
            if (arr[index] == 0){
                characters.add("" + cur);
                arr[index] = 1;
            }else {
                characters.remove("" + cur);
            }
        }
        char res = ' ';
        if (characters.size() == 0){
            return res;
        }else {
            return characters.get(0).toCharArray()[0];
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
