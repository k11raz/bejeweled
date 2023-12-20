import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class writeLeaderboard {

    public  void writeFile(ArrayList<Player> leaderboard, String fileName) {
        try {
            FileWriter fileWriter = new FileWriter("src\\"+ fileName+".txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (int i = 0; i< leaderboard.size();i++) {
                bufferedWriter.write(i+1 +". "+leaderboard.get(i).getName()+ " : "+leaderboard.get(i).getScore()); // Burada varsayılan olarak Player nesnesinin toString() metodunu kullanarak yazdırıyorum. Eğer başka bir çıktı istiyorsanız ona göre düzenlemelisiniz.
                bufferedWriter.newLine();
            }

            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
