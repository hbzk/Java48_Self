-- 강사
DROP TABLE SE_TEACHS;

-- 교육생
DROP TABLE SE_STUDS;

-- 관리자
DROP TABLE SE_MGRS;

-- 사용자
DROP TABLE SE_USERS;

-- 교육과정
DROP TABLE SE_COURS;

-- 과목
DROP TABLE SE_SUBJS;

-- 커리큘럼
DROP TABLE SE_COUR_SUBJS;

-- 개설강의
DROP TABLE SE_OPEN_LECTS;

-- 개설강의과목
DROP TABLE SE_OPEN_LECT_SUBJS;

-- 수강생
DROP TABLE SE_LECT_STDS;

-- 과제
DROP TABLE SE_TESTS;

-- 과제평가
DROP TABLE SE_TEST_RESUS;

-- 교육자료
DROP TABLE SE_LECT_FILES;

-- 강사과목
DROP TABLE SE_TEACH_SUBJS;

-- 과제유형
DROP TABLE SE_TEST_TYPES;

-- 과제상태
DROP TABLE SE_TEST_RESU_TYPES;

-- 교육지원
DROP TABLE SE_SUPPS;

-- 수강상태
DROP TABLE SE_LECT_STATS;

-- 강사
CREATE TABLE SE_TEACHS (
	UNO INTEGER NOT NULL, -- 강사번호
	SAL INTEGER NULL      -- 강의료
);

-- 강사 기본키
CREATE UNIQUE INDEX PK_SE_TEACHS
	ON SE_TEACHS ( -- 강사
		UNO ASC -- 강사번호
	);

-- 강사
ALTER TABLE SE_TEACHS
	ADD
		CONSTRAINT PK_SE_TEACHS -- 강사 기본키
		PRIMARY KEY (
			UNO -- 강사번호
		);

-- 강사
COMMENT ON TABLE SE_TEACHS IS '강사';

-- 강사번호
COMMENT ON COLUMN SE_TEACHS.UNO IS '강사번호';

-- 강의료
COMMENT ON COLUMN SE_TEACHS.SAL IS '강의료';

-- 강사 기본키
COMMENT ON INDEX PK_SE_TEACHS IS '강사 기본키';

-- 강사 기본키
COMMENT ON CONSTRAINT SE_TEACHS.PK_SE_TEACHS IS '강사 기본키';

-- 교육생
CREATE TABLE SE_STUDS (
	UNO      INTEGER      NOT NULL, -- 교육생번호
	COMP     VARCHAR(50)  NULL,     -- 회사
	POS      VARCHAR(50)  NULL,     -- 직위
	STAT     INTEGER      NULL,     -- 재직여부
	LAST_SCH VARCHAR(255) NULL,     -- 최종학력
	ACCT     VARCHAR(20)  NULL      -- 통장번호
);

-- 교육생 기본키
CREATE UNIQUE INDEX PK_SE_STUDS
	ON SE_STUDS ( -- 교육생
		UNO ASC -- 교육생번호
	);

-- 교육생
ALTER TABLE SE_STUDS
	ADD
		CONSTRAINT PK_SE_STUDS -- 교육생 기본키
		PRIMARY KEY (
			UNO -- 교육생번호
		);

-- 교육생
COMMENT ON TABLE SE_STUDS IS '교육생';

-- 교육생번호
COMMENT ON COLUMN SE_STUDS.UNO IS '교육생번호';

-- 회사
COMMENT ON COLUMN SE_STUDS.COMP IS '회사';

-- 직위
COMMENT ON COLUMN SE_STUDS.POS IS '직위';

-- 재직여부
COMMENT ON COLUMN SE_STUDS.STAT IS '재직여부';

-- 최종학력
COMMENT ON COLUMN SE_STUDS.LAST_SCH IS '최종학력';

-- 통장번호
COMMENT ON COLUMN SE_STUDS.ACCT IS '통장번호';

-- 교육생 기본키
COMMENT ON INDEX PK_SE_STUDS IS '교육생 기본키';

-- 교육생 기본키
COMMENT ON CONSTRAINT SE_STUDS.PK_SE_STUDS IS '교육생 기본키';

-- 관리자
CREATE TABLE SE_MGRS (
	UNO INTEGER     NOT NULL, -- 관리자번호
	POS VARCHAR(50) NULL      -- 직위
);

-- 관리자 기본키
CREATE UNIQUE INDEX PK_SE_MGRS
	ON SE_MGRS ( -- 관리자
		UNO ASC -- 관리자번호
	);

-- 관리자
ALTER TABLE SE_MGRS
	ADD
		CONSTRAINT PK_SE_MGRS -- 관리자 기본키
		PRIMARY KEY (
			UNO -- 관리자번호
		);

-- 관리자
COMMENT ON TABLE SE_MGRS IS '관리자';

-- 관리자번호
COMMENT ON COLUMN SE_MGRS.UNO IS '관리자번호';

-- 직위
COMMENT ON COLUMN SE_MGRS.POS IS '직위';

-- 관리자 기본키
COMMENT ON INDEX PK_SE_MGRS IS '관리자 기본키';

-- 관리자 기본키
COMMENT ON CONSTRAINT SE_MGRS.PK_SE_MGRS IS '관리자 기본키';

-- 사용자
CREATE TABLE SE_USERS (
	UNO       INTEGER      NOT NULL, -- 사용자번호
	EMAIL     VARCHAR(40)  NOT NULL, -- 이메일
	PWD       VARCHAR(20)  NOT NULL, -- 암호
	NAME      VARCHAR(50)  NOT NULL, -- 이름
	TEL       VARCHAR(30)  NOT NULL, -- 전화
	FAX       VARCHAR(30)  NULL,     -- 팩스
	POSTNO    VARCHAR(10)  NULL,     -- 우편번호
	ADDR      VARCHAR(255) NULL,     -- 주소
	PHOT_PATH VARCHAR(255) NULL      -- 사진경로
);

-- 사용자 기본키
CREATE UNIQUE INDEX PK_SE_USERS
	ON SE_USERS ( -- 사용자
		UNO ASC -- 사용자번호
	);

-- 사용자 유니크 인덱스
CREATE UNIQUE INDEX UIX_SE_USERS
	ON SE_USERS ( -- 사용자
		EMAIL ASC -- 이메일
	);

-- 사용자
ALTER TABLE SE_USERS
	ADD
		CONSTRAINT PK_SE_USERS -- 사용자 기본키
		PRIMARY KEY (
			UNO -- 사용자번호
		);

