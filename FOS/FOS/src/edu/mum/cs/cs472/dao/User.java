package edu.mum.cs.cs472.dao;

import java.util.Date;

public class User {
    private int user_id;
    private String first_name;
    private String last_name;
    private String email;
    private Role role;
    private Date created;
    private int status;
    private String password;

    public User() {
    }

    public User(String first_name, String email, Role role, Date created, int status, String password) {
        this.first_name = first_name;
        this.email = email;
        this.role = role;
        this.created = created;
        this.status = status;
        this.password = password;
    }

    public User(int user_id, String first_name, String last_name, String email, Role role, Date date, int status, String password) {
        this.user_id = user_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.role = role;
        this.created = date;
        this.status = status;
        this.password = password;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get.HI
     **/

    public boolean getHastUserId() {
        return this.getUser_id() != 0;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", created=" + created +
                ", status=" + status +
                ", password='" + password + '\'' +
                '}';
    }
}
