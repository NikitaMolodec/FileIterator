import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class FileIterator implements Iterator<String>, AutoCloseable{

    private String filename;
    private BufferedReader br;
    public String currentLine;

    public FileIterator(String filename) throws IOException {
        this.filename = filename;
        br = new BufferedReader(new FileReader(filename));
        currentLine = br.readLine();

    }

    private boolean isNull(BufferedReader br) throws IOException {
        return br.readLine() == null;
    }

    private BufferedReader copyBr(BufferedReader br) throws IOException {
        br = new BufferedReader(br);
        return br;
    }

    @Override
    public boolean hasNext() throws NoSuchElementException{
        try {
            BufferedReader br2 = copyBr(br);
            System.out.println(br.readLine()+ "111");
            System.out.println(br2.readLine());
            System.out.println(br.readLine()+ "999");
            return br2.readLine() != null;
        } catch (IOException e) {
            throw new IllegalStateException("line not exist");
        }
    }

    @Override
    public String next() throws NoSuchElementException{
        try {
            return currentLine = br.readLine();
        } catch (IOException e) {
            throw new IllegalStateException("Can't read line");
        }
    }

    @Override
    public void close() throws Exception {
        br.close();
    }
}
