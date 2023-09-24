package com.ps.jac16.services;

import com.ps.jac16.model.Cuenta;
import com.ps.jac16.model.Transferencia;
import com.ps.jac16.repository.CuentaRepository;
import com.ps.jac16.repository.TransferenciaRepository;
import net.bytebuddy.asm.Advice;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;
import java.math.BigDecimal;
import java.util.Optional;

@Service
public class TranferenciaServices {
    @Autowired
    CuentaRepository cuentaRepository;
    @Autowired
    TransferenciaRepository transferenciaRepository;
    public Transferencia save(Transferencia transferencia) throws Exception {
        Optional<Cuenta> cuentaEnvia = cuentaRepository.findByNumeroCuenta(transferencia.getCuentaOrigen().getNumeroCuenta());
        Optional<Cuenta> cuentaDestino = cuentaRepository.findByNumeroCuenta(transferencia.getCuentaDestino().getNumeroCuenta());

        if (cuentaEnvia.isPresent()) {
            throw new Exception("La cuenta que envía el dinero existe y se identifica con número:" + cuentaEnvia.get().getNumeroCuenta());
        }
        if (cuentaDestino.isPresent()) {
            throw new Exception("La cuenta destino existe y se identifica con número:" + cuentaDestino.get().getNumeroCuenta());
        }
        if (cuentaEnvia.get().getSaldo().compareTo(transferencia.getMonto()) < 0) {
            throw new Exception("Saldo insuficiente en la cuenta para realizar la transferencia, el saldo actual es: " + cuentaEnvia.get().getSaldo());
        }
        return transferenciaRepository.save(transferencia);
    }

    public Transferencia update(Transferencia transferencia) throws Exception {
        Optional<Cuenta> cuentaEnvia = cuentaRepository.findByNumeroCuenta(transferencia.getCuentaOrigen().getNumeroCuenta());
        Optional<Cuenta> cuentaDestino = cuentaRepository.findByNumeroCuenta(transferencia.getCuentaDestino().getNumeroCuenta());

        if (cuentaEnvia.isEmpty()) {
            throw new Exception("No existe una cuenta asociada al numero: " + cuentaEnvia.get().getNumeroCuenta());
        }
        if (cuentaDestino.isEmpty()) {
            throw new Exception("No existe una cuenta asociada al numero: " + cuentaDestino.get().getNumeroCuenta());
        }
        return transferenciaRepository.save(transferencia);
    }
}