-- 사용자
ALTER TABLE SE_USERS
	ADD
		CONSTRAINT UK_SE_USERS -- 사용자 유니크 제약
		UNIQUE (
			EMAIL -- 이메일
		);

-- 사용자
COMMENT ON TABLE SE_USERS IS '사용자';

-- 사용자번호
COMMENT ON COLUMN SE_USERS.UNO IS '사용자번호';

-- 이메일
COMMENT ON COLUMN SE_USERS.EMAIL IS '이메일';

-- 암호
COMMENT ON COLUMN SE_USERS.PWD IS '암호';

-- 이름
COMMENT ON COLUMN SE_USERS.NAME IS '이름';

-- 전화
COMMENT ON COLUMN SE_USERS.TEL IS '전화';

-- 팩스
COMMENT ON COLUMN SE_USERS.FAX IS '팩스';

-- 우편번호
COMMENT ON COLUMN SE_USERS.POSTNO IS '우편번호';

-- 주소
COMMENT ON COLUMN SE_USERS.ADDR IS '주소';

-- 사진경로
COMMENT ON COLUMN SE_USERS.PHOT_PATH IS '사진경로';

-- 사용자 기본키
COMMENT ON INDEX PK_SE_USERS IS '사용자 기본키';

-- 사용자 유니크 인덱스
COMMENT ON INDEX UIX_SE_USERS IS '사용자 유니크 인덱스';

-- 사용자 기본키
COMMENT ON CONSTRAINT SE_USERS.PK_SE_USERS IS '사용자 기본키';

-- 사용자 유니크 제약
COMMENT ON CONSTRAINT SE_USERS.UK_SE_USERS IS '사용자 유니크 제약';

-- 교육과정
CREATE TABLE SE_COURS (
	CNO   INTEGER      NOT NULL, -- 교육과정번호
	TITLE VARCHAR(255) NOT NULL, -- 과정명
	DEST  TEXT         NOT NULL, -- 설명
	HOURS INTEGER      NOT NULL  -- 교육시간
);

-- 교육과정 기본키
CREATE UNIQUE INDEX PK_SE_COURS
	ON SE_COURS ( -- 교육과정
		CNO ASC -- 교육과정번호
	);

-- 교육과정 유니크 인덱스
CREATE UNIQUE INDEX UIX_SE_COURS
	ON SE_COURS ( -- 교육과정
		TITLE ASC -- 과정명
	);

-- 교육과정
ALTER TABLE SE_COURS
	ADD
		CONSTRAINT PK_SE_COURS -- 교육과정 기본키
		PRIMARY KEY (
			CNO -- 교육과정번호
		);

-- 교육과정
ALTER TABLE SE_COURS
	ADD
		CONSTRAINT UK_SE_COURS -- 교육과정 유니크 제약
		UNIQUE (
			TITLE -- 과정명
		);

-- 교육과정
COMMENT ON TABLE SE_COURS IS '교육과정';

-- 교육과정번호
COMMENT ON COLUMN SE_COURS.CNO IS '교육과정번호';

-- 과정명
COMMENT ON COLUMN SE_COURS.TITLE IS '과정명';

-- 설명
COMMENT ON COLUMN SE_COURS.DEST IS '설명';

-- 교육시간
COMMENT ON COLUMN SE_COURS.HOURS IS '교육시간';

-- 교육과정 기본키
COMMENT ON INDEX PK_SE_COURS IS '교육과정 기본키';

-- 교육과정 유니크 인덱스
COMMENT ON INDEX UIX_SE_COURS IS '교육과정 유니크 인덱스';

-- 교육과정 기본키
COMMENT ON CONSTRAINT SE_COURS.PK_SE_COURS IS '교육과정 기본키';

-- 교육과정 유니크 제약
COMMENT ON CONSTRAINT SE_COURS.UK_SE_COURS IS '교육과정 유니크 제약';

-- 과목
CREATE TABLE SE_SUBJS (
	SNO   INTEGER      NOT NULL, -- 과목번호
	TITLE VARCHAR(255) NOT NULL, -- 과목명
	DEST  TEXT         NOT NULL  -- 설명
);

-- 과목 기본키
CREATE UNIQUE INDEX PK_SE_SUBJS
	ON SE_SUBJS ( -- 과목
		SNO ASC -- 과목번호
	);

-- 과목 유니크 인덱스
CREATE UNIQUE INDEX UIX_SE_SUBJS
	ON SE_SUBJS ( -- 과목
		TITLE ASC -- 과목명
	);

-- 과목
ALTER TABLE SE_SUBJS
	ADD
		CONSTRAINT PK_SE_SUBJS -- 과목 기본키
		PRIMARY KEY (
			SNO -- 과목번호
		);

-- 과목
ALTER TABLE SE_SUBJS
	ADD
		CONSTRAINT UK_SE_SUBJS -- 과목 유니크 제약
		UNIQUE (
			TITLE -- 과목명
		);

-- 과목
COMMENT ON TABLE SE_SUBJS IS '과목';

-- 과목번호
COMMENT ON COLUMN SE_SUBJS.SNO IS '과목번호';

-- 과목명
COMMENT ON COLUMN SE_SUBJS.TITLE IS '과목명';

-- 설명
COMMENT ON COLUMN SE_SUBJS.DEST IS '설명';

-- 과목 기본키
COMMENT ON INDEX PK_SE_SUBJS IS '과목 기본키';

-- 과목 유니크 인덱스
COMMENT ON INDEX UIX_SE_SUBJS IS '과목 유니크 인덱스';

-- 과목 기본키
COMMENT ON CONSTRAINT SE_SUBJS.PK_SE_SUBJS IS '과목 기본키';

-- 과목 유니크 제약
COMMENT ON CONSTRAINT SE_SUBJS.UK_SE_SUBJS IS '과목 유니크 제약';

-- 커리큘럼
CREATE TABLE SE_COUR_SUBJS (
	CNO   INTEGER NOT NULL, -- 교육과정번호
	SNO   INTEGER NOT NULL, -- 과목번호
	SEQ   INTEGER NULL,     -- 순서
	HOURS INTEGER NULL      -- 교육시간
);

-- 커리큘럼 기본키
CREATE UNIQUE INDEX PK_SE_COUR_SUBJS
	ON SE_COUR_SUBJS ( -- 커리큘럼
		CNO ASC, -- 교육과정번호
		SNO ASC  -- 과목번호
	);

