package cafitnessclub.view.com;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

import cafitnessclub.model.POJO.com.Member;
import cafitnessclub.model.POJO.com.Membership;
import cafitnessclub.model.com.Members;
import cafitnessclub.model.com.Memberships;

public class MembershipDialog extends JDialog {
		
    private JButton cancelButton;
    private JSeparator jSeparator1;
    private JComboBox membershipDropDown;
    private JButton okButton;
    private Member member;
    private boolean edit = false;

    public MembershipDialog(String title, Member member) {
        setTitle(title);
        initComponents();
        setLocationRelativeTo(null);
        this.member = member;
    }
    public MembershipDialog(String title, Member member, boolean edit) {
        setTitle(title);
        initComponents();
        setLocationRelativeTo(null);
        this.member = member;
        this.edit = edit;
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
            	if(!edit){
            	String membershipType = (String)membershipDropDown.getSelectedItem();
            	switch(membershipType){
            	case "Annual Unlimited (AU)": 
            		try {
						Memberships.insertMembership(new Membership(member.getMemberID(), "AU", 1500, 
	            				0));
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						e.printStackTrace();
					}
            		break;
            	case "Monthly Unlimited (MU)": 
            		try {
						Memberships.insertMembership(new Membership(member.getMemberID(), "MU", 150, 
	            				0));
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						e.printStackTrace();
					}
            		break;
            	case "Monthly Choose 5 (MC)":
            		try {
						Memberships.insertMembership(new Membership(member.getMemberID(), "MC", 80, 
	            				0));
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						e.printStackTrace();
					}
            		break;
            	}
            	
            	dispose();
            }else
            {
            	String membershipType = (String)membershipDropDown.getSelectedItem();
            	switch(membershipType){
            	case "Annual Unlimited (AU)": 
            		try {
            			Membership membership = member.getMembership();
            			membership.setMembershipType("AU");
            			membership.setCost(1500);
            			Memberships.deleteMembership(membership);
						Memberships.insertMembership(membership);
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						e.printStackTrace();
					}
            		break;
            	case "Monthly Unlimited (MU)": 
            		try {
            			Membership membership = member.getMembership();
            			membership.setMembershipType("MU");
            			membership.setCost(150);
            			Memberships.deleteMembership(membership);
						Memberships.insertMembership(membership);
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						e.printStackTrace();
					}
            		break;
            	case "Monthly Choose 5 (MC)":
            		try {
            			Membership membership = member.getMembership();
            			membership.setMembershipType("MC");
            			membership.setCost(80);
            			Memberships.deleteMembership(membership);
						Memberships.insertMembership(membership);
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						e.printStackTrace();
					}
            		break;
            	}
            	
            	dispose();
            }
            
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