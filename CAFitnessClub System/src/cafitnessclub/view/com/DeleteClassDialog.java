/**
 * This program
 * @author: Christy Eicher
 * Version
*/

package cafitnessclub.view.com;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

import cafitnessclub.model.com.Classes;

public class DeleteClassDialog extends JDialog {
	
    private JButton cancelButton;
    private JTextField classIDField;
    private JSeparator jSeparator1;
    private JButton okButton;

    public DeleteClassDialog(String title) {
        setTitle(title);
        initComponents();
        setLocationRelativeTo(null);
    }

    private void initComponents() {

        classIDField = new JTextField();
        	classIDField.setBorder(BorderFactory.createTitledBorder("Class ID"));
        jSeparator1 = new JSeparator();
        okButton = new JButton();
        	okButton.setText("OK");
        cancelButton = new JButton();
        	cancelButton.setText("Cancel");
      
      // ACTION LISTENERS
        	okButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                	String id = classIDField.getText();
                	int classID = Integer.parseInt(id);
                	
                	try {
						Classes.deleteClass(classID);
					} catch (SQLException e) {
						e.printStackTrace();
					}
                	
                	dispose();
                	JOptionPane.showMessageDialog(new JFrame(), "Class with ID: " + id + " has been deleted!", "Deletion Successful", JOptionPane.INFORMATION_MESSAGE);
                }
            });
        	cancelButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                	dispose();
                }
            });
      // END ACTION LISTENERS
        	
      // ADD ALL COMPONENTS
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(classIDField)
                    .addComponent(jSeparator1))
                .addContainerGap())
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addComponent(okButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelButton)
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(classIDField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(cancelButton))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
      // END ADD ALL COMPONENTS

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pack();
    }
}
