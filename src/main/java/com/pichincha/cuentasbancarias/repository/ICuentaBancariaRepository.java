package com.pichincha.cuentasbancarias.repository;

import com.pichincha.cuentasbancarias.entity.CuentaBancaria;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableScan
@Repository
public interface ICuentaBancariaRepository extends CrudRepository<CuentaBancaria, String> {
    boolean existsByNumeroCuenta(String numeroCuenta);

    Optional<CuentaBancaria> findByNumeroCuenta(String numberAccount);

}
