import java.util.Objects;

public class Wildcard extends  Jewel implements IGemCheck{

    public Wildcard() {
        super('W',10);
    }

    @Override
    public void checkGem(String[][] arr,Player p,int a,int b) {
        int n = arr[0].length - 1;
        int flag = 0;
        int addpoint = this.getPoints();

        for (int i = 1; i < 3; i++) {
            if (b + i <= n && a - i >= 0) {
                if (arr[a][b].equals(arr[a - i][b + i]) || Objects.equals(arr[a - i][b + i],"D")) {
                    flag++;
                    if (arr[a][b].equals(arr[a - i][b + i]))
                        addpoint += this.getPoints();
                    else
                        addpoint += 30;
                }
            }
        }
        if (flag == 2) {
            for (int i = 0; i < 3; i++) {
                arr[a - i][b + i] = " ";
            }
            p.setScore(p.getScore() + addpoint);
            return;
        } else {
            flag = 0;
            addpoint = this.getPoints();
        }

        for (int i = 1; i < 3; i++) {
            if (b + i >= 0 && a + i <= n) {
                if (Objects.equals(arr[a + i][b + i],"D")) {
                    flag++;
                    if (arr[a][b].equals(arr[a + i][b + i]))
                        addpoint += this.getPoints();
                    else
                        addpoint += 30;
                }
            }
        }
        if (flag == 2) {
            for (int i = 0; i < 3; i++) {
                arr[a + i][b + i] = " ";
            }
            p.setScore(p.getScore() + addpoint);
            return;
        } else {
            flag = 0;
            addpoint = this.getPoints();
        }
        p.setScore(p.getScore() + 0);
    }
}
