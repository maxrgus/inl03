package com.srebmem;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import java.util.*;

public class MemberTableModel extends AbstractTableModel {
  private String[] columnNames = { "Member ID",
                                   "Given name",
                                   "Family name",
                                   "Email",
                                   "Gender",
                                   "Birthday",
                                   "Member since",
                                   "Active status",
                                   "Role",
                                   "Team"};
  private List<Member> members = new ArrayList();

  public MemberTableModel(List<Member> members){
    this.members = members;
  }
  @Override
  public String getColumnName(int columnIndex) {
    return columnNames[columnIndex];
  }
  @Override
  public int getRowCount() {
    return members.size();
  }
  @Override
  public int getColumnCount() {
    return 10;
  }
  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    Member m = members.get(rowIndex);
    switch (columnIndex) {
      case 0:
        return m.getId();
      case 1:
        return m.getGivenName();
      case 2:
        return m.getFamilyName();
      case 3:
        return m.getEmail();
      case 4:
        return m.getGender();
      case 5:
        return m.getBirthday();
      case 6:
        return m.getMemberSince();
      case 7:
        return m.getActiveActual();
      case 8:
        return m.getRoleActual();
      case 9:
        return m.getTeam();
    }
    return null;
  }
  @Override
  public Class<?> getColumnClass(int columnIndex) {
    switch (columnIndex) {
      case 0:
        return Integer.class;
      case 1:
        return String.class;
      case 2:
        return String.class;
      case 3:
        return String.class;
      case 4:
        return String.class;
      case 5:
        return String.class;
      case 6:
        return String.class;
      case 7:
        return String.class;
      case 8:
        return String.class;
      case 9:
        return String.class;
    }
    return null;
  }

}
