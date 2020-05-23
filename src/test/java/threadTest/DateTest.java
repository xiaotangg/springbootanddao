package threadTest;

import org.junit.Test;

import java.sql.Timestamp;
import java.time.*;
import java.util.Date;

public class DateTest {

    int a = 2;

    @Test
    public void test1() {
        LocalDate now = LocalDate.now();
        Date date = new Date();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(localDateTime);
        System.out.println(now);
        System.out.println(localTime);
        System.out.println(localDateTime);
        System.out.println(timestamp);

    }



    @Test
    public void testLocalDateTime(){
//        String timeFormate = "2018-05-06";
//        DateTimeFormatter StringToDateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate localDate = LocalDate.parse(timeFormate,StringToDateFormat);
//        System.out.println("String转LocalDate:"+localDate);
//
//        DateTimeFormatter dateToStringFormat = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
//        String timeString = dateToStringFormat.format(localDate);
//        System.out.println("LocalDate转String:"+timeString);


        LocalDateTime beginDateTime = LocalDateTime.of(2019, 10, 3, 5, 5, 5);
        LocalDateTime endDateTime = LocalDateTime.of(2019, 6, 3, 5, 5, 5);

        //很坑，天数差只能获取同月的，月数差只能获取同年的，正确写法可以用下面两种，但是月数还是要getMonthValue()后自己算
//        System.out.println(Period.between(beginDateTime.toLocalDate(),endDateTime.toLocalDate()).getDays());
        System.out.println(Duration.between(beginDateTime,endDateTime).toDays());
        System.out.println(beginDateTime.toLocalDate().toEpochDay() - endDateTime.toLocalDate().toEpochDay());
    }

}
