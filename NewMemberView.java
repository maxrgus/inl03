package com.srebmem;

import javax.swing.JDialog;
import javax.swing.JTextField;
import java.beans.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.Dimension;

public class NewMemberView extends JDialog {

	private String typedText = null;
    private JTextField textField;
	public int roleAsInt = 0;
    private JFrame frame;
	private JDialog dialog;
	    
	/**
	* The constructor for the class.
	*/
	public NewMemberView(Frame owner, boolean modal) {
		super(owner,modal);
	}

     /**
     * Returns null if the typed string was invalid;
     * otherwise, returns the string as the user entered it.
     */
    public String getValidText() {
        return typedText;
    }
 
    /** 
	* This method creates the dialog.
	*/
    public void myDialog() {
				
		JTextField givenName_field = new JTextField(50);
		JTextField familyName_field = new JTextField(50);
		JTextField birth_field = new JTextField(10);
		JTextField email_field = new JTextField(50);
		JTextField memberSince_field = new JTextField(10);
		JTextField team_field = new JTextField(10);
								
		JButton btnSave = new JButton("Add member");
		JButton btnCancel = new JButton ("Cancel");
				
        JLabel givenName_Label = new JLabel("Firstname: ");
		JLabel familyName_Label = new JLabel("Lastname: ");
		JLabel role_Label = new JLabel("Role: ");
		JLabel email_Label = new JLabel("Email: ");
		JLabel gender_Label = new JLabel("Gender: ");
		JLabel birth_Label = new JLabel("Birth: ");
		JLabel memberSince_Label = new JLabel("Member since: ");
		JLabel team_Label = new JLabel("Member since: ");
						 
        String str1 = givenName_field.getText();
		String str2 = familyName_field.getText();
		String str3 = birth_field.getText();
		String str4 = email_field.getText();
		String str5 = memberSince_field.getText();
		String str6 = team_field.getText();
 
        String[] role = { "Parent", "Player", "Coach" };
		String[] gender = {"kvinna", "man"};

		JComboBox roleList = new JComboBox(role);
		JComboBox genderList = new JComboBox(gender);
		
		String chosenRole = (String)roleList.getSelectedItem();
        String chosenGender = (String)genderList.getSelectedItem();
		
		if (chosenRole=="Player") {
			roleAsInt = 0;
		} else if (chosenRole=="Coach") {
			roleAsInt = 1;
		} else {
			roleAsInt = 2;
		}
	
		this.setTitle("Add member");
		this.setLayout(new GridBagLayout());
	
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		
		gc.anchor = GridBagConstraints.LINE_END;
		
		//First column
		gc.gridx = 0;
		gc.gridy = 0;
		add(givenName_Label, gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		add(familyName_Label, gc);
		
		gc.gridx = 0;
		gc.gridy = 2;
		add(role_Label, gc);
		
		gc.gridx = 0;
		gc.gridy = 3;
		add(email_Label, gc);
		
		gc.gridx = 0;
		gc.gridy = 4;
		add(gender_Label, gc);
		
		gc.gridx = 0;
		gc.gridy = 5;
		add(birth_Label, gc);
		
		gc.gridx = 0;
		gc.gridy = 6;
		add(memberSince_Label, gc);
		
		//Second column
		gc.anchor = GridBagConstraints.LINE_START;
		
		gc.gridx = 1;
		gc.gridy = 0;
		add(givenName_field, gc);
		
		gc.gridx = 1;
		gc.gridy = 1;
		add(familyName_field, gc);
		
		gc.gridx = 1;
		gc.gridy = 2;
		add(roleList, gc);
		
		gc.gridx = 1;
		gc.gridy = 3;
		add(email_field, gc);
		
		gc.gridx = 1;
		gc.gridy = 4;
		add(genderList, gc);
		
		gc.gridx = 1;
		gc.gridy = 5;
		add(birth_field, gc);
		
		gc.gridx = 1;
		gc.gridy = 6;
		add(memberSince_field, gc);
		
		//Third column
		gc.weightx = 10;
		
		gc.gridx = 1;
		gc.gridy = 8;
		add(btnSave, gc);
		
		gc.gridx = 3;
		gc.gridy = 8;
		add(btnCancel, gc);
	
	/** 
	* This method returns a new object of the class Member. 
	*/
	MemberList ml = new MemberList(false);
	MemberTableModel mtm = new MemberTableModel(false);
	
	btnSave.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent ae) {
       
	   if (str1.length() <2 || str2.length() <2 || str3.length() 
		   <2 || str4.length() <2 || str5.length() <2 || str6.length() <2){
				JOptionPane.showMessageDialog(frame, "Please fill in all forms",
											  "Error",JOptionPane.WARNING_MESSAGE);
							 
		} else {
	   
			Member m = new Member(ml.generateMemberId(),str1,str2,str4,chosenGender,str3,str5,1,
						 roleAsInt,str6);
			mtm.addRow(m);
			ml.addMemberToDatabase(m);
			}
		
		}
	});
	
	/** 
	* This method returns disposes of the window
	* if the user clicks on the Cancel button.
	*/
	
	btnCancel.addActionListener(e -> this.dispose());
	
	}	
}