package cafitnessclub.view.com;

import javax.swing.JTabbedPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class MyTabbedPane extends JTabbedPane{
	
	public MyTabbedPane()
	{
		this.setBackground(new java.awt.Color(200, 200, 200));
		this.setSize(400, 500);
        this.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        this.setToolTipText("");
        this.setRequestFocusEnabled(false);
		
	}
}
