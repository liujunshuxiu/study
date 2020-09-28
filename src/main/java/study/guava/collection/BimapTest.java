package study.guava.collection;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import org.junit.Test;

public class BimapTest {

    @Test
    public void BimapTest(){
        BiMap<Integer,String> logfileMap = HashBiMap.create();
        logfileMap.put(1,"a.log");
        logfileMap.put(2,"b.log");
        logfileMap.put(3,"c.log");
        logfileMap.put(4,"d.log");

//        logfileMap.put(5,"d.log");
        logfileMap.forcePut(5,"d.log");

        System.out.println("logfileMap:"+logfileMap);

        //inverse方法会返回一个反转的BiMap，但是注意这个反转的map不是新的map对象，
        // 它实现了一种视图关联，这样你对于反转后的map的所有操作都会影响原先的map对象。
        BiMap<String,Integer> filelogMap = logfileMap.inverse();
        System.out.println("filelogMap:"+filelogMap);

        logfileMap.put(6,"e.log");
        System.out.println("add-----------------");
        System.out.println("logfileMap:"+logfileMap);
        System.out.println("filelogMap:"+filelogMap);
    }

    public static void main(String[] args) {
        BiMap<Integer,String> logfileMap = HashBiMap.create();
        logfileMap.put(1,"a.log");
        logfileMap.put(2,"b.log");
        logfileMap.put(3,"c.log");
        logfileMap.put(4,"d.log");

//        logfileMap.put(5,"d.log");
        logfileMap.forcePut(5,"d.log");

        System.out.println("logfileMap:"+logfileMap);

        //inverse方法会返回一个反转的BiMap，但是注意这个反转的map不是新的map对象，
        // 它实现了一种视图关联，这样你对于反转后的map的所有操作都会影响原先的map对象。
        BiMap<String,Integer> filelogMap = logfileMap.inverse();
        System.out.println("filelogMap:"+filelogMap);

        logfileMap.put(6,"e.log");
        System.out.println("add-----------------");
        System.out.println("logfileMap:"+logfileMap);
        System.out.println("filelogMap:"+filelogMap);
    }
}
