import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int x = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int left = 0, right = 0;
        boolean[] dp = new boolean[n];//用于记录该元素是否已经被选择
        PriorityQueue<Integer> selected = new PriorityQueue<>();
        PriorityQueue<int[]> window = new PriorityQueue<>((int[] a, int[] b) -> b[0] - a[0]);
        while (right < n) {
            int cur = arr[right];
            window.offer(new int[]{cur, right});
            right++;

            while (right - left >= k) {  //调整窗口，出
                cur = arr[left];
                int[] peek = window.peek();//本组最大的值
                if (selected.size() < x){
                    while (dp[peek[1]]) {
                        window.poll();
                        peek = window.peek();
                    }
                    selected.offer(peek[0]);
                    dp[peek[1]] = true;
                }else if (!dp[window.peek()[1]] && window.peek()[0] > selected.peek()){
                    System.out.println(-1);
                    return;
                }
                remove(window,new int[]{cur,left});
                left++;
            }
        }
        int ans = 0;
        while ( x > 0) {
            ans += selected.poll();
            x--;
        }
        System.out.println(ans);
    }
    private static void remove(PriorityQueue<int[]> d,int[] target){
        List<int[]> list = new ArrayList<>();
        while (!d.isEmpty()){
            int[] cur = d.poll();
            if (cur[0] == target[0] && cur[1] == target[1]){
                break;
            }
            list.add(cur);
        }
        for (int[] item : list) {
            d.offer(item);
        }
    }
}
