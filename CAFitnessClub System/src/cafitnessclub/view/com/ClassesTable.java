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
		
//		this.addMouseListener(new MouseAdapter(){
//        	public void mouseClicked(MouseEvent e) {
//                int row = this.rowAtPoint(e.getPoint());
//                int column = this.columnAtPoint(e.getPoint());
//                if (row >= 0 && column >= 0) {
//                    dialog.setVisible(true);
//                }
//            }
//        	
//        });
	}
	
	
}
