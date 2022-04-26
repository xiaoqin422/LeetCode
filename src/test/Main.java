package test;

import java.util.*;

/**
 * 包名: test
 * 类名: Main
 * 创建用户: 25789
 * 创建日期: 2022年04月21日 20:17
 * 项目名: LeetCode
 *
 * @author: 秦笑笑
 **/
public class Main {
    static boolean flag = true;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // m 条边
        int m = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        int[][] arr = new int[n][n];
        // 0 - n-1
        for (int i = 0; i < m; i++) {
            int row = sc.nextInt() - 1;
            int col = sc.nextInt() - 1;
            arr[row][col] = sc.nextInt();
        }

        System.out.println(dfs(arr,0,n,-1));
    }

    /**
     *
     * @param arr 图
     * @param index 当前所在点
     * @param n n个点
     * @param sum 路径求和
     * @return
     */
    private static int dfs(int[][] arr,int index,int n,int sum){
        if (index == n - 1) return sum;
        for (int i = index + 1; i < n; i++) {
            if (arr[index][i] != 0 || arr[i][index] != 0){
                int length = 0;
                if (arr[index][i] != 0 && arr[i][index] != 0){
                    length = Math.min(arr[index][i],arr[i][index]);
                }else {
                    length = Math.max(arr[index][i],arr[i][index]);
                }
                sum = sum == -1? length: sum + length;
                return dfs(arr,i,n,sum);
            }
        }
        return -1;
    }
}