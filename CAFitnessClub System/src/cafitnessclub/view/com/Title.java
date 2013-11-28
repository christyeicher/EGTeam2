package cafitnessclub.view.com;

import javax.swing.JLabel;

public class Title extends JLabel {
	
	public Title()
	{
		this.setBackground(new java.awt.Color(200, 200, 200));
	    this.setFont(new java.awt.Font("Britannic Bold", 1, 34)); // NOI18N
	    this.setForeground(new java.awt.Color(255, 255, 255));
	    this.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	    this.setText("California Fitness Club");
	    this.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
	}

}
