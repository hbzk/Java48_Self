package basic.exam05.step04;

import java.awt.Button;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class ScorePanel extends Panel implements ActionListener {
	StudentMgtSystem parent;
	Button backMenu = new Button("뒤로");
	Label title = new Label("점수관리");
	
	public ScorePanel(StudentMgtSystem parent) {
		this.parent = parent;
		add(title);
		
		backMenu.addActionListener(this);
		add(backMenu);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		parent.changePanel(StudentMgtSystem.MENU_PANEL);
	}
}


