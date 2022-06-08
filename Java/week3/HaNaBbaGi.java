package studyJava3;

import java.util.Random;
import java.util.Scanner;

public class HaNaBbaGi extends RockPaperScissors{

	@Override
	public boolean gameAct() {
		boolean losewin = true; // 컴퓨터와의 승패를 결정하는 boolean
		while(true) {
			//하나빼기는 가위바위보 중 두 개를 고른다.
			String[] userStrings = new String[2];
			String[] computerStrings = new String[2];
			
			System.out.println("[가위, 바위, 보] 첫 번째 선택");
			userStrings[0] = userSelect();
			
			System.out.println("[가위, 바위, 보] 두 번째 선택");
			userStrings[1] = userSelect(); // user의 선택을 저장하고 반환(String)하는 부모 함수를 불러옴
			
			computerStrings[0] = computerSelect(); // 컴퓨터의 랜덤 선택을 저장하고 반환하는 부모 함수
			computerStrings[1] = computerSelect();
			
			//유저와 컴퓨터의 수 공개
			System.out.println("유저 : " + userStrings[0] + " " + userStrings[1] + "\n");
			System.out.println("컴퓨터 : " + computerStrings[0] + " " + computerStrings[1] + "\n");
			
			//하나빼기의 목적인 두 수 중 하나를 선택하여 승부를 봄 : selectString
			String[] selectStrings = selectString(userStrings, computerStrings);
			
			System.out.println("유저 선택 : " + selectStrings[0] + " 컴퓨터 선택 : " + selectStrings[1]);
			
			if (selectStrings[0].equals(selectStrings[1])) { // 유저와 컴퓨터의 수가 같을 때
				System.out.println("비겼습니다.");
				continue;
			}
			else { // 비기지 않았을 때
				if(selectStrings[0].equals("가위") && selectStrings[1].equals("바위")) {
					losewin = false; // 유저가 짐
				} else if (selectStrings[0].equals("바위") && selectStrings[1].equals("보")) {
					losewin = false; // 유저가 짐
				} else if (selectStrings[0].equals("보") && selectStrings[1].equals("가위")) {
					losewin = false; // 유저가 짐
				}
			}//else문 끝
			break; 
		}//while문 끝
		
		return losewin;
	}
	
	public String[] selectString(String[] userStrings, String[] computerStrings) {
		Scanner in = new Scanner(System.in); // 유저가 둘 중 무엇을 고를지 입력받기 위해 scanner 사용
		Random random = new Random(); // 컴퓨터의 선택은 랜덤
		String[] selectArray = new String[2]; //0의 자리에는 유저의 선택을, 1의 자리에는 컴퓨터의 선택을 넣음
		
		while(true) {
			System.out.println("1 또는 2를 입력 : ");
			
			try {
				int userSelect = in.nextInt();
				selectArray[0] = userStrings[userSelect-1]; //유저가 선택한 수를 selectArray[0]에 넣음
			} catch (IndexOutOfBoundsException e) { // 인덱스 값을 오버했을 때, 즉 1 이나 2가 아닌 다른 수를 입력했을 때
				System.out.println("1 또는 2가 아님, 다시 입력");
				continue;
			}
			break;
		}
		
		selectArray[1] = computerStrings[random.nextInt(1)];
		
		
		return selectArray;
	}
	
	
	

}
