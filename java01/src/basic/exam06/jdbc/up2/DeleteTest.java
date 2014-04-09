package basic.exam06.jdbc.up2;

import java.util.Scanner;

/* SubjectDao 사용
 */
public class DeleteTest {
	public static void main(String[] args) throws Throwable {
		SubjectDao dao = new SubjectDao();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("삭제할 번호 입력: ");
		dao.delete(Integer.parseInt(sc.nextLine()));
		
		System.out.println("삭제 성공!");
		
		sc.close();
	}
}
