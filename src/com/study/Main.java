package com.study;


import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // double high = sc.nextDouble();
        // double step = sc.nextDouble();
        // double pass = 0;
        // double mid = high;
        // for (int i = 0; i < step; i++) {
        //     pass = pass + mid + mid * 0.5;
        //     mid = mid * 0.5;
        // }
        // String s = String.format("%.2f", pass);
        // System.out.println(s);

    }

    private int[][] method(int[] nums) {
        Arrays.sort(nums);
        List<int[]> res = new ArrayList<>();
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) break;
            if (k > 0 && nums[k] == nums[k - 1]) continue;
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum < 0) {
                    while (i < j && nums[i] == nums[++i]) ;
                } else if (sum > 0) {
                    while (i < j && nums[j] == nums[--j]) ;
                } else {
                    res.add(new int[]{nums[k], nums[i], nums[j]});
                    while (i < j && nums[i] == nums[++i]) ;
                    while (i < j && nums[j] == nums[--j]) ;
                }
            }
        }
        int[][] ans = new int[res.size()][];
        return res.toArray(ans);
    }
}