-- 커리큘럼
ALTER TABLE SE_COUR_SUBJS
	ADD
		CONSTRAINT PK_SE_COUR_SUBJS -- 커리큘럼 기본키
		PRIMARY KEY (
			CNO, -- 교육과정번호
			SNO  -- 과목번호
		);

-- 커리큘럼
COMMENT ON TABLE SE_COUR_SUBJS IS '커리큘럼';

-- 교육과정번호
COMMENT ON COLUMN SE_COUR_SUBJS.CNO IS '교육과정번호';

-- 과목번호
COMMENT ON COLUMN SE_COUR_SUBJS.SNO IS '과목번호';

-- 순서
COMMENT ON COLUMN SE_COUR_SUBJS.SEQ IS '순서';

-- 교육시간
COMMENT ON COLUMN SE_COUR_SUBJS.HOURS IS '교육시간';

-- 커리큘럼 기본키
COMMENT ON INDEX PK_SE_COUR_SUBJS IS '커리큘럼 기본키';

-- 커리큘럼 기본키
COMMENT ON CONSTRAINT SE_COUR_SUBJS.PK_SE_COUR_SUBJS IS '커리큘럼 기본키';

-- 개설강의
CREATE TABLE SE_OPEN_LECTS (
	OLNO  INTEGER      NOT NULL, -- 강의번호
	CNO   INTEGER      NOT NULL, -- 교육과정번호
	TITLE VARCHAR(255) NOT NULL, -- 개설강의명
	ST_DT DATETIME     NOT NULL, -- 강의시작일
	ED_DT DATETIME     NOT NULL, -- 강의종료일
	SIZES INTEGER      NOT NULL, -- 모집인원
	UNO   INTEGER      NULL      -- 관리자번호
);

-- 개설강의 기본키
CREATE UNIQUE INDEX PK_SE_OPEN_LECTS
	ON SE_OPEN_LECTS ( -- 개설강의
		OLNO ASC -- 강의번호
	);

-- 개설강의
ALTER TABLE SE_OPEN_LECTS
	ADD
		CONSTRAINT PK_SE_OPEN_LECTS -- 개설강의 기본키
		PRIMARY KEY (
			OLNO -- 강의번호
		);

-- 개설강의
COMMENT ON TABLE SE_OPEN_LECTS IS '개설강의';

-- 강의번호
COMMENT ON COLUMN SE_OPEN_LECTS.OLNO IS '강의번호';

-- 교육과정번호
COMMENT ON COLUMN SE_OPEN_LECTS.CNO IS '교육과정번호';

-- 개설강의명
COMMENT ON COLUMN SE_OPEN_LECTS.TITLE IS '개설강의명';

-- 강의시작일
COMMENT ON COLUMN SE_OPEN_LECTS.ST_DT IS '강의시작일';

-- 강의종료일
COMMENT ON COLUMN SE_OPEN_LECTS.ED_DT IS '강의종료일';

-- 모집인원
COMMENT ON COLUMN SE_OPEN_LECTS.SIZES IS '모집인원';

-- 관리자번호
COMMENT ON COLUMN SE_OPEN_LECTS.UNO IS '관리자번호';

-- 개설강의 기본키
COMMENT ON INDEX PK_SE_OPEN_LECTS IS '개설강의 기본키';

-- 개설강의 기본키
COMMENT ON CONSTRAINT SE_OPEN_LECTS.PK_SE_OPEN_LECTS IS '개설강의 기본키';

-- 개설강의과목
CREATE TABLE SE_OPEN_LECT_SUBJS (
	LSNO  INTEGER  NOT NULL, -- 과목강사번호
	OLNO  INTEGER  NOT NULL, -- 강의번호
	CNO   INTEGER  NOT NULL, -- 교육과정번호
	SNO   INTEGER  NOT NULL, -- 과목번호
	UNO   INTEGER  NOT NULL, -- 강사번호
	ST_DT DATETIME NULL,     -- 강의시작일
	ED_DT DATETIME NULL,     -- 강의종료일
	HOURS INTEGER  NULL      -- 강의시간
);

-- 개설강의과목 기본키
CREATE UNIQUE INDEX PK_SE_OPEN_LECT_SUBJS2
	ON SE_OPEN_LECT_SUBJS ( -- 개설강의과목
		LSNO ASC -- 과목강사번호
	);

-- 개설강의과목
ALTER TABLE SE_OPEN_LECT_SUBJS
	ADD
		CONSTRAINT PK_SE_OPEN_LECT_SUBJS2 -- 개설강의과목 기본키
		PRIMARY KEY (
			LSNO -- 과목강사번호
		);

-- 개설강의과목
COMMENT ON TABLE SE_OPEN_LECT_SUBJS IS '개설강의과목';

-- 과목강사번호
COMMENT ON COLUMN SE_OPEN_LECT_SUBJS.LSNO IS '과목강사번호';

-- 강의번호
COMMENT ON COLUMN SE_OPEN_LECT_SUBJS.OLNO IS '강의번호';

-- 교육과정번호
COMMENT ON COLUMN SE_OPEN_LECT_SUBJS.CNO IS '교육과정번호';

-- 과목번호
COMMENT ON COLUMN SE_OPEN_LECT_SUBJS.SNO IS '과목번호';

-- 강사번호
COMMENT ON COLUMN SE_OPEN_LECT_SUBJS.UNO IS '강사번호';

-- 강의시작일
COMMENT ON COLUMN SE_OPEN_LECT_SUBJS.ST_DT IS '강의시작일';

-- 강의종료일
COMMENT ON COLUMN SE_OPEN_LECT_SUBJS.ED_DT IS '강의종료일';

-- 강의시간
COMMENT ON COLUMN SE_OPEN_LECT_SUBJS.HOURS IS '강의시간';

-- 개설강의과목 기본키
COMMENT ON INDEX PK_SE_OPEN_LECT_SUBJS2 IS '개설강의과목 기본키';

-- 개설강의과목 기본키
COMMENT ON CONSTRAINT SE_OPEN_LECT_SUBJS.PK_SE_OPEN_LECT_SUBJS2 IS '개설강의과목 기본키';

-- 수강생
CREATE TABLE SE_LECT_STDS (
	LSNO  INTEGER NOT NULL, -- 수강생번호
	UNO   INTEGER NOT NULL, -- 교육생번호
	OLNO  INTEGER NOT NULL, -- 강의번호
	SUNO  INTEGER NOT NULL, -- 교육지원번호
	LSTNO INTEGER NULL      -- 수강상태번호
);

