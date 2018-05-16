package edu.ijse.ftb.dto;

public class UserDTO extends SuperDTO {

    private String userName, password, confirmPassword, uid, nic, email, phonenumber;

    public UserDTO() {
    }

    public UserDTO(String userName, String password, String confirmPassword, String uid, String nic, String email, String phonenumber) {
        this.userName = userName;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.uid = uid;
        this.nic = nic;
        this.email = email;
        this.phonenumber = phonenumber;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
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

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
