# spring-boot-new-template


curl --get http://localhost:8080/persons/test
curl --get http://localhost:8080/persons
curl -X POST -H "Content-Type: application/json" \
    -d '{"name": "linuxize"}' \
    http://localhost:8080/persons
curl -X POST -H "Content-Type: application/json" -d '{"name": "linuxize"}' http://localhost:8080/persons

curl -X GET http://localhost:8080/sessions
curl -X POST -H "Content-Type: application/json" -d '{"personId": 1, "date": "2023-07-20", "time": "11:11:00"}' http://localhost:8080/sessions 