package com.pichincha.cuentasbancarias.controller;

import com.pichincha.cuentasbancarias.dto.CuentaBancariaDTO;
import com.pichincha.cuentasbancarias.entity.CuentaBancaria;
import com.pichincha.cuentasbancarias.service.CuentaBancariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/bankAccount")
public class CuentaBancariaController {

    private final CuentaBancariaService cuentaService;

    @Autowired
    public CuentaBancariaController(CuentaBancariaService cuentaService){
        this.cuentaService = cuentaService;
    }

    @GetMapping
    public ResponseEntity<Iterable<CuentaBancaria>> ListBankAccounts(){
        var listAccounts = cuentaService.listaCuentasBancarias();
        return ResponseEntity.status(HttpStatus.OK).body(listAccounts);
    }

    @GetMapping("/{numberAccount}")
    public ResponseEntity<CuentaBancaria> getBankAccount(@PathVariable("numberAccount") String numberAccount){
        var account = cuentaService.getAccountByNumber(numberAccount);
        return ResponseEntity.status(HttpStatus.OK).body(account);
    }

    @PostMapping
    public ResponseEntity<?> createAccount(@RequestBody CuentaBancariaDTO cuentaDTO){
        var account = cuentaService.saveBankAccount(cuentaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(account);
    }


}
