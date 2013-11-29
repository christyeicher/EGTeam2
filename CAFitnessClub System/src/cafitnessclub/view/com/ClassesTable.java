package cafitnessclub.view.com;


import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;


public class ClassesTable extends JTable {
	//Needs Header
	JTableHeader header;
	MyTableModel model;
	
	public ClassesTable()
	{
		//header =  new JTableHeader();
		//header.setTable(this);
		super();
		model = new MyTableModel();
		this.setModel(model);
	
		this.setSize(new Dimension(450, 400));
		
		this.setBorder(BorderFactory.createRaisedBevelBorder());
	}
}
