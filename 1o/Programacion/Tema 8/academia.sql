USE academia;
-- Tabla Alumno
CREATE TABLE alumno (
    dni VARCHAR(9) PRIMARY KEY,
    nombre VARCHAR(50),
    apellidos VARCHAR(50),
    fechaNacimiento DATE,
    direccion VARCHAR(100),
    email VARCHAR(100)
);

-- Tabla Profesor
CREATE TABLE profesor (
    dni VARCHAR(9) PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    especialidad VARCHAR(100)
);

-- Tabla Asignatura
CREATE TABLE asignatura (
    idAsignatura INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    descripcion TEXT,
    dniProfesor VARCHAR(9),
    FOREIGN KEY (dniProfesor) REFERENCES profesor(dni)
);



-- Tabla Matricula
CREATE TABLE matricula (
    dniAlumno VARCHAR(9),
    idAsignatura INT,
    nota INT,
    FOREIGN KEY (dniAlumno) REFERENCES alumno(dni),
    FOREIGN KEY (idAsignatura) REFERENCES asignatura(idAsignatura),
    PRIMARY KEY (dniAlumno, idAsignatura)
);


-- Inserts para la tabla Alumno
INSERT INTO alumno (dni, nombre, apellidos, fechaNacimiento, direccion, email) VALUES
('12345678A', 'Juan', 'García Pérez', '1998-05-15', 'Calle Mayor 123', 'juan@gmail.com'),
('23456789B', 'María', 'Martínez López', '1999-07-20', 'Avenida Libertad 45', 'maria@hotmail.com'),
('34567890C', 'Carlos', 'Rodríguez González', '1997-12-10', 'Plaza España 8', 'carlos@yahoo.com'),
('45678901D', 'Laura', 'Fernández Sánchez', '2000-03-25', 'Calle Alameda 32', 'laura@gmail.com'),
('56789012E', 'Pablo', 'López Martín', '1996-09-05', 'Calle Real 67', 'pablo@gmail.com'),
('67890123F', 'Ana', 'Sánchez Gómez', '1999-11-18', 'Avenida Primavera 20', 'ana@hotmail.com'),
('78901234G', 'David', 'Gómez Rodríguez', '1998-08-30', 'Calle Mayor 5', 'david@yahoo.com'),
('89012345H', 'Elena', 'Pérez Fernández', '1997-04-12', 'Calle Sol 14', 'elena@gmail.com'),
('90123456I', 'Sara', 'Martín López', '1998-01-08', 'Calle Mayor 100', 'sara@hotmail.com'),
('01234567K', 'Javier', 'González Sánchez', '1995-06-22', 'Calle Real 23', 'javier@yahoo.com');

-- Inserts para la tabla Profesor
INSERT INTO profesor (dni, nombre, apellido, especialidad) VALUES
('12345678K', 'Pedro', 'Martínez', 'Matemáticas'),
('23456789L', 'Lucía', 'García', 'Física'),
('34567890M', 'Carmen', 'López', 'Historia'),
('45678901N', 'Juan', 'Sánchez', 'Biología'),
('56789012O', 'Marta', 'Rodríguez', 'Química'),
('67890123P', 'Carlos', 'Fernández', 'Literatura'),
('78901234Q', 'Elena', 'Gómez', 'Inglés'),
('89012345R', 'Pablo', 'Díaz', 'Geografía'),
('90123456S', 'Laura', 'Pérez', 'Arte'),
('01234567T', 'David', 'González', 'Educación Física');

-- Inserts para la tabla Asignatura
INSERT INTO asignatura (nombre, descripcion, dniProfesor) VALUES
('Matemáticas I', 'Curso introductorio de Matemáticas', '12345678K'),
('Física General', 'Conceptos básicos de Física', '23456789L'),
('Historia del Mundo Contemporáneo', 'Panorama histórico del siglo XX', '34567890M'),
('Biología Celular', 'Estudio de la célula y sus funciones', '45678901N'),
('Química Orgánica', 'Química de los compuestos orgánicos', '56789012O'),
('Literatura Española', 'Análisis de la literatura española', '67890123P'),
('Inglés Avanzado', 'Curso de inglés para nivel avanzado', '78901234Q'),
('Geografía Humana', 'Estudio de la relación entre la sociedad y el medio ambiente', '89012345R'),
('Arte Renacentista', 'Estudio del arte durante el Renacimiento', '90123456S'),
('Educación Física', 'Actividades deportivas y recreativas', '01234567T');

-- Inserts para la tabla Matricula
INSERT INTO matricula (dniAlumno, idAsignatura, nota) VALUES
('12345678A', 1, 2), 
('12345678A', 3, 3), 
('23456789B', 2, 7), 
('34567890C', 3, 6), 
('45678901D', 4, 5), 
('56789012E', 5, 9), 
('67890123F', 6, 10), 
('78901234G', 7, 2), 
('89012345H', 8, 2), 
('90123456I', 9, 3), 
('01234567K', 10, 1),
('56789012E', 3, 8), 
('90123456I', 4, 6),
('12345678A', 5, 7), 
('12345678A', 6, 7), 
('23456789B', 7, 4), 
('34567890C', 8, 3), 
('45678901D', 9, 5), 
('56789012E', 10, 7), 
('67890123F', 7, 10), 
('78901234G', 8, 8), 
('89012345H', 2, 7), 
('90123456I', 10, 4), 
('01234567K', 9, 5); 
