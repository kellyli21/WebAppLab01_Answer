DROP TABLE IF EXISTS Member; 

CREATE TABLE Member(
	pk   INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	id   CHAR(32) NULL,
	pswd CHAR(64) NULL,
	NAME CHAR(50) NULL
);

INSERT INTO Member VALUES 
(NULL, 'kitty', 'k123', '凱蒂貓'), 
(NULL, 'micky', 'm456', '米小薯'), 
(NULL, 'snoopy', 's789', '史努比')
