package com.xion.wiki;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
public class DateTimeUtilTests {

    @Test
    public void DateTime() throws ParseException {
        // 时间戳
        System.out.println(System.currentTimeMillis());
        System.out.println(new Date().getTime());

        String dateTime = "2022-01-01 08:00:00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(sdf.parse(dateTime).getTime());

//        SnowFlake snowFlake = new SnowFlake(1, 1);
//
//        long start = System.currentTimeMillis();
//        for (int i = 0; i < 10; i++) {
//            System.out.println(snowFlake.nextId());
//            System.out.println(System.currentTimeMillis() - start);
//        }
    }

}
