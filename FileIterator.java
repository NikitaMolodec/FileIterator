import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class FileIterator implements Iterator<String>{

    private String filename;
    private int iterator = 0;

    public FileIterator(String filename){
        this.filename = filename;
    }

    @Override
    public boolean hasNext() {
        try(BufferedReader br = new BufferedReader(new FileReader(filename))){
            if(br.readLine() != null) {
                iterator++;
                return true;
            }
            else{
                return false;
            }

        }catch(IOException e){
            throw new IllegalStateException("Can't read file");
        }
    }

    @Override
    public String next() {
        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String result = null;
            if (hasNext()) {
                for (int i = 0; i < iterator; i++) {
                    result = br.readLine();
                }
            }
            return result;
        }catch(IOException e){
            throw new IllegalStateException("Can't read file");
        }
    }
}
