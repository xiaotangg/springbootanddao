package threadTest;

import org.junit.Test;
import springboot.dao.param.SortDateClass;

import java.util.*;
import java.util.stream.Collectors;

public class SortTest {


    @Test
    public void test1() {
        int[] a = new int[]{1, 2, 3, 4};
        sortArray(a, 0);
    }

    public void sortArray(int[] array, int start) {
        StringBuilder stringBuilder = new StringBuilder();
        if (start == array.length - 1) {
            stringBuilder.setLength(0);
            for (int i = 0; i < array.length; i++) {
                stringBuilder.append(array[i]);
            }
            System.out.println(stringBuilder.toString());
        }

        for (int i = start; i < array.length; i++) {
            int temp = array[start];
            array[start] = array[i];
            array[i] = temp;
            sortArray(array, start + 1);
            int temp2 = array[start];
            array[start] = array[i];
            array[i] = temp2;
        }


    }


    @Test
    public void test2() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 5000; i++) {
            arrayList.add(i);
        }


        for (int i = 0; i < 5; i++) {
            long l1 = System.currentTimeMillis();
//          for (Integer number:arrayList
//               ) {
//              System.out.print(number);
//          }
            arrayList.forEach(x -> System.out.print(x));
            long l2 = System.currentTimeMillis();
            System.out.println("第" + i + "次" + (l2 - l1));


        }


    }


    @Test
    public void test3() {
        Map<Integer, Integer> treeMapTInteger = new TreeMap<Integer, Integer>();
        treeMapTInteger.put(20, 1);
        treeMapTInteger.put(4, 1);
        treeMapTInteger.put(3, 1);
        treeMapTInteger.put(7, 1);
        treeMapTInteger.put(8, 1);
        treeMapTInteger.put(1, 1);

        for (Map.Entry<Integer, Integer> map : treeMapTInteger.entrySet()) {
            System.out.println(map.getKey() + ":" + map.getValue());    //1,3,4,7,8
        }

        System.out.println("############################");

        Map<String, Integer> treeMapTString = new TreeMap<String, Integer>();
        treeMapTString.put("a", 1);
        treeMapTString.put("b", 1);
        treeMapTString.put("c", 1);
        treeMapTString.put("d", 1);
        treeMapTString.put("ca", 1);

        for (Map.Entry<String, Integer> map : treeMapTString.entrySet()) {
            System.out.println(map.getKey() + ":" + map.getValue());    //a,b,c,ca,d
        }
    }


    @Test
    public void testFinal() {
        final StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("a");
        System.out.println(stringBuffer.toString());
    }


    @Test
    public void testLinkedList() {
//        LinkedList<Integer> list=new LinkedList<>();
//        list.add(1);
//        list.add(4);
//        list.add(5);
//        list.add(3);
//        list.add(3);
//        //保证了插入的顺序
//        list.stream().forEach(e-> System.out.println(e));

        //linkedHashMap保证了插入的顺序(hashMap是无序的，而treeMap保证了)
        LinkedHashMap<Integer,String> linkedHashMap=new LinkedHashMap<>();
        linkedHashMap.put(1,"a");
        linkedHashMap.put(2,"b");
        linkedHashMap.put(3,"c");
        linkedHashMap.put(4,"d");
        linkedHashMap.put(5,"e");
        linkedHashMap.put(17,"f");
        linkedHashMap.entrySet().forEach(entry -> System.out.println("key:"+entry.getKey()+"value:"+entry.getValue()));


    }


    @Test
    public void testThirdSit() {
        thirdTest(3);

    }

    @Test
    public void testClassSortByDate() {
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH,1);
        Date time1 = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH,-3);
        Date time2 = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH,2);
        Date time3 = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH,-4);
        Date time4 = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH,-20);
        Date time5 = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH,50);
        Date time6 = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH,-80);
        Date time7 = calendar.getTime();


        SortDateClass sortDateClass1=new SortDateClass(1,time1);
        SortDateClass sortDateClass2=new SortDateClass(1,time2);
        SortDateClass sortDateClass3=new SortDateClass(1,time3);
        SortDateClass sortDateClass4=new SortDateClass(1,time4);
        SortDateClass sortDateClass5=new SortDateClass(2,time5);
        SortDateClass sortDateClass6=new SortDateClass(2,time6);
        SortDateClass sortDateClass7=new SortDateClass(1,time7);
        List<SortDateClass> list=new ArrayList<>();
        list.add(sortDateClass1);
        list.add(sortDateClass2);
        list.add(sortDateClass3);
        list.add(sortDateClass4);
        list.add(sortDateClass5);
        list.add(sortDateClass6);
        list.add(sortDateClass7);
        Map<Integer, List<SortDateClass>> collect = list.stream().sorted(Comparator.comparing(SortDateClass::getDate)).collect(Collectors.groupingBy(SortDateClass::getId));
        for(Map.Entry<Integer,List<SortDateClass>> entry:collect.entrySet()){
            System.out.println("----------------");
            List<SortDateClass> value = entry.getValue();
            for (SortDateClass sortDateClass:value) {
                System.out.println(sortDateClass.getId()+":"+sortDateClass.getDate());
            }
        }
    }



    public int thirdTest(int number){
        int index=-1;
        int count=1;
        int len;
        List<Integer> linkList=new LinkedList<>();
        for (int i = 1; i <=number; i++) {
            linkList.add(i);
        }

        while((len=linkList.size())>0){
            index=(index+3)%len;
            Integer peopleIndex = linkList.remove(index--);
            System.out.println("第"+count+"次的位置为："+peopleIndex);
            count++;
        }
        return index;

    }


}
