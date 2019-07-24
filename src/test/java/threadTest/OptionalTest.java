package threadTest;

import org.junit.Test;

import java.util.Optional;

public class OptionalTest {
    @Test
    public void test1(){
        Optional<Integer> empty = Optional.of(4);
        Integer a = empty.orElse(get('a'));
        Integer b = empty.orElseGet(()->get('b'));
        System.out.println("a"+a);
        System.out.println("b"+b);

    }

    private Integer get(char a) {
        System.out.println(a+"-----------");
        return 1;


    }
}
