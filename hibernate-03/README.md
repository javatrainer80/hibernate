# Hibernate 6 Generator Classes

- IDENTITY
- TABLE
- SEQUENCE
- AUTO
- UUID (for String types)

#MYSQL:

### IDENTITY:

Sybase, My SQL, MS SQL Server, DB2 and HypersonicSQL

```SQL
CREATE TABLE `customer` (
  `CUSTOMER_ID` int NOT NULL AUTO_INCREMENT,
  `CUSTOMER_ADDRESS` varchar(255) DEFAULT NULL,
  `CUSTOMER_AGE` int DEFAULT NULL,
  `CUSTOMER_NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`CUSTOMER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

```

```java
Entity:
@Id
	@Column(name = "CUSTOMER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	

```


# TABLE:

create below tables and insert first record into hibernate_sequences table.

```SQL
create table customer (
        CUSTOMER_AGE integer,
        CUSTOMER_ID integer not null,
        CUSTOMER_ADDRESS varchar(255),
        CUSTOMER_NAME varchar(255),
        primary key (CUSTOMER_ID)
    ) engine=InnoDB


    create table hibernate_sequences (
        next_val bigint,
        sequence_name varchar(255) not null,
        primary key (sequence_name)
    ) engine=InnoDB

    insert into hibernate_sequences(sequence_name, next_val) values ('default',0)


ex2:
  create table cust_sequence (
        next_val bigint,
        sequence_name varchar(255) not null,
        primary key (sequence_name)
    ) engine=InnoDB;

    insert into cust_sequence(sequence_name, next_val) values ('default',0)
```

```java
Entity:
@Id
@Column(name = "CUSTOMER_ID")
@GeneratedValue(strategy = GenerationType.TABLE,generator = "cust_seq")
@TableGenerator( 
        name = "cust_seq", 
        table = "cust_sequence", 
        pkColumnName = "sequence_name", 
        pkColumnValue = "default", 
        valueColumnName = "next_val", 
        initialValue = 1, 
        allocationSize = 2 )
	private Integer customerId;    
```



### AUTO:

- MySQL does not provide any built-in function to create a sequence.
- ERROR: could not read a hi value
- java.sql.SQLSyntaxErrorException: Table 'cis.customer_seq' doesn't exist

- If we use AUTO , it will look for  `sequence` or `table` generator .
- UUID values will use the UUIDGenerator.


But, we can create table/sequence and use with AUTO as below.

```SQL
create table customer (
        CUSTOMER_AGE integer,
        CUSTOMER_ID integer not null,
        CUSTOMER_ADDRESS varchar(255),
        CUSTOMER_NAME varchar(255),
        primary key (CUSTOMER_ID)
    ) engine=InnoDB

create table customer_SEQ (
        next_val bigint
    ) engine=InnoDB;
    
insert into customer_SEQ( next_val) values (0);

```

```java
Entity:
    @Id
	@Column(name = "CUSTOMER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "cust_seq")
	@TableGenerator( 
	        name = "cust_seq", 
	        table = "cust_sequence", 
	        pkColumnName = "sequence_name", 
	        pkColumnValue = "default", 
	        valueColumnName = "next_val", 
	        initialValue = 1, 
	        allocationSize = 2 )

```


