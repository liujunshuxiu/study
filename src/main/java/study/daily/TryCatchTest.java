package study.daily;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TryCatchTest {
    private static final Logger logger = LoggerFactory.getLogger(TryCatchTest.class);

    public static void main(String[] args) {
        int num = 0;

        try {
            for (int i = 0; i < 100; i++) {
                num++;
                if (i == 50) {
                    throwError();
                }

            }

        } catch (Exception e) {
            logger.error(" create table error:" + e.getMessage(), e);
        }


        System.out.println("num:" + num);
    }

    private static void throwError() {
        try {
            System.out.println("触发异常");
            throw new Exception("试试");
        } catch (Exception e) {
            logger.error("table agent_detail insertOnUpdate error:" + e.getMessage(), e);
        }

    }


}
