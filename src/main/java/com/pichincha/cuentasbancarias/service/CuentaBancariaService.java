package com.pichincha.cuentasbancarias.service;

import com.pichincha.cuentasbancarias.dto.CuentaBancariaDTO;
import com.pichincha.cuentasbancarias.entity.CuentaBancaria;
import com.pichincha.cuentasbancarias.exception.ExistingAccountException;
import com.pichincha.cuentasbancarias.exception.NotFoundException;
import com.pichincha.cuentasbancarias.repository.ICuentaBancariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CuentaBancariaService {

    public final ICuentaBancariaRepository cuentaBancariaRepository;

    @Autowired
    public CuentaBancariaService(ICuentaBancariaRepository cuentaBancariaRepository){
        this.cuentaBancariaRepository = cuentaBancariaRepository;
    }


    public Iterable<CuentaBancaria> listaCuentasBancarias(){
        return cuentaBancariaRepository.findAll();
    }

    public CuentaBancaria getAccountById(String id){
        return cuentaBancariaRepository.findById(id)
                .orElseThrow(NotFoundException::new);
    }

    public CuentaBancaria getAccountByNumber(String numberAccount){
        return cuentaBancariaRepository.findByNumeroCuenta(numberAccount)
                .orElseThrow(NotFoundException::new);
    }

    public  void saveBankAccount(CuentaBancariaDTO cuentaDTO){

        // Validaciones
        if (existsByNumeroCuenta(cuentaDTO.getNumeroCuenta())){
            throw new ExistingAccountException();
        }

        CuentaBancaria cuentaBancaria = new CuentaBancaria();

        cuentaBancaria.setNumeroCuenta(cuentaDTO.getNumeroCuenta());
        cuentaBancaria.setTipoCuenta(cuentaDTO.getTipoCuenta());
        cuentaBancaria.setNombreTitular(cuentaDTO.getNombreTitular());
        cuentaBancaria.setSaldo(cuentaDTO.getSaldo());

        cuentaBancariaRepository.save(cuentaBancaria);
    }

    public  CuentaBancaria updateBankAccount(String numberAccount, CuentaBancariaDTO cuentaDTO){

        var existingAccount = getAccountByNumber(numberAccount);

        // Datos permitidos para actualizar
        existingAccount.setTipoCuenta(cuentaDTO.getTipoCuenta());
        existingAccount.setNombreTitular(cuentaDTO.getNombreTitular());
        existingAccount.setSaldo(cuentaDTO.getSaldo());

        return cuentaBancariaRepository.save(existingAccount);
    }

    public void deleteBankAccount(String id_bankAccount){
        cuentaBancariaRepository.deleteById(id_bankAccount);
    }

    public boolean existsByNumeroCuenta(String numeroCuenta){
        if(cuentaBancariaRepository.existsByNumeroCuenta(numeroCuenta)){
            return true;
        }
        return false;
    }




}
