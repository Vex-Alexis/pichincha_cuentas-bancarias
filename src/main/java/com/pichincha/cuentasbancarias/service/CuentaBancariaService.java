package com.pichincha.cuentasbancarias.service;

import com.pichincha.cuentasbancarias.dto.CuentaBancariaDTO;
import com.pichincha.cuentasbancarias.entity.CuentaBancaria;
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
                .orElseThrow(()-> new NotFoundException(id));
    }

    public CuentaBancaria getAccountByNumber(String numberAccount){
        return cuentaBancariaRepository.findByNumeroCuenta(numberAccount)
                .orElseThrow(()-> new NotFoundException(numberAccount));
    }

    public  CuentaBancaria saveBankAccount(CuentaBancariaDTO cuentaDTO){

        CuentaBancaria cuentaBancaria = new CuentaBancaria();

        cuentaBancaria.setId_Cuenta(cuentaDTO.getId_Cuenta());
        cuentaBancaria.setNumeroCuenta(cuentaDTO.getNumeroCuenta());
        cuentaBancaria.setTipoCuenta(cuentaDTO.getTipoCuenta());
        cuentaBancaria.setNombreTitular(cuentaDTO.getNombreTitular());
        cuentaBancaria.setSaldo(cuentaDTO.getSaldo());

        //TODO: Transformar a DTO o hacer VOID y generar respuesta personalizada en Controller
        return cuentaBancariaRepository.save(cuentaBancaria);
    }

    public  CuentaBancaria updateBankAccount(CuentaBancariaDTO cuentaDTO){

        CuentaBancaria cuentaBancaria = cuentaBancariaRepository.findById(cuentaDTO.getId_Cuenta())
                .orElseThrow(()-> new NotFoundException(cuentaDTO.getId_Cuenta()));

        cuentaBancaria.setNumeroCuenta(cuentaDTO.getNumeroCuenta());
        cuentaBancaria.setTipoCuenta(cuentaDTO.getTipoCuenta());
        cuentaBancaria.setNombreTitular(cuentaDTO.getNombreTitular());
        cuentaBancaria.setSaldo(cuentaDTO.getSaldo());

        return cuentaBancariaRepository.save(cuentaBancaria);
    }

    public void deleteBankAccount(String id_bankAccount){
        cuentaBancariaRepository.deleteById(id_bankAccount);
    }

    public boolean existsByNumeroCuenta(String numeroCuenta){
        return cuentaBancariaRepository.existsByNumeroCuenta(numeroCuenta);
    }


}
