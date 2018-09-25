package study.concurrence.collections.map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentHashMapTest {
    private static final int THREAD_POOL_MAX_NUM = 10;
    //    private List<String> mMap = new ArrayList<String>();
    private Map<Integer, String> mMap = new ConcurrentHashMap<Integer, String>();

    public static void main(String args[]) {
        new ConcurrentHashMapTest().start();
    }

    private void initData() {
        for (int i = 0; i <= THREAD_POOL_MAX_NUM; i++) {
            this.mMap.put((i + 1), "...... Line " + (i + 1) + " ......");
        }
    }

    private void start() {
        initData();
        ExecutorService service = Executors.newFixedThreadPool(THREAD_POOL_MAX_NUM);
        for (int i = 0; i < THREAD_POOL_MAX_NUM; i++) {
            service.execute(new ListReader(this.mMap));
            service.execute(new ListWriter(this.mMap, i));
        }
        service.shutdown();
    }

    private class ListReader implements Runnable {
        private Map<Integer, String> mMap;

        public ListReader(Map<Integer, String> map) {
            this.mMap = map;
        }

        @Override
        public void run() {
            if (this.mMap != null) {
                for (Map.Entry<Integer, String> entry : this.mMap.entrySet()) {
                    System.out.println(Thread.currentThread().getName() + " ,key: " + entry.getKey() + ",value:" + entry.getValue());
                }
            }
        }
    }

    private class ListWriter implements Runnable {
        private Map<Integer, String> mMap;
        private int mIndex;

        public ListWriter(Map<Integer, String> map, int index) {
            this.mMap = map;
            this.mIndex = index;
        }

        @Override
        public void run() {
            if (this.mMap != null) {
                //this.mMap.remove(this.mIndex);
                this.mMap.put(mIndex + 1, "...... add Line " + (mIndex) + " ......");
            }
        }
    }
}