-- 수강생 기본키
CREATE UNIQUE INDEX PK_SE_LECT_STDS
	ON SE_LECT_STDS ( -- 수강생
		LSNO ASC -- 수강생번호
	);

-- 수강생 유니크 인덱스
CREATE UNIQUE INDEX UIX_SE_LECT_STDS
	ON SE_LECT_STDS ( -- 수강생
		UNO  ASC, -- 교육생번호
		OLNO ASC  -- 강의번호
	);

-- 수강생
ALTER TABLE SE_LECT_STDS
	ADD
		CONSTRAINT PK_SE_LECT_STDS -- 수강생 기본키
		PRIMARY KEY (
			LSNO -- 수강생번호
		);

-- 수강생
ALTER TABLE SE_LECT_STDS
	ADD
		CONSTRAINT UK_SE_LECT_STDS -- 수강생 유니크 제약
		UNIQUE (
			UNO,  -- 교육생번호
			OLNO  -- 강의번호
		);

-- 수강생
COMMENT ON TABLE SE_LECT_STDS IS '수강생';

-- 수강생번호
COMMENT ON COLUMN SE_LECT_STDS.LSNO IS '수강생번호';

-- 교육생번호
COMMENT ON COLUMN SE_LECT_STDS.UNO IS '교육생번호';

-- 강의번호
COMMENT ON COLUMN SE_LECT_STDS.OLNO IS '강의번호';

-- 교육지원번호
COMMENT ON COLUMN SE_LECT_STDS.SUNO IS '교육지원번호';

-- 수강상태번호
COMMENT ON COLUMN SE_LECT_STDS.LSTNO IS '수강상태번호';

-- 수강생 기본키
COMMENT ON INDEX PK_SE_LECT_STDS IS '수강생 기본키';

-- 수강생 유니크 인덱스
COMMENT ON INDEX UIX_SE_LECT_STDS IS '수강생 유니크 인덱스';

-- 수강생 기본키
COMMENT ON CONSTRAINT SE_LECT_STDS.PK_SE_LECT_STDS IS '수강생 기본키';

-- 수강생 유니크 제약
COMMENT ON CONSTRAINT SE_LECT_STDS.UK_SE_LECT_STDS IS '수강생 유니크 제약';

-- 과제
CREATE TABLE SE_TESTS (
	TNO       INTEGER      NOT NULL, -- 과제번호
	OLNO      INTEGER      NOT NULL, -- 강의번호
	TTNO      INTEGER      NOT NULL, -- 과제유형번호
	TITLE     VARCHAR(255) NOT NULL, -- 과제명
	DEST      TEXT         NOT NULL, -- 내용
	FILE_PATH VARCHAR(255) NULL,     -- 파일경로
	CR_DT     DATETIME     NOT NULL, -- 출제일
	ED_DT     DATETIME     NOT NULL  -- 제출마감일
);

-- 과제 기본키
CREATE UNIQUE INDEX PK_SE_TESTS
	ON SE_TESTS ( -- 과제
		TNO ASC -- 과제번호
	);

-- 과제
ALTER TABLE SE_TESTS
	ADD
		CONSTRAINT PK_SE_TESTS -- 과제 기본키
		PRIMARY KEY (
			TNO -- 과제번호
		);

-- 과제
COMMENT ON TABLE SE_TESTS IS '과제';

-- 과제번호
COMMENT ON COLUMN SE_TESTS.TNO IS '과제번호';

-- 강의번호
COMMENT ON COLUMN SE_TESTS.OLNO IS '강의번호';

-- 과제유형번호
COMMENT ON COLUMN SE_TESTS.TTNO IS '과제유형번호';

-- 과제명
COMMENT ON COLUMN SE_TESTS.TITLE IS '과제명';

-- 내용
COMMENT ON COLUMN SE_TESTS.DEST IS '내용';

-- 파일경로
COMMENT ON COLUMN SE_TESTS.FILE_PATH IS '파일경로';

-- 출제일
COMMENT ON COLUMN SE_TESTS.CR_DT IS '출제일';

-- 제출마감일
COMMENT ON COLUMN SE_TESTS.ED_DT IS '제출마감일';

-- 과제 기본키
COMMENT ON INDEX PK_SE_TESTS IS '과제 기본키';

-- 과제 기본키
COMMENT ON CONSTRAINT SE_TESTS.PK_SE_TESTS IS '과제 기본키';

-- 과제평가
CREATE TABLE SE_TEST_RESUS (
	TNO       INTEGER      NOT NULL, -- 과제번호
	LSNO      INTEGER      NOT NULL, -- 수강생번호
	TRSNO     INTEGER      NOT NULL, -- 과제상태번호
	CR_DT     DATETIME     NOT NULL, -- 제출일
	FILE_PATH VARCHAR(255) NULL,     -- 파일경로
	GRAD      INTEGER      NOT NULL  -- 평가점수
);

-- 과제평가 기본키
CREATE UNIQUE INDEX PK_SE_TEST_RESUS
	ON SE_TEST_RESUS ( -- 과제평가
		TNO  ASC, -- 과제번호
		LSNO ASC  -- 수강생번호
	);

-- 과제평가
ALTER TABLE SE_TEST_RESUS
	ADD
		CONSTRAINT PK_SE_TEST_RESUS -- 과제평가 기본키
		PRIMARY KEY (
			TNO,  -- 과제번호
			LSNO  -- 수강생번호
		);

-- 과제평가
COMMENT ON TABLE SE_TEST_RESUS IS '과제평가';

-- 과제번호
COMMENT ON COLUMN SE_TEST_RESUS.TNO IS '과제번호';

-- 수강생번호
COMMENT ON COLUMN SE_TEST_RESUS.LSNO IS '수강생번호';

-- 과제상태번호
COMMENT ON COLUMN SE_TEST_RESUS.TRSNO IS '과제상태번호';

-- 제출일
COMMENT ON COLUMN SE_TEST_RESUS.CR_DT IS '제출일';

-- 파일경로
COMMENT ON COLUMN SE_TEST_RESUS.FILE_PATH IS '파일경로';

-- 평가점수
COMMENT ON COLUMN SE_TEST_RESUS.GRAD IS '평가점수';

-- 과제평가 기본키
COMMENT ON INDEX PK_SE_TEST_RESUS IS '과제평가 기본키';

