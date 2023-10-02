package com.ps.jac16.controller;

import com.ps.jac16.controller.model.ApiResponseMessage;
import com.ps.jac16.controller.model.HttpStatusMessages;
import com.ps.jac16.model.Cuenta;
import com.ps.jac16.services.CuentaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {

    @Autowired
    CuentaServices cuentaServices;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Cuenta cuenta){
        try {

            return ResponseEntity.ok().body(
                    ApiResponseMessage.builder()
                            .status(HttpStatusMessages.OK.getStatusCode())
                            .message(HttpStatusMessages.OK.getStatusMessage())
                            .data(cuentaServices.save(cuenta)).build());


        }catch (Exception e){
            return ResponseEntity.badRequest().body(
                    ApiResponseMessage.builder()
                            .status(HttpStatusMessages.BAD_REQUEST.getStatusCode())
                            .message(HttpStatusMessages.BAD_REQUEST.getStatusMessage())
                            .data(new ArrayList<>()).build());
        }
    }
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Cuenta cuenta){

        try {

            return ResponseEntity.ok().body(
                    ApiResponseMessage.builder()
                            .status(HttpStatusMessages.OK.getStatusCode())
                            .message(HttpStatusMessages.OK.getStatusMessage())
                            .data(cuentaServices.save(cuenta)).build());


        }catch (Exception e){
            return ResponseEntity.badRequest().body(
                    ApiResponseMessage.builder()
                            .status(HttpStatusMessages.BAD_REQUEST.getStatusCode())
                            .message(HttpStatusMessages.BAD_REQUEST.getStatusMessage())
                            .data(new ArrayList<>()).build());
        }

    }
    @GetMapping("/{numeroCuenta}")
    public ResponseEntity<?> get( @PathVariable String numeroCuenta){

        try {

            return ResponseEntity.ok().body(
                    ApiResponseMessage.builder()
                            .status(HttpStatusMessages.OK.getStatusCode())
                            .message(HttpStatusMessages.OK.getStatusMessage())
                            .data(cuentaServices.get(numeroCuenta)).build());


        }catch (Exception e){
            return ResponseEntity.badRequest().body(
                    ApiResponseMessage.builder()
                            .status(HttpStatusMessages.BAD_REQUEST.getStatusCode())
                            .message(HttpStatusMessages.BAD_REQUEST.getStatusMessage())
                            .data(new ArrayList<>()).build());
        }

    }
    @DeleteMapping("/{numeroCuenta}")
    public ResponseEntity<?> delete(@PathVariable String numeroCuenta){

        try {

            return ResponseEntity.ok().body(
                    ApiResponseMessage.builder()
                            .status(HttpStatusMessages.OK.getStatusCode())
                            .message(HttpStatusMessages.OK.getStatusMessage())
                            .data(cuentaServices.delete(numeroCuenta)).build());


        }catch (Exception e){
            return ResponseEntity.badRequest().body(
                    ApiResponseMessage.builder()
                            .status(HttpStatusMessages.BAD_REQUEST.getStatusCode())
                            .message(HttpStatusMessages.BAD_REQUEST.getStatusMessage())
                            .data(new ArrayList<>()).build());
        }

    }

}