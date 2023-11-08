import java.io.IOException;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.io.PrintWriter;

/**
 This program prints all lines from a web page that contain
 references to other web sites.
 */
public class Main
{
    public static void main(String[] args) throws IOException
    {
        Scanner console = new Scanner(System.in);
        System.out.print("enter the web page URL: ");
        String address = console.next();

        System.out.print("Enter the Output File: ");
        String FileName = console.next();
        try{
            printToFile(address, FileName);
        }
        catch(IOException e){
            //e.printStackTrace();
            System.out.println("exception caught");
        }
        console.close();
    }

    public static void printToFile(String address, String fileName) throws java.io.IOException {

        URL pageLocation = new URL(address);
        try(Scanner in = new Scanner(pageLocation.openStream()); PrintWriter outFile = new PrintWriter(fileName);)
        {
            while (in.hasNext())
            {
                String line = in.next();
                //System.out.println(line);
                if (line.contains("href=\"https://"))
                {
                    int from = line.indexOf("\"");
                    int to = line.lastIndexOf("\"");
                    outFile.println(line.substring(from + 1, to));
                    //System.out.println(line.substring(from + 1, to));
                }
            }
        }

    }
}
