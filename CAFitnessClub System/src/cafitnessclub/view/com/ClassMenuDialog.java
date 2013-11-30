package cafitnessclub.view.com;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.border.Border;


public class ClassMenuDialog extends JDialog{
	//String title;
	private JButton classRosterBtn;
    private JButton editClassBtn;
	private int classID;
	
	public ClassMenuDialog(String title, int id){
		this.classID = id;
        setTitle(title);
       // initComponents();
//        setLocationRelativeTo(null);
//        setPreferredSize(new Dimension(300,300));
       
    }
	public ClassMenuDialog(String title){
		//this.classID = id;
        setTitle(title);
//        initComponents();
//        setLocationRelativeTo(null);
       // setPreferredSize(new Dimension(300,300));
    }

	                          
	    private void initComponents() {
	    	
	    	 setLocationRelativeTo(null);
	         setPreferredSize(new Dimension(300,300));

	        classRosterBtn = new JButton();
	        editClassBtn = new JButton();

	        classRosterBtn.setText("Class Roster");
	        editClassBtn.setText("Edit Class");
	        add(classRosterBtn, BorderLayout.NORTH);
	        add(editClassBtn, BorderLayout.SOUTH);
	        
	        
	        
	        
	        
	        
	        classRosterBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					JDialog dialog = new JDialog();
					JScrollPane spTable = new JScrollPane(new ClassRosterTable(classID));
					//spTable
					dialog.add(spTable);
					dialog.setVisible(true);
					dispose();
					
				}
			});

	        
	        editClassBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					EditClassDialog dialog = new EditClassDialog("Edit Class", classID);
					dialog.setVisible(true);
					dispose();
					
				}
			});
	        
	    }// </editor-fold>                        

	    
	    
	    public void setClassID(int id)
	    {
	    	this.classID = id;
	    	this.initComponents();
	    }
	

	

}
