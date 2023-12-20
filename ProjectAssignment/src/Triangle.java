import java.util.Objects;

public class Triangle extends Jewel implements IGemCheck{

    public Triangle() {
        super('T',15);
    }

    @Override
    public void checkGem(String[][] arr,Player p,int a,int b) {
        int n = arr[0].length-1;
        int flag=0;
        int addpoint = this.getPoints();

        for (int i=1; i<3; i++) {
            if(a+i <= n)
            {
                if (arr[a][b].equals(arr[a + i][b]) || Objects.equals(arr[a + i][b], "W")) {
                    flag++;
                    if (arr[a][b].equals(arr[a + i][b]))
                        addpoint += this.getPoints();
                    else
                        addpoint += 10;
                }
            }
        }
        if (flag == 2) {
            for (int i=0; i<3; i++) {
                arr[a + i][b] = " ";
            }
            p.setScore(p.getScore() + addpoint);
            return;
        }
        else {
            flag=0;
            addpoint = this.getPoints();
        }

        for (int i=1; i<3; i++) {
            if(a-i >= 0)
            {
                if (arr[a][b].equals(arr[a - i][b]) || Objects.equals(arr[a - i][b], "W")) {
                    flag++;
                    if (arr[a][b].equals(arr[a - i][b]))
                        addpoint += this.getPoints();
                    else
                        addpoint += 10;
                }
            }
        }
        if (flag == 2) {
            for (int i=0; i<3; i++) {
                arr[a - i][b] = " ";
            }
            p.setScore(p.getScore() + addpoint);
            return;
        }
        else {
            flag=0;
            addpoint = this.getPoints();
        }
        p.setScore(p.getScore() + 0);
    }
}
