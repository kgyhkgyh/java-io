package readerwriter;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.CharBuffer;

/**
 * Created by Administrator on 2015/7/15.
 */
public class InputStreamReaderTest {

    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        InputStreamReader reader = null;
        try {
            fileInputStream = new FileInputStream(new File("d:/test.txt"));
            reader = new InputStreamReader(fileInputStream);
            CharBuffer buffer = CharBuffer.allocate(100);
            reader.read(buffer);
            System.out.println(buffer.array());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(fileInputStream);
            IOUtils.closeQuietly(reader);
        }
    }

}
