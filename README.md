# Indel-Group-Project
## Consulta SQL Tarea 2
```sql
Select PAIS.ID_PAIS, 
		PAIS.NOMBRE_PAIS, 
        CIUDAD.ID_CIUDAD, 
        CIUDAD.NOMBRE_CIUDAD, 
        (IFNULL(VALOR_CIUDAD,VALOR_PAIS)) AS VALOR, 
        (SELECT DESCRIPCION_TIPO FROM TIPO_JJOO where SEDE_JJOO.ID_TIPO_JJOO=TIPO_JJOO.ID_TIPO_JJOO) AS DESCRIPCION_TIPO, 
        (count(SEDE_JJOO.SEDE)) AS CANTIDAD
FROM CIUDAD
INNER JOIN PAIS on CIUDAD.ID_PAIS=PAIS.ID_PAIS
LEFT OUTER JOIN SEDE_JJOO on CIUDAD.ID_CIUDAD=SEDE_JJOO.SEDE
GROUP BY ciudad.ID_CIUDAD;
```

## Manual de despligue
1. Instalar JRE 1.7 o superior
2. Tener la base de datos en el servidor mysql
  2. Configuración 
    * usr: root
    * password:root
    * ip:localhost
    * nombre db:juegosolimpicos
3. En caso de tu configuración ser diferente ir al archivo DbConnection.java ubicado en Indel-Group-Project\TestQuindel\src\main\java\modelo y modificar dichos datos que difieran, una vez hecho esto volver a generar el ejecutable
4. Si son iguales los datos puedes ejecutar el archivo ejercicio1.jar

>NOTA: Por la configuración de mi base de datos me surgía un [problema](http://stackoverflow.com/questions/26515700/mysql-jdbc-driver-5-1-33-time-zone-issue) y la solucion puede ser que afecte como te conectas a la base de datos


## Descripcion de clases
Se trato de utilizar un arquitectura MVC por lo que se generaron 3 paquetes, con sus respectivos nombres modelo, vista, controlador
###### Paquete modelo:
Tiene las clases DAO y las clases que representan las entidades.
Tiene dos clases a mayor que son DbConection y DbUtil. La primera es utilizada para crear la conexion a la base de datos usando el patron singleton, y la segunda nos da metodos para realizar las desconexiones
###### Paquete controlador:
Contiene las clases necesarias para implementar las funcionalidades de la vistas. Añade toda la logica para realizar las consultas
###### Paquete vista:
La idea de la vista fue tener una clase Principal que era la que creaba el proyecto, y luego las otras clases son clases que heradan de Composite. Y mediante la pila de layout de shell principal mostrar el composite en la ventana principal.
