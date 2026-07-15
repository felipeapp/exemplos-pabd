# Projeto Final para Programação com Acesso a Banco de Dados

Cada grupo deverá desenvolver uma aplicação Java utilizando JDBC e MySQL, executada via terminal. O objetivo é aplicar os conceitos estudados de programação, projeto de banco de dados e acesso a banco utilizando JDBC.

Use o exemplo deste repositório (`Ex_08_JDBC_Acesso`) como base para o projeto. Todos os projetos deverão, no mínimo:

- Implementar cadastros e relatórios
- Realizar persistência dos dados em banco MySQL
- Usar a linguagem Java e o JDBC
- Usar o Gradle como gerenciador de dependências
- Definir os atributos de cada entidade

---

## Grupo 1

### Membros

- João Eduardo dos Santos Carvalho
- João Lucas Alves Dantas
- Lucas Gomes da Silva
- Luiz Arthur Dantas Barbosa
- Maria Leticia da Silva
- Viniciws Palhano Dantas

### Problema

É necessário realizar a gestão de reservas entre usuários e salas de uma instituição de ensino.

### Tabelas

- Usuário
- Sala
- Reserva

### Funcionalidades Básicas

- Cadastrar usuários
- Cadastrar salas
- Resgistrar reserva
- Remover reserva

### Relatórios Emitidos pelo Sistema

- Usuários cadastrados
- Salas disponíveis
- Reservas feitas
- Reservas por usuário

---

## Grupo 2

### Membros

- Abylene Freitas de França
- Ana Karolline Carneiro Souza
- Hadassa Ludmylla da Silva Beserra

### Problema

Uma locadora de veículos deseja controlar os aluguéis realizados para seus clientes.

### Tabelas

- Cliente
- Veículo
- Locação

### Funcionalidades Básicas

- Cadastrar clientes
- Cadastrar veículos
- Registrar locações
- Registrar devoluções

### Relatórios Emitidos pelo Sistema

- Veículos disponíveis
- Veículos alugados
- Histórico de locações de um cliente
- Quantidade de locações por veículo

---

## Grupo 3

### Membros

- Rodrigo Medeiros
- Kauany Victoria
- Manuele Pietra
- Antonio Phillipe
- Kaiser

### Problema

Uma clínica médica deseja informatizar o processo de agendamento de consultas.

### Tabelas

- Médico
- Paciente
- Consulta

### Funcionalidades Básicas

- Cadastrar médicos
- Cadastrar pacientes
- Agendar consultas
- Cancelar consultas

### Relatórios Emitidos pelo Sistema

- Consultas de um médico
- Consultas de um paciente
- Quantidade de consultas por médico
- Consultas agendadas para uma determinada data

---

## Grupo 4

### Membros

- Anny Gabriele Militão do Nascimento
- Gabriel Endrel da Silva
- Heitor Lisboa dos Santos
- José Valesson Gondim da Costa
- Maria Clara Pinheiro Alves
- Maria Eduarda Rosendo de Paulo

### Problema

A biblioteca de uma escola deseja informatizar o controle de empréstimos de livros.

### Tabelas

- Livro
- Aluno
- Empréstimo

### Funcionalidades Básicas

- Cadastrar livros
- Cadastrar alunos
- Registrar empréstimos
- Registrar devoluções

### Relatórios Emitidos pelo Sistema

- Livros emprestados
- Livros disponíveis
- Empréstimos de um aluno
- Livros mais emprestados

---

## Grupo 5

### Membros

- Elienai Ferreira
- Felipe Gabriel
- Jorge Guilherme
- Luana Gomes
- Otávio Augusto
- Wyllians Emanuel

### Problema

Um pequeno hotel deseja informatizar o gerenciamento de reservas de quartos.

### Tabelas

- Hóspede
- Quarto
- Reserva

### Funcionalidades Básicas

- Cadastrar hóspedes
- Cadastrar quartos
- Registrar reservas
- Cancelar reservas

### Relatórios Emitidos pelo Sistema

- Quartos disponíveis
- Reservas de um hóspede
- Reservas por período
- Quantidade de reservas por quarto

---

## Grupo 6

### Membros

- Alice Laila de Souza
- Mary Mel Rebouças Marcelino
- Maria Heloísa Pinheiro de Souza
- Marjorie Cecília Andrade da Silva
- Thalis Felipe Veras da Silva

### Problema

Uma empresa organizadora de eventos deseja informatizar o controle de inscrições em seus eventos.

### Tabelas

- Participante
- Evento
- Inscrição

### Funcionalidades Básicas

- Cadastrar participantes
- Cadastrar eventos
- Registrar inscrições
- Cancelar inscrições

### Relatórios Emitidos pelo Sistema

- Participantes inscritos em um evento
- Eventos em que um participante está inscrito
- Quantidade de inscritos por evento
- Eventos com maior número de inscritos

## Grupo 7

### Membros

- João Ricardo Dantas Mendes
- Kellyane Pereira Da Silva

### Problema

Uma escola deseja informatizar o processo de oferta de disciplinas para seus alunos.

### Tabelas

- Aluno
- Disciplina
- Matrícula

### Funcionalidades Básicas

- Cadastrar alunos;
- Cadastrar disciplinas;
- Registrar matrículas;
- Cancelar matrículas.

### Relatórios Emitidos pelo Sistema

- Alunos matriculados em uma disciplina;
- Disciplinas em que um aluno está matriculado;
- Quantidade de alunos por disciplina;
- Disciplinas com maior número de alunos matriculados.

## Grupo 8

### Membros

- Renato Costa
- Artur Luis
- Igor Luis
- Guilherme Paulo
- Arthur Guilherme
- Pedro Jerônimo

### Problema

Uma academia deseja controlar as matrículas dos alunos em suas modalidades (musculação, pilates, natação, zumba, hidroginástica, etc).

### Tabelas

- Aluno
- Modalidade
- Matrícula

### Funcionalidades Básicas

- Cadastrar alunos
- Cadastrar modalidades
- Matricular alunos
- Cancelar matrículas

### Relatórios Emitidos pelo Sistema

- Alunos por modalidade
- Modalidades de um aluno
- Quantidade de alunos por modalidade
- Modalidades sem alunos matriculados

---

## Grupo 9

### Membros

- Hadassa Ludmylla

### Problema

Uma escola deseja informatizar o agendamento de atividades avaliativas e acompanhamento por status (Agendado, Finalizado, Cancelado).

### Tabela

- Atividade Avaliativa

### Campos sugeridos

- `id`
- `titulo`
- `descricao`
- `nome_disciplina`
- `nome_turma`
- `data_realizacao`
- `status`

### Funcionalidades Básicas

- Cadastrar atividades avaliativas
- Consultar atividade por `id`
- Alterar status de uma atividade por `id`
- Excluir uma atividade por `id`

### Relatórios Emitidos pelo Sistema

- Listar todas as atividades cadastradas
- Listar atividades por status
- Listar atividades de um determinado dia
