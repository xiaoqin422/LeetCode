package com.study.leetcode.editor.cn.helpClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();//表示有t组数据
        int[] result = new int[t];// 解
        // 问题求解
        for (int i = 0; i < t; i++) {
            int number = sc.nextInt();
            String color = sc.next();

            int count[] = new int[3]; //记录三中颜色的墙面个数
            Stack<Integer> A = new Stack<>();
            Stack<Integer> B = new Stack<>();
            Stack<Integer> C = new Stack<>();
            for (int j = 0; j < color.length(); j++) {
                char item = color.charAt(j);
                if (item == 'A'){
                    A.push(j);
                }else if (item == 'B'){
                    B.push(j);
                }else {
                    C.push(j);
                }
            }
            if (A.size() == B.size() && A.size() == number){
                result[i] = 0;
                break;
            }


        }
        // 结果输出
        for (int i : result) {
            System.out.println(i);
        }
    }
}