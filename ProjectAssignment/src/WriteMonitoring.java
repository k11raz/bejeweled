import java.io.*;

public class WriteMonitoring {
    public void writemonitor() {
        try {

            PrintStream console = System.out;


            File file = new File("src\\monitoring.txt");
            FileOutputStream fos = new FileOutputStream(file);


            PrintStream ps = new PrintStream(fos);
            System.setOut(ps);


            Play play = new Play();
            play.game();


            System.setOut(console);
            System.out.println("Done writing to a file!");
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }
}
