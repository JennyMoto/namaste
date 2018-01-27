-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2018-01-27 12:34:21.924

-- tables
-- Table: Classes
CREATE TABLE Classes (
    ID integer  NOT NULL,
    ClassesType_ID integer  NOT NULL,
    ClassesRooms_ID integer  NOT NULL,
    Persons_ID integer  NOT NULL,
    CONSTRAINT Classes_pk PRIMARY KEY (ID)
) ;

-- Table: ClassesReservations
CREATE TABLE ClassesReservations (
    ID integer  NOT NULL,
    Persons_ID integer  NOT NULL,
    Classes_ID integer  NOT NULL,
    CancelDate timestamp  NOT NULL,
    CONSTRAINT ClassesReservations_pk PRIMARY KEY (ID)
) ;

-- Table: ClassesRooms
CREATE TABLE ClassesRooms (
    ID integer  NOT NULL,
    RoomName varchar2(10)  NULL,
    MembersLimit integer  NULL,
    CONSTRAINT ClassesRooms_pk PRIMARY KEY (ID)
) ;

-- Table: ClassesType
CREATE TABLE ClassesType (
    ID integer  NOT NULL,
    Name varchar2(20)  NULL,
    CONSTRAINT ClassesType_pk PRIMARY KEY (ID)
) ;

-- Table: Persons
CREATE TABLE Persons (
    ID integer  NOT NULL,
    Name varchar2(20)  NULL,
    Surname varchar2(30)  NULL,
    Email varchar2(20)  NOT NULL,
    Mobile varchar2(20)  NULL,
    IsInstructor smallint  NULL,
    CONSTRAINT Persons_pk PRIMARY KEY (ID)
) ;

-- foreign keys
-- Reference: ClassMembers_Classes (table: ClassesReservations)
ALTER TABLE ClassesReservations ADD CONSTRAINT ClassMembers_Classes
    FOREIGN KEY (Classes_ID)
    REFERENCES Classes (ID);

-- Reference: ClassMembers_Persons (table: ClassesReservations)
ALTER TABLE ClassesReservations ADD CONSTRAINT ClassMembers_Persons
    FOREIGN KEY (Persons_ID)
    REFERENCES Persons (ID);

-- Reference: Classes_ClassesRooms (table: Classes)
ALTER TABLE Classes ADD CONSTRAINT Classes_ClassesRooms
    FOREIGN KEY (ClassesRooms_ID)
    REFERENCES ClassesRooms (ID);

-- Reference: Classes_ClassesType (table: Classes)
ALTER TABLE Classes ADD CONSTRAINT Classes_ClassesType
    FOREIGN KEY (ClassesType_ID)
    REFERENCES ClassesType (ID);

-- Reference: Classes_Persons (table: Classes)
ALTER TABLE Classes ADD CONSTRAINT Classes_Persons
    FOREIGN KEY (Persons_ID)
    REFERENCES Persons (ID);

-- End of file.

