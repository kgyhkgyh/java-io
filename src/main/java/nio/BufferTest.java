package nio;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by Administrator on 2015/7/15.
 */
public class BufferTest {

    public static void main(String[] args) {
        FileInputStream inputStream = null;
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        FileOutputStream outputStream = null;
        try {
            long startTime = System.currentTimeMillis();
            inputStream = new FileInputStream(new File("d:/test.txt"));
            outputStream = new FileOutputStream(new File("d:/test2.txt"));
            inChannel = inputStream.getChannel();
            outChannel = outputStream.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1000);
            while (inChannel.read(buffer) != -1) {
                buffer.flip();
                outChannel.write(buffer);
                buffer.flip();
            }
            System.out.println(System.currentTimeMillis() - startTime);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(inputStream);
            IOUtils.closeQuietly(outputStream);
            IOUtils.closeQuietly(inChannel);
            IOUtils.closeQuietly(outChannel);
        }
    }

}
