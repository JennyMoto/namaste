-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2018-01-27 21:43:24.459

-- tables
-- Table: Classes
CREATE TABLE Classes (
    ID integer  NOT NULL,
    ClassesType_ID integer  NOT NULL,
    ClassesRooms_ID integer  NOT NULL,
    Instructors_ID integer  NOT NULL,
    CONSTRAINT Classes_pk PRIMARY KEY (ID)
) ;

-- Table: ClassesReservations
CREATE TABLE ClassesReservations (
    ID integer  NOT NULL,
    Classes_ID integer  NOT NULL,
    CancelDate timestamp  NOT NULL,
    Members_ID integer  NOT NULL,
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

-- Table: Members
CREATE TABLE Members (
    ID integer  NOT NULL,
    Persons_ID integer  NOT NULL,
    CONSTRAINT Members_pk PRIMARY KEY (ID)
) ;

-- Table: Persons
CREATE TABLE Persons (
    ID integer  NOT NULL,
    Name varchar2(20)  NULL,
    Surname varchar2(30)  NULL,
    Email varchar2(20)  NOT NULL,
    Mobile varchar2(20)  NULL,
    CONSTRAINT Persons_pk PRIMARY KEY (ID)
) ;

-- Table: Instructors
CREATE TABLE Instructors (
    ID integer  NOT NULL,
    Persons_ID integer  NOT NULL,
    CONSTRAINT Instructors_pk PRIMARY KEY (ID)
) ;

-- foreign keys
-- Reference: ClassMembers_Classes (table: ClassesReservations)
ALTER TABLE ClassesReservations ADD CONSTRAINT ClassMembers_Classes
    FOREIGN KEY (Classes_ID)
    REFERENCES Classes (ID);

-- Reference: ClassesReservations_Members (table: ClassesReservations)
ALTER TABLE ClassesReservations ADD CONSTRAINT ClassesReservations_Members
    FOREIGN KEY (Members_ID)
    REFERENCES Members (ID);

-- Reference: Classes_ClassesRooms (table: Classes)
ALTER TABLE Classes ADD CONSTRAINT Classes_ClassesRooms
    FOREIGN KEY (ClassesRooms_ID)
    REFERENCES ClassesRooms (ID);

-- Reference: Classes_ClassesType (table: Classes)
ALTER TABLE Classes ADD CONSTRAINT Classes_ClassesType
    FOREIGN KEY (ClassesType_ID)
    REFERENCES ClassesType (ID);

-- Reference: Classes_Instructors (table: Classes)
ALTER TABLE Classes ADD CONSTRAINT Classes_Instructors
    FOREIGN KEY (Instructors_ID)
    REFERENCES Instructors (ID);

-- Reference: Members_Persons (table: Members)
ALTER TABLE Members ADD CONSTRAINT Members_Persons
    FOREIGN KEY (Persons_ID)
    REFERENCES Persons (ID);

-- Reference: Instructors_Persons (table: Instructors)
ALTER TABLE Instructors ADD CONSTRAINT Instructors_Persons
    FOREIGN KEY (Persons_ID)
    REFERENCES Persons (ID);

-- End of file.

