# BSPQ-03_server

A continuación se muestran los comandos que se deben ejecutar en la línea de comandos para lanzar el servidor de la aplicación "DeustoTickets". 

Limpiar los archivos y directorios generados por Maven durante su compilación. 

      mvn clean

Compilar el proyecto.

      mvn compile
      
Crear el esquema de la base de datos.

      mvn datanucleus:schema-create

Lanzar el programa.

    	mvn jetty:run

En este momento, el servidor está lanzado y funcionando; es decir, se puede empezar a usar la aplicación.

*Notas: 
1. Es necesario tener la aplicación de la BD abierta.
2. En caso de querer visualizar las dependencias del proyecto, ejecutar el siguiente comando:
	
    	mvn dependecy:tree

Comando para ejecutar las pruebas unitarias:

      mvn test