-- 과제평가 기본키
COMMENT ON CONSTRAINT SE_TEST_RESUS.PK_SE_TEST_RESUS IS '과제평가 기본키';

-- 교육자료
CREATE TABLE SE_LECT_FILES (
	LFNO      INTEGER      NOT NULL, -- 교육자료번호
	OLNO      INTEGER      NOT NULL, -- 강의번호
	UNO       INTEGER      NOT NULL, -- 사용자번호
	FILE_PATH VARCHAR(255) NOT NULL, -- 파일경로
	MSG       TEXT         NOT NULL  -- 내용
);

-- 교육자료 기본키
CREATE UNIQUE INDEX PK_SE_LECT_FILES
	ON SE_LECT_FILES ( -- 교육자료
		LFNO ASC -- 교육자료번호
	);

-- 교육자료
ALTER TABLE SE_LECT_FILES
	ADD
		CONSTRAINT PK_SE_LECT_FILES -- 교육자료 기본키
		PRIMARY KEY (
			LFNO -- 교육자료번호
		);

-- 교육자료
COMMENT ON TABLE SE_LECT_FILES IS '교육자료';

-- 교육자료번호
COMMENT ON COLUMN SE_LECT_FILES.LFNO IS '교육자료번호';

-- 강의번호
COMMENT ON COLUMN SE_LECT_FILES.OLNO IS '강의번호';

-- 사용자번호
COMMENT ON COLUMN SE_LECT_FILES.UNO IS '사용자번호';

-- 파일경로
COMMENT ON COLUMN SE_LECT_FILES.FILE_PATH IS '파일경로';

-- 내용
COMMENT ON COLUMN SE_LECT_FILES.MSG IS '내용';

-- 교육자료 기본키
COMMENT ON INDEX PK_SE_LECT_FILES IS '교육자료 기본키';

-- 교육자료 기본키
COMMENT ON CONSTRAINT SE_LECT_FILES.PK_SE_LECT_FILES IS '교육자료 기본키';

-- 강사과목
CREATE TABLE SE_TEACH_SUBJS (
	UNO  INTEGER NOT NULL, -- 강사번호
	SNO  INTEGER NOT NULL, -- 과목번호
	LEVL INTEGER NULL      -- 수준
);

-- 강사과목 기본키
CREATE UNIQUE INDEX PK_SE_TEACH_SUBJS
	ON SE_TEACH_SUBJS ( -- 강사과목
		UNO ASC, -- 강사번호
		SNO ASC  -- 과목번호
	);

-- 강사과목
ALTER TABLE SE_TEACH_SUBJS
	ADD
		CONSTRAINT PK_SE_TEACH_SUBJS -- 강사과목 기본키
		PRIMARY KEY (
			UNO, -- 강사번호
			SNO  -- 과목번호
		);

-- 강사과목
COMMENT ON TABLE SE_TEACH_SUBJS IS '강사과목';

-- 강사번호
COMMENT ON COLUMN SE_TEACH_SUBJS.UNO IS '강사번호';

-- 과목번호
COMMENT ON COLUMN SE_TEACH_SUBJS.SNO IS '과목번호';

-- 수준
COMMENT ON COLUMN SE_TEACH_SUBJS.LEVL IS '수준';

-- 강사과목 기본키
COMMENT ON INDEX PK_SE_TEACH_SUBJS IS '강사과목 기본키';

-- 강사과목 기본키
COMMENT ON CONSTRAINT SE_TEACH_SUBJS.PK_SE_TEACH_SUBJS IS '강사과목 기본키';

-- 과제유형
CREATE TABLE SE_TEST_TYPES (
	TTNO  INTEGER     NOT NULL, -- 과제유형번호
	TITLE VARCHAR(50) NOT NULL  -- 과제유형명
);

-- 과제유형 기본키
CREATE UNIQUE INDEX PK_SE_TEST_TYPES
	ON SE_TEST_TYPES ( -- 과제유형
		TTNO ASC -- 과제유형번호
	);

-- 과제유형 유니크 인덱스
CREATE UNIQUE INDEX UIX_SE_TEST_TYPES
	ON SE_TEST_TYPES ( -- 과제유형
		TITLE ASC -- 과제유형명
	);

-- 과제유형
ALTER TABLE SE_TEST_TYPES
	ADD
		CONSTRAINT PK_SE_TEST_TYPES -- 과제유형 기본키
		PRIMARY KEY (
			TTNO -- 과제유형번호
		);

-- 과제유형
ALTER TABLE SE_TEST_TYPES
	ADD
		CONSTRAINT UK_SE_TEST_TYPES -- 과제유형 유니크 제약
		UNIQUE (
			TITLE -- 과제유형명
		);

-- 과제유형
COMMENT ON TABLE SE_TEST_TYPES IS '과제유형';

-- 과제유형번호
COMMENT ON COLUMN SE_TEST_TYPES.TTNO IS '과제유형번호';

-- 과제유형명
COMMENT ON COLUMN SE_TEST_TYPES.TITLE IS '과제유형명';

-- 과제유형 기본키
COMMENT ON INDEX PK_SE_TEST_TYPES IS '과제유형 기본키';

-- 과제유형 유니크 인덱스
COMMENT ON INDEX UIX_SE_TEST_TYPES IS '과제유형 유니크 인덱스';

-- 과제유형 기본키
COMMENT ON CONSTRAINT SE_TEST_TYPES.PK_SE_TEST_TYPES IS '과제유형 기본키';

-- 과제유형 유니크 제약
COMMENT ON CONSTRAINT SE_TEST_TYPES.UK_SE_TEST_TYPES IS '과제유형 유니크 제약';

-- 과제상태
CREATE TABLE SE_TEST_RESU_TYPES (
	TRSNO INTEGER     NOT NULL, -- 과제상태번호
	TITLE VARCHAR(50) NOT NULL  -- 과제상태명
);

-- 과제상태 기본키
CREATE UNIQUE INDEX PK_SE_TEST_RESU_TYPES
	ON SE_TEST_RESU_TYPES ( -- 과제상태
		TRSNO ASC -- 과제상태번호
	);

-- 과제상태 유니크 인덱스
CREATE UNIQUE INDEX UIX_SE_TEST_RESU_TYPES
	ON SE_TEST_RESU_TYPES ( -- 과제상태
		TITLE ASC -- 과제상태명
	);

