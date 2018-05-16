package edu.ijse.ftb.validation;

public class LoginWindowValidation {
    public static boolean isFieldsEmpty(String userName,String password){
        if(!(userName.equals("")&&password.equals(""))){
            return true;
        }
        return false;
    }
}
