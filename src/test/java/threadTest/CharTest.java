package threadTest;

import org.junit.Test;

public class CharTest {



    /**
     * 测试字符串的个数
     */
    @Test
    public void testCharCount(){
        String str="asfd   ";
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]+"--"+i);
        }
    }
}
