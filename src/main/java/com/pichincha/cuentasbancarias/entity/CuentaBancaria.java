package com.pichincha.cuentasbancarias.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@DynamoDBTable(tableName = "pichincha_CuentasBancarias")
public class CuentaBancaria {

    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    private String id_cuentaBancaria;
    @DynamoDBAttribute
    private String numeroCuenta;
    @DynamoDBAttribute
    private String tipoCuenta;
    @DynamoDBAttribute
    private String nombreTitular;
    @DynamoDBAttribute
    private BigDecimal saldo;


    // Getter & Setter
    public String getId_Cuenta() {
        return id_cuentaBancaria;
    }

    public void setId_Cuenta(String id_Cuenta) {
        this.id_cuentaBancaria = id_Cuenta;
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
