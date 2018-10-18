package study.util;

import study.MapStudyKey;

import java.util.HashMap;
import java.util.Map;

public class LJHashMapTest {


    public static void main(String[] args) {

        MapStudyKey key1 = new MapStudyKey(1);
        MapStudyKey key2 = new MapStudyKey(2);

        Map<MapStudyKey, String> ljMap = new HashMap<MapStudyKey, String>();

        ljMap.put(key1, "1");
        ljMap.put(key2, "2");
    }


}
