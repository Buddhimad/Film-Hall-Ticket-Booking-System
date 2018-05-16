package edu.ijse.ftb.validation;

public class SettingsValidation {
    public static boolean matcher(String email){
        if(email.matches( "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")){
            return true;
        }
        return false;
    }
    public static boolean checkFields(String un,String p,String cp,String id,String nic,String pn,String em){
        if(!(un.equals("")&&p.equals("")&&cp.equals("")&&id.equals("")&&nic.equals("")&&pn.equals("")&&em.equals(""))){
            return true;
        }
        return false;
    }
}
