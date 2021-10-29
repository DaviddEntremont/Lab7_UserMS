package models;

public class Role {
    
    private int roleid;
    private String rolename;

public Role() {
}

public Role(int Roleid) {
    
    this.roleid = Roleid;

    switch(Roleid) {
        case 1:
            this.rolename = "system admin";
           break;
            case 2:
            this.rolename = "regular user";
            break;
            case 3:
            this.rolename = "company admin";
            break;
            default:
}
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