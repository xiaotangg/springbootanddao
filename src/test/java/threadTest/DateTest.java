package threadTest;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class DateTest {

     int a=2;

    @Test
    public void test1(){
        LocalDate now = LocalDate.now();
        Date date =new Date();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(localDateTime);
        System.out.println( now);
        System.out.println( localTime);
        System.out.println( localDateTime);
        System.out.println( timestamp);

    }

}
