/*6. Filter Streams - Convert Uppercase to Lowercase
Problem Statement:
Create a program that reads a text file and writes its contents into another file, converting all uppercase letters to lowercase.
Requirements:
Use FileReader and FileWriter.
Use BufferedReader and BufferedWriter for efficiency.
Handle character encoding issues.
 */
import java.io.*;

public class ConvertUppercaseLowercase {

    public static void main(String[] args) {

        String sourceFile = "input.txt";
        String destFile = "output.txt";

        try (
            FileReader fr = new FileReader(sourceFile);
            BufferedReader br = new BufferedReader(fr);

            FileWriter fw = new FileWriter(destFile);
            BufferedWriter bw = new BufferedWriter(fw);
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line.toLowerCase());
                bw.newLine();
            }

            System.out.println("File converted to lowercase successfully: " + destFile);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
