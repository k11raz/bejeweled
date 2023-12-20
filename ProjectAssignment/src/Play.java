import java.util.*;
public class Play
{
    public void game() {
        ReadGrid rg = new ReadGrid();
        writeLeaderboard wl = new writeLeaderboard();

        Triangle tri = new Triangle();
        Diamond dia = new Diamond();
        Square squ = new Square();
        Wildcard wc = new Wildcard();
        Slash sl = new Slash();
        BackSlash bsl = new BackSlash();
        Minus mn = new Minus();
        VerticalSlash vsl = new VerticalSlash();
        Plus pl = new Plus();

        ReadCommand commandList = new ReadCommand();
        ArrayList<String> commands = commandList.Commands();

        ArrayList<Player> leaderboard = new ArrayList<>();

        int playerCount = 0;
        String answer = "Y";
        int commandIndex = 0;
        while (answer.equals("Y"))
        {
            String[][] gameGrid = new String[10][10];
            for (int i = 0; i < 10; i++) {
                gameGrid[i] = rg.FileReader()[i].split(" ");
            }
            System.out.print("Player's name : ");
            String name = commands.get(commandIndex);
            System.out.println(name);
            commandIndex++;

            Player p1 = new Player(name);
            while (true) {
                print(gameGrid);

                System.out.print("Select coordinate or enter E to end the game :  ");

                if (commands.get(commandIndex).equals("E")) {
                    System.out.println("E");
                    commandIndex++;
                    break;
                }

                int a = Integer.parseInt(commands.get(commandIndex));
                commandIndex++;
                int b = Integer.parseInt(commands.get(commandIndex));
                commandIndex++;

                System.out.println(a+" "+b);

                switch (gameGrid[a][b]) {
                    case "S" -> squ.checkGem(gameGrid, p1, a, b);
                    case "T" -> tri.checkGem(gameGrid, p1, a, b);
                    case "D" -> dia.checkGem(gameGrid, p1, a, b);
                    case "W" -> wc.checkGem(gameGrid, p1, a, b);
                    case "/" -> sl.checkGem(gameGrid, p1, a, b);
                    case "\\" -> bsl.checkGem(gameGrid, p1, a, b);
                    case "-" -> mn.checkGem(gameGrid, p1, a, b);
                    case "|" -> vsl.checkGem(gameGrid, p1, a, b);
                    case "+" -> pl.checkGem(gameGrid, p1, a, b);
                }
            }

            int score = p1.getScore();
            leaderboard.add(new Player(p1.getName()));
            playerCount++;
            leaderboard.get(playerCount-1).setScore(score);

            System.out.print("Play Again?? Y-N : ");
            System.out.println(commands.get(commandIndex));
            answer = commands.get(commandIndex);
            commandIndex++;
            System.out.println();

            for (int i=0; i<leaderboard.size();i++) {
                sort(leaderboard);
                System.out.println(leaderboard.get(i).getName()+ " : " + leaderboard.get(i).getScore());
                wl.writeFile(leaderboard,"leaderboard");
            }
        }
    }
    public void print(String[][] gameGrid)
    {
        swap(gameGrid);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(gameGrid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void swap(String[][] arr) {
        for (int i =0; i < 10; i++) {
            for (int j = 1; j<10; j++) {
                for (int k=0; k<10; k++){
                    if (arr[j][k].equals(" ")) {
                        String temp = arr[j][k];
                        arr[j][k] = arr[j-1][k];
                        arr[j-1][k] = temp;
                    }
                }
            }
        }
    }

    public ArrayList<Player> sort(ArrayList<Player> p) {

        for (int i = 0; i < p.size() - 1; i++) {
            for (int j = 0; j < p.size() - 1 - i; j++) {
                if (p.get(j).getScore() < p.get(j + 1).getScore()) {
                    Player temp = p.get(j);
                    p.set(j, p.get(j + 1));
                    p.set(j + 1, temp);
                }
            }
        }
        return p;
    }
}


