package threadTest;

import org.junit.Test;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class MathTest {

    @Test
    public void test1() {
        System.out.println(Math.floor(Math.random() * 100)); //86.0
        String a = "a";
        String b = "A";
        System.out.println(a.equalsIgnoreCase(b));     //true
        System.out.println(a.compareToIgnoreCase(b));  //0
    }
}
