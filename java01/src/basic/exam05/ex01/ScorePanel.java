package basic.exam05.ex01;

import java.awt.Button;

@SuppressWarnings("serial")
public class ScorePanel extends ContentPanel{
	public ScorePanel() {
		super("점수관리");
		
		content.add(new Button("점수관리 항목 추가"));
	}
}


