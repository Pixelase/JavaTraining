# Communal services

**Database backups:**
* _clean_ folder: just for unit tests and safety;
* _demo(with users)_ folder: ready for demonstration backup with some already registered users (for saving time);
* _demo(without users)_ folder: clean database just with predefined dictionary data (work types, work scopes, roles, etc);

_P.S. Better to use **demo(with users)**_


**Restore procedure:**
* Backup is in `.tar` format;
* 1 ignored error during restore process is ok
 (_ERROR:  must be owner of extension plpgsql_)


**Database properties:**
* jdbc.url=jdbc:postgresql://localhost:5432/demo_db
* jdbc.username=test
* jdbc.password=password
* db.schema=public

_________________________________
> ##### Babai Alexander