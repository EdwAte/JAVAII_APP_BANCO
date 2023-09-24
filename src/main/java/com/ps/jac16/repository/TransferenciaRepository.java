package com.ps.jac16.repository;
import com.ps.jac16.model.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface TransferenciaRepository extends JpaRepository<Transferencia,Long> {
    Optional<Transferencia> findByNumeroTransferencia(Long id);
    Optional<Transferencia> findByNumeroTransferencia(String cuentaOrigen);


}
