package maps;

import java.util.LinkedHashMap;

/**
 * @program: com.lmn.lmntest
 * @description:
 * @author: linminna
 * @create: 2019-04-09 16:44
 * 
 * LinkedHashMap增加了两个属性用于保证顺序，分别是双向链表头结点header和标志位accessOrder
 * 
 * 当accessOrder标志位为true时，表示双向链表中的元素按照访问的先后顺序排列，Entry插入链表的顺序依然是按照其put到LinkedHashMap中的顺序，但put和get
 * 方法均有调用recordAccess方法（put方法在key相同时会调用）。
 *
 * recordAccess方法判断accessOrder是否为true，如果是，则将当前访问的Entry（put进来的Entry或get出来的Entry）移到双向链表的尾部（key不相同时，put新Entry
 * 时，会调用addEntry，它会调用createEntry，该方法同样将新插入的元素放入到双向链表的尾部，既符合插入的先后顺序，又符合访问的先后顺序，因为这时该Entry也被访问了
 * 
 **/
public class LinkedHashMapTest {

    public static void main(String[] args) {
        LinkedHashMap<String, String> hashMap = new LinkedHashMap<>(10, 0.75F, true);
        hashMap.put("A","1");
        hashMap.put("B","2");
        hashMap.put("C","3");
        hashMap.put("D","4");
        
        hashMap.forEach( (k, v) -> System.out.print(v));
        System.out.println();
        hashMap.get("A");
        hashMap.forEach( (k, v) -> System.out.print(v));
        System.out.println();
        hashMap.get("C");
        hashMap.forEach( (k, v) -> System.out.print(v));
        System.out.println();
        hashMap.put("E","5");
        hashMap.forEach( (k, v) -> System.out.print(v));
    }
    
}
