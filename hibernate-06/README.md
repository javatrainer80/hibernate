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

- OneToOne relationship always EAGER FETCH.
  Passport details will be fetched while fetching employee.
  
```SQL

    select
        e1_0.EMP_ID,
        e1_0.EMP_NAME,
        p1_0.PID,
        p1_0.PASSPORT_NUMBER 
    from
        EMPLOYEE e1_0 
    left join
        PASSPORT p1_0 
            on p1_0.PID=e1_0.pid 
    where
        e1_0.EMP_ID=?
```
#  
- in jpa, PersistenceContenxt = Session
- if we add @Trasnactional on method- it is applicable for entire method.
- if we don't add @Transactional- then each method call open transaction & close as soon as method call completes.

```java
 @Transactional
  perform(){
  
    get()
    save()
    update()
    
  }
```
- JPA (EntityManager & PersistanceContext ,Transactional)
- Hibernate (SessionFactory & Session)

# Bidirectional
- Add mapped by non-owning side of relationship so OneToOne relationship owned by Employee now else duplicate data in   both tables

- if we add mappedBy="passport" , then in PASSPORT table student_id column will not be created.
  