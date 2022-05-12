package studyJava2;

abstract public class ScheduleSet implements IScheduleSet {
	private int count;
	
	public ScheduleSet(int count) {
		this.count = count; //자식이 값을 설정해줌
	}
	
	@Override
	public Schedule[] makeSchedule() {
		Schedule[] sch = new Schedule[count]; //공간 정의
		for (int i = 0; i < sch.length; i++) {
			String[] getSt = getString();
//			if(getSt[2].isEmpty()) { //비어 있으면 true
//				sch[i] = new Schedule(getSt[0], getSt[1]); //공간 안의 데이터 정의
//			} else {
//				sch[i] = new Schedule(getSt[0], getSt[1], getSt[2]);
//			}
			sch[i] = (getSt[2].isEmpty()) ? sch[i] = new Schedule(getSt[0], getSt[1]) : new Schedule(getSt[0], getSt[1], getSt[2]);
		}
		return sch;
	}

	@Override
	public void sreachSchedule(Schedule[] sch, String inputDay) {
		boolean nullIt = true; //출력 true, false
		for(int i = 0; i < sch.length; i++) {
			if(inputDay.equals(sch[i].getDay())) {
				nullIt = false;
				System.out.println(sch[i].getSchedule() + " " + sch[i].getPlace() + " " + sch[i].getDay());
			}
		}
		if(nullIt) {
			System.out.println("일치하는 것이 없습니다."); //일치하지 않을 떄
		}
	}
	
	abstract public String[] getString();

}
