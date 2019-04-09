package maps;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LinkedHashMap无论是put方法还是get方法，都会导致目标Entry成为最近访问的Entry
 * 这样便把最近使用的Entry放入到了双向链表的后面。
 * 多次操作后，双向链表前面的Entry便是最近没有使用的,当节点个数满的时候，删除最前面的Entry(head后面的那个Entry)即可.
 * 
 * @param <K>
 * @param <V>
 */
public class LRU<K, V> extends LinkedHashMap<K, V> implements Map<K, V> {

    private static final long serialVersionUID = 1L;

    public LRU(int initialCapacity, float loadFactor, boolean accessOrder) {
        super(initialCapacity, loadFactor, accessOrder);
    }

    /**
     * @param eldest
     * @return
     * @description 重写LinkedHashMap中的removeEldestEntry方法，当LRU中元素多余6个时，
     * 删除最不经常使用的元素
     * @author rico
     * @created 2017年5月12日 上午11:32:51
     * @see java.util.LinkedHashMap#removeEldestEntry(java.util.Map.Entry)
     */
    @Override
    protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
        if (size() > 6) {//相当于没有缓存容器容量（超过即移除最先插入且未被使用的元素）
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LRU<Character, Integer> lru = new LRU<Character, Integer>(
                16, 0.75f, true);
        String s = "abcdefghijkl";
        for (int i = 0; i < s.length(); i++) {
            lru.put(s.charAt(i), i);
        }
        System.out.println("LRU ：" + lru);//此时的集合里面只包含最后的 6 个元素
        System.out.println("LRU中key为h的Entry的值为： " + lru.get('h'));
        System.out.println("LRU的大小 ：" + lru.size());
        System.out.println("LRU ：" + lru);
    }
}