package file.AC;


import model.CR.SecretarialStaff;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Read<T> implements Serializable{//đọc
    public  <T> List<T> readFile(List<SecretarialStaff> lister){
        File file = new File("data.txt");
        List<T> element = new ArrayList<>();
        try(InputStream inputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream)) {
            element = (List<T>) objectInputStream.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }
        return element;
    }
}
