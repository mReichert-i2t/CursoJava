CREATE DATABASE biblioteca_sf;

CREATE TABLE TIPO_USUARIO(
	ID INTEGER PRIMARY KEY AUTO_INCREMENT,
	DESCRIPCION VARCHAR(25) NOT NULL,
	FECHA_CREACION DATETIME NOT NULL,
	FECHA_MODIFICACION DATETIME DEFAULT NULL
);

CREATE TABLE USUARIO(
	ID BIGINT PRIMARY KEY AUTO_INCREMENT,
	USERNAME VARCHAR(50) NOT NULL,
	EMAIL VARCHAR(100) NOT NULL,
	PASSWORD VARCHAR(255) NOT NULL,
	NOMBRE VARCHAR(100) NOT NULL,
	APELLIDO VARCHAR(100) NOT NULL,
	FECHA_NACIMIENTO DATE NOT NULL,
	ID_TIPO_USUARIO INTEGER NOT NULL,
	FECHA_CREACION DATETIME NOT NULL,
	FECHA_MODIFICACION DATETIME DEFAULT NULL,
	FOREIGN KEY (ID_TIPO_USUARIO) REFERENCES TIPO_USUARIO(ID)
);

CREATE TABLE LIBRO(
	ID BIGINT PRIMARY KEY AUTO_INCREMENT,
	ISBN VARCHAR(20) NOT NULL,
	NOMBRE VARCHAR(50) NOT NULL,
	AUTOR VARCHAR(100) NOT NULL,
	CANTIDAD INTEGER NOT NULL,
	FECHA_CREACION DATETIME NOT NULL,
	FECHA_MODIFICACION DATETIME DEFAULT NULL,
	UNIQUE KEY(ISBN)
);

CREATE TABLE PRESTAMO(
	ID_LIBRO BIGINT,
	ID_USUARIO BIGINT,
	FECHA_INCIO DATE NOT NULL,
	FECHA_FIN DATE NOT NULL,
    ESTADO VARCHAR(50) NOT NULL,
	FECHA_CREACION DATETIME NOT NULL,
	FECHA_MODIFICACION DATETIME DEFAULT NULL,
	PRIMARY KEY(ID_LIBRO, ID_USUARIO),
	FOREIGN KEY (ID_LIBRO) REFERENCES LIBRO(ID),
	FOREIGN KEY (ID_USUARIO) REFERENCES USUARIO(ID)
);

