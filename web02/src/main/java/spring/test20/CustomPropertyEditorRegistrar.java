package spring.test20;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;

public class CustomPropertyEditorRegistrar implements PropertyEditorRegistrar {
	CustomDateEditor customDateEditor;
	
	//> Custom야옹이Editor = custom야옹이Editor;  // ==> 스프링에서 제공하는게 없는 경우 직접 작성 
	//> Custom멍멍이Editor = custom멍멍이Editor;
	//> Custom삐약이Editor = custom삐약이Editor;
	
	
	/* 메서드 호출 순서
	 * 1) 스프링 IoC 컨테이너가 beans.xml 파일을 읽는다.
	 * 2) 빈을 생성한다.
	 * 3) CustomEditorConfigurer 객체가 있는지 찾는다.
	 * 4) 찾았다면, 커스텀 에디터 설정기가 가지고 있는 에디터 등록기를 실행한다. (갯수 만큼 반복)
	 * 5) 커스텀에디터등록기.registerCustomEditors(registry => 기록할 때 사용할 등록 명단)
	 * 6) registerCustomEditors()에서는 registry("기록지")에 커스텀 에디터를 적는다.
	 * 
	 *  Spring IoC Container 
	 *  -> CustomerEditorConfigurer 실행
	 *  		-> CustomerPropertyEditorRegistrar.registerCustomEditor() 호출
	 */
	
	public void setCustomDateEditor(CustomDateEditor customDateEditor) {
		this.customDateEditor = customDateEditor;
	}
	
/*	public void setCustom야옹이Editor(CustomDateEditor custom야옹이Editor) { 	// 
		this.custom야옹이Editor = custom야옹이Editor;
	}*/
	
	
	@Override
	public void registerCustomEditors(PropertyEditorRegistry registry) {
		// > java.util.Date.class 형식은 customDateEditor가 담당
		registry.registerCustomEditor(java.util.Date.class, customDateEditor);
		
		//> registry.registerCustomEditor(고양이.class, custom야옹이Editor);
		//> registry.registerCustomEditor(강아지.class, custom멍멍이Editor);
		//> registry.registerCustomEditor(병아리.class, custom삐약이Editor);
		
	}
	
	
}
