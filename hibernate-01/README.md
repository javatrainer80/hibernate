# Hibernate
Hibernate First Example

# Some of the key features and improvements in Hibernate 6 include:

* Support for Java 17
* Improved query performance
* Streamlined APIs
* Modular architecture
* Enhanced validation

# download hibernate latest version 


#steps to create hibernate program
- Step 1: Create a Database
- Step 2: Create a Entity Class
- Step 3: Create a Hibernate Configuration file(hibernate.cfg.xml)
- Step 4: Create a Mapping XML file(*.hbm.xml)
- Step 5: Write client clode to run the program

#add `hibernate` and mysql `dependencies` pom.xml

``` xml
<dependency>
	<groupId>org.hibernate.orm</groupId>
	<artifactId>hibernate-core</artifactId>
	<version>6.2.1.Final</version>
</dependency>

<dependency>
	<groupId>mysql</groupId>
	<artifactId>mysql-connector-java</artifactId>
	<version>8.0.33</version>
</dependency>

```

# hibernate.cfg.xml file

```xml
<?xml version="1.0" encoding="UTF-8"?>

<!DOCTYPE hibernate-configuration PUBLIC
        "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
        "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">

<hibernate-configuration>
	<session-factory>

		<!-- Connection settings -->
		<property name="hibernate.connection.driver_class"></property>
		<property name="hibernate.connection.url"></property>
		<property name="hibernate.connection.username"></property>
		<property name="hibernate.connection.password"></property>
		<!-- SQL dialect -->
		<property name="hibernate.dialect"></property>
		<!-- Print executed SQL to stdout -->
		<property name="show_sql">true</property>
		<property name="format_sql">true</property>
	
		<!-- Create/Update/Validate/Create-drop database -->
		<!--<property name="hibernate.hbm2ddl.auto">update</property>-->
		<!-- Annotated entity classes <mapping class="com.tech2java.Customer"/> -->
		<mapping resource="" />
	</session-factory>
</hibernate-configuration>
```

# Mapping file

```xml
<?xml version="1.0" encoding="UTF-8"?>

<!DOCTYPE hibernate-mapping PUBLIC 
"-//Hibernate/Hibernate Mapping DTD//EN"
"http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd"> 

<hibernate-mapping>
   <class name = "" table = "">
      
      <id name = "id" type = "long" column = "id">
         <generator class="identity"/>
      </id>
      
      <property name = "customerName" column = "" type = "string"/>
      <property name = "" column = "" type = "int"/>
      
   </class>
</hibernate-mapping>
```


#question

What will happen if `hibernate.properties` and `hibernate.cfg.xml` both present in class path?
- If hibernate.properties and hibernate.cfg.xml both present in class path, hibernate.cfg.xml setting will override the hibernate.properties values. hibernate.properties configuration values are global Environment properties.