-- 과제상태
ALTER TABLE SE_TEST_RESU_TYPES
	ADD
		CONSTRAINT PK_SE_TEST_RESU_TYPES -- 과제상태 기본키
		PRIMARY KEY (
			TRSNO -- 과제상태번호
		);

-- 과제상태
ALTER TABLE SE_TEST_RESU_TYPES
	ADD
		CONSTRAINT UK_SE_TEST_RESU_TYPES -- 과제상태 유니크 제약
		UNIQUE (
			TITLE -- 과제상태명
		);

-- 과제상태
COMMENT ON TABLE SE_TEST_RESU_TYPES IS '과제상태';

-- 과제상태번호
COMMENT ON COLUMN SE_TEST_RESU_TYPES.TRSNO IS '과제상태번호';

-- 과제상태명
COMMENT ON COLUMN SE_TEST_RESU_TYPES.TITLE IS '과제상태명';

-- 과제상태 기본키
COMMENT ON INDEX PK_SE_TEST_RESU_TYPES IS '과제상태 기본키';

-- 과제상태 유니크 인덱스
COMMENT ON INDEX UIX_SE_TEST_RESU_TYPES IS '과제상태 유니크 인덱스';

-- 과제상태 기본키
COMMENT ON CONSTRAINT SE_TEST_RESU_TYPES.PK_SE_TEST_RESU_TYPES IS '과제상태 기본키';

-- 과제상태 유니크 제약
COMMENT ON CONSTRAINT SE_TEST_RESU_TYPES.UK_SE_TEST_RESU_TYPES IS '과제상태 유니크 제약';

-- 교육지원
CREATE TABLE SE_SUPPS (
	SUNO  INTEGER     NOT NULL, -- 교육지원번호
	TITLE VARCHAR(50) NOT NULL  -- 교육지원명
);

-- 교육지원 기본키
CREATE UNIQUE INDEX PK_SE_SUPPS
	ON SE_SUPPS ( -- 교육지원
		SUNO ASC -- 교육지원번호
	);

-- 교육지원 유니크 인덱스
CREATE UNIQUE INDEX UIX_SE_SUPPS
	ON SE_SUPPS ( -- 교육지원
		TITLE ASC -- 교육지원명
	);

-- 교육지원
ALTER TABLE SE_SUPPS
	ADD
		CONSTRAINT PK_SE_SUPPS -- 교육지원 기본키
		PRIMARY KEY (
			SUNO -- 교육지원번호
		);

-- 교육지원
ALTER TABLE SE_SUPPS
	ADD
		CONSTRAINT UK_SE_SUPPS -- 교육지원 유니크 제약
		UNIQUE (
			TITLE -- 교육지원명
		);

-- 교육지원
COMMENT ON TABLE SE_SUPPS IS '교육지원';

-- 교육지원번호
COMMENT ON COLUMN SE_SUPPS.SUNO IS '교육지원번호';

-- 교육지원명
COMMENT ON COLUMN SE_SUPPS.TITLE IS '교육지원명';

-- 교육지원 기본키
COMMENT ON INDEX PK_SE_SUPPS IS '교육지원 기본키';

-- 교육지원 유니크 인덱스
COMMENT ON INDEX UIX_SE_SUPPS IS '교육지원 유니크 인덱스';

-- 교육지원 기본키
COMMENT ON CONSTRAINT SE_SUPPS.PK_SE_SUPPS IS '교육지원 기본키';

-- 교육지원 유니크 제약
COMMENT ON CONSTRAINT SE_SUPPS.UK_SE_SUPPS IS '교육지원 유니크 제약';

-- 수강상태
CREATE TABLE SE_LECT_STATS (
	LSTNO INTEGER     NOT NULL, -- 수강상태번호
	TITLE VARCHAR(50) NOT NULL  -- 수강상태명
);

-- 수강상태 기본키
CREATE UNIQUE INDEX PK_SE_LECT_STATS
	ON SE_LECT_STATS ( -- 수강상태
		LSTNO ASC -- 수강상태번호
	);

-- 수강상태 유니크 인덱스
CREATE UNIQUE INDEX UIX_SE_LECT_STATS
	ON SE_LECT_STATS ( -- 수강상태
		TITLE ASC -- 수강상태명
	);

-- 수강상태
ALTER TABLE SE_LECT_STATS
	ADD
		CONSTRAINT PK_SE_LECT_STATS -- 수강상태 기본키
		PRIMARY KEY (
			LSTNO -- 수강상태번호
		);

-- 수강상태
ALTER TABLE SE_LECT_STATS
	ADD
		CONSTRAINT UK_SE_LECT_STATS -- 수강상태 유니크 제약
		UNIQUE (
			TITLE -- 수강상태명
		);

-- 수강상태
COMMENT ON TABLE SE_LECT_STATS IS '수강상태';

-- 수강상태번호
COMMENT ON COLUMN SE_LECT_STATS.LSTNO IS '수강상태번호';

-- 수강상태명
COMMENT ON COLUMN SE_LECT_STATS.TITLE IS '수강상태명';

-- 수강상태 기본키
COMMENT ON INDEX PK_SE_LECT_STATS IS '수강상태 기본키';

-- 수강상태 유니크 인덱스
COMMENT ON INDEX UIX_SE_LECT_STATS IS '수강상태 유니크 인덱스';

-- 수강상태 기본키
COMMENT ON CONSTRAINT SE_LECT_STATS.PK_SE_LECT_STATS IS '수강상태 기본키';

-- 수강상태 유니크 제약
COMMENT ON CONSTRAINT SE_LECT_STATS.UK_SE_LECT_STATS IS '수강상태 유니크 제약';

-- 강사
ALTER TABLE SE_TEACHS
	ADD
		CONSTRAINT FK_SE_USERS_TO_SE_TEACHS -- 사용자 -> 강사
		FOREIGN KEY (
			UNO -- 강사번호
		)
		REFERENCES SE_USERS ( -- 사용자
			UNO -- 사용자번호
		);

-- 사용자 -> 강사
COMMENT ON CONSTRAINT SE_TEACHS.FK_SE_USERS_TO_SE_TEACHS IS '사용자 -> 강사';

-- 교육생
ALTER TABLE SE_STUDS
	ADD
		CONSTRAINT FK_SE_USERS_TO_SE_STUDS -- 사용자 -> 교육생
		FOREIGN KEY (
			UNO -- 교육생번호
		)
		REFERENCES SE_USERS ( -- 사용자
			UNO -- 사용자번호
		);

