package cafitnessclub.view.com;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MembersPanel extends JPanel{
	
	ClassesTable table;
	JScrollPane spTable;
	
	public MembersPanel(){
		
		this.initComponents();		
	}
	
	private void initComponents()
	{		
		this.setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createRaisedBevelBorder());
	    panel.setSize(new Dimension(200,200));       
        this.add(this.memberSearchPanel(), BorderLayout.CENTER);
        this.setSize(new Dimension(400,500));
	}
	
	private JPanel memberSearchPanel()
	{
		JPanel panel = new JPanel ();
		panel.setSize(new Dimension(100,100));
		panel.setPreferredSize(new Dimension(100,100));
		
		panel.add(new SearchMemberPanel());
		return panel;
	}
}
