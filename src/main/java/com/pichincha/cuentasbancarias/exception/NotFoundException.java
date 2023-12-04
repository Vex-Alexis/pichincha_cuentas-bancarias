package com.pichincha.cuentasbancarias.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(){
        super("Registro no encontrado.");
    }

}
