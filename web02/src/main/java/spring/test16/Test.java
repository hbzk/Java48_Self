package spring.test16;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext beanContainer =
				new ClassPathXmlApplicationContext("spring/test16/beans.xml");
		
		//Engine e1 = (Engine) beanContainer.getBean("engine1");
		//System.out.println(e1);
		
		Car c1 = (Car) beanContainer.getBean("car1");
		System.out.println(c1);
		
		if (c1.getEngine() != null) {
			System.out.println("엔진이 있다.");
		}	else {
			System.out.println("엔진이 없다.");
		}
	}
}
