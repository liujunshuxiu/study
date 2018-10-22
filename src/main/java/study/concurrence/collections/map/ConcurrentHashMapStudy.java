package study.concurrence.collections.map;

import study.MapStudyKey;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapStudy {
    public static void main(String[] args){
//        Map<String, String> mMap = new ConcurrentHashMap<String, String>();
//
//        mMap.put("1","1a");
//        mMap.put("2","2b");
//        mMap.put("3","3c");
//
//        mMap.get("2");


        MapStudyKey key1 = new MapStudyKey(1);
        MapStudyKey key2 = new MapStudyKey(2);
        MapStudyKey key3 = new MapStudyKey(3);
        MapStudyKey key4 = new MapStudyKey(4);
        MapStudyKey key5 = new MapStudyKey(5);
        MapStudyKey key6 = new MapStudyKey(6);
        MapStudyKey key7 = new MapStudyKey(7);

        Map<MapStudyKey, String> ljMap = new ConcurrentHashMap<MapStudyKey, String>();

        ljMap.put(key1, "1");
        ljMap.put(key2, "2");
        ljMap.put(key3, "3");
        ljMap.put(key4, "4");
        ljMap.put(key5, "5");
        ljMap.put(key6, "6");
        ljMap.put(key7, "7");


        ljMap.get(key3);
        ljMap.get(key2);
    }
}