-- 사용자 -> 교육생
COMMENT ON CONSTRAINT SE_STUDS.FK_SE_USERS_TO_SE_STUDS IS '사용자 -> 교육생';

-- 관리자
ALTER TABLE SE_MGRS
	ADD
		CONSTRAINT FK_SE_USERS_TO_SE_MGRS -- 사용자 -> 관리자
		FOREIGN KEY (
			UNO -- 관리자번호
		)
		REFERENCES SE_USERS ( -- 사용자
			UNO -- 사용자번호
		);

-- 사용자 -> 관리자
COMMENT ON CONSTRAINT SE_MGRS.FK_SE_USERS_TO_SE_MGRS IS '사용자 -> 관리자';

-- 커리큘럼
ALTER TABLE SE_COUR_SUBJS
	ADD
		CONSTRAINT FK_SE_SUBJS_TO_SE_COUR_SUBJS -- 과목 -> 커리큘럼
		FOREIGN KEY (
			SNO -- 과목번호
		)
		REFERENCES SE_SUBJS ( -- 과목
			SNO -- 과목번호
		);

-- 과목 -> 커리큘럼
COMMENT ON CONSTRAINT SE_COUR_SUBJS.FK_SE_SUBJS_TO_SE_COUR_SUBJS IS '과목 -> 커리큘럼';

-- 커리큘럼
ALTER TABLE SE_COUR_SUBJS
	ADD
		CONSTRAINT FK_SE_COURS_TO_SE_COUR_SUBJS -- 교육과정 -> 커리큘럼
		FOREIGN KEY (
			CNO -- 교육과정번호
		)
		REFERENCES SE_COURS ( -- 교육과정
			CNO -- 교육과정번호
		);

-- 교육과정 -> 커리큘럼
COMMENT ON CONSTRAINT SE_COUR_SUBJS.FK_SE_COURS_TO_SE_COUR_SUBJS IS '교육과정 -> 커리큘럼';

-- 개설강의
ALTER TABLE SE_OPEN_LECTS
	ADD
		CONSTRAINT FK_SE_COURS_TO_SE_OPEN_LECTS -- 교육과정 -> 개설강의
		FOREIGN KEY (
			CNO -- 교육과정번호
		)
		REFERENCES SE_COURS ( -- 교육과정
			CNO -- 교육과정번호
		);

-- 교육과정 -> 개설강의
COMMENT ON CONSTRAINT SE_OPEN_LECTS.FK_SE_COURS_TO_SE_OPEN_LECTS IS '교육과정 -> 개설강의';

-- 개설강의
ALTER TABLE SE_OPEN_LECTS
	ADD
		CONSTRAINT FK_SE_MGRS_TO_SE_OPEN_LECTS -- 관리자 -> 개설강의
		FOREIGN KEY (
			UNO -- 관리자번호
		)
		REFERENCES SE_MGRS ( -- 관리자
			UNO -- 관리자번호
		);

-- 관리자 -> 개설강의
COMMENT ON CONSTRAINT SE_OPEN_LECTS.FK_SE_MGRS_TO_SE_OPEN_LECTS IS '관리자 -> 개설강의';

-- 개설강의과목
ALTER TABLE SE_OPEN_LECT_SUBJS
	ADD
		CONSTRAINT FK_SE_OPEN_LECTS_TO_SE_OPEN_LECT_SUBJS -- 개설강의 -> 개설강의과목
		FOREIGN KEY (
			OLNO -- 강의번호
		)
		REFERENCES SE_OPEN_LECTS ( -- 개설강의
			OLNO -- 강의번호
		);

-- 개설강의 -> 개설강의과목
COMMENT ON CONSTRAINT SE_OPEN_LECT_SUBJS.FK_SE_OPEN_LECTS_TO_SE_OPEN_LECT_SUBJS IS '개설강의 -> 개설강의과목';

-- 개설강의과목
ALTER TABLE SE_OPEN_LECT_SUBJS
	ADD
		CONSTRAINT FK_SE_TEACHS_TO_SE_OPEN_LECT_SUBJS -- 강사 -> 개설강의과목
		FOREIGN KEY (
			UNO -- 강사번호
		)
		REFERENCES SE_TEACHS ( -- 강사
			UNO -- 강사번호
		);

-- 강사 -> 개설강의과목
COMMENT ON CONSTRAINT SE_OPEN_LECT_SUBJS.FK_SE_TEACHS_TO_SE_OPEN_LECT_SUBJS IS '강사 -> 개설강의과목';

-- 개설강의과목
ALTER TABLE SE_OPEN_LECT_SUBJS
	ADD
		CONSTRAINT FK_SE_COUR_SUBJS_TO_SE_OPEN_LECT_SUBJS -- 커리큘럼 -> 개설강의과목
		FOREIGN KEY (
			CNO, -- 교육과정번호
			SNO  -- 과목번호
		)
		REFERENCES SE_COUR_SUBJS ( -- 커리큘럼
			CNO, -- 교육과정번호
			SNO  -- 과목번호
		);

-- 커리큘럼 -> 개설강의과목
COMMENT ON CONSTRAINT SE_OPEN_LECT_SUBJS.FK_SE_COUR_SUBJS_TO_SE_OPEN_LECT_SUBJS IS '커리큘럼 -> 개설강의과목';

-- 수강생
ALTER TABLE SE_LECT_STDS
	ADD
		CONSTRAINT FK_SE_STUDS_TO_SE_LECT_STDS -- 교육생 -> 수강생
		FOREIGN KEY (
			UNO -- 교육생번호
		)
		REFERENCES SE_STUDS ( -- 교육생
			UNO -- 교육생번호
		);

-- 교육생 -> 수강생
COMMENT ON CONSTRAINT SE_LECT_STDS.FK_SE_STUDS_TO_SE_LECT_STDS IS '교육생 -> 수강생';

-- 수강생
ALTER TABLE SE_LECT_STDS
	ADD
		CONSTRAINT FK_SE_OPEN_LECTS_TO_SE_LECT_STDS -- 개설강의 -> 수강생
		FOREIGN KEY (
			OLNO -- 강의번호
		)
		REFERENCES SE_OPEN_LECTS ( -- 개설강의
			OLNO -- 강의번호
		);

-- 개설강의 -> 수강생
COMMENT ON CONSTRAINT SE_LECT_STDS.FK_SE_OPEN_LECTS_TO_SE_LECT_STDS IS '개설강의 -> 수강생';

