package study.guava.strings;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GuavaStringsTest {

    @Test
    public void testSplitter() {
        String s = "0x01|8002002601558858|101|0x00|1370928807267|01\\r\\n0x01|8002002601558858|101|0x00|1370928807267|01";
        String[] splitJava = s.split("\\r\\n");
        List<String> stringGuava = Splitter.on("\\r\\n").trimResults().omitEmptyStrings().splitToList(s);
        System.out.println("splitJava:"+Arrays.asList(splitJava));
        System.out.println("stringGuava:"+stringGuava);
    }

    @Test
    public void testJoiner(){
        String join = Joiner.on(",")
                .skipNulls()
                .join(Arrays.asList(1, 2, 3, 4, 5, null, 6));

        System.out.println(Joiner.on(",")
                .skipNulls()
                .join(Arrays.asList(1,2,3,4,5,null,6)));
    }


}