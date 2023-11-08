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


        URL pageLocation = new URL(address);
        Scanner in = new Scanner(pageLocation.openStream());
        System.out.print("Enter the Output File: ");
        String FileName = console.next();
        PrintWriter outFile = new PrintWriter(FileName);

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
        console.close();
        in.close();
        outFile.close();
    }
}