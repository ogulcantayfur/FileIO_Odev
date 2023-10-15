import java.io.*;
import java.util.ArrayList;

public class OTReader
{
    BufferedReader bufferedReader;
    public String fileName;
    public OTReader(String fileName) throws FileNotFoundException
    {
        this.fileName = fileName;
    }

    public ArrayList<String> readWords() throws IOException
    {
        ArrayList<String> words = new ArrayList<>();
        bufferedReader = new BufferedReader(new FileReader(fileName));
        while (bufferedReader.ready())
        {
            String line = bufferedReader.readLine();
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < line.length(); i++)
            {
                if (line.charAt(i) == 32)
                {
                    if (!(str.toString().isEmpty()))
                    {
                        words.add(str.toString());
                    }
                    str.setLength(0);
                }
                else
                {
                    if (!(line.charAt(i) == 32))
                    {
                        str.append(line.charAt(i));
                    }
                }
            }
            // döngü eğer boşluksuz biterse direkt burada listeye atıyorum.
            if (!(str.toString().isEmpty()))
            {
                words.add(String.valueOf(str));
            }
        }
        bufferedReader.close();
        return words;
    }

    public String readLineAt(int lineNumber) throws IOException
    {
        Integer iterator = 0;
        bufferedReader = new BufferedReader(new FileReader(fileName));
        while (bufferedReader.ready())
        {
            String line = bufferedReader.readLine();
            iterator++;

            if (iterator.equals(lineNumber))
            {
                bufferedReader.close();
                return line;
            }
        }
        bufferedReader.close();
        return "Satır bulunamadı";
    }


}
