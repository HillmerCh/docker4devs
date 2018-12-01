# Docker para desarrolladores

Este workshop presenta como utilizar a Docker para desarrollo de software, 
en algunas partes de este material encontrara 4 signos de interrogación `????`, estos son una senal de observación 
para ejeuctar, observar y/o analizar

## Pre-requisitos

- Docker
- IDE de desarrollo o herramienta de conexión a base de datos
- Maven (Opcional)

## Primeros pasos en Docker

En este sección se presentan comandos iniciales para la creación de contenedores en Docker

* Comando docker

   ```
   docker
   ```  
* ????
   ```
   docker ps
   ```
* ????
   ```
   docker images
   ```
* Desplegar un contenedor
   ```
   docker run <NOMBRE_IMAGEN>
   ```
* Crear un contenedor con un nombre especifico
    ```
   docker run --name <NOMBRE_CONTENEDOR> <NOMBRE_IMAGEN>
   ```
* ????
   ```
   docker run -d <NOMBRE_IMAGEN>
   ```
   
## BaseS de datos en Docker

Este sección presenta como desplegar una intancia de base de datos POstgresSQL. 
Docker puede ser utilizado para crear base de datos MySQL, Oracle Database, Amazon DynamoDB, Microsoft SQL Server, MongoDB entre otras.

* Crear un contenedor de base de datos Postgres
   ```
   docker run --name <MY_CONTENEDOR> -d postgres
   ```
* Opcional: Crear un contenedor de base de datos Postgres con parámetros de ambiente (Para asignar un password) 
   ```
   $ docker run --name <MY_CONTENEDOR> -e POSTGRES_PASSWORD=<MI_PASSWORD> -d postgres
   ```
* Acceder a la base de datos (dentro del contenedor)
   ```
   docker run -it --rm --link <MY_CONTENEDOR>:postgres postgres psql -h postgres -U postgres
   ```

    ```
    -it  ????
	--rm ????
   ```   
* Acceder a la base de datos (desde afuera del contenedor) utilice un IDE o Herramienta de acceso a base de datos 
   ```
   docker run --name my-postgres -p 5432:5432 postgres
   ```
   
   ```
   -p ????:????
   ```
   
* Utilice la conexión a la base de datos y crea una alguna tabla e insertele algunos datos

* Detenga el contenedor, inicielo y conectese  a la base de datos, consulte la tabla creada anteriormente. 

* Nuevemante detenga el contenedor, pero esta vez inicielo con el siguiente comando
   ```
   docker run --name my-postgres -v pgdata:/var/lib/postgresql/data  -p 5432:5432 postgres
   ```  
* Vuelva a crear una tabla, inserte datos, luego detenga el contenedor, use nuevamente el comando anterior para reiniciarlo y consulte la tabla creada

   ```
   -v ????
   ```

## Aplicaciones en Docker

Este sección presenta como desplegar una aplicación Java utilizando el servidor de aplicaciones Payara. 
Docker puede ser utilizado para aplicaciones utilizando servidores como Apache y Microsoft IIS.

* 
   ```
   mvn package -f app/pom.xml
   ```
   
   ```
   docker build -t mi-app-imagen .
   ```
   
* Consultar la imagen creada

   ```
   docker ????
   ```

   ```
   docker run -it --rm -p 4848:4848 -p 8080:8080 mi-app-imagen
   ```

   ```
   http://127.0.0.1:8080/java-docke4devs/rest/hello/
   ```
   

* Ver logs del servidor 

   ```
   docker run -it --rm --name mi-app -p 4848:4848 -p 8080:8080 -d mi-app-imagen 
   ```

$ docker logs --tail=all -f mi-app

Acceder al SO del contenedor de mi-app

$ docker ????


## Cargando imágenes en la libreria de docker hub 

* Loguearse en Docker Hub utilizando el comando de docker login:
   ```
   docker login
   ```
* Crear una imagen de Docker:
   ```
   docker build -t <CUENTA_DOCKER_HUB>/mi-app-imagen:v1 .
   ```
* Cargar la imagen en Docker Hub:
   ```
   docker push <CUENTA_DOCKER_HUB>/mi-app-imagen:v1
   ```
* Consultar la imagen el docker hub via internet
   ```
   https://hub.docker.com/r/<CUENTA_DOCKER_HUB>/
   ```