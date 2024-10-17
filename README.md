
# Luxmed

Microservice application, that implements a ‘CRUD’
with REST endpoints for JSON entity (not for all entities, only for root entity)
with the structure :

* The root object is the **company**.
* Each **company** has name and **departments**.
* Each **department** has name and contains **teams**.
* Each **team** has name and **project**.
* Each **project** has a **manager** with contact information.



Build project with Maven:
```
mvn package
```

Run project with Docker:
```
docker compose up
```
