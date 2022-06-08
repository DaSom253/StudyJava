package studyJava3;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors implements IGameFrame {

	@Override
	public <T> T computerSelect() {
		Random random = new Random();
		int ranNum = random.nextInt(2);
		//T타입 변수에 비어있는 String을 T로 자동 형변환하여 넣어준다.
		//다른 곳에도 다른 형으로 쓰기 위함 제네릭 씀, 타입 선언은 아직 안함
		//오류 방지용으로 디폴트값 공백 설정
		//이런 식으로 제네릭 반환해주어도 되고, user 메서드와 같이 제네릭 반환해주어도 됨
		T select = (T) "";
		
		if(ranNum == 0) {
			select = (T) "바위";
		} else if (ranNum == 1) {
			select = (T) "보";
		} else {
			select = (T) "가위";
		}
		
		return select;
	}

	@Override
	public <T> T userSelect() {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		//먼저 스트링으로 선언한 후 반환 시 제너릭으로 반환해주어도 됨 (순서)
		String select = "";
		
		while(true) {
			System.out.println("가위바위보 중 하나를 입력하세요 : ");
			select = in.next();
			//스트링 비교 시 equals 사용해주세요
			if( !(select.equals("가위") || select.equals("바위") || select.equals("보"))) {
				System.out.println("다시 입력해주세요.");
				continue;
			}
			break;
		}
		
		return (T) select;
	}

	@Override
	public boolean gameAct() {
		// 유저 입장에서 이기면 true, 지면 false
		boolean userWin = true;
		boolean userLose = false;
		
		while(true) {		
			String user = userSelect();
			String computer = computerSelect();
			
			if(user.equals(computer)) {
			System.out.println("비겼습니다.");
			continue;
			}else if(user.equals("가위") && computer.equals("주먹")) {
				return userLose;
			}else if(user.equals("보") && computer.equals("가위")) {
				return userLose;
			}else if(user.equals("보") && computer.equals("가위")) {
				return userLose;
			}break;
		}
		return userWin;
	}

	@Override
	public void loseWinOut(boolean loseWin) {
		// TODO Auto-generated method stub
		if (loseWin)
            System.out.println("\n[유저 승리]\n");
        else
            System.out.println("\n[컴퓨터 승리]\n");
	}

	@Override
	public boolean gameOut() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("게임을 계속 하시겠습니까? (y/n) : \n");
		String userA = in.next();
		
		if(userA.equals("y")) {
			return true;
		}return false;
	}

}
