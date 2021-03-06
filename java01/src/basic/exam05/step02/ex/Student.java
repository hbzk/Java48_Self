package basic.exam05.step02.ex;

public class Student {
	String name, tel, email, address;
	int age;
	
	public Student(String name) {
		this.name = name;
	}
	
	public static Student fromCSV(String value) {
	  String[] data = value.split(",");
	  
	  Student obj = new Student(data[0]);
	  obj.age = Integer.parseInt(data[1]);
	  obj.tel = data[2];
	  obj.email = data[3];
	  obj.address = data[4];
	  
	  return obj;
	}

	@Override
	public String toString() {
	  return name + "," + age + "," + tel + "," + email + "," + address;
	}
	
}

