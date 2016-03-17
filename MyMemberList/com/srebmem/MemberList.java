package com.srebmem;

import java.sql.*;
import java.util.*;

public class MemberList {
  ArrayList<Member> members;

  public MemberList() {
    members = new ArrayList<Member>();
    getMembersFromDatabase();
  }

  private void getMembersFromDatabase() {
    MemberDatabase md = new MemberDatabase();
    Member m = null;
    Connection c = md.createConnection();
    try {
      Statement st = c.createStatement();
      String sql = "SELECT medlem.id,givenName,familyName,email,gender,birth,"+
      "membersince,active,role,team FROM medlem INNER JOIN funktion"+
      " ON medlem.id=funktion.id;";

      ResultSet rs = st.executeQuery(sql);

      while(rs.next()) {
        members.add(new Member(
          rs.getInt("id"),
          rs.getString("givenName"),
          rs.getString("familyName"),
          rs.getString("email"),
          rs.getString("gender"),
          rs.getString("birth"),
          rs.getString("memberSince"),
          rs.getInt("active"),
          rs.getInt("role"),
          rs.getString("team")));
      }
      rs.close();

    } catch (Exception e) {
      System.out.println(e);
    }
  }
  public ArrayList<Member> getMemberList() { return members; }
  
}
