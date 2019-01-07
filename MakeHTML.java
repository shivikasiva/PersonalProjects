//Project for Achaa
//Make a HTML file from Java
//Input: Image URLs in a CSV file
//Output: HTML file with all images displayed

//import
import java.io.*;
import java.util.Scanner;


public class MakeHTML
{
    //global variable 
    //array initialized to null initially and then later populated within while loop using split
    String[] imageURLsArray = null; 

    //each individual image URL
    String imageURL; 

    //main method
    public static void main(String [] args) throws IOException
    {
        //call a method which makes HTML
        MakeHTML mh = new MakeHTML(); 

        Scanner in = new Scanner(new File(args[0]));
        PrintWriter out = new PrintWriter(new FileWriter(args[1]));
        mh.HTMLMaker(in, out); 
    }

    //html file maker using input CSV file and outputs into output html file
    public void HTMLMaker(Scanner in, PrintWriter out)
    {
        //HTML basic syntax setup
        out.print(" <!DOCTYPE html> \n\t <html lang=\"en\"> \n\t\t <head> \n\t\t\t <title>AllImagesDisplay</title> \n\t\t\t\t <link href=\"output.css\" rel=\"stylesheet\"> \n\t\t </head> \n\t\t <body> \n\t\t\t <div> \n\t\t\t\t "); 
        
        while(in.hasNextLine())
        {
            //trim lines
            String line = in.nextLine().trim() + " "; 

            //split each line around comma and store it to the variable imageURL
            imageURLsArray = line.split(","); 
            
            for(int i=0; i<imageURLsArray.length; i++)
            {
                imageURL = imageURLsArray[i];
                out.println("<img class=\"imageDisplaySettings\" src=\""+imageURL+"\" alt=\"Image Not Available\">");
            }
        }

        out.println("\n\t\t\t </div> \n\t\t </body> \n\t </html>"); 
        out.close();
    }
}