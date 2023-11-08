import java.io.IOException;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.io.PrintWriter;

/**
 This program prints all data from a web page and writes it to a file given by user.
 */
public class Main
{
    public static void main(String[] args) throws IOException
    {
        Scanner console = new Scanner(System.in);
        System.out.print("enter the web page URL: ");
        String address = console.next();

        System.out.print("Enter the Output File: ");
        String fileName = console.next();
        try{
            printToFile(address, fileName);
        }
        catch(IOException e){
            if(e.getClass().getSimpleName().equals("MalformedURLException")){
                System.out.println("Incorrect address");
            }
            else {
                System.out.println(e.getClass().getSimpleName() + "exception caught: " + e.getMessage());
            }
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
                outFile.println(line);
                //code to display all lines from a web page that contain references to other web sites.
//                if (line.contains("href=\"https://"))
//                {
//                    int from = line.indexOf("\"");
//                    int to = line.lastIndexOf("\"");
//                    outFile.println(line.substring(from + 1, to));
//                }
            }
        }

    }
}
