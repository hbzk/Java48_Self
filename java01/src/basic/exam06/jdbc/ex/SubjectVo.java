package basic.exam06.jdbc.ex;

/* DTO(Data Transfer Object) = VO (Value Object)
 * - 데이터를 담는 그릇 역할
 * - layer 간의 데이터 교환 시 사용됨.
 * - 테이블 <-> VO
 * - 테이블A + 테이블B + ... <-> VO
 */
public class SubjectVo {
	int 			no; 											// DB 컬럼과 연결되지만, 컬렴명을 사용하지 말고, 일반 용어를 사용한다.
	String 	title; 										// -> 그래야 다른 프로젝트에서 재사용할때 제약이 줄어든다.
	String 	description;
}