-- 수강생
ALTER TABLE SE_LECT_STDS
	ADD
		CONSTRAINT FK_SE_SUPPS_TO_SE_LECT_STDS -- 교육지원 -> 수강생
		FOREIGN KEY (
			SUNO -- 교육지원번호
		)
		REFERENCES SE_SUPPS ( -- 교육지원
			SUNO -- 교육지원번호
		);

-- 교육지원 -> 수강생
COMMENT ON CONSTRAINT SE_LECT_STDS.FK_SE_SUPPS_TO_SE_LECT_STDS IS '교육지원 -> 수강생';

-- 수강생
ALTER TABLE SE_LECT_STDS
	ADD
		CONSTRAINT FK_SE_LECT_STATS_TO_SE_LECT_STDS -- 수강상태 -> 수강생
		FOREIGN KEY (
			LSTNO -- 수강상태번호
		)
		REFERENCES SE_LECT_STATS ( -- 수강상태
			LSTNO -- 수강상태번호
		);

-- 수강상태 -> 수강생
COMMENT ON CONSTRAINT SE_LECT_STDS.FK_SE_LECT_STATS_TO_SE_LECT_STDS IS '수강상태 -> 수강생';

-- 과제
ALTER TABLE SE_TESTS
	ADD
		CONSTRAINT FK_SE_OPEN_LECTS_TO_SE_TESTS -- 개설강의 -> 과제
		FOREIGN KEY (
			OLNO -- 강의번호
		)
		REFERENCES SE_OPEN_LECTS ( -- 개설강의
			OLNO -- 강의번호
		);

-- 개설강의 -> 과제
COMMENT ON CONSTRAINT SE_TESTS.FK_SE_OPEN_LECTS_TO_SE_TESTS IS '개설강의 -> 과제';

-- 과제
ALTER TABLE SE_TESTS
	ADD
		CONSTRAINT FK_SE_TEST_TYPES_TO_SE_TESTS -- 과제유형 -> 과제
		FOREIGN KEY (
			TTNO -- 과제유형번호
		)
		REFERENCES SE_TEST_TYPES ( -- 과제유형
			TTNO -- 과제유형번호
		);

-- 과제유형 -> 과제
COMMENT ON CONSTRAINT SE_TESTS.FK_SE_TEST_TYPES_TO_SE_TESTS IS '과제유형 -> 과제';

-- 과제평가
ALTER TABLE SE_TEST_RESUS
	ADD
		CONSTRAINT FK_SE_LECT_STDS_TO_SE_TEST_RESUS -- 수강생 -> 과제평가
		FOREIGN KEY (
			LSNO -- 수강생번호
		)
		REFERENCES SE_LECT_STDS ( -- 수강생
			LSNO -- 수강생번호
		);

-- 수강생 -> 과제평가
COMMENT ON CONSTRAINT SE_TEST_RESUS.FK_SE_LECT_STDS_TO_SE_TEST_RESUS IS '수강생 -> 과제평가';

-- 과제평가
ALTER TABLE SE_TEST_RESUS
	ADD
		CONSTRAINT FK_SE_TESTS_TO_SE_TEST_RESUS -- 과제 -> 과제평가
		FOREIGN KEY (
			TNO -- 과제번호
		)
		REFERENCES SE_TESTS ( -- 과제
			TNO -- 과제번호
		);

-- 과제 -> 과제평가
COMMENT ON CONSTRAINT SE_TEST_RESUS.FK_SE_TESTS_TO_SE_TEST_RESUS IS '과제 -> 과제평가';

-- 과제평가
ALTER TABLE SE_TEST_RESUS
	ADD
		CONSTRAINT FK_SE_TEST_RESU_TYPES_TO_SE_TEST_RESUS -- 과제상태 -> 과제평가
		FOREIGN KEY (
			TRSNO -- 과제상태번호
		)
		REFERENCES SE_TEST_RESU_TYPES ( -- 과제상태
			TRSNO -- 과제상태번호
		);

-- 과제상태 -> 과제평가
COMMENT ON CONSTRAINT SE_TEST_RESUS.FK_SE_TEST_RESU_TYPES_TO_SE_TEST_RESUS IS '과제상태 -> 과제평가';

-- 교육자료
ALTER TABLE SE_LECT_FILES
	ADD
		CONSTRAINT FK_SE_OPEN_LECTS_TO_SE_LECT_FILES -- 개설강의 -> 교육자료
		FOREIGN KEY (
			OLNO -- 강의번호
		)
		REFERENCES SE_OPEN_LECTS ( -- 개설강의
			OLNO -- 강의번호
		);

-- 개설강의 -> 교육자료
COMMENT ON CONSTRAINT SE_LECT_FILES.FK_SE_OPEN_LECTS_TO_SE_LECT_FILES IS '개설강의 -> 교육자료';

-- 교육자료
ALTER TABLE SE_LECT_FILES
	ADD
		CONSTRAINT FK_SE_USERS_TO_SE_LECT_FILES -- 사용자 -> 교육자료
		FOREIGN KEY (
			UNO -- 사용자번호
		)
		REFERENCES SE_USERS ( -- 사용자
			UNO -- 사용자번호
		);

-- 사용자 -> 교육자료
COMMENT ON CONSTRAINT SE_LECT_FILES.FK_SE_USERS_TO_SE_LECT_FILES IS '사용자 -> 교육자료';

-- 강사과목
ALTER TABLE SE_TEACH_SUBJS
	ADD
		CONSTRAINT FK_SE_TEACHS_TO_SE_TEACH_SUBJS -- 강사 -> 강사과목
		FOREIGN KEY (
			UNO -- 강사번호
		)
		REFERENCES SE_TEACHS ( -- 강사
			UNO -- 강사번호
		);

-- 강사 -> 강사과목
COMMENT ON CONSTRAINT SE_TEACH_SUBJS.FK_SE_TEACHS_TO_SE_TEACH_SUBJS IS '강사 -> 강사과목';

-- 강사과목
ALTER TABLE SE_TEACH_SUBJS
	ADD
		CONSTRAINT FK_SE_SUBJS_TO_SE_TEACH_SUBJS -- 과목 -> 강사과목
		FOREIGN KEY (
			SNO -- 과목번호
		)
		REFERENCES SE_SUBJS ( -- 과목
			SNO -- 과목번호
		);

-- 과목 -> 강사과목
COMMENT ON CONSTRAINT SE_TEACH_SUBJS.FK_SE_SUBJS_TO_SE_TEACH_SUBJS IS '과목 -> 강사과목';