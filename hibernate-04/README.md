# Hibernate CRUD Operations

- `save` (Returns newly inserted id & deprecated in 6.0 version) 
- `persist` ( It's return type is void)
- `get` (it return null if there is not object exist in DB else return existing object)
  it returns complete object. 
- `load` (Deprecated in 6.0. 
  if we try to retrieve object that doesn't exist in DB then it throws exception(org.hibernate.ObjectNotFoundException:  No row with the given identifier exists)
  It loads proxy object from DB. When we try to call any method on the object then it hit the DB and get the object
  it performs lazy loading.
  You should not use this method to determine if an instance exists in the database use `get()` instead)
- `delete` (Deprecated in 6.0)
- `remove` use it for remove object
- `update` (Deprecated in 6.0)
- `merge` (used in scenario where we loaded the same object again and again)
- `saveOrUpdate` (@deprecated use {@link #merge(String, Object)} or {@link #persist(Object)})
- `openSession` vs `currentSesion`

# Object states (life cycle of POJO)
- Transient state
- Persistent state
- Detached state

```java
-- Transient state start

Customer customer = new Customer();
customer.setCustomerName("Rahul");
customer.setCustomerAge(1);
customer.setCustomerAddress("SEC");

-- Transient state End	

-- Persistent State start
Transaction tx=session.beginTransaction();
session.persist(customer);
tx.commit();
-- Persistent State end

session.close();
sf.close()
-- object is in detached state(not associated with session)				

```




