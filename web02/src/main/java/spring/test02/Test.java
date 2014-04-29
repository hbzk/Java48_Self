package spring.test02;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
	  ClassPathXmlApplicationContext beanContainer = 
	  		new ClassPathXmlApplicationContext("spring/test02/beans.xml");
	  
	  Score s1 = (Score) beanContainer.getBean("s1");
	  printScore(s1);
	  
	  Score s2 = (Score) beanContainer.getBean("s2");
	  printScore(s2);
	  
	  Score s3 = (Score) beanContainer.getBean("s3");
	  printScore(s3);
	  
	  Score s4 = (Score) beanContainer.getBean("s4");
	  printScore(s4);
	  
	  Score s5 = (Score) beanContainer.getBean("s5");
	  printScore(s5);
  }

	public static void main01(String[] args) {
	  ClassPathXmlApplicationContext beanContainer = 
	  		new ClassPathXmlApplicationContext("spring/test02/beans.xml");
	  
	  Score s1 = (Score) beanContainer.getBean("s1");
	  printScore(s1);
  }
	
	public static void printScore(Score s) {
		System.out.format("%1$s: %2$d, %3$d, %4$d, %5$3d, %6$3.1f\n",
	  		s.getName(), s.getKor(), s.getEng(), s.getMath(), s.sum(), s.average());
	}
}
