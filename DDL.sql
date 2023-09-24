-- Crear la tabla de cuentas
CREATE TABLE cuenta (
    id SERIAL PRIMARY KEY,
    numero_cuenta VARCHAR(20) NOT NULL,
    saldo DECIMAL(10, 2) NOT NULL,
    estado boolean
);

-- Insertar datos de muestra en la tabla de cuentas
INSERT INTO cuenta (numero_cuenta, saldo) VALUES
    ('123456789', 1000.00),
    ('987654321', 2500.00);

-- Crear la tabla de transferencias
CREATE TABLE transferencia (
    id SERIAL PRIMARY KEY,
    cuenta_origen_id INTEGER REFERENCES cuenta(id),
    cuenta_destino_id INTEGER REFERENCES cuenta(id),
    monto DECIMAL(10, 2) NOT NULL,
    estado boolean,
    fecha_transferencia TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


-- Insertar una transferencia de muestra
INSERT INTO transferencia (cuenta_origen_id, cuenta_destino_id, monto) VALUES
    (1, 2, 500.00);
commit;