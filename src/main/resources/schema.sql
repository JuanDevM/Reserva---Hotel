CREATE TABLE IF NOT EXISTS
hotel_reservas(
    id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR2(120),
    direccion VARCHAR2(200),
    telefono  VARCHAR2(25),
    tipo VARCHAR2(50),
    PRIMARY KEY (id));

INSERT INTO hotel_reservas (nombre,direccion, telefono, tipo ) VALUES ('Belfort','Calle 40 sur avenida el poblado','1041234568','1 Estrellas');
INSERT INTO hotel_reservas (nombre,direccion, telefono, tipo ) VALUES ('Dann Carlton','Calle 31 sur avenida el poblado','2041234568','2 Estrellas');
INSERT INTO hotel_reservas (nombre,direccion, telefono, tipo ) VALUES ('Nutibara','Calle 30 Norte','3041234568','3 Estrellas');
INSERT INTO hotel_reservas (nombre,direccion, telefono, tipo ) VALUES ('Vitta','Calle 30 Centro','4041234568','4 Estrellas');
INSERT INTO hotel_reservas (nombre,direccion, telefono, tipo ) VALUES ('Ibis','Calle 37 Sur','5041234568','5 Estrellas');
INSERT INTO hotel_reservas (nombre,direccion, telefono, tipo ) VALUES ('Ayacucho','Calle 35 Centro','6041234568','6 Estrellas');
INSERT INTO hotel_reservas (nombre,direccion, telefono, tipo ) VALUES ('Palma Centro','Calle 22 Centro','7041234568','7 Estrellas');
INSERT INTO hotel_reservas (nombre,direccion, telefono, tipo ) VALUES ('Rosales','Calle 14 Centro','8041234568','8 Estrellas');
INSERT INTO hotel_reservas (nombre,direccion, telefono, tipo ) VALUES ('Plaza Center','Calle 10 Centro','9041234568','9 Estrellas');
INSERT INTO hotel_reservas (nombre,direccion, telefono, tipo ) VALUES ('Manantiales','Calle 5 Norte','3041234568','5 Estrellas');


CREATE TABLE IF NOT EXISTS
clientes_reservas(
    id INT NOT NULL AUTO_INCREMENT,
    documento VARCHAR2(120),
    celular VARCHAR2(120),
    nombre VARCHAR2(120),
    direccion VARCHAR2(200),
    correo VARCHAR2(200),
    PRIMARY KEY (id));

INSERT INTO clientes_reservas (documento,celular, nombre, direccion, correo ) VALUES ('1234567','3001234567','Karol G','calle 89 # 67- 89','Marcela789@gmail.com');
INSERT INTO clientes_reservas (documento,celular, nombre, direccion, correo ) VALUES ('2234567','3002234567','Chespirito Pererira','calle 90 # 67- 89','Catalina789@gmail.com');
INSERT INTO clientes_reservas (documento,celular, nombre, direccion, correo ) VALUES ('3234567','3003234567','Kiko Cadavid','calle 91 # 91- 89','Luz789@gmail.com');
INSERT INTO clientes_reservas (documento,celular, nombre, direccion, correo ) VALUES ('4234567','3004234567','Chavo Alonso','calle 92 # 67- 89','Andres789@gmail.com');
INSERT INTO clientes_reservas (documento,celular, nombre, direccion, correo ) VALUES ('5234567','3005234567','Madona Cadavid','calle 93 # 67- 89','Maria789@gmail.com');
INSERT INTO clientes_reservas (documento,celular, nombre, direccion, correo ) VALUES ('6234567','3006234567','Pedro Ruiz Ramirez','calle 94 # 67- 89','Pedro789@gmail.com');
INSERT INTO clientes_reservas (documento,celular, nombre, direccion, correo ) VALUES ('7234567','3007234567','Ramon Valdes','calle 95 # 67- 89','Ramon789@gmail.com');
INSERT INTO clientes_reservas (documento,celular, nombre, direccion, correo ) VALUES ('8234567','3008234567','Esteban Botero Mejia','calle 96 # 67- 89','Esteban789@gmail.com');
INSERT INTO clientes_reservas (documento,celular, nombre, direccion, correo ) VALUES ('9234567','3009234567','Juan Rodriguez Ruiz','calle 97 # 67- 89','Juan789@gmail.com');
INSERT INTO clientes_reservas (documento,celular, nombre, direccion, correo ) VALUES ('1234567','3006234567','Chapulin Salazar Botero','calle 98 # 67- 89','Estela789@gmail.com');

