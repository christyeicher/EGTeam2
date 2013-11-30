package cafitnessclub.view.com;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import cafitnessclub.model.POJO.com.Member;
import cafitnessclub.model.com.Members;

public class SearchMemberPanel extends JPanel {
	                     
    private JButton searchBtn;
    private JButton enrollMemberBtn;
    private JButton editMembershipBtn;
    private JButton editMemberBtn;
    private JButton deleteMemberBtn;
    private JButton signupMemberBtn;
    private JLabel emailJLabel1;
    private JLabel memberJLabel;
    private JLabel searchMemberEmailJLabel;
    private JLabel registerEditMemberJLabel;
    private JLabel firstLastNameJLabel;
    private JLabel emailJLabel2;
    private JLabel pinJLabel;
    private JLabel passwordJLabel;
    private JLabel addressJLabel;
    private JScrollPane jScrollPane1;
    private JSeparator jSeparator1;
    private JTextArea memberTextArea;
    private JTextField emailTextField;
    private JTextField nameTextField;
    private JTextField formEmailTextField;
    private JTextField addressTextField;
    private JTextField pinTextField;
    private JTextField passwordTextField;
    private JToggleButton registerMemberBtn;
    public Member member = null;

    public SearchMemberPanel() {
        initComponents();
    }
                         
