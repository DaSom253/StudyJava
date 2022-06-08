package studyJava3;

import java.util.Random;
import java.util.Scanner;

public class FindApproximateValue implements IGameFrame {

	@Override
	public <T> T computerSelect() {
		Random random = new Random();
		
		return (T) (Integer.valueOf(random.nextInt(99)+1));
	}

	@Override
	public <T> T userSelect() {
		Scanner in = new Scanner(System.in);
		int user;
		
		while(true) {
			System.out.println("숫자를 입력하세요. (1~100) : ");
			user = in.nextInt();
			
			if(user >= 1 && user <= 100) {
				break;
			}else {
				System.out.println("숫자가 범위 내에 없습니다. 다시 입력해주세요. : ");
			}
		}
		
		//제너릭으로 형변환하기 위해서는 int를 Integer로 바꾸어준다.
		return (T) (Integer.valueOf(user));
	}

	@Override
	public boolean gameAct() {
		boolean losewin = true;
		Random random = new Random();
		
		while(true) {
			int user = userSelect();
			int computer = computerSelect();
			int value = random.nextInt(99) + 1;
			
			System.out.println("\n 제시된 수 : " + value + "\n 유저가 제시한 수 : " + user + "\n 컴퓨터가 제시한 수 : " + computer);
			System.out.println("\n 유저의 차이 : " + Math.abs(value - user) + "\n 컴퓨터의 차이 : " + Math.abs(value - computer));
			//차이는 절댓값으로 판단한다.
			
			if(Math.abs(value - user) == Math.abs(value - computer)) {
				System.out.println("비겼습니다. 다시 프로그램을 실행합니다.");
				continue;
			} else if (Math.abs(value - user) > Math.abs(value - computer)) {
				losewin = false;
				//유저가 짐
			}
			break;
		}
		//유저가 이김
		return losewin;
	}

}
