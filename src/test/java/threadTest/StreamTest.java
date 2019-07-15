package threadTest;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;
import springboot.dao.UserT;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {
        //stream练习
        //构建数据
        UserT user1=new UserT();
        user1.setId(1);
        user1.setAge(18);
        user1.setUserName("user1");
        user1.setPassword("password1");
        UserT user2=new UserT();
        user2.setId(2);
        user2.setAge(19);
        user2.setUserName("user2");
        user2.setPassword("password2");
        UserT user3=new UserT();
        user3.setId(3);
        user3.setAge(20);
        user3.setUserName("user3");
        user3.setPassword("password3");
        UserT user4=new UserT();
        user4.setId(1);
        user4.setAge(21);
        user4.setUserName("user4");
        user4.setPassword("password4");

        List<UserT> userTList=new ArrayList<UserT>();
        userTList.add(user1);
        userTList.add(user2);
        userTList.add(user3);
        userTList.add(user4);

//        练习一(这种形式是处理list转map情况下key重复时，前提是list，一种不错的解决方案)
//        通过list获取一个Int为key，List<object>为value 的map
//        List转map
//        Map<Integer, List<UserT>> oneMap = userTList.stream().collect(Collectors.groupingBy(UserT::getId));
//        for (Map.Entry<Integer,List<UserT>> userMap:oneMap.entrySet()) {
//            Integer key=userMap.getKey();
//            List<UserT> value = userMap.getValue();
//            for (UserT usertT:value
//                 ) {
//                System.out.println(key+"------"+usertT.getUserName());
//            }
//        }

//        练习二（这种list转map会选择新key的值还是旧key的值）
//        通过list获取一个Int为key，userT为value 的map
//        List转map
//        Map<Integer,UserT> testMap2 = userTList.stream().collect(Collectors.toMap(UserT::getId,item->item,(k1,k2)->k2));
//        for (Map.Entry<Integer,UserT> userMap:testMap2.entrySet()) {
//            Integer key=userMap.getKey();
//            UserT value = userMap.getValue();
//            System.out.println(key+"------"+value.getUserName());
//        }

//        练习三（list集合去重key得到ID的List）
//        List<Integer> distinctIdList = userTList.stream().map(UserT::getId).distinct().collect(Collectors.toList());
//        for (Integer i:distinctIdList
//             ) {
//            System.out.println(i);
//        }
//
//
//
//        练习四（list集合根据条件获取一个对象，没有就返回null,findAny在数据少的时候基本返回第一个跟findFirst一样，并行的时候返回随机一个，）
//        UserT  userT = userTList.stream().filter(item->item.getId()==1).findAny().orElse(null);
//        System.out.println(userT);


//        练习五（list集合根据ID转成数组）
//        String[] usernames = userTList.stream().map(UserT::getUserName).distinct().toArray(String[]::new);
//        System.out.println(usernames.length);

//        练习六（list集合求出年龄最大的学生）
//        UserT userT = userTList.stream().collect(Collectors.maxBy(Comparator.comparing(UserT::getAge))).get();
//        System.out.println(userT.getUserName());


//        练习七（list集合查找是否有年龄为20的学生）
//        System.out.println(userTList.stream().anyMatch(item->item.getAge()==20));
//
//
//
//        练习八（list集合所有学生的年龄总值）
        Integer sum = userTList.stream().map(UserT::getAge).reduce(Integer::sum).get();
        System.out.println(sum);
//


    }

}
