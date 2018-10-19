package study.concurrence.collections.map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapStudy {
    public static void main(String[] args){
        Map<String, String> mMap = new ConcurrentHashMap<String, String>();

        mMap.put("1","1a");
        mMap.put("2","2b");
        mMap.put("3","3c");

        mMap.get("2");

    }
}
