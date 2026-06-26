# Todo Serverless App

Aplicación serverless desarrollada en AWS utilizando Java y AWS SAM para automatizar el despliegue de la infraestructura.

---

## Arquitectura

```text
TodoGetter
    │
    ▼
   SQS
    │
    ▼
TodoRegister
    │
    ▼
DynamoDB

Monitoreo: AWS X-Ray
```

---

## Tecnologías

* Java 21
* Maven
* AWS Lambda
* Amazon SQS
* Amazon DynamoDB
* AWS X-Ray
* AWS SAM

---

## Prerrequisitos

Antes de ejecutar el proyecto debes tener instalado:

* Java 21
* Maven
* AWS SAM CLI
* AWS CLI configurado
* Cuenta de AWS

---

## Construcción del proyecto

Compilar el proyecto y generar el archivo JAR:

```bash
mvn package
```

---

## Despliegue

Para desplegar la infraestructura en AWS:

```bash
sam deploy --guided
```

Este comando creará automáticamente los recursos definidos en el archivo:

```text
template.yaml
```

---

## Ejecución

1. Ingresar a la consola de AWS.
2. Buscar la función Lambda:

```text
TodoGetter
```

3. Crear un evento de prueba:

```json
{
  "id": "1"
}
```

4. Ejecutar el test.

---

## Flujo de la aplicación

```text
TodoGetter
    │
    ▼
Amazon SQS
    │
    ▼
TodoRegister
    │
    ▼
Amazon DynamoDB
```

AWS X-Ray se utiliza para el monitoreo y trazabilidad de las invocaciones.

---

## Entidades

### DTodo

Representa la información de las tareas almacenadas en DynamoDB.

### DUser

Representa la información de los usuarios asociados a las tareas.

---

## Infraestructura

La infraestructura se define mediante AWS SAM utilizando el archivo:

```text
template.yaml
```

Los recursos desplegados incluyen:

* AWS Lambda
* Amazon SQS
* DynamoDB
* Roles IAM
* Permisos necesarios
* Integración con AWS X-Ray

---

## Autor

Carlos Lopez

---

## Licencia

Este proyecto se distribuye únicamente con fines educativos y de aprendizaje.
