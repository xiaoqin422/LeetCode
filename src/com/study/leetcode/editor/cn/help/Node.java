package com.study.leetcode.editor.cn.help;

/**
 * 包名: com.study.leetcode.editor.cn.help
 * 类名: Node
 * 创建用户: 25789
 * 创建日期: 2022年05月12日 16:18
 * 项目名: LeetCode
 *
 * @author: 秦笑笑
 **/
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};