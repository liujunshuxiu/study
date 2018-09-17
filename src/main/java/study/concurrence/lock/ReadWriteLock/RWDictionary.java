package study.concurrence.lock.ReadWriteLock;

import java.util.Map;
import java.util.TreeMap;

public class RWDictionary {
    private final Map<String, String> m = new TreeMap<String, String>();
}
