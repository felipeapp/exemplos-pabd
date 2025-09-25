DROP SCHEMA IF EXISTS exercicios_slide_12;
CREATE SCHEMA exercicios_slide_12;

USE exercicios_slide_12;

CREATE TABLE ambulatorio (
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	numero INT NOT NULL UNIQUE,
	andar INT NOT NULL,
	capacidade INT NOT NULL
);

CREATE TABLE medico (
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	nome VARCHAR(100) NOT NULL,
	rg INT NOT NULL UNIQUE,
	idade INT NOT NULL,
	salario DECIMAL(7, 2) NOT NULL,
	especialidade VARCHAR(50) NOT NULL,
	data_contrato DATE,
	ambulatorio_id INT,
	FOREIGN KEY(ambulatorio_id) REFERENCES ambulatorio(id)
);

INSERT INTO medico (nome, rg, idade, salario, especialidade) VALUES
	('Natasha', 12200, 41, 12000, 'Cardiologia'),
	('Otávio', 12300, 23, 1400, 'Oftalmologia'),
	('Pedro', 12347, 22, 1150, 'Ortopedia');

INSERT INTO ambulatorio (numero, andar, capacidade) VALUES (101, 1, 15);
INSERT INTO medico (nome, rg, idade, salario, especialidade, data_contrato, ambulatorio_id) VALUES
	('Paulo', 1200, 42, 10000, 'Cardiologia', '2012-01-31', LAST_INSERT_ID()),
	('Anna', 3234, 24, 12000, 'Cardiologia', '2012-01-17', LAST_INSERT_ID()),
	('Arthur', 32234, 22, 8000, 'Ortopedia', '2012-12-15', LAST_INSERT_ID());

INSERT INTO ambulatorio (numero, andar, capacidade) VALUES (201, 2, 20);
INSERT INTO medico (nome, rg, idade, salario, especialidade, data_contrato, ambulatorio_id) VALUES
	('Felipe', 12122, 25, 19800, 'Dermatologia', '2012-12-31', LAST_INSERT_ID()),
	('Gustavo', 51421, 45, 1400, 'Oftalmologia', '2012-05-05', LAST_INSERT_ID());

INSERT INTO ambulatorio (numero, andar, capacidade) VALUES (202, 2, 30);
INSERT INTO medico (nome, rg, idade, salario, especialidade, data_contrato, ambulatorio_id) VALUES
	('Alan', 12034, 38, 19700, 'Neurologia', '2012-07-29', LAST_INSERT_ID()),
	('Henrique', 32034, 39, 18000, 'Mastologia', '2012-09-10', LAST_INSERT_ID()),
	('Daniela', 32340, 28, 8500, 'Ortopedia', '2012-09-11', LAST_INSERT_ID());

INSERT INTO ambulatorio (numero, andar, capacidade) VALUES (302, 3, 10);

# ----------------------------------------------------------------- #
# Exercício 1

/*
Crie uma consulta que retorne informações
(nome, salário e número do ambulatório) de todos
os médicos que trabalham em ambulatórios do segundo andar.
*/
SELECT medico.nome, medico.salario, ambulatorio.numero
	FROM medico INNER JOIN ambulatorio
    ON medico.ambulatorio_id = ambulatorio.id AND ambulatorio.andar = 2;

/*
Crie uma consulta que retorne a soma dos salários dos
médicos que trabalham em ambulatórios do primeiro andar.
*/
SELECT SUM(medico.salario)
	FROM medico INNER JOIN ambulatorio
	ON medico.ambulatorio_id = ambulatorio.id AND ambulatorio.andar = 1;

/*
Crie uma consulta que retorne uma lista com o nome dos
médicos, o número do ambulatório onde ele trabalha e a
data que ele foi contratado para trabalhar no ambulatório.
*/
SELECT medico.nome, ambulatorio.numero, medico.data_contrato
	FROM medico INNER JOIN ambulatorio
    ON medico.ambulatorio_id = ambulatorio.id;

/*
Crie uma consulta que mostre uma lista com os números
dos ambulatórios e quantos médicos trabalham nele.
*/
SELECT ambulatorio.numero, COUNT(medico.id)
	FROM medico RIGHT JOIN ambulatorio
    ON medico.ambulatorio_id = ambulatorio.id
    GROUP BY ambulatorio.numero;

# ----------------------------------------------------------------- #
# Exercício 2

/*
Adicione para o ambulatório de número 201 o médico:
'Alberto', 120, 41, 6000, 'Cardiologia', '2012-01-10'
*/
INSERT INTO medico
	(nome, rg, idade, salario, especialidade, data_contrato, ambulatorio_id)
    VALUES ('Alberto', 120, 41, 6000, 'Cardiologia', '2012-01-10',
    (SELECT id FROM ambulatorio WHERE numero = 201));

/*
Adicione para o ambulatório de número 302 os médicos:
'Flávio', 12130, 34, 6000, 'Ortopedia', '2012-02-10'
'Augusto', 9130, 29, 7000, 'Dermatologia', '2013-01-10'
*/
SET @id_amb_302 = (SELECT id FROM ambulatorio WHERE numero = 302);

INSERT INTO medico
	(nome, rg, idade, salario, especialidade, data_contrato, ambulatorio_id)
    VALUES ('Flávio', 12130, 34, 6000, 'Ortopedia', '2012-02-10', @id_amb_302);

INSERT INTO medico
	(nome, rg, idade, salario, especialidade, data_contrato, ambulatorio_id)
    VALUES ('Augusto', 9130, 29, 7000, 'Dermatologia', '2013-01-10', @id_amb_302);

/*
Faça uma consulta que mostre o nome e a especialidade dos
médicos, bem como o número do ambulatório onde eles
trabalham e o andar deste ambulatório.
*/
SELECT medico.nome `Nome do Médico`, medico.especialidade `Especialidade do Médico`,
    ambulatorio.numero `Número do Ambulatório`, ambulatorio.andar `Andar do Ambulatório`
	FROM ambulatorio INNER JOIN medico
	ON ambulatorio.id = medico.ambulatorio_id
    ORDER BY ambulatorio.numero ASC, medico.nome ASC;
