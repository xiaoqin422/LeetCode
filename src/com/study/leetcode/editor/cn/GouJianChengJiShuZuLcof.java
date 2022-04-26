//<p>给定一个数组 <code>A[0,1,…,n-1]</code>，请构建一个数组 <code>B[0,1,…,n-1]</code>，其中 <code>B[i]</code> 的值是数组 <code>A</code> 中除了下标 <code>i</code> 以外的元素的积, 即 <code>B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]</code>。不能使用除法。</p>
//
//<p> </p>
//
//<p><strong>示例:</strong></p>
//
//<pre>
//<strong>输入:</strong> [1,2,3,4,5]
//<strong>输出:</strong> [120,60,40,30,24]</pre>
//
//<p> </p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li>所有元素乘积之和不会溢出 32 位整数</li>
//	<li><code>a.length <= 100000</code></li>
//</ul>
//<div><div>Related Topics</div><div><li>数组</li><li>前缀和</li></div></div><br><div><li>👍 222</li><li>👎 0</li></div>

package com.study.leetcode.editor.cn;

/**
 * [剑指 Offer 66]构建乘积数组
 * @author 秦笑笑
 * @date 2022-04-26 10:58:34
 */
public class GouJianChengJiShuZuLcof {
    public static void main(String[] args) {
        Solution solution = new GouJianChengJiShuZuLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] constructArr(int[] a) {
        int length = a.length;
        if (length == 0) return new int[0];
        // 存储当前索引之前的数的乘积之和
        int[] l = new int[length];
        // 存储当前索引之后的数的乘积之和
        int[] r = new int[length];
        int[] ans = new int[length];
        // 索引为0 对应之前没有数字，为了满足后续要求 设置为1
        l[0] = 1;
        for (int i = 1; i < length; i++) {
            l[i] = l[i - 1]  * a[i - 1];
        }

        r[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            r[i] = r[i + 1] * a[i + 1];
        }
        for (int i = 0; i < length; i++) {
            ans[i] = l[i] * r[i];
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
