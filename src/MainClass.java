import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class MainClass
{
    public static void main(String[] args)
    {
        try
        {
            OTReader myReader3 = new OTReader("dosya.txt");
            System.err.println(myReader3.readLineAt(29));
            for (String c : myReader3.readWords())
            {
                System.out.println(c);
            }

        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }


    }
}
