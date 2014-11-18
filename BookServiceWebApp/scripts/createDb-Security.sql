/* CREATE DATABASE news; */
USE bookservice;

DROP TABLE IF EXISTS t_user_role;
DROP TABLE IF EXISTS t_user;
DROP TABLE IF EXISTS t_role;

CREATE TABLE t_user (
  userid INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(25) NOT NULL,
  password VARCHAR(128) NOT NULL
);

CREATE TABLE t_role (
  roleid INT AUTO_INCREMENT PRIMARY KEY,
  rolename VARCHAR(25) NOT NULL
);

CREATE TABLE t_user_role (
  userroleid INT AUTO_INCREMENT PRIMARY KEY,
  userid INT NOT NULL,
  roleid INT NOT NULL,
  FOREIGN KEY (userid) REFERENCES t_user(userid),
  FOREIGN KEY (roleid) REFERENCES t_role(roleid)
);

INSERT INTO t_user (userid, username, password) VALUES (1, 'reader', SHA2('123', 512));
INSERT INTO t_user (userid, username, password) VALUES (2, 'writer', SHA2('123', 512));
INSERT INTO t_user (userid, username, password) VALUES (3, 'other', SHA2('123', 512));

INSERT INTO t_role (roleid, rolename) VALUES (1, 'BSRead');
INSERT INTO t_role (roleid, rolename) VALUES (2, 'BSWrite');
INSERT INTO t_role (roleid, rolename) VALUES (3, 'BSOther');

INSERT INTO t_user_role (userid, roleid) VALUES (1, 1);
INSERT INTO t_user_role (userid, roleid) VALUES (2, 1);
INSERT INTO t_user_role (userid, roleid) VALUES (2, 2);
INSERT INTO t_user_role (userid, roleid) VALUES (3, 3);