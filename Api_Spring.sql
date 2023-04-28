CREATE TABLE facultades (
  id INTEGER PRIMARY KEY,
  nombre VARCHAR(50)
);

CREATE TABLE programas (
  id INTEGER PRIMARY KEY,
  nombre VARCHAR(50),
  facultad_id INTEGER REFERENCES facultades(id)
);

CREATE TABLE estudiantes (
  id INTEGER PRIMARY KEY,
  nombre VARCHAR(50),
  programa_id INTEGER REFERENCES programas(id),
  edad INTEGER
);

INSERT INTO facultades (id, nombre) VALUES (1, 'Facultad de Ciencias');
INSERT INTO facultades (id, nombre) VALUES (2, 'Facultad de Ingeniería');
INSERT INTO facultades (id, nombre) VALUES (3, 'Facultad de Humanidades');
INSERT INTO facultades (id, nombre) VALUES (4, 'Facultad de Artes');

INSERT INTO programas (id, nombre, facultad_id) VALUES (1, 'Licenciatura en Física', 1);
INSERT INTO programas (id, nombre, facultad_id) VALUES (2, 'Ingeniería Industrial', 2);
INSERT INTO programas (id, nombre, facultad_id) VALUES (3, 'Licenciatura en Letras', 3);
INSERT INTO programas (id, nombre, facultad_id) VALUES (4, 'Diseño Gráfico', 4);

INSERT INTO estudiantes (id, nombre, programa_id, edad) VALUES (1, 'Juan Perez', 1, 20);
INSERT INTO estudiantes (id, nombre, programa_id, edad) VALUES (2, 'Maria Rodriguez', 2, 22);
INSERT INTO estudiantes (id, nombre, programa_id, edad) VALUES (3, 'Ana Gomez', 3, 21);
INSERT INTO estudiantes (id, nombre, programa_id, edad) VALUES (4, 'Carlos Rodriguez', 4, 23);








SELECT estudiantes.nombre, programas.nombre, facultades.nombre, estudiantes.edad
FROM estudiantes
JOIN programas ON programas.id = estudiantes.programa_id
JOIN facultades ON facultades.id = programas.facultad_id;

