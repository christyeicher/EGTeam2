package cafitnessclub.view.com;


import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;


public class ClassRosterTable extends JTable {
	//Needs Header
	JTableHeader header;
	RosterTableModel model;
	
	public ClassRosterTable(int classID)
	{
		model = new RosterTableModel(classID);
		this.setModel(model);
	
		this.setSize(new Dimension(450, 400));
		
		this.setBorder(BorderFactory.createRaisedBevelBorder());
	}
	
	/*public void ResetiarTable(){
		model.resetClasses(2);
		model.fireTableDataChanged();
		this.setModel(model);
	}*/
}
