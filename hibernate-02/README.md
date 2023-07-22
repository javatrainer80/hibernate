# hibernate.hbm2ddl.auto options
- create/update/validate/create-drop database
-
`<property name="hibernate.hbm2ddl.auto">update</property>`

# hbm2ddl.auto property the list of possible options is:

- `validate:` validate that the schema matches, make no changes to the schema of the database, you probably want this for production.
- delete table and try -(org.hibernate.tool.schema.spi.SchemaManagementException: Schema-validation: missing table [customer])
- `update:` update the schema to reflect the entities being persisted
- `create:` creates the schema necessary for your entities, destroying any previous data.
- `create-drop:` create the schema as in create above, but also drop the schema at the end of the session. This is great in early development or for testing.
- (console log: SessionFactory shut-down' Hibernate: drop table if exists customer)
 
`Don't use above options in production` expect validate   