package cafitnessclub.view.com;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

public class ClassDialog extends JDialog {
	
    private javax.swing.JButton cancelButton;
    private javax.swing.JComboBox classTypeCombo;
    private javax.swing.JLabel classTypeLabel;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton okButton;
    private javax.swing.JComboBox startTimeCombo;
    private javax.swing.JLabel startTimeLabel;
    private String info;

    public ClassDialog(String title) {
        setTitle(title);
        initComponents();
        info = "";
        setLocationRelativeTo(null);
    }

    private void initComponents() { 	

            okButton = new javax.swing.JButton();
            	okButton.setText("OK");
            cancelButton = new javax.swing.JButton();
            	cancelButton.setText("Cancel");
            jSeparator1 = new javax.swing.JSeparator();
            startTimeLabel = new javax.swing.JLabel();
            	startTimeLabel.setText("Start Time: ");
            startTimeCombo = new javax.swing.JComboBox();
            	startTimeCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] 
            			{ "6am", "9am", "12pm", "3pm", "6pm" }));
            classTypeCombo = new javax.swing.JComboBox();
            	classTypeCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { 
            			"Choose Class Type...", "Aerobics", "Basketball", "Karate", "Kickboxing", 
            			"Pilates", "Pool", "Racquetball", "Tennis", "Yoga", "Zumba" }));
            classTypeLabel = new javax.swing.JLabel();
            	classTypeLabel.setText("Class Type: ");
            
          // ACTION LISTENERS
            okButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                	dispose();
                }
            });
            cancelButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                	dispose();
                }
            });
          // END ACTION LISTENERS
            
          // ADD ALL COMPONENTS  
            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator1)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(startTimeLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(startTimeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(classTypeLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(classTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap())
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(okButton)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(cancelButton)
                    .addGap(41, 41, 41))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(classTypeLabel)
                        .addComponent(classTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(startTimeLabel)
                        .addComponent(startTimeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(okButton)
                        .addComponent(cancelButton))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

        	setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            pack();
        }
      // END ADD ALL COMPONENTS

    public void setInfo(int id) {
    	info = (Integer.toString(id));
    }
}
