package studyJava2;

import java.util.Scanner;

public class ScheduleClass extends ScheduleSet{

	public ScheduleClass(int count) {
		super(count);
	}

	public String[] getString() {
		Scanner scan = new Scanner(System.in);
		String[] getSt = new String[3];
		
		System.out.println("스켸줄 입력쓰~ : ");
		getSt[0] = scan.next();
		
		System.out.println("장소 입력쓰~ : ");
		getSt[1] = scan.next();
		
		System.out.println("시간 입력쓰~ : ");
		getSt[2] = scan.next();
		
		return getSt;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		System.out.print("스케줄을 정할 수를 정하세요 : ");
		ScheduleClass sdc = new ScheduleClass(scan.nextInt());
		
		System.out.println("---스케줄 설정---");
		Schedule[] schedule = sdc.makeSchedule();
		
		while(true){
			System.out.print("스케줄을 검색할 날짜를 입력하세요(종료 : q) : ");
			String day = scan.next();
			
			if(day.equals("q")){
				break;
			}
			
			sdc.sreachSchedule(schedule, day);
		}
	}

}
