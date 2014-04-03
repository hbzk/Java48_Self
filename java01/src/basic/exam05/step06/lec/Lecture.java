package basic.exam05.step06.lec;

public class Lecture {
	
	String 		title;
	String 		teacher;
	java.sql.Date 		startDate;
	java.sql.Date 		endDate;
	String 		classroom;
	String 		manager;
	int hours;
	
	public static Lecture fromCSV(String value) {
		String[] data = value.split(",");
		
		Lecture obj = new Lecture();
		obj.title = data[0];
		obj.teacher = data[1];
		obj.startDate = java.sql.Date.valueOf(data[2]);
		obj.endDate = java.sql.Date.valueOf(data[3]);
		obj.classroom = data[4];
		obj.manager = data[5];
		obj.hours= Integer.parseInt(data[6]);
		
		
		return obj;
	}

	@Override
  public String toString() {
	  return title + "," + teacher + "," + startDate + "," + 
	  		endDate + "," + classroom + "," + manager + "," + hours;
  }
	
}
