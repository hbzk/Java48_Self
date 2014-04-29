package spring.test06;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext beanContainer =
				new ClassPathXmlApplicationContext("spring/test06/beans.xml");
		
		Car c1 = (Car) beanContainer.getBean("car1");
		Car c2 = (Car) beanContainer.getBean("car2");
		
		System.out.println(c1);
		System.out.println(c2);
		
		if (c1.getEngine() == c2.getEngine()) {
			System.out.println("c1.getEngine() == c2.getEngine()");
		}
	}
}
