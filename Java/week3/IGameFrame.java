package studyJava3;

import java.util.Scanner;

public interface IGameFrame {
	//게임하는 두 메소드
	public <T> T computerSelect();
	public <T> T userSelect();
	// <제너릭 선언> 리턴타입
	
	//게임 승패 판정
	public boolean gameAct();
	
	//게임 승패 판정 출력
	//추상 메서드는 interface에서 구현 불가
	//default는 구현 가능
	default void loseWinOut(boolean loseWin) {
		if (loseWin)
            System.out.println("\n[유저 승리]\n");
        else
            System.out.println("\n[컴퓨터 승리]\n");
	}
	default boolean gameOut() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("다른 게임을 하시겠습니까? (y/n) : \n");
		String userA = in.next();
		
		if(userA.equals("y")) {
			return true;
		}return false;
	}
	
}
