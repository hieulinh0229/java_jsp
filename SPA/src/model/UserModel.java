package model;

public class UserModel {

    private int id;
    private String userName;
    private String password;
    private String fullName;
    private int status;
    private int roleId;
    private RoleModel role = new RoleModel();

    public UserModel() {
    }

    public UserModel(int id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public UserModel(String userName, String password, String fullName) {
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
    }

    public UserModel(String userName, String password, String fullName, int status, int roleId) {
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.status = status;
        this.roleId = roleId;
    }

    public UserModel(int id, String userName, String password, String fullName, int status, int roleId) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.status = status;
        this.roleId = roleId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public RoleModel getRole() {
        return role;
    }

    public void setRole(RoleModel role) {
        this.role = role;
    }

}
