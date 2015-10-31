# WebService para trabalho de conclusão de curso.

* **Sobre**

WebService utiizado para trabalho de conclusão de curso, sendo consumido por protótipo de aplicativo mobile (https://github.com/gabrielqueiroz/androidtcc).

* **O que você pode encontrar neste projeto?**

1. Framework RESTEasy para mapeamento de funções de classes controles disponibilizando via HTTP (Métodos POST com parametro no Body e GET).
2. Framework Gson para gerenciamento de objetos e lista de objetos Java para arquivos JSON.
3. Projeto Maven para gerenciamento de dependências.
4. JBoss EAP como servidor de aplicação.
5. MySQL como banco de dados.
6. Padrão DAO (Data Access Object) para classes de interação com o banco de dados.

* **Configurações do Servidor de Aplicação**
```
JBoss EAP 6.1+
Default User: admin
Default Pass: a1b2c3d4e5@
```
* **Configurações do Banco de Dados**
```
MySQL 
url = jdbc:mysql://localhost:3306/TCCSERVER
Default User = root
Default Pass = root
```
* **Script de Criação do Banco de Dados**
```
CREATE DATABASE TCCSERVER;
USE TCCSERVER;
```
* **Script de Criação de Tabelas**
```
CREATE TABLE USUARIO ( ID_USUARIO INT PRIMARY KEY NOT NULL AUTO_INCREMENT, NOME VARCHAR(60) NOT NULL, SOBRENOME VARCHAR(60) NOT NULL, TELEFONE VARCHAR(15), DATA_NASC DATE NOT NULL, EMAIL VARCHAR(60) NOT NULL, PERFIL VARCHAR(1) NOT NULL,SENHA VARCHAR(60) NOT NULL);
CREATE TABLE MATERIA ( ID_MATERIA INT PRIMARY KEY NOT NULL AUTO_INCREMENT, MATERIA VARCHAR(60) NOT NULL, SEMESTRE INT NOT NULL );
CREATE TABLE DUVIDA ( ID_DUVIDA INT PRIMARY KEY NOT NULL AUTO_INCREMENT, ID_USUARIO INT NOT NULL, TITULO_DUVIDA TEXT NOT NULL, CONTEUDO_DUVIDA TEXT NOT NULL, DATA_CRIACAO DATE NOT NULL ); 
CREATE TABLE RESPOSTA ( ID_RESPOSTA INT PRIMARY KEY NOT NULL AUTO_INCREMENT, ID_USUARIO INT NOT NULL, ID_DUVIDA INT NOT NULL, RESPOSTA TEXT NOT NULL, RANK INT NOT NULL, FLAG_PROF BOOL NOT NULL, FLAG_ALUNO BOOL NOT NULL, DATA_CRIACAO DATE NOT NULL ); 	CREATE TABLE TAG ( ID_TAG INT PRIMARY KEY NOT NULL AUTO_INCREMENT, NOME VARCHAR(10) NOT NULL );
CREATE TABLE MATERIA_USUARIO ( ID_MATERIA INT NOT NULL, ID_USUARIO INT NOT NULL);
CREATE TABLE MATERIA_DUVIDA ( ID_MATERIA INT NOT NULL, ID_DUVIDA INT NOT NULL );
CREATE TABLE DUVIDA_TAG ( ID_DUVIDA INT NOT NULL, ID_TAG INT NOT NULL );
CREATE TABLE `like_resposta` (
  `ID_USUARIO` int(11) NOT NULL,
  `ID_RESPOSTA` int(11) NOT NULL,
  `MARCADA` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`ID_USUARIO`,`ID_RESPOSTA`)
)
```
* **Script de Criação de Chaves Estrangeiras**
```
ALTER TABLE USUARIO ADD UNIQUE(EMAIL);
ALTER TABLE DUVIDA ADD CONSTRAINT FK_DUVIDAUSUARIO FOREIGN KEY(ID_USUARIO) REFERENCES USUARIO(ID_USUARIO);
ALTER TABLE RESPOSTA ADD CONSTRAINT FK_RESPOSTAUSUARIO FOREIGN KEY(ID_USUARIO) REFERENCES USUARIO(ID_USUARIO);
ALTER TABLE RESPOSTA ADD CONSTRAINT FK_RESPOSTADUVIDA FOREIGN KEY(ID_DUVIDA) REFERENCES DUVIDA(ID_DUVIDA);
ALTER TABLE TAG ADD UNIQUE(NOME);
ALTER TABLE MATERIA_USUARIO ADD CONSTRAINT FK_MATERIAUSUARIO FOREIGN KEY(ID_MATERIA) REFERENCES MATERIA(ID_MATERIA);
ALTER TABLE MATERIA_USUARIO ADD CONSTRAINT FK_USUARIOMATERIA FOREIGN KEY(ID_USUARIO) REFERENCES USUARIO(ID_USUARIO);
ALTER TABLE MATERIA_USUARIO ADD UNIQUE(ID_MATERIA, ID_USUARIO);
ALTER TABLE MATERIA_DUVIDA ADD CONSTRAINT FK_MATERIADUVIDA FOREIGN KEY(ID_MATERIA) REFERENCES MATERIA(ID_MATERIA);
ALTER TABLE MATERIA_DUVIDA ADD CONSTRAINT FK_DUVIDAMATERIA FOREIGN KEY(ID_DUVIDA) REFERENCES DUVIDA(ID_DUVIDA);
ALTER TABLE MATERIA_USUARIO ADD UNIQUE(ID_MATERIA, ID_USUARIO);
ALTER TABLE DUVIDA_TAG ADD CONSTRAINT FK_DUVIDATAG FOREIGN KEY(ID_DUVIDA) REFERENCES DUVIDA(ID_DUVIDA);
ALTER TABLE DUVIDA_TAG ADD CONSTRAINT FK_TAGDUVIDA FOREIGN KEY(ID_TAG) REFERENCES TAG(ID_TAG);
```
* **Script de Insert de Matérias**
```
INSERT INTO MATERIA (MATERIA, SEMESTRE) VALUES ('INGLÊS I','1');
INSERT INTO MATERIA (MATERIA, SEMESTRE) VALUES ('ADMINISTRAÇÃO GERAL','1');
INSERT INTO MATERIA (MATERIA, SEMESTRE) VALUES ('ALGORITMOS E LÓGICA DE PROGRAMAÇÃO','1');
INSERT INTO MATERIA (MATERIA, SEMESTRE) VALUES ('ARQUITETURA E ORGANIZAÇÃO DE COMPUTADORES','1');
INSERT INTO MATERIA (MATERIA, SEMESTRE) VALUES ('LABORATÓRIO DE HARDWARE','1');
INSERT INTO MATERIA (MATERIA, SEMESTRE) VALUES ('MATEMÁTICA DISCRETA','1');
INSERT INTO MATERIA (MATERIA, SEMESTRE) VALUES ('PROGRAMAÇÃO EM MICROINFORMÁTICA','1');
INSERT INTO MATERIA (MATERIA, SEMESTRE) VALUES ('INGLÊS II','2');
INSERT INTO MATERIA (MATERIA, SEMESTRE) VALUES ('CÁLCULO','2');
INSERT INTO MATERIA (MATERIA, SEMESTRE) VALUES ('COMUNICAÇÃO E EXPRESSÃO','2');
INSERT INTO MATERIA (MATERIA, SEMESTRE) VALUES ('CONTABILIDADE','2');
INSERT INTO MATERIA (MATERIA, SEMESTRE) VALUES ('ENGENHARIA DE SOFTWARE I','2');
INSERT INTO MATERIA (MATERIA, SEMESTRE) VALUES ('LINGUAGEM DE PROGRAMAÇÃO','2');
INSERT INTO MATERIA (MATERIA, SEMESTRE) VALUES ('SISTEMAS DE INFORMAÇÃO','2');
INSERT INTO MATERIA (MATERIA, SEMESTRE) VALUES ('INGLÊS III','3');
INSERT INTO MATERIA (MATERIA, SEMESTRE) VALUES ('ECONOMIA E FINANÇAS','3');
INSERT INTO MATERIA (MATERIA, SEMESTRE) VALUES ('ESTATÍSTICA APLICADA','3');
INSERT INTO MATERIA (MATERIA, SEMESTRE) VALUES ('ESTRUTURA DE DADOS','3');
INSERT INTO MATERIA (MATERIA, SEMESTRE) VALUES ('INTERAÇÃO HUMANO COMPUTADOR','3');
INSERT INTO MATERIA (MATERIA, SEMESTRE) VALUES ('SISTEMAS OPERACIONAIS I','3');
INSERT INTO MATERIA (MATERIA, SEMESTRE) VALUES ('SOCIEDADE E TECNOLOGIA','3');
INSERT INTO MATERIA (MATERIA, SEMESTRE) VALUES ('INGLÊS IV','4');
INSERT INTO MATERIA (MATERIA, SEMESTRE) VALUES ('BANCO DE DADOS','4');
INSERT INTO MATERIA (MATERIA, SEMESTRE) VALUES ('ENGENHARIA DE SOFTWARE III','4');
INSERT INTO MATERIA (MATERIA, SEMESTRE) VALUES ('METODOLOGIA DA PESQUISA CIENTIFICO-TECNOLÓGICA','4');
INSERT INTO MATERIA (MATERIA, SEMESTRE) VALUES ('PROGRAMAÇÃO PARA MAINFRAME','4');
INSERT INTO MATERIA (MATERIA, SEMESTRE) VALUES ('SISTEMAS OPERACIONAIS II','4');
INSERT INTO MATERIA (MATERIA, SEMESTRE) VALUES ('INGLÊS V','5');
INSERT INTO MATERIA (MATERIA, SEMESTRE) VALUES ('LABORATÓRIO DE BANCO DE DADOS','5');
INSERT INTO MATERIA (MATERIA, SEMESTRE) VALUES ('LABORATÓRIO DE ENGENHARIA DE SOFTWARE','5');
INSERT INTO MATERIA (MATERIA, SEMESTRE) VALUES ('PROGRAMAÇÃO LINEAR E APLICAÇÕES','5');
INSERT INTO MATERIA (MATERIA, SEMESTRE) VALUES ('REDES DE COMPUTADORES','5');
INSERT INTO MATERIA (MATERIA, SEMESTRE) VALUES ('SEGURANÇA DA INFORMAÇÃO','5');
INSERT INTO MATERIA (MATERIA, SEMESTRE) VALUES ('TESTE DE SOFTWARE','5');
INSERT INTO MATERIA (MATERIA, SEMESTRE) VALUES ('TRABALHO DE GRADUAÇÃO I','5');
INSERT INTO MATERIA (MATERIA, SEMESTRE) VALUES ('INGLÊS VI', '6');
INSERT INTO MATERIA (MATERIA, SEMESTRE) VALUES ('AUDITORIA DE SISTEMAS', '6');
INSERT INTO MATERIA (MATERIA, SEMESTRE) VALUES ('INGLÊS VI', '6');
INSERT INTO MATERIA (MATERIA, SEMESTRE) VALUES ('AUDITORIA DE SISTEMAS', '6');
INSERT INTO MATERIA (MATERIA, SEMESTRE) VALUES ('EMPREENDORISMO', '6');
INSERT INTO MATERIA (MATERIA, SEMESTRE) VALUES ('ÉTICA E RESPONSABILIDADE PROFISSIONAL', '6');
INSERT INTO MATERIA (MATERIA, SEMESTRE) VALUES ('GESTÃO DE PROJETOS', '6');
INSERT INTO MATERIA (MATERIA, SEMESTRE) VALUES ('GESTÃO DE EQUIPES', '6');
INSERT INTO MATERIA (MATERIA, SEMESTRE) VALUES ('GESTÃO E GOVERNANÇA DE TECNOLOGIA DA INFORMAÇÃO', '6');
INSERT INTO MATERIA (MATERIA, SEMESTRE) VALUES ('LABORATÓRIO DE REDES', '6');
INSERT INTO MATERIA (MATERIA, SEMESTRE) VALUES ('TRABALHO DE GRADUAÇÃO II', '6');
```
* **SP De Likes**
```
drop procedure sp_set_like
DELIMITER $$ 
CREATE PROCEDURE sp_set_Like(IN id_resp int, IN id_usu int)
 
BEGIN 
DECLARE total_likes int default 0;
DECLARE like_usu_resposta int default 0;
DECLARE total_rank_atual int default 0;
DECLARE like_marcada tinyint default 0;
	
    SELECT count(ID_USUARIO) FROM LIKE_RESPOSTA WHERE ID_RESPOSTA = id_resp And ID_USUARIO = id_usu INTO like_usu_resposta;
    SELECT rank FROM RESPOSTA WHERE ID_RESPOSTA = id_resp INTO total_rank_atual;
	SELECT MARCADA FROM LIKE_RESPOSTA WHERE ID_RESPOSTA = id_resp and ID_USUARIO = id_usu INTO like_marcada;
    
	IF like_usu_resposta = 0 THEN
			SET total_rank_atual := total_rank_atual+1;
            INSERT INTO LIKE_RESPOSTA (ID_RESPOSTA,ID_USUARIO,MARCADA) VALUES (id_resp,id_usu,1);
		
	ELSEIF like_marcada=0 then
			SET total_rank_atual := total_rank_atual+1;
			UPDATE LIKE_RESPOSTA set MARCADA = 1  WHERE ID_RESPOSTA = id_resp AND ID_USUARIO = id_usu;
	ELSE
			SET total_rank_atual := total_rank_atual-1;
            UPDATE LIKE_RESPOSTA set MARCADA = 0 WHERE ID_RESPOSTA = id_resp AND ID_USUARIO = id_usu;
	END IF;
	UPDATE RESPOSTA SET RANK = total_rank_atual WHERE ID_RESPOSTA = id_resp; 
    
END $$ 
```

