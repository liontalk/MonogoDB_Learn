package cn.liontalk.mongodb_demo.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * SpringBoot默认给我们使用的是info级别，
 * 所有的日志信息都会按照这个标准输入，如果想要修改 就需要修改配置
 */
public class LogTest {

    private static Logger logger = LoggerFactory.getLogger(LogTest.class);


    public static void main(String[] args) {
        /**
         * 通过logger打印日志信息
         *日志级别由低到高
         */
        logger.error("这是error");
        logger.info("这是info");
        logger.warn("这是warn");
        logger.warn("这是warn");
        logger.trace("这是trace");
        Integer a = 3;
        System.out.println(a);
        String a1  = new String("zhouzhe");
        String a2  = new String("zhouzhe");
        System.out.println(a1==a2);
        String a3 = a1.intern();
        String a4 = a1.intern();
        System.out.println(a3==a4);
    }

}
