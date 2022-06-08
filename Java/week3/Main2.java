package studyJava3;

//main문은 복붙함
public class Main2 {
    public static void main(String[] args) {
        FindApproximateValue find = new FindApproximateValue();
        System.out.println("[근사값 찿기 게임]");

        while (true) {
            find.loseWinOut(find.gameAct());
            if (find.gameOut()) {
                break;
            }
        }
        
    }
}
