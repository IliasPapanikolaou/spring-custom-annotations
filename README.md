# Custom annotations

## Endpoints
Employee POST: http://localhost:8080/employees

Custom validator annotation:
Invalid message:
```json
{
  "firstName": "John",
  "lastName": "Rambo",
  "doj": "12-5-55",
  "dept": "Combat",
  "email": "rambo@mail.com",
  "employeeType": "something"
}
```

Correct message (employeeType: Permanent/Vendor):
```json
{
  "firstName": "John",
  "lastName": "Rambo",
  "doj": "12-5-55",
  "dept": "Combat",
  "email": "rambo@mail.com",
  "employeeType": "Permanent"
}
```