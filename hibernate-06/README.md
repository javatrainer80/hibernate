# One-to-One

# entities
- Customer <-----> Address
- Employee <-----> Passport
- Student  <-----> Passport
- Country  <----->Capital

# mapping
- Can create address_id in customer table(address_id if foreign key in customer table(i.e address_id is primary key in address table))
             OR 
- Can create customer_id in address table(customer_id if foreign key in address table)              

# case 1
without saving passport object-if we try to insert employee , gets below error
- option1:save passport object before employee object.
- option2:use cascade options

org.hibernate.TransientObjectException: object references an unsaved transient instance - save the transient instance before flushing: com.tech2java.cis.entity.Passport

```sql
@OneToOne(targetEntity = Passport.class)
@JoinColumn(name = "pid",referencedColumnName = "PID")
- targetEntity = Passport.class -> optional 
- if we don't mention joinColumn-hibernate we will create foriegn column with passport_pid column


create table EMPLOYEE (
        EMP_ID integer not null auto_increment,
        pid integer,
        EMP_NAME varchar(255),
        primary key (EMP_ID)
    ) engine=InnoDB


    create table PASSPORT (
        PID integer not null auto_increment,
        PASSPORT_NUMBER varchar(255),
        primary key (PID)
    ) engine=InnoDB

    alter table EMPLOYEE 
       add constraint UK_nqbbpp0mxlqil2b373cysxr5q unique (pid)

    alter table EMPLOYEE 
       add constraint FKrsalsfsbiugpeyg9ckqjjc75q 
       foreign key (pid) 
       references PASSPORT (PID)    
```

- //session.persist(employee.getPassport());//persist passport (or use cascade options)