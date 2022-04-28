package com.study;


import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] split = str.split("\\.");
        for (String s : split) {
            char[] chars = s.toCharArray();
            StringBuilder sb = new StringBuilder();
            // 末尾为符号位，从倒数第二位开始向头遍历
            int end = chars.length - 1;
            sb.append('.');
            for (int start = chars.length - 1; start >= 0; start--) {
                if (chars[start] == ' '){
                    sb.append(chars,start + 1,end - start).append(' ');
                    end = start - 1;
                }else if (start == 0){
                    sb.append(chars,start,end - start + 1);
                }
            }
            System.out.println(sb);
        }
    }
    private static int search(List<Integer> vec,int target){
        int mid = vec.size() / 2;
        if (vec.get(mid) == target){
            return mid;
        }else if (vec.get(mid) > target){
            return binary(vec,target,0,mid - 1);
        }else {
            return binary(vec,target,mid + 1,vec.size() - 1);
        }
    }
    private static int binary(List<Integer> vec,int target,int left,int right){
        if (left > right) return -1;
        int mid = left + ((right - left) >> 1);//防止越界
        if (vec.get(mid) == target){
            return mid;
        }else if (vec.get(mid) > target){
            return binary(vec,target,0,mid - 1);
        }else {
            return binary(vec,target,mid + 1,vec.size() - 1);
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
