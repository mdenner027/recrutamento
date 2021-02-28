-- data.sql

-- Inserts da tabela responsáveis
INSERT INTO responsaveis (id_responsavel, nome_responsavel) VALUES (1, 'João Joaquim Medeiros');
INSERT INTO responsaveis (id_responsavel, nome_responsavel) VALUES (2, 'Diogo Renan Iago Souza');
INSERT INTO responsaveis (id_responsavel, nome_responsavel) VALUES (3, 'Elisa Raquel Marcela Santos');
INSERT INTO responsaveis (id_responsavel, nome_responsavel) VALUES (4, 'Aurora Vitória Castro');
INSERT INTO responsaveis (id_responsavel, nome_responsavel) VALUES (5, 'Rayssa Teresinha Drumond');
INSERT INTO responsaveis (id_responsavel, nome_responsavel) VALUES (6, 'Isabella Gabriela Analu Barros');
INSERT INTO responsaveis (id_responsavel, nome_responsavel) VALUES (7, 'Leandro Ian Ribeiro');

-- Inserts da tabela tarefas
INSERT INTO tarefas (id_tarefa, deadline_tarefa, descricao_tarefa ,prioridade_tarefa, status_tarefa, titulo_tarefa, id_responsavel_tarefa) 
VALUES (1, '2021-03-20', 'Testar todos os módulos e validar as operações com os membros', 1, 0, 'Testar Módulo de Vendas', 1);
INSERT INTO tarefas (id_tarefa, deadline_tarefa, descricao_tarefa ,prioridade_tarefa, status_tarefa, titulo_tarefa, id_responsavel_tarefa) 
VALUES (2, '2021-02-25', 'Levantar requisitos com os steakholders', 2, 0, 'Levantar Requisitos', 1);
INSERT INTO tarefas (id_tarefa, deadline_tarefa, descricao_tarefa ,prioridade_tarefa, status_tarefa, titulo_tarefa, id_responsavel_tarefa) 
VALUES (3, '2021-01-19', 'Consertar computador nº 24', 0, 1, 'Consertar PC', 2);
INSERT INTO tarefas (id_tarefa, deadline_tarefa, descricao_tarefa ,prioridade_tarefa, status_tarefa, titulo_tarefa, id_responsavel_tarefa) 
VALUES (4, '2021-02-28', 'Verificar possibilidade de realocação de tarefas', 0, 0, 'Realocação de Tarefas', 3);
INSERT INTO tarefas (id_tarefa, deadline_tarefa, descricao_tarefa ,prioridade_tarefa, status_tarefa, titulo_tarefa, id_responsavel_tarefa) 
VALUES (5, '2021-05-22', 'Analisar projetos dos cadidatos à vaga de estágio', 0, 0, 'Análise dos projetos de estágio', 5);
INSERT INTO tarefas (id_tarefa, deadline_tarefa, descricao_tarefa ,prioridade_tarefa, status_tarefa, titulo_tarefa, id_responsavel_tarefa) 
VALUES (6, '2021-01-20', 'Fazer levantamento de gastos de 2020', 2, 1, 'Levantamento de Gastos', 7);
INSERT INTO tarefas (id_tarefa, deadline_tarefa, descricao_tarefa ,prioridade_tarefa, status_tarefa, titulo_tarefa, id_responsavel_tarefa) 
VALUES (7, '2021-03-20', 'Fazer teste de integração do back com o front do sistema', 2, 0, 'Testar integração', 6);
INSERT INTO tarefas (id_tarefa, deadline_tarefa, descricao_tarefa ,prioridade_tarefa, status_tarefa, titulo_tarefa, id_responsavel_tarefa) 
VALUES (8, '2021-02-20', 'Analisar o que precisa ser comprado para o escritório', 1, 1, 'Análise do almoxarifado', 7);