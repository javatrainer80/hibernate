# ManyToOne

- ManyToOne- default FETCH is EAGER
- ****ToMany is always LAZY
- ****ToOne is always EAGER
#Entities:

- Employee n....1 Department
- Review n....1 Post

Note: creating dept_id in employee table is good design.If we create emp_id in Department table, can't store multiple employees in emp_id column.

- Don't make any changes to OneToMany tables - use it for ManyToOne
- Good practice is to use OneToMany over ManyToOne
- delete(it's bit tricky)- can't delete dept by employee as other employees ties with same dept
  option-1: Don't use cascade options
  option-2: Use OneToMany
  option-3: Use Bidirectional mapping
  
 - Gets StackOverFlowError - if we add toString() methods in both DEPT and EMPLOYEE entities. 

 
# note

If we use mapped by in department entity no need to use @jonColumn 

```java
Department:

@OneToMany(targetEntity = Employee.class,
			   cascade = CascadeType.ALL,
			   fetch = FetchType.LAZY,
			   mappedBy = "department")//need add in opposite of owning entity. Employee is owning entity with dept_id
	//@JoinColumn(name = "dept_id", referencedColumnName = "dept_id")
	private Set<Employee> employees=new HashSet<>();
	
Employee:

@ManyToOne(targetEntity = Department.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="dept_id",referencedColumnName = "dept_id")
	private Department department;	
```
	