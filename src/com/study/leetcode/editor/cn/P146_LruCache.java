package com.study.leetcode.editor.cn;
//<div class="title__3Vvk">请你设计并实现一个满足&nbsp; <a href="https://baike.baidu.com/item/LRU" target="_blank">LRU (最近最少使用) 缓存</a> 约束的数据结构。</div>
//
//<div class="title__3Vvk">实现 <code>LRUCache</code> 类：</div>
//
//<div class="original__bRMd">
//<div>
//<ul>
//	<li><code>LRUCache(int capacity)</code> 以 <strong>正整数</strong> 作为容量&nbsp;<code>capacity</code> 初始化 LRU 缓存</li>
//	<li><code>int get(int key)</code> 如果关键字 <code>key</code> 存在于缓存中，则返回关键字的值，否则返回 <code>-1</code> 。</li>
//	<li><code>void put(int key, int value)</code>&nbsp;如果关键字&nbsp;<code>key</code> 已经存在，则变更其数据值&nbsp;<code>value</code> ；如果不存在，则向缓存中插入该组&nbsp;<code>key-value</code> 。如果插入操作导致关键字数量超过&nbsp;<code>capacity</code> ，则应该 <strong>逐出</strong> 最久未使用的关键字。</li>
//</ul>
//
//<p>函数 <code>get</code> 和 <code>put</code> 必须以 <code>O(1)</code> 的平均时间复杂度运行。</p>
//</div>
//</div>
//
//<p>&nbsp;</p>
//
//<p><strong>示例：</strong></p>
//
//<pre>
//<strong>输入</strong>
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//<strong>输出</strong>
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//<strong>解释</strong>
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>1 &lt;= capacity &lt;= 3000</code></li>
//	<li><code>0 &lt;= key &lt;= 10000</code></li>
//	<li><code>0 &lt;= value &lt;= 10<sup>5</sup></code></li>
//	<li>最多调用 <code>2 * 10<sup>5</sup></code> 次 <code>get</code> 和 <code>put</code></li>
//</ul>
//<div><div>Related Topics</div><div><li>设计</li><li>哈希表</li><li>链表</li><li>双向链表</li></div></div><br><div><li>👍 2136</li><li>👎 0</li></div>

import java.util.HashMap;

/**
 * [146]lru-cache
 * @author 秦笑笑
 * @date 2022-04-28 09:27:14
 */
public class P146_LruCache {
    public static void main(String[] args) {
        LRUCache lruCache = new P146_LruCache().new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
        lruCache.put(3,3);
        System.out.println(lruCache.get(2));
        lruCache.put(4,4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {
    class Node{
        int val;
        int key;
        Node next;
        Node pre;
        public Node(){}
        public Node(int key,int val){
            this.val = val;
            this.key = key;
        }
        public Node(int key,int val, Node next){
            this.val = val;
            this.key = key;
            this.next = next;
        }
    }
    HashMap<Integer,Node> param = null;
    Node head = null;
    Node tail = null;
    int capacity = 0;
    int size = 0;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        param = new HashMap<>();
        head = new Node();//虚节点
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        Node node = param.get(key);
        if (node == null){
            return -1;
        }
        if (head.next != node){
            moveToHead(node);
        }
        return node.val;
    }
    
    public void put(int key, int value) {
        Node node = param.get(key);
        if (node == null){
            Node newNode = new Node(key,value);
            param.put(key,newNode);
            addToHead(newNode);
            ++size;
            if (size > capacity){
                Node removeTail = removeTail();
                param.remove(removeTail.key);
                --size;
            }
        }else {
            node.val = value;
            moveToHead(node);
        }
    }
    private void addToHead(Node node){
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }
    private void removeNode(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    private void moveToHead(Node node){
        removeNode(node);
        addToHead(node);
    }
    private Node removeTail(){
        Node pre = tail.pre;
        removeNode(pre);
        return pre;
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
