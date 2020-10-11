# API Spec

## Create Product
Request: 
- Method : POST
- Endpoint : `/api/products`
- Header : 
    - Content-Type : application/json
    - Accept : application/json
- Body : 

``` json
{ 
  "code": "number",
  "status": "string",
  "data": { 
            "id" : "string, unique",
            "name" : "string",
            "price" : "long",
            "quantity": "integer" },
  "message": "string"
}
```

- Response :
``` json
{
  "code": "number",
  "status": "string",
  "data": { 
            "id" : "string, unique",
            "name" : "string",
            "price" : "long",
            "quantity": "integer",
            "createdAt": "date",
            "updatedAt": "date" },
  "message": "string"
}
```

## Get Product
Request: 
- Method : GET
- Endpoint : `/api/products/{product_id}`
- Header : 
    - Accept : application/json
- Response :
``` json
{ 
  "code": "number",
  "status": "string",
  "data": { 
            "id" : "string, unique",
            "name" : "string",
            "price" : "long",
            "quantity": "integer",
            "createdAt": "date",
            "updatedAt": "date" },
  "message": "string"
}
```

## Update Product
Request: 
- Method : PUT
- Endpoint : `/api/products/{product_id}`
- Header : 
    - Content-Type : application/json
    - Accept : application/json
- Body : 

``` json
{
  "code": "number",
  "status": "string",
  "data": { 
            "name" : "string",
            "price" : "long",
            "quantity": "integer" },
  "message": "string"
}
```

- Response :
``` json
{ 
  "code": "number",
  "status": "string",
  "data": { 
            "id" : "string, unique",
            "name" : "string",
            "price" : "long",
            "quantity": "integer",
            "createdAt": "date",
            "updatedAt": "date" },
  "message": "string"
}
```

## List Product
Request: 
- Method : GET
- Endpoint : `/api/products/`
- Header : 
    - Accept : application/json
- Query Param:
    - size : number 
    - page : number
- Body : 
``` json
{ 
  "code": "number",
  "status": "string",
  "data": [{ 
            "id" : "string, unique",
            "name" : "string",
            "price" : "long",
            "quantity": "integer",
            "createdAt": "date",
            "updatedAt": "date" },
            { 
            "id" : "string, unique",
            "name" : "string",
            "price" : "long",
            "quantity": "integer",
            "createdAt": "date",
            "updatedAt": "date" }],
  "message": "string"
}
```

- Response :
``` json
{ 
  "code": "number",
  "status": "string",
  "data": { 
            "id" : "string, unique",
            "name" : "string",
            "price" : "long",
            "quantity": "integer",
            "createdAt": "date",
            "updatedAt": "date" },
  "message": "string"
}
```

## Delete Product
Request: 
- Method : DELETE
- Endpoint : `/api/products/{product_id}`
- Header : 
    - Accept : application/json
- Response :
``` json
{ 
  "code": "number",
  "status": "string",
  "message": "string"
}
```
