import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GetBiggestNumber {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/home/ernie/Documents/專案/ArffFormatter/example.txt");
        int biggest = 0;
        if (file.exists()) {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                int num = Integer.parseInt(scanner.next());
                if (num >= biggest) {
                    biggest = num;
                }
            }
            System.out.println(biggest);
        } else {
            System.out.println("File not found...");
        }
        System.out.println("done.");
    }
}
