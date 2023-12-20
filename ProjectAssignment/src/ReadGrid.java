import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.String;

public class ReadGrid {

    public String[] FileReader() {


        int i=0;
        String[] gameGrid = new String[11];
        try {
            BufferedReader br = new BufferedReader(new FileReader(
                    "src\\gameGrid.txt"
            ));

            while((gameGrid[i] = br.readLine()) != null) {
                i++;

            }
            br.close();
        }catch (Exception ex) {
            ex.printStackTrace();
        }

        return gameGrid;

    }
}
