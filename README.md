# BSPQ-03_server

A continuación se indican los comandos que has de ejecutar en la línea de comandos para lanzar el servidor de la aplicación "DeustoTickets". 

Limpiar el servidor por si hubiera algún problema. 

      mvn clean

Compilar el programa.

      mvn compile
      
Crear el esquema de la base de datos.

      mvn datanucleus:schema-create

Lanzar el programa.

    	mvn jetty:run

En este momento, el servidor está lanzado y funcionando; es decir, se puede empezar a usar la aplicación.

*Notas: 
1. Es necesario tener la aplicación de la BBDD abierta.
2. Si quieres ver las dependencias, puedes introducir el siguiente comando:
	
	
		
    		mvn dependecy:tree