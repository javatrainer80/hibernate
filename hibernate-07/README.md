# One-to-Many
Note:Keep hbm2ddl.auto to create then run the program-
     copy the generated the queries and use them
- OneToMany - FETCH strategy by default LAZY     
# entities
- Department 1...n employees

@JoinColumn(name = "dept_id",referencedColumnName = "dept_id")
- employee table join column name = "dept_id"
- Department table primary_key reference in employee table-> referencedColumnName = "dept_id"

```SQL
create table DEPARTMENT (
        DEPT_ID integer not null auto_increment,
        EMP_NAME varchar(255),
        primary key (DEPT_ID)
    ) engine=InnoDB;


 create table EMPLOYEE (
    EMP_ID integer not null auto_increment,
    dept_id integer,
    EMP_NAME varchar(255),
    primary key (EMP_ID)
) engine=InnoDB;


alter table EMPLOYEE 
   add constraint FK4ptfse7jwpwn2lrwocn8kuwmh 
   foreign key (dept_id) 
   references DEPARTMENT (DEPT_ID);
```