import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ArffFormatter {
    private static final int MAX_ELEMENT = 16469;
    private static final int NUM_CONVERT_LINES = 10000; // convert all when value is 0
    private static final String OLD_FILENAME = "/home/ernie/Documents/專案/ArffFormatter/resources/example.txt";
    private static final String NEW_FILENAME = "/home/ernie/Documents/專案/ArffFormatter/arff/dataset1000.arff";
    private static final String DATASET_NAME = "410615712李岳";

    public static void main(String[] args) {//arg1: old file location, arg2: new filename
        try {
            int lineCounter = 0;
            File oldFile = new File(OLD_FILENAME);
            File newFile = new File(NEW_FILENAME);
            if (newFile.exists() || newFile.createNewFile()) {
                Scanner scanner = new Scanner(oldFile);
                FileWriter fileWriter = new FileWriter(newFile);
                //write head
                fileWriter.write("@relation " + DATASET_NAME + "\n\n");
                for (int i = 0; i <= MAX_ELEMENT; i++) {
                    fileWriter.write("@attribute " + "A" + i + " {t}\n");
                }
                fileWriter.write("@data\n");
                //deal with every single line of old data
                while (scanner.hasNextLine() && (lineCounter <=NUM_CONVERT_LINES || 0 == NUM_CONVERT_LINES)) {
                    if (lineCounter != 0) {
                        fileWriter.write("\n");
                    }
                    System.out.println("converting line: " + lineCounter);
                    lineCounter++;
                    String[] strings = scanner.nextLine().split(" ");
                    //製作當前數字組
                    ArrayList<Integer> integers = new ArrayList<>();
                    for (String str : strings) {
                        integers.add(Integer.parseInt(str));
                    }
                    //輸出arff資料組
                    for (int i = 0; i <= MAX_ELEMENT; i++) {
                        if (integers.contains(i)) {
                            fileWriter.write("t");
                        } else {
                            fileWriter.write("?");
                        }
                        if (i <= MAX_ELEMENT - 1) {
                            fileWriter.write(",");
                        }
                    }
                }
                fileWriter.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("successfully build arff file.");
    }
}
