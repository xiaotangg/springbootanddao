package threadTest;

import org.junit.Test;



public class ForeachTest {


    public boolean printChar(String c){
        System.out.print(c);
        return true;
    }


    @Test
    public void test1(){
        for(;;){
            System.out.println(1);
        }
    }

    @Test
    public void test2(){
        int i=0;
        for(printChar("A");printChar("B")&&i<5;++i){
            printChar("D");
            System.out.println(i);
        }
    }


}
