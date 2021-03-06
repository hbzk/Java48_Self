package basic.exam05.step04;

import java.awt.Button;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class StudentPanel extends Panel implements ActionListener {
	StudentMgtSystem parent;
	Button backMenu = new Button("뒤로");
	Label title = new Label("학생관리");
	
	public StudentPanel(StudentMgtSystem parent) {
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
