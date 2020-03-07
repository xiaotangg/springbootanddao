package threadTest;

import org.junit.Test;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class SortTest {





    @Test
    public void test1(){
        int[] a=new int[]{1,2,3,4};
        sortArray(a,0);
    }

    public void sortArray(int[] array,int start){
        StringBuilder stringBuilder=new StringBuilder();
        if (start==array.length-1){
            stringBuilder.setLength(0);
            for (int i=0;i<array.length;i++){
                stringBuilder.append(array[i]);
            }
            System.out.println(stringBuilder.toString());
        }

        for (int i=start;i<array.length;i++){
            int temp=array[start];
            array[start]=array[i];
            array[i]=temp;
            sortArray(array,start+1);
            int temp2=array[start];
            array[start]=array[i];
            array[i]=temp2;
        }



    }


    @Test
    public void test2(){
      ArrayList<Integer> arrayList=new ArrayList<>();
      for(int i=0;i<5000;i++){
          arrayList.add(i);
      }


      for (int i=0;i<5;i++){
          long l1 = System.currentTimeMillis();
//          for (Integer number:arrayList
//               ) {
//              System.out.print(number);
//          }
          arrayList.forEach(x-> System.out.print(x));
          long l2 = System.currentTimeMillis();
          System.out.println("第"+i+"次"+(l2-l1));


          
      }


    }


    @Test
    public void test3(){
        Map<Integer,Integer> treeMapTInteger=new TreeMap<Integer,Integer>();
        treeMapTInteger.put(4,1);
        treeMapTInteger.put(3,1);
        treeMapTInteger.put(7,1);
        treeMapTInteger.put(8,1);
        treeMapTInteger.put(1,1);

        for (Map.Entry<Integer,Integer> map:treeMapTInteger.entrySet()) {
            System.out.println(map.getKey()+":"+map.getValue());    //1,3,4,7,8
        }

        System.out.println("############################");

        Map<String,Integer> treeMapTString=new TreeMap<String,Integer>();
        treeMapTString.put("a",1);
        treeMapTString.put("b",1);
        treeMapTString.put("c",1);
        treeMapTString.put("d",1);
        treeMapTString.put("ca",1);

        for (Map.Entry<String,Integer> map:treeMapTString.entrySet()) {
            System.out.println(map.getKey()+":"+map.getValue());    //a,b,c,ca,d
        }
    }


    @Test
    public void testFinal(){
       final StringBuffer stringBuffer=new StringBuffer();
       stringBuffer.append("a");
       System.out.println(stringBuffer.toString());
    }


}