INSERT INTO LIBRO (ISBN, NOMBRE, AUTOR, CANTIDAD, FECHA_CREACION) VALUES
('978-3-16-148410-0', 'Cien años de soledad', 'Gabriel García Márquez', 10, NOW()),
('978-0-06-112008-1', 'Matar a un ruiseñor', 'Harper Lee', 5, NOW()),
('978-0-452-28423-5', 'El gran Gatsby', 'F. Scott Fitzgerald', 7, NOW()),
('978-0-7432-7356-1', 'El código Da Vinci', 'Dan Brown', 4, NOW()),
('978-1-56619-909-5', '1984', 'George Orwell', 12, NOW()),
('978-1-4028-9462-7', 'Harry Potter y la piedra filosofal', 'J.K. Rowling', 15, NOW()),
('978-0-141-03435-8', 'El guardián entre el centeno', 'J.D. Salinger', 6, NOW()),
('978-1-4391-1118-1', 'El cuento de la criada', 'Margaret Atwood', 9, NOW()),
('978-0-7432-7356-2', 'It', 'Stephen King', 8, NOW()),
('978-1-56619-909-6', 'Las aventuras de Tom Sawyer', 'Mark Twain', 3, NOW()),
('978-0-525-47545-8', 'El viejo y el mar', 'Ernest Hemingway', 11, NOW()),
('978-0-141-03436-5', 'Guerra y paz', 'Leo Tolstoy', 6, NOW()),
('978-0-06-093546-8', 'Orgullo y prejuicio', 'Jane Austen', 5, NOW()),
('978-0-374-15380-9', 'Las uvas de la ira', 'John Steinbeck', 7, NOW()),
('978-0-06-245773-9', 'Kafka en la orilla', 'Haruki Murakami', 4, NOW()),
('978-0-618-10083-7', 'Medias noches en el jardín del bien y del mal', 'John Berendt', 8, NOW()),
('978-0-06-230167-9', 'La campana de cristal', 'Sylvia Plath', 6, NOW()),
('978-1-56731-337-2', 'Una breve historia del tiempo', 'Stephen Hawking', 3, NOW()),
('978-0-06-083865-3', 'El principito', 'Antoine de Saint-Exupéry', 9, NOW()),
('978-0-06-230168-0', 'El gran Gatsby', 'F. Scott Fitzgerald', 5, NOW()),
('978-0-7432-7356-3', 'El alquimista', 'Paulo Coelho', 4, NOW()),
('978-1-60154-434-3', 'El nombre de la rosa', 'Umberto Eco', 10, NOW()),
('978-0-7432-7356-4', 'Cumbres borrascosas', 'Emily Brontë', 6, NOW()),
('978-0-451-52993-6', 'Cien años de soledad', 'Gabriel García Márquez', 8, NOW()),
('978-0-374-15380-7', 'El juego de Ender', 'Orson Scott Card', 5, NOW()),
('978-0-06-245772-0', 'La sombra del viento', 'Carlos Ruiz Zafón', 3, NOW()),
('978-0-553-21311-8', 'Fahrenheit 451', 'Ray Bradbury', 7, NOW()),
('978-1-4391-1234-5', 'La casa de los espíritus', 'Isabel Allende', 4, NOW()),
('978-0-06-228953-7', 'La chica del tren', 'Paula Hawkins', 9, NOW()),
('978-1-250-07348-4', 'El héroe de las mil caras', 'Joseph Campbell', 2, NOW()),
('978-0-307-38960-5', 'Los ojos de mi princesa', 'Carlos Cuauhtémoc Sánchez', 5, NOW()),
('978-1-59240-858-8', 'Bajo la misma estrella', 'John Green', 6, NOW()),
('978-0-545-23185-0', 'El odio que das', 'Angie Thomas', 3, NOW()),
('978-0-06-231609-7', 'Un monstruo viene a verme', 'Patrick Ness', 7, NOW()),
('978-1-5038-0062-6', 'Ready Player One', 'Ernest Cline', 8, NOW()),
('978-0-06-226731-6', 'El marciano', 'Andy Weir', 10, NOW()),
('978-1-4052-8487-1', 'El arte de la guerra', 'Sun Tzu', 4, NOW()),
('978-0-316-01792-1', 'Sapiens: De animales a dioses', 'Yuval Noah Harari', 6, NOW()),
('978-0-553-21716-5', 'La ladrona de libros', 'Markus Zusak', 9, NOW()),
('978-0-345-53478-7', 'El camino', 'C. A. K. H.', 3, NOW()),
('978-0-14-303943-4', 'Rayuela', 'Julio Cortázar', 5, NOW()),
('978-1-5038-0062-7', 'El silencio de los corderos', 'Thomas Harris', 2, NOW()),
('978-0-14-017739-9', 'El túnel', 'Ernesto Sabato', 4, NOW()),
('978-0-06-296367-6', 'Americanah', 'Chimamanda Ngozi Adichie', 6, NOW()),
('978-0-14-029707-6', 'La casa de los espíritus', 'Isabel Allende', 8, NOW()),
('978-0-553-38835-3', 'El arte de la felicidad', 'El Dalai Lama', 3, NOW()),
('978-0-7432-7356-6', 'La historia interminable', 'Michael Ende', 7, NOW()),
('978-1-4028-9462-1', 'El hombre en el castillo', 'Philip K. Dick', 5, NOW()),
('978-0-451-53024-6', 'Cuentos de la selva', 'Horacio Quiroga', 6, NOW());

INSERT INTO TIPO_USUARIO (DESCRIPCION, FECHA_CREACION)
VALUES ('ADMINISTRADOR', NOW()),
('BIBLIOTECARIO', NOW()),
('LECTOR', NOW());