package com.pichincha.cuentasbancarias.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CuentaBancariaDTO {

    //private String id_cuentaBancaria;
    private String numeroCuenta;
    private String tipoCuenta;
    private String nombreTitular;
    private BigDecimal saldo;


}
