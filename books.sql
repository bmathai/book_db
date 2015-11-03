-- Book Normalization --Again-- assignment
-- Lucas Clarke, Konstantin Kazantsev, Blaise Maathia, Sean Stamm, Andrew Proctor, Amanda Lail
-- Due on Thursday


-- -----------------------------------------------------
-- Use your database
-- -----------------------------------------------------
-- use yourDB

-- -----------------------------------------------------
-- Drop all tables if they exist
-- -----------------------------------------------------
drop table if exists bookhasauthor;
drop table if exists books;
drop table if exists publisher;
drop table if exists author;

-- -----------------------------------------------------
-- Authors Table
-- -----------------------------------------------------
create table author(
	authorId int not null,
    authorLname varchar(25) not null,
    authorFname varchar(25) not null,
    PRIMARY KEY (authorId)
);

-- -----------------------------------------------------
-- Publishers Table
-- -----------------------------------------------------
create table publisher(
	publisherName varchar(50) not null,
    publisherAdd varchar(50) not null,
	PRIMARY KEY (publisherName)
);

-- -----------------------------------------------------
-- Books Table
-- -----------------------------------------------------
create table books(
	isbn int not null,
    title varchar(100) not null,
    publisherName varchar(50) not null,
    totalCopiesOrdered int not null,
    copiesInStock int not null,
    publicationDate date not null,
    category varchar(25) not null,
    cost decimal(10,2) not null,
    FOREIGN KEY (publisherName) REFERENCES publisher(publisherName),
    PRIMARY KEY (isbn)
);

-- -----------------------------------------------------
-- Books Has Authors Table
-- -----------------------------------------------------
create table bookhasauthor(
	isbn int not null,
    authorId int not null,
    FOREIGN KEY (isbn) REFERENCES books(isbn),
    FOREIGN KEY (authorId) REFERENCES author(authorId),
    CONSTRAINT pk_BHAPK PRIMARY KEY (isbn, authorId)
);

-- -----------------------------------------------------
-- View SellingPrices
-- -----------------------------------------------------
create or replace view sellingPrices as select isbn, format(1.20*cost, 2) as sellingPrice from books;
