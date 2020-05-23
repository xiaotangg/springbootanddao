package threadTest;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;


public class MyDoubleTest implements Cloneable {
    public static void main(String[] args) {
        double d1 = 0.01;
        double d2 = 0.02;
        System.out.println("d1*d2:" + d1 * d2);
        System.out.println("d1+d2:" + ((1.2 - 0.4) / 0.1));
        System.out.println("d1-d2:" + (d1 - d2));
        System.out.println("d1/d2:" + d1 / d2);

        BigDecimal bigDecimal = new BigDecimal((float) 1.2);
        BigDecimal bigDecima2 = new BigDecimal(1.2);
        System.out.println(bigDecimal.add(bigDecima2).multiply(bigDecima2).divide(bigDecima2, 2, BigDecimal.ROUND_HALF_EVEN));


        System.out.println("###############");
        System.out.println(Long.MAX_VALUE);
        System.out.println(new BigInteger(String.valueOf(Long.MAX_VALUE)).add(new BigInteger(String.valueOf(1L))));
        System.out.println(BigInteger.ONE.add(new BigInteger(String.valueOf(1)))); //2

    }

    @Test
    public void testListSpeed() {
//        long arrayStartTime = System.currentTimeMillis();
//        ArrayList<Integer> arrayList=new ArrayList<>();
//        for(int i =0;i<5000000;i++){
//            arrayList.add(i);
//        }
//        for (Integer value:arrayList
//                ) {
//            if(value ==1){
//                break;
//            }
//        }
//        long arrayEndTime =System.currentTimeMillis();
//        System.out.println("arrayList的时间是:"+(arrayEndTime-arrayStartTime));


        long linkStartTime = System.currentTimeMillis();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5000000; i++) {
            linkedList.add(i);
        }

//        Iterator<Integer> iterator = linkedList.iterator();
//        while(iterator.hasNext()){
//            Integer next = iterator.next();
//            if (next==500000){
//                break;
//            }
//        }
//        for (Integer value:linkedList
//             ) {
//            if(value ==1){
//                break;
//            }
//        }


        long linEndTime = System.currentTimeMillis();
        System.out.println("linkedList的时间是:" + (linEndTime - linkStartTime));
    }


    @Test
    public void testEqual() {
        BigDecimal number = new BigDecimal(1);
        changLong(number);
        System.out.println(number);
    }

    @Test
    public void testString() {
//        String s=new String("5");
//        System.out.println(s.intern() == s);
        DateTest a = new DateTest();
        System.out.println(a.a);
    }


    public static void changLong(BigDecimal number) {
        number.add(new BigDecimal(2));
    }

}
