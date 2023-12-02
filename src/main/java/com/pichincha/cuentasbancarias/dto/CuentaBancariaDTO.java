package com.pichincha.cuentasbancarias.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CuentaBancariaDTO {

    private String id_Cuenta;
    private String numeroCuenta;
    private String tipoCuenta;
    private String nombreTitular;
    private BigDecimal saldo;


    public String getId_Cuenta() {
        return id_Cuenta;
    }
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}
