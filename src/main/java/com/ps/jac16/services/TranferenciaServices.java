package com.ps.jac16.services;

import com.ps.jac16.model.Cuenta;
import com.ps.jac16.model.Transferencia;
import com.ps.jac16.repository.CuentaRepository;
import com.ps.jac16.repository.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

@Service
public class TranferenciaServices {
    @Autowired
    CuentaRepository cuentaRepository;
    @Autowired
    TransferenciaRepository transferenciaRepository;
    public Transferencia save(Transferencia transferencia) throws Exception {
        Cuenta cuentaOrigen = cuentaRepository.findByNumeroCuenta(transferencia.getCuentaOrigen().getNumeroCuenta());
        Cuenta cuentaTransferencia = cuentaRepository.findByNumeroCuenta(transferencia.getCuentaDestino().getNumeroCuenta());

        if (cuentaOrigen==null) {
            throw new Exception("La cuenta que envía el dinero no existe y se identifica con número:" + transferencia.getCuentaOrigen().getNumeroCuenta());
        }
        if (cuentaTransferencia==null) {
            throw new Exception("La cuenta destino existe y se identifica con número:" + transferencia.getCuentaDestino().getNumeroCuenta());
        }
        if (!StringUtils.isNumeric(transferencia.getCuentaOrigen().getNumeroCuenta()) || !StringUtils.isNumeric(transferencia.getCuentaDestino().getNumeroCuenta())){
            throw new Exception("Las cuentas deben ser númericas");
        }
        if (cuentaOrigen.getSaldo().compareTo(transferencia.getMonto()) < 0) {
            throw new Exception("Saldo insuficiente en la cuenta para realizar la transferencia, el saldo actual es: " + cuentaEnvia.getSaldo());
        }
        return transferenciaRepository.save(transferencia);
    }

    public Transferencia get (Long idTransferencia) throws Exception {
        return transferenciaRepository.findById(idTransferencia).get();
    }
    public void delete (Transferencia transferencia){ transferenciaRepository.delete(transferencia);

    }
}