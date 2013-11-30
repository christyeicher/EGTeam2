package cafitnessclub.view.com;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ClassesPanel extends JPanel{
	
	private ClassesTable table;
	private JScrollPane spTable;
	
	public ClassesPanel(){
		
		this.setLayout(new BorderLayout());
		 table = new ClassesTable();
	     spTable = new JScrollPane(table);
	     spTable.setPreferredSize(new Dimension(400,300));
	     this.add(spTable, BorderLayout.CENTER);	
	     
	     initComponents();
	}
	
	private void initComponents(){
		
		final ClassDialog dialog = new ClassDialog("Blah");
		 // MOUSE LISTENER
        table.addMouseListener(new MouseAdapter(){
        	public void mouseClicked(MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());
                int column = table.columnAtPoint(e.getPoint());
                if (row >= 0 && column >= 0) {
                	int temp = (int) table.getModel().getValueAt(row, 0);
                	System.out.println("CLASSID: " + temp);
                	dialog.setInfo(temp);                	
                    dialog.setVisible(true);
                }
            }        	
        });
	}
}
