package basic.exam04.step01;

import java.util.Scanner;

/* System.in, System.out
 * - System.out : 표준 출력 장치(기본 모니터)
 * - System.in : 표준 입력 장치(기본 키보드)
 * 
 * java.lang 패키지
 * - 프로그래밍 핵심 클래스들이 있는 패키지
 * - 패키지 이름을 적지 않아도 된다.
 * - 자동으로 찾는다.
 * - String, Integer, System, ...
 * - 나머지 모든 패키지의 클래스는 반드시 패키지 이름을 적어야 한다.
 * 
 * import
 * - 사용할 클래스가 있는 패키지 이름을 컴파일러에게 알려줌 
 * - import 패키지명.클래스명;
 *   		import로 선언된 패키지의 클래스는 패키지명 없이 클래스 이름만으로 사용 가능.
 * - import 패키지명.*;
 *   		패키지명만 선언해도 된다. 단, 자바 컴파일러가 해당 클래스를 찾는데 시간이 걸린다.
 *   		패키지명만 선언되어 있으면 나중에 사용한 클래스에 어떤 패키지에 있는지 즉시 파악할 수 없다.
 */
public class StudentMgtSystem01 {

	public static void main(String[] args) {
		// java.util.Scanner scanner = new java.util.Scanner(System.in);
		Scanner scanner = new Scanner(System.in);

		do {
			System.out.print("명령>");
			String input = scanner.nextLine(); // 키보드로부터 들어 온 값을 읽는다. 엔터를 만날 떄까지. (I/O Blocking)
			// 엔터를 만나면 엔터를 제외한, 사용자가 입력한 문자열을 힙 메모리에 String으로 저장한 후
			// 해당 메모리의 주소를 리턴한다.
			
			String[] values = input.split(" ");
			
			// (values[0].equals("add")) 인스턴스 메소드는 인스턴스를 넘겨받아야 호출할 수 있다 (Null point exception 발생 가능)
			// "add".equals 중 "add"는 문자열이 아닌 String 인스턴스로 간주
			if ("add".equals(values[0])) {
				String[] data = values[1].split(",");
				System.out.println("이름:" + data[0]);
				System.out.println("국어:" + data[1]);
				System.out.println("영어:" + data[2]);
				System.out.println("수학:" + data[3]);
				
				System.out.print("등록하시겠습니까?(y/n)");
				input = scanner.nextLine();
				if ("y".equals(input.toLowerCase())) {
					System.out.println("등록 되었습니다.");
				}	else {
					System.out.println("등록 취소 되었습니다.");
				}
			}	else if ("quit".equals(values[0])) {
				break;
			}	else {
				System.out.println("사용할 수 없는 명령어입니다.");
			}
		}	while(true);
		// 입출력은 사용 후 닫아주어야 한다.		
		scanner.close();
	}

}