    private void initComponents() {
      
      // VARIABLE DECLARATION
      // BUTTONS
    	searchBtn = new JButton();
        	searchBtn.setText("Search");
    	enrollMemberBtn = new JButton();
    		enrollMemberBtn.setText("Enroll Member in Class");
    	registerMemberBtn = new JToggleButton();
        	registerMemberBtn.setText("Register New Member");
        editMembershipBtn = new JButton();
        	editMembershipBtn.setText("Edit Member's Membership");
        editMemberBtn = new JButton();
        	editMemberBtn.setText("Edit Member Info");
        deleteMemberBtn = new JButton();
        	deleteMemberBtn.setText("Delete Member");
        signupMemberBtn = new JButton();
        	signupMemberBtn.setText("Sign Up Member for Membership");
      // LABELS      
        emailJLabel1 = new JLabel();
        	emailJLabel1.setText("Email:");
        memberJLabel = new JLabel();
        	memberJLabel.setText("Member: ");
        searchMemberEmailJLabel = new JLabel();
        	searchMemberEmailJLabel.setText("Search Member By Email:");
        registerEditMemberJLabel = new JLabel();
        	registerEditMemberJLabel.setText("Register/Edit Member:");
        firstLastNameJLabel = new JLabel();
        	firstLastNameJLabel.setText("First and Last Name: ");
        emailJLabel2 = new JLabel();
        	emailJLabel2.setText("Email: ");
        pinJLabel = new JLabel();
        	pinJLabel.setText("PIN:");
        passwordJLabel = new JLabel();
        	passwordJLabel.setText("Password:");
        addressJLabel = new JLabel();
        	addressJLabel.setText("Address:");
      // TEXT FIELDS
    	emailTextField = new JTextField();        
        addressTextField = new JTextField();
        pinTextField = new JTextField();
        passwordTextField = new JTextField(); 
        nameTextField = new JTextField();
        formEmailTextField = new JTextField();
      // MISC
        memberTextArea = new JTextArea();
	        memberTextArea.setEditable(false);
	        memberTextArea.setColumns(20);
	        memberTextArea.setRows(5);
        jSeparator1 = new JSeparator();
        jScrollPane1 = new JScrollPane();
        	jScrollPane1.setViewportView(memberTextArea);
      // END VARIABLE DECLARATION
         
      // ACTION LISTENERS
        	signupMemberBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                	
                	if(member != null){
                    MembershipDialog membershipDialog = new MembershipDialog("Sign Up Member for Membership", member);
                    membershipDialog.setVisible(true);
                	}else{
                		
                    		String message = "Please Search for a member first!";
                    		JOptionPane.showMessageDialog(new JFrame(), message, "Error", JOptionPane.ERROR_MESSAGE);
                    		return;
                    	
                	}
                }
            });
        	editMembershipBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                	if(member == null) {
                		String message = "Please Search for a member first!";
                		JOptionPane.showMessageDialog(new JFrame(), message, "Error", JOptionPane.ERROR_MESSAGE);
                		return;
                	}
                	MembershipDialog membershipDialog = new MembershipDialog("Edit Membership", member, true);
                    membershipDialog.setVisible(true);
                }
            });
            editMemberBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                	if(member == null) {
                		String message = "Please Search for a member first!";
                		JOptionPane.showMessageDialog(new JFrame(), message, "Error", JOptionPane.ERROR_MESSAGE);
                		return;
                	}
                	EditMemberDialog editMemberDialog = new EditMemberDialog("Edit Member", member);
                	editMemberDialog.setVisible(true);
                	
                }
            });
            deleteMemberBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                	if(member == null) {
                		String message = "Please Search for a member first!";
                		JOptionPane.showMessageDialog(new JFrame(), message, "Error", JOptionPane.ERROR_MESSAGE);
                		return;
                	}
                	try {
            			Members.deleteMember(member);
            			memberTextArea.setText("");
            			member = null;
            		} catch (SQLException e) {
            			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            			System.out.println("Error Deleting Member: " + e.getMessage());
            			e.printStackTrace();
            		}
                }
            });
            enrollMemberBtn.addActionListener(new ActionListener(){
        		public void actionPerformed(ActionEvent e){
        			if(member == null) {
                		String message = "Please Search for a member first!";
                		JOptionPane.showMessageDialog(new JFrame(), message, "Error", JOptionPane.ERROR_MESSAGE);
                		return;
                	}
        			ClassDialog classDialog = new ClassDialog("Add Member to Class");
        			classDialog.setVisible(true);
        		}
        	});
        	searchBtn.addActionListener(new ActionListener(){
        		public void actionPerformed(ActionEvent evt){
        			String email = emailTextField.getText();
        	    	if(email != null){
        	    		try {
        					member = Members.getMemberByEmail(email);
        					if(member != null)
        					memberTextArea.setText(member.toString());
        					else{
        						
        	                		String message = "Member Not Found";
        	                		JOptionPane.showMessageDialog(new JFrame(), message, "Error", JOptionPane.ERROR_MESSAGE);
        	                		memberTextArea.setText("");
        	                		member = null;
        	                		return;
        	                	
        					}
        					
        				} catch (SQLException e) {
        					// TODO Auto-generated catch block
        					System.out.println("Error getting Member. "+ e.getMessage());
        					e.printStackTrace();
        				}
        	    	}
        		}
        	});
            registerMemberBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                	try {
                    	Member newMember = new Member(nameTextField.getText(),
                    			passwordTextField.getText(), Integer.parseInt(pinTextField.getText()),
                    			formEmailTextField.getText(), addressTextField.getText());
                    	if(newMember.memberCheck())
                    		Members.insertMember(newMember);
                    	else {
                    		memberTextArea.setText("Please fill out all the fields");
                    		return;
                    	}
                		} catch (SQLException e) {
                			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                			System.out.println("Error Registering Member: " + e.getMessage());
                			e.printStackTrace();
                		}catch(NumberFormatException e){
                			memberTextArea.setText("Enter Member's 4 DIGIT PIN number");
                		}catch(NullPointerException e){
                			memberTextArea.setText("Please fill out all the fields");
                		}
                }
            });
      // END ACTION LISTENERS

      // ADD ALL COMPONENTS 
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(enrollMemberBtn)
                    .addComponent(editMembershipBtn)
                    .addComponent(deleteMemberBtn)
                    .addComponent(signupMemberBtn)
                    .addComponent(editMemberBtn))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(memberJLabel)
                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(searchBtn)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(emailJLabel1)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(emailTextField, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)))
                            .addComponent(searchMemberEmailJLabel))))
                .addGap(74, 74, 74))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(registerEditMemberJLabel)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(emailJLabel2)
                        .addComponent(firstLastNameJLabel)
                        .addComponent(addressJLabel)))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(formEmailTextField, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(passwordJLabel)
                            .addComponent(pinJLabel))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(passwordTextField, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                            .addComponent(pinTextField)))
                    .addComponent(addressTextField, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 468, GroupLayout.PREFERRED_SIZE)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(editMemberBtn)
                        .addGap(18, 18, 18)
                        .addComponent(registerMemberBtn)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jSeparator1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(memberJLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchMemberEmailJLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(emailTextField, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailJLabel1))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(signupMemberBtn)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(enrollMemberBtn)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editMembershipBtn)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editMemberBtn)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteMemberBtn)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(registerEditMemberJLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(firstLastNameJLabel)
                    .addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(pinJLabel)
                    .addComponent(pinTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(emailJLabel2)
                    .addComponent(formEmailTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordJLabel)
                    .addComponent(passwordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(addressJLabel)
                    .addComponent(addressTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(registerMemberBtn)
                    .addComponent(editMemberBtn))
                .addContainerGap(46, Short.MAX_VALUE))
        );
      // END ADD ALL COMPONENTS
    }
}