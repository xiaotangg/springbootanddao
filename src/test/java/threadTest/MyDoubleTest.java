package threadTest;

import java.math.BigDecimal;

public class MyDoubleTest {
    public static void main(String[] args) {
        double d1=0.01;
        double d2=0.02;
        System.out.println("d1*d2:"+d1*d2);
        System.out.println("d1+d2:"+((1.2 - 0.4)/ 0.1));
        System.out.println("d1-d2:"+(d1-d2));
        System.out.println("d1/d2:"+d1/d2);

        BigDecimal bigDecimal = new BigDecimal((float)1.2);
        BigDecimal bigDecima2 = new BigDecimal(1.2);
        System.out.println(bigDecimal.add(bigDecima2).multiply(bigDecima2).divide(bigDecima2,2,BigDecimal.ROUND_HALF_EVEN));
    }
}
