package cafitnessclub.view.com;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ClassesPanel extends JPanel{
	
	ClassesTable table;
	JScrollPane spTable;
	
	public ClassesPanel(){
		
		this.setLayout(new BorderLayout());
		 table = new ClassesTable();
	     spTable = new JScrollPane(table);
	     spTable.setPreferredSize(new Dimension(400,300));
	     this.add(spTable, BorderLayout.CENTER);		
	}
}
