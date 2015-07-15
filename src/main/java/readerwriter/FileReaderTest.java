package readerwriter;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileReader;
import java.nio.CharBuffer;

/**
 * Created by Administrator on 2015/7/15.
 */
public class FileReaderTest {

    public static void main(String[] args) {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(new File("d:/test.txt"));
            CharBuffer buffer = CharBuffer.allocate(100);
            fileReader.read(buffer);
            System.out.println(buffer.array());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(fileReader);
        }
    }

}
