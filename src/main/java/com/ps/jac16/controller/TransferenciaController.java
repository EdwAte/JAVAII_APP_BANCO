package com.ps.jac16.controller;

import com.ps.jac16.controller.model.ApiResponseMessage;
import com.ps.jac16.controller.model.HttpStatusMessages;
import com.ps.jac16.model.Transferencia;
import com.ps.jac16.services.TranferenciaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/transferencia")
public class TransferenciaController {

    @Autowired
    TranferenciaServices tranferenciaServices;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Transferencia transferencia){

        try {

            return ResponseEntity.ok().body(
                    ApiResponseMessage.builder()
                            .status(HttpStatusMessages.OK.getStatusCode())
                            .message(HttpStatusMessages.OK.getStatusMessage())
                            .data(tranferenciaServices.save(transferencia)).build());


        }catch (Exception e){
            return ResponseEntity.badRequest().body(
                    ApiResponseMessage.builder()
                            .status(HttpStatusMessages.BAD_REQUEST.getStatusCode())
                            .message(HttpStatusMessages.BAD_REQUEST.getStatusMessage())
                            .data(new ArrayList<>()).build());
        }
    }
    @GetMapping("/{numeroTransferencia}")
    public ResponseEntity<?> get( @PathVariable String numeroTransferencia){

        try {

            return ResponseEntity.ok().body(
                    ApiResponseMessage.builder()
                            .status(HttpStatusMessages.OK.getStatusCode())
                            .message(HttpStatusMessages.OK.getStatusMessage())
                            .data(tranferenciaServices.get(Long.parseLong(numeroTransferencia))).build());


        }catch (Exception e){
            return ResponseEntity.badRequest().body(
                    ApiResponseMessage.builder()
                            .status(HttpStatusMessages.BAD_REQUEST.getStatusCode())
                            .message(HttpStatusMessages.BAD_REQUEST.getStatusMessage())
                            .data(new ArrayList<>()).build());
        }
    }
    @DeleteMapping("/{numeroTransferencia}")
    public ResponseEntity<?> delete(@PathVariable String numeroTransferencia){

        return null;
    }

}