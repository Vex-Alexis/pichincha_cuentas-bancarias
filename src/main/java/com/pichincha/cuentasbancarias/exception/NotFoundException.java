package com.pichincha.cuentasbancarias.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String id){
        super("Registro con ID: " + id + "no encontrado.");
    }

}
