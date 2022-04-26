package com.study.leetcode.editor.cn.helpClass;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        int[] prices = new int[n];
        int[] nums = new int[n];
        arr[0][0] = sc.nextInt();
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }
        nums[0] = arr[0][0]/prices[0];
        arr[0][1] = arr[0][0]-(nums[0] * prices[0]);
        for (int i = 1; i < n; ++i) {
            arr[i][0] = Math.max(arr[i - 1][0], arr[i - 1][1] + prices[i] * nums[i-1]);
            nums[i] = arr[i - 1][0]/prices[i];
            if(arr[i-1][1]+nums[i-1]*prices[i] < arr[i][0] && nums[i-1] < nums[i]){
                arr[i][1] = arr[i - 1][0] - prices[i] * nums[i];
            }
            else {
                nums[i] = nums[i-1];
                arr[i][1] = arr[i-1][1];
            }
        }
        System.out.println(arr[n - 1][0]);
    }
}
