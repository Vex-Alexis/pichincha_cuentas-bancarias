package com.pichincha.cuentasbancarias.exception;

public class ExistingAccountException extends RuntimeException{

    public ExistingAccountException(){
        super("Una cuenta bancaria ya existe en el sistema.");
    }
}
