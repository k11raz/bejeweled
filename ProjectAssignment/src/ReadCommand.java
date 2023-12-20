import java.io.BufferedReader;
import java.io.FileReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ReadCommand {
    public ArrayList<String> Commands() {
        ArrayList<String> commands = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(
                    "src\\command.txt"
            ));

            String line;
            while ((line = br.readLine()) != null) {
                commands.add(line);
            }
            br.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }

        ArrayList<String> commandList = new ArrayList<>();
        for(int i=0;i<commands.size();i++)
        {
            String[] a = commands.get(i).split(" ");
            if(a.length  > 1)
            {
                for(int j = 0;j<a.length;j++)
                {
                    commandList.add(a[j]);
                }
            }
            else
                commandList.add(a[0]);
        }


        return commandList;
    }
}

