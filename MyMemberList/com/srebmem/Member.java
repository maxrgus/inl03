package com.srebmem;

import java.util.*;

public class Member {
  private int id;
  private String givenName;
  private String familyName;
  private String email;
  private String gender;
  private String birth;
  private String memberSince;
  private int active;
  private int role;
  private String team;

  public Member(int id,String givenName,String familyName,String email,
                String gender,String birth,String memberSince,int active,
                int role,String team) {
    this.id = id;
    this.givenName = givenName;
    this.familyName = familyName;
    this.email = email;
    this.gender = gender;
    this.birth = birth;
    this.memberSince = memberSince;
    this.active = active;
    this.role = role;
    this.team = team;

  }
  @Override
  public String toString() {
    return id + givenName + familyName + email + gender + birth + memberSince +
           active + role + team;
  }
  public int getId() { return id; }
  public String getGivenName() { return givenName; }
  public String getFamilyName() { return familyName; }
  public String getEmail() { return email; }
  public String getGender() { return gender; }
  public String getBirthday() { return birth; }
  public String getMemberSince() { return memberSince; }
  public int getActive() { return active; }
  public int getRole() { return role; }
  public String getTeam() { return team; }

  public String getActiveActual() {
    String actualActive = "Inactive";
    if (active==1) {
      actualActive = "Active";
    }
    return actualActive;
  }
  public String getRoleActual() {
    String actualRole = "Player";

    if (role==1) {
      actualRole = "Coach";
    }
    if (role==2) {
      actualRole = "Parent";
    }
    return actualRole;
  }
}
