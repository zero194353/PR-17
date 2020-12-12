import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandler {
    static void write(String s) {
        try (FileWriter writer = new FileWriter("notes.txt", false)) {
            writer.write(s);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    static void read() {
        try (FileReader reader = new FileReader("notes.txt")) {
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    static void rewrite() {
        try (FileReader reader = new FileReader("notes.txt")) {
            String s = "";
            int c;
            while ((c = reader.read()) != -1) {
                s += (char) c;
            }
            s += new Scanner(System.in).nextLine();
            write(s);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {
        write(new Scanner(System.in).nextLine());
        read();
        System.out.println("\n");
        write(new Scanner(System.in).nextLine());
        rewrite();
        read();
        System.out.println("\n");

    }
}
