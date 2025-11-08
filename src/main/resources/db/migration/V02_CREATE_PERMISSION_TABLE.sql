CREATE TABLE PERMISSION_TABLE
(
	permission_id            INTEGER(16)   	NOT NULL PRIMARY KEY,
    name                	 VARCHAR(70) 	NOT NULL UNIQUE,
    description              VARCHAR(150)
);

CREATE TABLE USER_PERMISSION_TABLE
(
	user_id 				 INTEGER(16)    NOT NULL,
	permission_id			 INTEGER(16) 	NOT NULL,
	created_at               DATETIME     	NOT NULL DEFAULT CURRENT_TIMESTAMP,
    modified_at              DATETIME       DEFAULT NULL,
    PRIMARY KEY (user_id, permission_id),
    FOREIGN KEY (user_id)       REFERENCES  USER_TABLE (user_id),
    FOREIGN KEY (permission_id) REFERENCES  PERMISSION_TABLE (permission_id)
);

CREATE TABLE GROUP_TABLE
(
	group_id                 INTEGER(16)   	NOT NULL PRIMARY KEY,
	name                     VARCHAR(70) 	NOT NULL UNIQUE
	description              VARCHAR(70)
);

CREATE TABLE GROUP_PERMISSION_TABLE
(
	group_id      			 INTEGER(16)   	NOT NULL,
    permission_id			 INTEGER(16) 	NOT NULL,
  	PRIMARY KEY (group_id, permission_id),
  	FOREIGN KEY (group_id)       REFERENCES  GROUP_TABLE (group_id),
    FOREIGN KEY (permission_id) REFERENCES  PERMISSION_TABLE (permission_id)
);

CREATE TABLE USER_GROUP_PERMISSION_TABLE
(
	user_id                  INTEGER(16)   	NOT null,
	group_id      INTEGER(16)   	NOT NULL,
	PRIMARY KEY (user_id, group_id),
	FOREIGN KEY (group_id)       REFERENCES  GROUP_TABLE (group_id),
    FOREIGN KEY (user_id) REFERENCES  USER_TABLE (user_id)
);