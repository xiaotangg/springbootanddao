package threadTest;

import org.junit.Test;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClassTest {

   public int x=5;


   @Test
    public void test1() {
        System.out.println(1);
    }


    @Test
    public void test2() throws ClassNotFoundException {
        //获取包中所有的类
        //包名
        String packageName = "threadTest";
        List<String> classNameList = getClassName(packageName);
        String className = classNameList.stream().filter(item -> item.equals("ClassTest.class")).collect(Collectors.toList()).get(0);
        className = className.substring(0, className.length() - 6);
        className = packageName + "." + className;
        Class<?> testClass = Class.forName(className);
        //获取类中的所有方法
        Method[] declaredMethods = testClass.getDeclaredMethods();
        for (Method method : declaredMethods
                ) {
            //获取方法上的注解
            Annotation[] annotations = method.getAnnotations();
            if (annotations.length > 0) {
                for (Annotation annotation : annotations
                        ) {
                    System.out.println(method.getName() + "----" + annotation.annotationType().getName());
                }
            } else {
                System.out.println(method.getName());
            }

        }

    }

    private List<String> getClassName(String packageName) {
        List<String> list = new ArrayList<>();
        packageName = packageName.replace(".", "/");
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        URL resource = contextClassLoader.getResource(packageName);
        if (resource != null) {
            if (resource.getProtocol().equals("file")) {
                list = getClassNameByFile(resource.getPath(), list);
            } else if (resource.getProtocol().equals("jar")) {

            }
        } else {
            return list;
        }
        return list;

    }

    private List<String> getClassNameByFile(String path, List<String> list) {
        File floder = new File(path);
        File[] files = floder.listFiles();
        for (File file : files
                ) {
            if (file.isDirectory()) {
                list = getClassNameByFile(file.getPath(), list);
            } else {
                String fileName = file.getName();
                if (fileName.endsWith(".class")) {
//                    String classname=fileName.substring(0,fileName.length()-6);
                    list.add(fileName);

                }
            }
        }
        return list;

    }


    /**
     * 测试子类会不会覆盖父类方法
     */
    @Test
    public void test3() {
        //只能拿到父类的方法,子类多出的方法并不能获取到，相同方法如果是私有就是使用自己的，共有就是使用子类的，不能子类定义私有而自己非私有，相同变量使用父类的
        Parent parent = new Son();
        System.out.println("parent.a=" + parent.a);
        System.out.println("--------");
        //既然拿到父类方法又能拿到子类的方法，相同方法如果是私有就是使用自己的，共有使用子类的，相同变量是使用子类的
        Son son = new Son();
        System.out.println("son.a=" + son.a);
        Parent[] p = new Son[10];   //数组的协变性

    }

    /**
     * 测试断言
     */
    @Test
    public void testAssert() {
        Integer a = 0;
        Integer b = 1;
//        Assert.assertEquals(a,b);

        exchangeInteger(a, b);
//        Assert.assertEquals(a,b);
        System.out.println(a);

    }

    /**
     * 测试引用地址对比
     */
    @Test
    public void testObjectAddress() {
        int x=7;
        System.out.println(x);
        String a = "a", b = "b", ab = "ab", c;
        String f = a + b;
        String e = new String("a") + new String("b");
        String g = "a" + "b";
        System.out.println(f == ab);  //false
        System.out.println(e == ab);  //false
        System.out.println(g == ab);  //true
//        System.out.println(a+c);   //编译无法通过
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append("hello");
        ((ClassTest)null).exchangeStringbuffer(stringBuffer);
        System.out.println(stringBuffer); //helloaaaa



    }

    private static void  exchangeStringbuffer(StringBuffer stringBuffer) {
//        stringBuffer=new StringBuffer();
        stringBuffer.append("aaaa");
    }


    /**
     * 测试引用传递
     */
    @Test
    public void test4() {
        int[] a = new int[]{1, 2, 3};
        int[] b = new int[]{4, 5, 6};
        exchangeArray(a, b);
        for (int i = 0; i < a.length; i++) {
            System.out.println("a[" + i + "]:" + a[i]);
        }
        for (int i = 0; i < b.length; i++) {
            System.out.println("b[" + i + "]:" + b[i]);
        }

    }

    class Parent {
        int a = 10;
        private int b = 11;

        Parent() {
            methodC(a);
        }

        void methodA() {
            System.out.println("parent-methodA");
        }

        private void methodC(int x) {
            System.out.println("parent-methodC");
            a = x + 2;
        }

    }

    class Son extends Parent {
        int a = 15;  //子类并不会覆盖父类的变量
        int c = 14;

        Son() {
            methodC(a);
        }

        void methodB() {
            System.out.println("son-methodB");
        }

        void methodC(int x) {
            System.out.println("son-methodC,x=" + x);
            a = x + 2;            //这里等同于  this.a=x+2
//            super.a=super.a+2;    //这里才会真正修改父类的变量值
        }
    }

    public void changeStr(String path) {
        path = "456";
    }

    public void exchangeArray(int[] a, int[] b) {
        a[0] = 8;   //改到真实地址数组的值
        b = a;      //只改到局部变量b的指向
    }

    public void exchangeInteger(Integer a, Integer b) {
        a = 1;   //基本数据类型和其封装类型只是值传递
        b = a;      //只改到局部变量b的指向
    }

    public static void foo(String name) {
        System.out.println(name);
    }


    /**
     * 测试子类是否需要显式调用父类带参构造
     * 结论：子类需要带参构造而父类也有带参构造的情况下，如果父类没有无参构造，就会编译错误，如果父类有无参构造，但子类带参构造不显式调用父类带参构造，就不会执行父类带参构造
     * ps：super必须写在构造参数的第一行
     */

    class SecondParent {
        private int a = 10;

        SecondParent(int a) {
            System.out.println("父类带参构造");
            this.a = a;
        }

        SecondParent() {
            System.out.println("父类无参构造");
        }


        public void outParam(String o){
            System.out.println("调用父类参数");
        }
    }

    class SecondSon extends SecondParent {
        private int a = 10;

        SecondSon(int a) {
//            super(a);
            System.out.println("子类带参构造");
            this.a = a;
        }
        public void outParam(String o){
            System.out.println("调用子类参数");
        }
    }

    @Test
    public void testExtends() {
        SecondParent son = new SecondSon(1);
        //重写会调用子类的，重载只会调用父类的，因为这个是parent为引用
        son.outParam(new String("aaa"));
    }


    /**
     * 测试string参数方法和object参数方法会优先使用哪个(String优先)
     * 测试Integer参数方法和object参数方法会优先使用哪个(Integer优先)
     */

    @Test
    public void testParam() {
        String a="aa";
        outParam(a);
        outParam(new Integer(1));
    }


    public void outParam(String s){
        System.out.println("调用String参数");
    }
    public void outParam(Object o){
        System.out.println("调用Object参数");
    }
    public void outParam(Integer o){
        System.out.println("调用Integer参数");
    }



}
