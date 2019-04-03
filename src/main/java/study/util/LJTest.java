package study.util;

import java.util.*;

public class LJTest {

    public static void main(String[] args) {
//        ApplicationContext context = new FileSystemXmlApplicationContext("applicationContext.xml");

        //------------------------ArrayList-----------------------------
        List<Integer> testList = new ArrayList<Integer>();
        testList.add(1);
//        testList.add(null);
        testList.add(1);
        testList.add(2);
//
//
//        List<Integer> testAddList = new ArrayList<Integer>();
//        for(int i = 0;i<100;i++ ){
//            testAddList.add(i);
//        }
//
//        testList.addAll(testAddList);
//

        for(Iterator<Integer> iterator1 = testList.iterator();iterator1.hasNext();){
            Integer next = iterator1.next();
        }
        
        Iterator<Integer> iterator = testList.iterator();
        System.out.println("--------------------分割1--------------------");

        while (iterator.hasNext()){
            int next = iterator.next();
            System.out.println("iterator当前元素："+next);
        }

//        ListIterator<Integer> integerListIterator = testList.listIterator();
//        while (integerListIterator.hasPrevious()){
//            int next = integerListIterator.previous();
//            System.out.println("integerListIterator当前元素："+next);
//        }

        //--------------------------------------------------------------


        //--------------------
//        List<String> linkList = new LinkedList<>();
//        linkList.add("a");
//        linkList.add("b");
//        linkList.add("c");
//        linkList.add("d");
//        linkList.add("e");
//        linkList.add(2,"java");
//
//        linkList.remove(4);




//       Integer a= testList.get(1);
//        System.out.println("a="+a);

//        Map<Integer, String> testMap = new HashMap<Integer, String>();
//
//        testMap.put(1, "java");
//        testMap.put(2, "SX");
////
////        testMap.get(1);
//
//


        Map<String,String> hashMapStudy = new HashMap<>();
//        for(int i = 0;i<100;i++ ){
//            if(i == 15){
//                System.out.println(i);
//            }
//            hashMapStudy.put(""+i,""+i);
//        }
        hashMapStudy.put("1","a");
        hashMapStudy.put("1","aLJ");
        hashMapStudy.put("2","b");
        hashMapStudy.put("3","c");
        hashMapStudy.put("4","d");

        hashMapStudy.get("3");
//
//        Set<Map.Entry<String, String>> entries = hashMapStudy.entrySet();
//        System.out.println(hashMapStudy);

//        Map<String,List<Integer>> hashStringMapStudy = new HashMap<>();
//        List<Integer> testAddList = new ArrayList<Integer>();
//        for(int i = 0;i<10;i++ ){
//            testAddList.add(i);
//        }
//        hashStringMapStudy.put("1",testAddList);

//        Map<String,String> linkHashMap = new LinkedHashMap<>();
//        linkHashMap.put("1","a");
//        linkHashMap.put("1","aLJ");
//        linkHashMap.put("2","b");
//        linkHashMap.put("3","c");
//        linkHashMap.put("4","d");


//        Map<String,String> treeMap = new TreeMap<>();
//        treeMap.put("1","a");
//        treeMap.put("1","aLJ");
//        treeMap.put("2","b");
//        treeMap.put("3","c");
//        treeMap.put("4","d");


//        Set<String> hashSet = new HashSet<>();
//        hashSet.add("a");
//        hashSet.add("b");
//        hashSet.add("c");
//        hashSet.add("d");
//        hashSet.add("e");
//
//        Set<String>  treeSet = new TreeSet<>();
//        treeSet.add("a");
//        treeSet.add("b");
//        treeSet.add("c");
//        treeSet.add("d");
//        treeSet.add("e");

    }
}
