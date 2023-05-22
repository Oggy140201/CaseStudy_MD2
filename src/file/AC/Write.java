package file.AC;

import model.CC.Employee;

import java.io.*;
import java.util.List;

public class Write<T> implements Serializable {//ghi

    public void writeFile(List<Employee> element) {
        File file = new File("data.txt");
        try{
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(element.toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}