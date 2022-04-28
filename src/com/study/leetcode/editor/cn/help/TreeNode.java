package com.study.leetcode.editor.cn.help;

/**
 * 包名: com.study.leetcode.editor.cn.help
 * 类名: TreeNode
 * 创建用户: 25789
 * 创建日期: 2022年04月28日 15:55
 * 项目名: LeetCode
 *
 * @author: 秦笑笑
 **/
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}