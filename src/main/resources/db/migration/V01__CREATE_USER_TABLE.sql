CREATE TABLE USER_TABLE
(
    user_id                  INTEGER(16)   	NOT NULL PRIMARY KEY,
    name					 VARCHAR(70)    NOT NULL,
    email                	 VARCHAR(150) 	NOT NULL UNIQUE,
    password                 VARCHAR(100) 	NOT NULL,
    role               		 VARCHAR(20)  	NOT NULL,
    status               	 tinyint        DEFAULT 1,
    created_at               DATETIME     	NOT NULL DEFAULT CURRENT_TIMESTAMP,
    modified_at              DATETIME       DEFAULT NULL,
    last_login_at            DATETIME       DEFAULT NULL,
    password_reset_token     VARCHAR(6)   	NULL
);