CREATE TABLE IF NOT EXISTS
habitacion_reservas(
    id INT NOT NULL AUTO_INCREMENT,
    codigoHabitacion VARCHAR2(120),
    tipoHabitacion VARCHAR2(200),
    PRIMARY KEY (id));

INSERT INTO habitacion_reservas (codigoHabitacion,tipoHabitacion ) VALUES ('LUNA001','Suite Basica');
INSERT INTO habitacion_reservas (codigoHabitacion,tipoHabitacion ) VALUES ('LUNA002','Suite Sencilla');
INSERT INTO habitacion_reservas (codigoHabitacion,tipoHabitacion ) VALUES ('LUNA003','Suite Premium');
INSERT INTO habitacion_reservas (codigoHabitacion,tipoHabitacion ) VALUES ('LUNA004','Suite Mixta');
INSERT INTO habitacion_reservas (codigoHabitacion,tipoHabitacion ) VALUES ('LUNA005','Suite Celebracion');
INSERT INTO habitacion_reservas (codigoHabitacion,tipoHabitacion ) VALUES ('LUNA006','Suite Party');
INSERT INTO habitacion_reservas (codigoHabitacion,tipoHabitacion ) VALUES ('LUNA007','Suite Eventos');
INSERT INTO habitacion_reservas (codigoHabitacion,tipoHabitacion ) VALUES ('LUNA008','Suite Tematica');
INSERT INTO habitacion_reservas (codigoHabitacion,tipoHabitacion ) VALUES ('LUNA009','Suite Preferencial');
INSERT INTO habitacion_reservas (codigoHabitacion,tipoHabitacion ) VALUES ('LUNA012','Suite Presidencial');


CREATE TABLE  IF NOT EXISTS
reserva_hotel(
    id INT NOT NULL AUTO_INCREMENT,
    idhotel INT NOT NULL,
    idhabitacion  INT NOT NULL,
    cedulareserva VARCHAR2(15),
    fechainicioReserva DATE NOT NULL,
    fechafinReserva DATE NOT NULL,
    valor DECIMAL(20,2) NOT NULL,
    estado VARCHAR2(10),
    --FOREIGN KEY (id) REFERENCES hotel(id)
    PRIMARY KEY (id));

INSERT INTO reserva_hotel (idhotel,idhabitacion,cedulareserva,fechainicioReserva, fechafinReserva,valor,estado) VALUES (1,1,'89.255.963','2023-12-01','2023-12-03',1000000,'Disponible');
INSERT INTO reserva_hotel (idhotel,idhabitacion,cedulareserva,fechainicioReserva, fechafinReserva,valor,estado) VALUES (1,2,'90.255.963','2023-12-02','2023-12-04',1000000,'Disponible');
INSERT INTO reserva_hotel (idhotel,idhabitacion,cedulareserva,fechainicioReserva, fechafinReserva,valor,estado) VALUES (2,3,'91.255.963','2023-12-03','2023-12-05',1000000,'Disponible');
INSERT INTO reserva_hotel (idhotel,idhabitacion,cedulareserva,fechainicioReserva, fechafinReserva,valor,estado) VALUES (2,4,'92.255.963','2023-12-04','2023-12-06',1000000,'Disponible');
INSERT INTO reserva_hotel (idhotel,idhabitacion,cedulareserva,fechainicioReserva, fechafinReserva,valor,estado) VALUES (3,5,'93.255.963','2023-12-05','2023-12-07',1000000,'Disponible');
INSERT INTO reserva_hotel (idhotel,idhabitacion,cedulareserva,fechainicioReserva, fechafinReserva,valor,estado) VALUES (3,6,'94.255.963','2023-12-06','2023-12-08',1000000,'Disponible');
INSERT INTO reserva_hotel (idhotel,idhabitacion,cedulareserva,fechainicioReserva, fechafinReserva,valor,estado) VALUES (4,7,'95.255.963','2023-12-07','2023-12-09',1000000,'Disponible');
INSERT INTO reserva_hotel (idhotel,idhabitacion,cedulareserva,fechainicioReserva, fechafinReserva,valor,estado) VALUES (4,8,'96.255.963','2023-12-08','2023-12-10',1000000,'Disponible');
INSERT INTO reserva_hotel (idhotel,idhabitacion,cedulareserva,fechainicioReserva, fechafinReserva,valor,estado) VALUES (6,9,'97.255.963','2023-12-09','2023-12-11',1000000,'Disponible');
INSERT INTO reserva_hotel (idhotel,idhabitacion,cedulareserva,fechainicioReserva, fechafinReserva,valor,estado) VALUES (6,10,'98.255.963','2023-12-10','2023-12-12',1000000,'Disponible');

