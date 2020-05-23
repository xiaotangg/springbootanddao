package threadTest;

import org.junit.Test;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class NIOTest {


    //测试使用java8的NIO进行文件的读取
    @Test
    public void test1() {
        try {
            File file = ResourceUtils.getFile("classpath:a.txt");
            FileChannel fileChannel = new FileInputStream(file).getChannel();
            //分配buffer
            int readLength = 15;
            ByteBuffer byteBuffer = ByteBuffer.allocate(readLength);
            int length;
            byte[] nioByte = new byte[1024];
            int time = 0;
            while ((length = fileChannel.read(byteBuffer)) != -1) {
                time++;
                byteBuffer.flip();
                byteBuffer.get(nioByte, 0, length);
                System.out.println(new String(nioByte, 0, length, "UTF-8")+"-----length:"+length);
                byteBuffer.clear();
            }
            System.out.println(time);
            fileChannel.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //测试使用java8的NIO进行文件的复制
    @Test
    public void test2() {
        try {
            File fileA = ResourceUtils.getFile("classpath:a.txt");
            File fileB = new File("D:\\b.txt");
            if (!fileB.exists()) {
                fileB.createNewFile();
            }
            FileChannel fileChannelA = new FileInputStream(fileA).getChannel();
            FileChannel fileChannelB = new FileOutputStream(fileB).getChannel();
            //将文件映射到内存
            MappedByteBuffer buffer = fileChannelA.map(FileChannel.MapMode.READ_ONLY, 0, fileA.length());

            fileChannelB.write(buffer);
            fileChannelA.close();
            fileChannelB.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    //测试使用java8的NIO进行文件的下载
    @Test
    public void test3() {
        try {
            File fileA = ResourceUtils.getFile("classpath:a.txt");
            File fileB = new File("D:\\b.txt");
            FileChannel fileChannelA = new FileInputStream(fileA).getChannel();
            FileChannel fileChannelB = new FileOutputStream(fileB).getChannel();
            //从in通道进行读取，通过out通道写出去，连接两个通道，就不用使用应用程序的内存
//            fileChannelB.transferFrom(fileChannelA, 0, fileA.length());
            fileChannelA.transferTo(0, fileA.length(), fileChannelB);

            fileChannelA.close();
            fileChannelB.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void testChangeReader() throws Exception {
        FileInputStream inputStream = new FileInputStream(new File("aaa"));
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");

    }


}
