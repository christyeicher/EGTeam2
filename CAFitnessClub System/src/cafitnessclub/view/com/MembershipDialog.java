package cafitnessclub.view.com;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

import cafitnessclub.model.POJO.com.Member;

public class MembershipDialog extends JDialog {
		
    private JButton cancelButton;
    private JSeparator jSeparator1;
    private JComboBox membershipDropDown;
    private JButton okButton;
    private Member member;

    public MembershipDialog(String title, Member member) {
        setTitle(title);
        initComponents();
        setLocationRelativeTo(null);
        this.member = member;
    }

    private void initComponents() {

    	okButton = new JButton();
    		okButton.setText("OK");
        cancelButton = new JButton();
        	cancelButton.setText("Cancel");
        membershipDropDown = new JComboBox();
        	membershipDropDown.setModel(new DefaultComboBoxModel(new String[] { 
        			"Choose Membership Type...", "Annual Unlimited (AU)", 
        			"Monthly Unlimited (MU)", "Monthly Choose 5 (MC)" }));
        jSeparator1 = new JSeparator();

      // ACTION LISTENERS
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	//member.setMembership(membership);
            	dispose();
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
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(okButton)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(membershipDropDown, 0, 180, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(membershipDropDown, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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