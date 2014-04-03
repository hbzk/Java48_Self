package basic.exam05.step06.lec;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

@SuppressWarnings("serial")
public class ScorePanel extends ContentPanel{
	StudentScoreControl controller = new StudentScoreControl();
	
	List listView = new List() {
		public Dimension getPreferredSize() {
			return new Dimension(300, 400);
		}
	};
	
	Panel detailView = new Panel(new FlowLayout(FlowLayout.LEFT));
	TextField tfName = new TextField(10);
	TextField tfKor = new TextField(5);
	TextField tfEng = new TextField(5);
	TextField tfMath = new TextField(5);
	
	Panel newButtonBar;
	Panel detailButtonBar;
	
	Button btnAdd = new Button("등록");
	Button btnUpdate = new Button("변경");
	Button btnDelete = new Button("삭제");
	Button btnCancel = new Button("취소");
	
	int selectedIndex = -1; 	// > 변경 등 동작시 선택 해제를 방지하기 위해 선택 인덱스를 변수에 저장
	
	
	
	public ScorePanel() {
		super("점수관리");
		listView.setMultipleMode(false); 	// > 여러줄 동시 선택을 막기 위해 필요
		listView.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(listView.getSelectedIndex());
			}
		});
		
		listView.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				StudentScore s = StudentScore.fromCSV(
						listView.getItem(
								listView.getSelectedIndex()));

				tfName.setText(s.name);
				tfKor.setText(Integer.toString(s.kor));
				tfEng.setText(Integer.toString(s.eng));
				tfMath.setText(Integer.toString(s.math));
				
				newButtonBar.setVisible(false);
				detailButtonBar.setVisible(true);
				ScorePanel.this.validate();
				
				selectedIndex = listView.getSelectedIndex(); 	// > 선택되는 항목이 있는 경우 해당 인덱스를 저장
			}
		});
		
		content.add(listView);
		
		detailView.setPreferredSize(new Dimension(300, 400));
		
		Panel rowPane = createRowPane();
		rowPane.add(createLabel("이름"));
		rowPane.add(tfName);
		detailView.add(rowPane);
		
		rowPane = createRowPane();
		rowPane.add(createLabel("국어"));
		rowPane.add(tfKor);
		detailView.add(rowPane);
		
		rowPane = createRowPane();
		rowPane.add(createLabel("영어"));
		rowPane.add(tfEng);
		detailView.add(rowPane);
		
		rowPane = createRowPane();
		rowPane.add(createLabel("수학"));
		rowPane.add(tfMath);
		detailView.add(rowPane);
		
		newButtonBar = createRowPane();
		newButtonBar.add(btnAdd);
		
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StudentScore s = new StudentScore();
				s.name = tfName.getText();
				s.kor = Integer.parseInt(tfKor.getText());
				s.eng= Integer.parseInt(tfEng.getText());
				s.math = Integer.parseInt(tfMath.getText());
				
				controller.add(s);
				listView.add(s.toString());
				
				clearFrom();
			}
		});
		detailView.add(newButtonBar);
		
		detailButtonBar = createRowPane();
		detailButtonBar.setVisible(false);
		detailButtonBar.add(btnUpdate);
		detailButtonBar.add(btnDelete);
		detailButtonBar.add(btnCancel);
		
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StudentScore s = new StudentScore();
				s.name = tfName.getText();
				s.kor = Integer.parseInt(tfKor.getText());
				s.eng= Integer.parseInt(tfEng.getText());
				s.math = Integer.parseInt(tfMath.getText());
				
				controller.update(selectedIndex, s);
				listView.replaceItem(s.toString(), selectedIndex);
			}
		});
		
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				newButtonBar.setVisible(true);
				detailButtonBar.setVisible(false);
				listView.remove(selectedIndex); 	// > 화면 삭제
				controller.remove(selectedIndex); 	// > 데이터 삭제
				clearFrom();
				// > selectedIndex = -1;
			}
		});
		
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				newButtonBar.setVisible(true);
				detailButtonBar.setVisible(false);
				selectedIndex = -1;
				clearFrom();
			}
		});
		detailView.add(detailButtonBar);
		
		content.add(detailView);
		
		controller.load(); 	// > StudentControl
		displayList();
	}
	
	
	protected void clearFrom() {
	  tfName.setText("");
	  tfKor.setText("");
	  tfEng.setText("");
	  tfMath.setText("");
  }


	private void displayList() {
	  for (StudentScore score : controller.scoreList) {
		  listView.add(score.toString());
	  }
  }

	private Panel createRowPane() {
		Panel rowPane = new Panel(new FlowLayout(FlowLayout.LEFT));
		rowPane.setPreferredSize(new Dimension(290, 50));
		return rowPane;
	}
	
	private Label createLabel(String title) {
		Label label = new Label(title);
		label.setPreferredSize(new Dimension(70, 30));
		return label;
	}
	
	public void save() {
		controller.save();
	}
}


