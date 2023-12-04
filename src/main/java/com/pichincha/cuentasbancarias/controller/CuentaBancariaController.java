package com.pichincha.cuentasbancarias.controller;

import com.pichincha.cuentasbancarias.dto.CuentaBancariaDTO;
import com.pichincha.cuentasbancarias.entity.CuentaBancaria;
import com.pichincha.cuentasbancarias.service.CuentaBancariaService;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
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
    public ResponseEntity<?> getBankAccount(@PathVariable("numberAccount") String numberAccount){
        var account = cuentaService.getAccountByNumber(numberAccount);
        return ResponseEntity.status(HttpStatus.OK).body(account);
    }

    @PostMapping
    public ResponseEntity<?> createAccount(@RequestBody CuentaBancariaDTO cuentaDTO){
        cuentaService.saveBankAccount(cuentaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Cuenta bancaria creada!");
    }

    @PutMapping("/{numberAccount}")
    public ResponseEntity<CuentaBancaria> updateBankAccount(@PathVariable("numberAccount") String numberAccount, @RequestBody CuentaBancariaDTO cuentaDTO ){
        var updatedAccount = cuentaService.updateBankAccount(numberAccount, cuentaDTO);
        return ResponseEntity.status(HttpStatus.OK).body(updatedAccount);
    }

    @DeleteMapping("/{id_bankAccount}")
    public ResponseEntity<?> deleteAccount(@PathVariable("id_bankAccount") String id_bankAccount) {
        cuentaService.deleteBankAccount(id_bankAccount);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
