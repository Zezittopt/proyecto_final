-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS bd_viajes;

-- Seleccionar la base de datos
USE bd_viajes;

-- Crear la tabla de hoteles
CREATE TABLE IF NOT EXISTS hoteles (
    idHotel INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    categoria INT NOT NULL,
    precio DECIMAL(10, 2) NOT NULL,
    disponible ENUM('si', 'no') NOT NULL
);

-- Crear la tabla de vuelos
CREATE TABLE IF NOT EXISTS vuelos (
    idVuelo INT AUTO_INCREMENT PRIMARY KEY,
    compania VARCHAR(255) NOT NULL,
    fechaVuelo DATE NOT NULL,
    precio DECIMAL(10, 2) NOT NULL,
    plazasDisponibles INT NOT NULL
);

-- Crear la tabla de reservas
CREATE TABLE IF NOT EXISTS reservas (
    idReserva INT AUTO_INCREMENT PRIMARY KEY,
    nombreCliente VARCHAR(255) NOT NULL,
    dni VARCHAR(20) NOT NULL,
    idHotel INT,
    idVuelo INT,
    FOREIGN KEY (idHotel) REFERENCES hoteles(idHotel),
    FOREIGN KEY (idVuelo) REFERENCES vuelos(idVuelo)
);

-- Insertamos valores en hoteles

INSERT INTO hoteles (nombre, categoria, precio, disponible) VALUES
('Hotel Hilton', 5, 400.00, 'si'),
('Hotel Four Seasons', 5, 300.00, 'no'),
('Hotel Ibis', 3, 100.00, 'si');

-- Insertamos valores en vuelos

INSERT INTO vuelos (compania, fechaVuelo, precio, plazasDisponibles) VALUES
('Ryanair', '2023-10-10', 50.00, 50),
('Arabia Airs', '2023-11-05', 250.00, 30),
('Seoul Airlines', '2023-12-20', 400.00, 20);

-- Insertamos valores en reservas

INSERT INTO reservas (nombreCliente, dni, idHotel, idVuelo) VALUES
('Juan Pérez', '12345678A', 1, 1),
('María Gómez', '98765432B', 2, 2),
('Carlos Ruiz', '65432178C', 3, 3);


