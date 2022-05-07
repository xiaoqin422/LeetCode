package com.study;


import java.nio.file.Paths;
import java.util.*;

public class Main {
    private static int ans = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int m = sc.nextInt();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int[] arr = {sc.nextInt(), sc.nextInt()};
            list.add(arr);
        }
        for (int i = 0; i < N; i++) {
            dfs(list,0,m,i,new boolean[N]);
        }
        System.out.println(ans);
    }
    private static void dfs(List<int[]> list,int price,int cost,int index,boolean[] dp){
    //    TODO 满足条件进行最优结果存储并返回
        // index肯定没有被使用
        if (index >= list.size() || list.get(index)[0] > cost){
            // 在index之前找是否还有剩余未完成，如果没有则，记录最优结果
            for (int i = 0; i < index; i++) {
                if (dp[i]) continue;
                int[] cur = list.get(i);
                if (cur[0] > cost) break;
                dp[i] = true;
                cost -= cur[0];
                price += cur[1];
                dfs(list,price,cost,index,dp);
            }
            ans = Math.max(ans,price);
        }else {
            int[] cur = list.get(index);
            dp[index] = true;
            cost -= cur[0];
            price += cur[1];
            dfs(list,price,cost,index + 1,dp);
        }

    }
}
class Cache{
    static class Node{
        int key;
        int value;
        Node pre;
        Node next;
        public Node(){}
        public Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }
    // 缓存最大容量
    private final int n;
    // 缓存大小
    public int size;
    private final Node head;
    private final Node tail;
    private final Map<Integer,Node> cache;
    public Cache(int n){
        this.n = n;
        size = 0;
        cache = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    /**
     *
     * @param key key值
     * @param value value值
     * @return 如果是添加值，返回true，如果是更新值，返回false
     */
    public boolean put(int key, int value){
        Node target = cache.get(key);
        if (target == null){
            target = new Node(key, value);
            cache.put(key,target);
            addNodeToHead(target);
            size++;
            // 如果超过最大容量，执行淘汰策略
            if (size > n){
                // 删除对应节点
                Node node = removeLastNode();
                // 删除map中的值
                cache.remove(node.key);
                --size;
            }
            return false;
        }else {
            target.value = value;
            cache.put(target.key,target);
            movieNodeToHead(target);
            return true;
        }
    }

    /**
     *
     * @param key key值
     * @return 如果存在，返回对应的value，如果不存在，返回-1
     */
    public int get(int key){
        Node target = cache.get(key);
        if (target == null){
            return -1;
        }else {
            // 如果target不是头结点，应该将其加到头结点
            if (target != head.next){
                movieNodeToHead(target);
            }
            return target.value;
        }
    }
    private void addNodeToHead(Node node){
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
    }
    private void deleteNode(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    private void movieNodeToHead(Node node){
        deleteNode(node);
        addNodeToHead(node);
    }
    private Node removeLastNode(){
        Node pre = tail.pre;
        deleteNode(pre);
        return pre;
    }
}
