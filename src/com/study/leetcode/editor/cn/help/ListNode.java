package com.study.leetcode.editor.cn.help;

/**
 * 包名: com.study.leetcode.editor.cn
 * 类名: ListNode
 * 创建用户: 25789
 * 创建日期: 2022年04月27日 15:28
 * 项目名: LeetCode
 *
 * @author: 秦笑笑
 **/
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val){
        this.val = val;
    }
    public ListNode(int val,ListNode next){
        this.val = val;
        this.next = next;
    }
}