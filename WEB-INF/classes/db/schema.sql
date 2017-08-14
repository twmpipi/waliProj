/*
create table users(
id integer primary key,
name varchar(30),
email varchar(50)
);
*/



CREATE TABLE
    USERSIMINFO
    (
        SID INTEGER NOT NULL primary key,
        WALI_ID INTEGER,
        ICCID VARCHAR(30),
        MIFARE_ID VARCHAR(30),
        JOINT_SIM INTEGER,
        IS_ENABLE INTEGER,
        CREATE_DATE DATE,
        UPDATE_DATE DATE
        
    )
 
