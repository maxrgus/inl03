package com.srebmem;

import javax.swing.SwingUtilities;

public class MyMemberList {

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() { //InvokeLater to prevent freezing
      public void run() {
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
      }
    });
}
}
