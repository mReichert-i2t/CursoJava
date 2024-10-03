CREATE TABLE TIPO_USUARIO(
	ID INTEGER PRIMARY KEY AUTO_INCREMENT,
	NOMBRE VARCHAR(50) NOT NULL
); 

CREATE TABLE USUARIO(
	ID BIGINT PRIMARY KEY AUTO_INCREMENT,
	USERNAME VARCHAR(50) NOT NULL,
	EMAIL VARCHAR(100) NOT NULL,
	PASSWORD VARCHAR(255) NOT NULL,
	NOMBRE VARCHAR(100) NOT NULL,
	APELLIDO VARCHAR(100) NOT NULL,
	FECHA_NACIMIENTO DATE NOT NULL,
	FECHA_CREACION DATETIME NOT NULL,
	FECHA_MODIFICACION DATETIME DEFAULT NULL
);

CREATE TABLE USUARIO_TIPO_USUARIO( 
	ID_TIPO_USUARIO INTEGER NOT NULL,
	ID_USUARIO BIGINT NOT NULL,
	PRIMARY KEY(ID_TIPO_USUARIO, ID_USUARIO),
	FOREIGN KEY(ID_TIPO_USUARIO) REFERENCES TIPO_USUARIO(ID),
	FOREIGN KEY(ID_USUARIO) REFERENCES USUARIO(ID)
);

CREATE TABLE TIPO_HOSPEDAJE(
	ID INTEGER PRIMARY KEY AUTO_INCREMENT,
	NOMBRE VARCHAR(50) NOT NULL
);

CREATE TABLE PAIS(
	ID INTEGER PRIMARY KEY AUTO_INCREMENT,
	NOMBRE VARCHAR(50) NOT NULL
);

CREATE TABLE CIUDAD(
	ID INTEGER PRIMARY KEY AUTO_INCREMENT,
	NOMBRE VARCHAR(50) NOT NULL,
	ID_PAIS INTEGER NOT NULL,
	FOREIGN KEY(ID_PAIS) REFERENCES PAIS(ID)
);

CREATE TABLE SERVICIO(
	ID INTEGER PRIMARY KEY AUTO_INCREMENT,
	NOMBRE VARCHAR(50) NOT NULL
);

CREATE TABLE HOSPEDAJE(
	ID BIGINT PRIMARY KEY AUTO_INCREMENT,
	DESCRIPCION VARCHAR(100) NOT NULL,
	IMAGEN VARCHAR(255),
	PRECIO_POR_NOCHE NUMERIC(8,2) NOT NULL,
	FECHA_CREACION DATETIME NOT NULL,
	FECHA_MODIFICACION DATETIME NOT NULL,
	ID_TIPO_HOSPEDAJE INTEGER NOT NULL,
	ID_CIUDAD INTEGER NOT NULL,
	FOREIGN KEY(ID_TIPO_HOSPEDAJE) REFERENCES TIPO_HOSPEDAJE(ID),
	FOREIGN KEY(ID_CIUDAD) REFERENCES CIUDAD(ID)
);

CREATE TABLE SERVICIO_HOSPEDAJE(
	ID_SERVICIO INTEGER NOT NULL,
	ID_HOSPEDAJE BIGINT NOT NULL,
	PRIMARY KEY(ID_SERVICIO, ID_HOSPEDAJE),
	FOREIGN KEY(ID_SERVICIO) REFERENCES SERVICIO(ID),
	FOREIGN KEY(ID_HOSPEDAJE) REFERENCES HOSPEDAJE(ID)
);

CREATE TABLE RESERVA(
	ID_HOSPEDAJE BIGINT NOT NULL,
	ID_USUARIO BIGINT NOT NULL,
	FECHA_CHECK_IN DATE NOT NULL,
	FECHA_CHECK_OUT DATE NOT NULL,
	CANT_NIÑOS NUMERIC(2,0) DEFAULT 0,
	CANT_ADULTOS NUMERIC(2,0) DEFAULT 0,
	CANT_BEBES NUMERIC(2,0) DEFAULT 0,
	CANT_MASCOTAS NUMERIC(2,0) DEFAULT 0,
	IMPORTE_TOTAL NUMERIC(10,2) NOT NULL,
	FECHA_CREACION DATETIME NOT NULL,
	FECHA_MODIFICACION DATETIME DEFAULT NULL,
	PRIMARY KEY(ID_HOSPEDAJE, ID_USUARIO),
	FOREIGN KEY(ID_HOSPEDAJE) REFERENCES HOSPEDAJE(ID),
	FOREIGN KEY(ID_USUARIO) REFERENCES USUARIO(ID)
);

