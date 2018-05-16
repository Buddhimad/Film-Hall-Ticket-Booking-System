package edu.ijse.ftb.validation;

public class RecoverPasswordValidation {
    public static boolean isFilled(String txtUID,String txtnewPassword,String txtconfirmPassword){
        if(!(txtUID.equals("")&&txtnewPassword.equals("")&&txtconfirmPassword.equals(""))){
             return true;
        }
        return false;
    }
}
