package study.util;

import study.MapStudyKey;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LJHashMapTest {

    public static List<MapStudyKey> ljJP = new LinkedList<>();

    public static void main(String[] args) {

        MapStudyKey key1 = new MapStudyKey(1);
        MapStudyKey key2 = new MapStudyKey(2);
        MapStudyKey key3 = new MapStudyKey(3);
        MapStudyKey key4 = new MapStudyKey(4);
        MapStudyKey key5 = new MapStudyKey(5);
        MapStudyKey key6 = new MapStudyKey(6);
        MapStudyKey key7 = new MapStudyKey(7);
        MapStudyKey key8 = new MapStudyKey(8);
        MapStudyKey key9 = new MapStudyKey(9);
        MapStudyKey key10 = new MapStudyKey(10);
        MapStudyKey key11 = new MapStudyKey(11);
        MapStudyKey key12 = new MapStudyKey(12);

        MapStudyKey key21 = new MapStudyKey(21);
        MapStudyKey key22 = new MapStudyKey(22);


        Map<MapStudyKey, String> ljMap = new HashMap<MapStudyKey, String>();

        ljMap.put(key1, "1");
        ljMap.put(key2, "2");
        ljMap.put(key3, "3");

        ljMap.put(key21, "21");
        ljMap.put(key22, "22");

        ljMap.put(key4, "4");
        ljMap.put(key5, "5");
        ljMap.put(key6, "6");
        ljMap.put(key7, "7");
        ljMap.put(key8, "8");
        ljMap.put(key9, "9");
        ljMap.put(key10, "10");
        ljMap.put(key11, "11");
        ljMap.put(key12, "12");

        ljMap.get(key7);



        for(int i = 0 ; i < 20000 ; i++){
            MapStudyKey jp = new MapStudyKey();
            ljJP.add(jp);
        }


        ljMap.remove(key7);

    }


}
