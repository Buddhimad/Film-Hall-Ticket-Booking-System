
package edu.ijse.ftb.dto;

import java.io.Serializable;



public class CustomerDTO  extends SuperDTO{
    private String cid,name,email;
    private int mobnum;
    private CustomerDTO customerdto;
    public CustomerDTO() {
    }

    public CustomerDTO(String cid, String name, String email, int mobnum) {
        this.cid = cid;
        this.name = name;
        this.email = email;
        this.mobnum = mobnum;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMobnum() {
        return mobnum;
    }

    public void setMobnum(int mobnum) {
        this.mobnum = mobnum;
    }

    public CustomerDTO getCustomerdto() {
        return customerdto;
    }

    public void setCustomerdto(CustomerDTO customerdto) {
        this.customerdto = customerdto;
    }

    
}
