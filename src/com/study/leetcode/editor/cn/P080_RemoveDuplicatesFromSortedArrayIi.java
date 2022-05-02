package com.study.leetcode.editor.cn;
//<p>给你一个有序数组 <code>nums</code> ，请你<strong><a href="http://baike.baidu.com/item/%E5%8E%9F%E5%9C%B0%E7%AE%97%E6%B3%95" target="_blank"> 原地</a></strong> 删除重复出现的元素，使每个元素 <strong>最多出现两次</strong> ，返回删除后数组的新长度。</p>
//
//<p>不要使用额外的数组空间，你必须在 <strong><a href="https://baike.baidu.com/item/%E5%8E%9F%E5%9C%B0%E7%AE%97%E6%B3%95" target="_blank">原地 </a>修改输入数组 </strong>并在使用 O(1) 额外空间的条件下完成。</p>
//
//<p> </p>
//
//<p><strong>说明：</strong></p>
//
//<p>为什么返回数值是整数，但输出的答案是数组呢？</p>
//
//<p>请注意，输入数组是以<strong>「引用」</strong>方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。</p>
//
//<p>你可以想象内部操作如下:</p>
//
//<pre>
//// <strong>nums</strong> 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
//int len = removeDuplicates(nums);
//
//// 在函数里修改输入数组对于调用者是可见的。
//// 根据你的函数返回的长度, 它会打印出数组中<strong> 该长度范围内</strong> 的所有元素。
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//}
//</pre>
//
//<p> </p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [1,1,1,2,2,3]
//<strong>输出：</strong>5, nums = [1,1,2,2,3]
//<strong>解释：</strong>函数应返回新长度 length = <strong><code>5</code></strong>, 并且原数组的前五个元素被修改为 <strong><code>1, 1, 2, 2,</code></strong> <strong>3 </strong>。 不需要考虑数组中超出新长度后面的元素。
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [0,0,1,1,1,1,2,3,3]
//<strong>输出：</strong>7, nums = [0,0,1,1,2,3,3]
//<strong>解释：</strong>函数应返回新长度 length = <strong><code>7</code></strong>, 并且原数组的前五个元素被修改为 <strong><code>0</code></strong>, <strong>0</strong>, <strong>1</strong>, <strong>1</strong>, <strong>2</strong>, <strong>3</strong>, <strong>3 。</strong> 不需要考虑数组中超出新长度后面的元素。
//</pre>
//
//<p> </p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>1 <= nums.length <= 3 * 10<sup>4</sup></code></li>
//	<li><code>-10<sup>4</sup> <= nums[i] <= 10<sup>4</sup></code></li>
//	<li><code>nums</code> 已按升序排列</li>
//</ul>
//<div><div>Related Topics</div><div><li>数组</li><li>双指针</li></div></div><br><div><li>👍 678</li><li>👎 0</li></div>

/**
 * [80]remove-duplicates-from-sorted-array-ii
 * @author 秦笑笑
 * @date 2022-05-02 19:53:17
 */
public class P080_RemoveDuplicatesFromSortedArrayIi {
    public static void main(String[] args) {
        Solution solution = new P080_RemoveDuplicatesFromSortedArrayIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len <= 2) return len;
        // ！！！slow - 1为已经整理好的数组的下标
        int slow = 2,fast = 2;
        while (fast < len){
            // 因为允许最多重复两次。slow - 1符合条件。
            // 因为slow - 2 可能等于slow-1,则应该判断，
            // 当前待判断的位置fast下标是否等于 slow - 2
            if (nums[slow - 2] != nums[fast]){
                nums[slow] = nums[fast];
                slow ++;
            }
            fast++;
        }
        return slow;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}