package com.srebmem;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.Dimension;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import javax.swing.*;

public class MainFrame extends JFrame {

  public MainFrame() {
    createMenuBar();
    createTableView();
    init();
  }
  public final void init() {
    setTitle("My members");
    setSize(1280, 720);
    setLocationRelativeTo(null); //Center window on screen
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
  private void createMenuBar() {
    JMenuBar menubar = new JMenuBar();

    //Top level items
    JMenu file = new JMenu("File");
    file.setMnemonic(KeyEvent.VK_F);

    JMenu members = new JMenu("Members");
    members.setMnemonic(KeyEvent.VK_M);

    JMenu sort = new JMenu("Sort");
    sort.setMnemonic(KeyEvent.VK_S);

    //Sublevel items
    JMenuItem exitFile = new JMenuItem("Exit");
    exitFile.setMnemonic(KeyEvent.VK_E);
    exitFile.setToolTipText("Exit Application");
    exitFile.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent ae) {
        System.exit(0);
      }
    });

    JMenuItem addMember = new JMenuItem("Add member");
    addMember.setMnemonic(KeyEvent.VK_A);
    addMember.setToolTipText("Add a member to the database");
    addMember.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent ae) {
        //Code to add member here
      }
    });

    JMenuItem updateMember = new JMenuItem("Update member");
    updateMember.setMnemonic(KeyEvent.VK_U);
    updateMember.setToolTipText("Update existing member");
    updateMember.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent ae) {
        //Code to update member
      }
    });

    JCheckBoxMenuItem familyName = new JCheckBoxMenuItem("by Family Name");
    familyName.setMnemonic(KeyEvent.VK_F);
    familyName.setSelected(false);
    familyName.addItemListener(new ItemListener() {
      @Override
      public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            // Sorting code here
        }
      }
    });

    JCheckBoxMenuItem memberID = new JCheckBoxMenuItem("by Member ID");
    memberID.setMnemonic(KeyEvent.VK_I);
    memberID.setSelected(true);
    memberID.addItemListener(new ItemListener() {
      @Override
      public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            // Sorting code here
        }
      }
    });

    //Add items to menubar
    file.add(exitFile);
    members.add(addMember);
    members.add(updateMember);
    sort.add(familyName);
    sort.add(memberID);
    menubar.add(file);
    menubar.add(members);
    menubar.add(sort);

    //init
    setJMenuBar(menubar);

  }
  private void createTableView() {
    JPanel panel = new JPanel();

    MemberList ml = new MemberList();

    // The table that displays members
    JTable memberTable = new JTable();
    MemberTableModel mtm = new MemberTableModel(ml.getMemberList());
    memberTable.setModel(mtm);

    // ScrollPane for the table
    JScrollPane pane = new JScrollPane();
    pane.getViewport().add(memberTable);
    pane.setPreferredSize(new Dimension(1000,600));

    // Objects for dialogs
    //final NewMemberView nmvDialog = new NewMemberView(this, false);
    //final DetailedMemberView dmvDialog = new DetailedMemberView(this, false);

    // Vertical box for the buttons
    Box verticalBox = Box.createVerticalBox();

    // Buttons
    JButton detailedButton = new JButton("Detailed view");
    JButton searchButton = new JButton("Search");

    //Listeners for buttons above
    // detailedButton.addActionListener(new ActionListener() {
    //   public void actionPerformed(ActionEvent ae) {
    //       String id = (memberTable.getValueAt(memberTable.getSelectedRow(),
    //       0).toString()); // Get member ID from the table as String
    //       ArrayList<Member> children = new ArrayList<Member>(ch.getChildren(id));
    //       dmvDialog.createDetailedView(children, ml.getMemberFromId(id));
    //       dmvDialog.setSize(1200,600);
    //       dmvDialog.setVisible(true);
    //       dmvDialog.setLocationRelativeTo(null);
    //   }
    // });

    // Add to panel and pack
    verticalBox.add(detailedButton);
    verticalBox.add(Box.createVerticalStrut(10));
    verticalBox.add(searchButton);

    panel.add(pane);
    panel.add(verticalBox);
    add(panel);
    pack();
  }
}
