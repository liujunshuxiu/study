package study.guava.collection.multiset;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.Multimap;
import org.junit.Test;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MultiMapTest {

    @Test
    public void testHashMultimap() {
        HashMultimap<Integer, Integer> map = HashMultimap.create();
        map.put(1, 2);
        map.put(1, 3);
        map.put(1, 2);
        map.put(2, 3);
        map.put(4, 2);
        map.put(4, 3);
        map.put(4, 2);
        map.put(4, 3);
        System.out.println(map.toString());

        /*输出结果：
         *{1=[2, 3], 2=[3], 4=[2, 3]}
         * 其实它会把相同key和value的值给覆盖起来，但是相同的key又可以保留不同的value。
         * 因为它的entry的实现是一个set，set会对相同的Entry<K,V>进行去重
         */
    }


    @Test
    public void testArrayListMultimap() {

        Multimap<String, String> multimap = ArrayListMultimap.create();

        multimap.put("lower", "a");
        multimap.put("lower", "b");
        multimap.put("lower", "c");

        multimap.put("upper", "A");
        multimap.put("upper", "B");
        multimap.put("upper", "B");

        System.out.println(multimap.toString());

        List<String> lowerList = (List<String>) multimap.get("lower");
        //输出key为lower的list集合
        System.out.println("输出key为lower的list集合=========");
        System.out.println(lowerList.toString());
        lowerList.add("f");
        System.out.println(lowerList.toString());


        Map<String, Collection<String>> map = multimap.asMap();
        System.out.println("把Multimap转为一个map============");
        for (Map.Entry<String, Collection<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            Collection<String> value = multimap.get(key);
            System.out.println(key + ":" + value);
        }

        System.out.println("获得所有Multimap的key值==========");
        Set<String> keys = multimap.keySet();
        for (String key : keys) {
            System.out.println(key);
        }

        System.out.println("输出Multimap所有的value值========");
        Collection<String> values = multimap.values();
        System.out.println(values);

        /**输出结果：
         *输出key为lower的list集合=========
         * [a, b, c]
         * [a, b, c, f]
         * 把Multimap转为一个map============
         * lower:[a, b, c, f]
         * upper:[A, B]
         * 获得所有Multimap的key值==========
         * lower
         * upper
         * 输出Multimap所有的value值========
         * [a, b, c, f, A, B]
         */
    }

    @Test
    public void testImmutableListMultimap() {
        ImmutableListMultimap<String, Integer> of = ImmutableListMultimap.of("fn", 1, "cursor", 2);

        System.out.println(of.toString());

        of.put("ds",3);
    }
}
