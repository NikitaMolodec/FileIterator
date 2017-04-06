import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileIterator fi = new FileIterator("src/test.txt");
        System.out.println(fi.currentLine);
        if(fi.hasNext()) System.out.println(fi.next());
    }
}
