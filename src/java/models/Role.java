package models;

public class Role {
    
    private int roleid;
    private String rolename;

public Role() {
}

public Role(int Roleid, String Rolename) {
    
    this.roleid = Roleid;
    this.rolename = Rolename;

    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}