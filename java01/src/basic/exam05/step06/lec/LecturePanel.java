package basic.exam05.step06.lec;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@SuppressWarnings("serial")
public class LecturePanel extends ContentPanel{
	LectureControl controller = new LectureControl();

	List listView = new List() {
		public Dimension getPreferredSize() {
			return new Dimension(300, 400);
		}
	};

	Panel detailView = new Panel(new FlowLayout(FlowLayout.LEFT));
	TextField tfTitle= new TextField(20);
	TextField tfTeacher = new TextField(10);
	TextField tfStartDate = new TextField(20);
	TextField tfEndDate = new TextField(20);
	// TextField tfClassroom = new TextField(20);
	// TextField tfManager = new TextField(20);
	Choice chClassroom = new Choice();
	Choice chManager = new Choice();
	Choice chHours = new Choice();

  

  
  public MenuItem makeMenuItem(String name) {
      MenuItem m = new MenuItem(name);
      m.addActionListener(this);
      return m;
  }
	
	TextField tfHours = new TextField(20);

	Panel newButtonBar;
	Panel detailButtonBar;

	Button btnAdd = new Button("등록");
	Button btnUpdate = new Button("변경");
	Button btnDelete = new Button("삭제");
	Button btnCancel = new Button("취소");

	int selectedIndex = -1; 	// > 변경 등 동작시 선택 해제를 방지하기 위해 선택 인덱스를 변수에 저장

	public LecturePanel() {
		super("과목관리");
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
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");  
				// String text = df.format(date);  
				
				Lecture l = Lecture.fromCSV(
						listView.getItem(
								listView.getSelectedIndex()));

				tfTitle.setText(l.title);
				tfTeacher.setText(l.teacher);
				//tfStartDate.setText(l.startDate);
				//tfEndDate.setText(l.endDate);
				tfStartDate.setText(df.format(l.startDate));
				tfEndDate.setText(df.format(l.endDate));
				chClassroom.select(l.classroom);
				chManager.select(l.manager);
				chHours.select(Integer.toString(l.hours));

				newButtonBar.setVisible(false);
				detailButtonBar.setVisible(true);
				LecturePanel.this.validate();

				selectedIndex = listView.getSelectedIndex(); 	// > 선택되는 항목이 있는 경우 해당 인덱스를 저장
			}
		});

		content.add(listView);

		detailView.setPreferredSize(new Dimension(300, 450));

		Panel rowPane = createRowPane();
		rowPane.add(createLabel("과목"));
		rowPane.add(tfTitle);
		detailView.add(rowPane);

		rowPane = createRowPane();
		rowPane.add(createLabel("강사"));
		rowPane.add(tfTeacher);
		detailView.add(rowPane);

		rowPane = createRowPane();
		rowPane.add(createLabel("시작일"));
		rowPane.add(tfStartDate);
		detailView.add(rowPane);

		rowPane = createRowPane();
		rowPane.add(createLabel("종료일"));
		rowPane.add(tfEndDate);
		detailView.add(rowPane);

		rowPane = createRowPane();
		rowPane.add(createLabel("교실"));
		chClassroom.add("3-1");
		chClassroom.add("3-2");
		chClassroom.add("3-3");
		chClassroom.add("4-1");
		rowPane.add(chClassroom);
		detailView.add(rowPane);

		rowPane = createRowPane();
		rowPane.add(createLabel("관리자"));
		chManager.add("임꺽정");
		chManager.add("홍길동");
		chManager.add("장길산");
		rowPane.add(chManager);
		detailView.add(rowPane);

		rowPane = createRowPane();
		rowPane.add(createLabel("일 강의 시간"));
		chHours.add("4");
		chHours.add("6");
		chHours.add("8");
		rowPane.add(chHours);
		detailView.add(rowPane);

		newButtonBar = createRowPane();
		newButtonBar.add(btnAdd);

		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Lecture l = new Lecture();
				l.title = tfTitle.getText();
				l.teacher = tfTeacher.getText();
				//l.startDate = tfStartDate.getText();
				//l.endDate = tfEndDate.getText();
				l.startDate =  java.sql.Date.valueOf(tfStartDate.getText());
				l.endDate = java.sql.Date.valueOf(tfEndDate.getText());
				
				l.classroom = chClassroom.getSelectedItem();
				l.manager = chManager.getSelectedItem();
				l.hours = Integer.parseInt(chHours.getSelectedItem());


				controller.add(l);
				listView.add(l.toString());

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
				Lecture l = new Lecture();
				l.title = tfTitle.getText();
				l.teacher = tfTeacher.getText();
				//l.startDate = tfStartDate.getText();
				//l.endDate = tfEndDate.getText();
				l.startDate =  java.sql.Date.valueOf(tfStartDate.getText());
				l.endDate = java.sql.Date.valueOf(tfEndDate.getText());
				l.classroom = chClassroom.getSelectedItem();
				l.manager = chManager.getSelectedItem();
				l.hours = Integer.parseInt(chHours.getSelectedItem());


				controller.update(selectedIndex, l);
				listView.replaceItem(l.toString(), selectedIndex);
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
		tfTitle.setText("");
		tfTeacher.setText("");
		tfStartDate.setText("");
		tfEndDate.setText("");
		chClassroom.select(0);
		chManager.select(0);
		chHours.select(0);
  }


	private void displayList() {
	  for (Lecture lecture : controller.lectureList) {
		  listView.add(lecture.toString());
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