INSERT INTO TIPO_USUARIO (NOMBRE) VALUES
('ADMINISTRADOR'), ('INQUILINO'), ('ANFITRION');

INSERT INTO TIPO_HOSPEDAJE (NOMBRE) VALUES
('CASA'), ('DEPARTAMENTO'), ('CABAÑA'), ('HOTEL'), ('CASA DE HUSPEDES'), ('MANSION'), ('DOMO');

INSERT INTO PAIS (NOMBRE) 
VALUES 
    ('Francia'),
    ('España'),
    ('Estados Unidos'),
    ('China'),
    ('Italia'),
    ('Turquía'),
    ('México'),
    ('Tailandia'),
    ('Alemania'),
    ('Reino Unido');

INSERT INTO CIUDAD (NOMBRE, ID_PAIS) VALUES
    -- Ciudades de Francia
    ('París', 1),
    ('Marsella', 1),
    ('Lyon', 1),
    ('Toulouse', 1),
    ('Niza', 1),
    ('Nantes', 1),
    ('Estrasburgo', 1),
    ('Montpellier', 1),
    ('Burdeos', 1),
    ('Lille', 1),

    -- Ciudades de España
    ('Madrid', 2),
    ('Barcelona', 2),
    ('Valencia', 2),
    ('Sevilla', 2),
    ('Zaragoza', 2),
    ('Málaga', 2),
    ('Bilbao', 2),
    ('Las Palmas de Gran Canaria', 2),
    ('Palma de Mallorca', 2),
    ('Alicante', 2),

    -- Ciudades de Estados Unidos
    ('Nueva York', 3),
    ('Los Ángeles', 3),
    ('Chicago', 3),
    ('Houston', 3),
    ('Phoenix', 3),
    ('Filadelfia', 3),
    ('San Antonio', 3),
    ('San Diego', 3),
    ('Dallas', 3),
    ('San José', 3),

    -- Ciudades de China
    ('Pekín', 4),
    ('Shanghái', 4),
    ('Cantón', 4),
    ('Shenzhen', 4),
    ('Chongqing', 4),
    ('Tianjin', 4),
    ('Hangzhou', 4),
    ('Wuhan', 4),
    ('Xi\'an', 4),
    ('Chengdu', 4),

    -- Ciudades de Italia
    ('Roma', 5),
    ('Milán', 5),
    ('Nápoles', 5),
    ('Turín', 5),
    ('Palermo', 5),
    ('Génova', 5),
    ('Bolonia', 5),
    ('Florencia', 5),
    ('Bari', 5),
    ('Catania', 5),

    -- Ciudades de Turquía
    ('Estambul', 6),
    ('Ankara', 6),
    ('Izmir', 6),
    ('Bursa', 6),
    ('Adana', 6),
    ('Gaziantep', 6),
    ('Konya', 6),
    ('Antalya', 6),
    ('Kayseri', 6),
    ('Mersin', 6),

    -- Ciudades de México
    ('Ciudad de México', 7),
    ('Guadalajara', 7),
    ('Monterrey', 7),
    ('Puebla', 7),
    ('Tijuana', 7),
    ('León', 7),
    ('Ciudad Juárez', 7),
    ('Cancún', 7),
    ('Chihuahua', 7),
    ('Mérida', 7),

    -- Ciudades de Tailandia
    ('Bangkok', 8),
    ('Chiang Mai', 8),
    ('Phuket', 8),
    ('Pattaya', 8),
    ('Nonthaburi', 8),
    ('Udon Thani', 8),
    ('Hat Yai', 8),
    ('Nakhon Ratchasima', 8),
    ('Khon Kaen', 8),
    ('Surat Thani', 8),

    -- Ciudades de Alemania
    ('Berlín', 9),
    ('Hamburgo', 9),
    ('Múnich', 9),
    ('Colonia', 9),
    ('Fráncfort', 9),
    ('Stuttgart', 9),
    ('Düsseldorf', 9),
    ('Dortmund', 9),
    ('Essen', 9),
    ('Leipzig', 9),

    -- Ciudades de Reino Unido
    ('Londres', 10),
    ('Birmingham', 10),
    ('Glasgow', 10),
    ('Liverpool', 10),
    ('Mánchester', 10),
    ('Edimburgo', 10),
    ('Leeds', 10),
    ('Bristol', 10),
    ('Sheffield', 10),
    ('Newcastle', 10);



INSERT INTO SERVICIO (NOMBRE) VALUES
('Wifi'), ('Cocina'), ('Lavarropas'), ('Secadora'), ('Aire acondicionado'), 
('Calefacción'), ('Zona de trabajo'), ('Televisor'), ('Secador de pelo'), ('Plancha')



