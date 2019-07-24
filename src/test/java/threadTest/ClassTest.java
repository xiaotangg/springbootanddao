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





    @Test
    public void test1(){
        System.out.println(1);
    }


    @Test
    public void test2() throws ClassNotFoundException {
        //获取包中所有的类
        //包名
        String packageName="threadTest";
        List<String> classNameList=getClassName(packageName);
        String className = classNameList.stream().filter(item -> item.equals("ClassTest.class")).collect(Collectors.toList()).get(0);
        className=className.substring(0,className.length()-6);
        className=packageName + "." + className;
        Class<?> testClass = Class.forName(className);
        //获取类中的所有方法
        Method[] declaredMethods = testClass.getDeclaredMethods();
        for (Method method:declaredMethods
             ) {
            //获取方法上的注解
            Annotation[] annotations = method.getAnnotations();
            if(annotations.length>0){
                for (Annotation annotation:annotations
                     ) {
                    System.out.println(method.getName()+"----"+annotation.annotationType().getName());
                }
            }else{
                System.out.println(method.getName());
            }

        }

    }

    private List<String> getClassName(String packageName) {
        List<String>  list=new ArrayList<>();
        packageName=packageName.replace(".","/");
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        URL resource = contextClassLoader.getResource(packageName);
        if(resource!=null){
            if(resource.getProtocol().equals("file")){
                list=getClassNameByFile(resource.getPath(),list);
            }else if(resource.getProtocol().equals("jar")){

            }
        }else{
            return  list;
        }
        return  list;

    }

    private List<String> getClassNameByFile(String path, List<String> list) {
        File floder=new File(path);
        File[] files = floder.listFiles();
        for (File file:files
             ) {
            if(file.isDirectory()){
                list=getClassNameByFile(file.getPath(),list);
            }else{
                String fileName = file.getName();
                if(fileName.endsWith(".class")){
//                    String classname=fileName.substring(0,fileName.length()-6);
                    list.add(fileName);

                }
            }
        }
        return list;

    }


    @Test
    public void test3(){
//        String a="123";
//        changeStr(a);
//        System.out.println(a);
        Son son=new Son();

    }

    class Parent{
        Parent(){

        }
        protected void mehtodA(int a,int b){
            System.out.println("parent");
        }
    }

    class Son extends Parent{
        Son(){
            super();
        }
        private   void methodA(String a,int b){
            System.out.println("son");
        }
    }

    public void changeStr(String path) {
        path="456";
    }

    public static void foo(String name) {
        System.out.println(name);
    }

    public static void main(String[] args) {
        int i=0;

    }


}
