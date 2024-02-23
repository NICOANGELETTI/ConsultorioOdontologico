

# CONSULTORIO ODONTOLÓGICO  <a href="https://www.java.com" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="50" height="50"/> </a> <a href="https://www.mysql.com/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/mysql/mysql-original-wordmark.svg" alt="mysql" width="50" height="50"/> </a> 



<p>Este proyecto consiste en un sistema de gestión para un consultorio odontológico, diseñado para ser utilizado principalmente por un secretario administrativo y 
  los odontólogos del consultorio. Permite la administración de pacientes, sus datos, tratamientos y la asignación de turnos.</p>

### Las Principales Funciones son:

- Administrar datos de odontólgos y pacientes.
- Validar el ingreso al sistema mediante un login con usuario y password.
- Asignar a un paciente un turno con un respectivo odontólogo a una determinada fecha y horario
- Crear,Leer, Actualizar y eliminar(CRUD) registros de tipo Odontologos,Pacientes,Usuarios y Turnos.


### Acceso de Prueba</h2>

<p>Puedes acceder al sistema utilizando las siguientes credenciales de prueba:</p>
<ul>
    <li><strong>Usuario:</strong> Nicolas</li>
    <li><strong>Contraseña:</strong> 12345</li>
</ul>

<p><strong>Nota:</strong> Debido a que se utiliza un servidor de pruebas (Clever Cloud), es posible que experimentes demoras en la carga de información. Por favor, ten paciencia.</p>

### Tecnologías Utilizadas 


![Java](https://img.shields.io/badge/-Java-007396?style=flat&logo=java)
![MySQL](https://img.shields.io/badge/-MySQL-4479A1?style=flat&logo=mysql&logoColor=white)
![Bootstrap](https://img.shields.io/badge/-Bootstrap-563D7C?style=flat&logo=bootstrap)
![HTML](https://img.shields.io/badge/-HTML-E34F26?style=flat&logo=html5&logoColor=white)
![CSS](https://img.shields.io/badge/-CSS-1572B6?style=flat&logo=css3)


### Front:

El frontend de la aplicación se desarrolló utilizando JSP (JavaServer Pages) para la generación dinámica de contenido HTML. Se combinó HTML con JSP scriptlets para crear páginas web dinámicas adaptadas a las necesidades del usuario y los datos del servidor. Además, se utilizó Bootstrap para mejorar el diseño y la apariencia de la interfaz de usuario, aprovechando sus componentes y estilos predefinidos. La integración de una plantilla predefinida de Bootstrap facilitó el desarrollo y aseguró la consistencia del diseño en todo el sistema. Esta combinación de tecnologías proporcionó una interfaz de usuario atractiva y receptiva para los usuarios del sistema.

### Back:

El backend de la aplicación se desarrolló principalmente con Java y Servlets para manejar las solicitudes y generar respuestas dinámicas. Para la persistencia de datos, se utilizó MySQL como base de datos, con JPA (Java Persistence API) como unidad de persistencia para interactuar con la base de datos alojada en Clever Cloud.

La arquitectura sigue el patrón de diseño Modelo-Vista-Controlador (MVC), donde se separan claramente las responsabilidades entre la capa de presentación (Vista), la capa de lógica de negocio (Modelo) y la capa de control (Controlador). Esta separación facilita el mantenimiento y la escalabilidad del sistema.

La capa de lógica de persistencia, se encarga de gestionar los datos y la lógica de negocio de la aplicación. JPA se utiliza para mapear objetos Java a entidades de la base de datos y proporcionar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) de manera eficiente. Esto permite una interacción fácil y robusta con la base de datos, asegurando la integridad y consistencia de los datos. 


## Uso 

Asegúrate de tener instalados los siguientes componentes:
- Java 8
- Maven
- Entorno de desarrollo NetBeans
- Servidor de aplicaciones Apache Tomcat

  
## Guia Instalacion
Pasos para Descargar, Abrir y Ejecutar la Aplicación en NetBeans:

1- Clona el Repositorio desde GitHub:

Abre tu navegador web y visita la página del repositorio en GitHub.
Haz clic en el botón "Code" y selecciona "Download ZIP" para descargar el proyecto como un archivo ZIP en tu computadora.
Extrae el contenido del archivo ZIP descargado en una ubicación de tu elección en tu computadora.

2- Abre el Proyecto en NetBeans:

Abre NetBeans y selecciona File > Open Project... en el menú principal.
Navega hasta la ubicación donde extrajiste el proyecto y selecciona la carpeta que contiene el código de la aplicación para abrirlo en NetBeans.

3- Compila el Proyecto:

Haz clic derecho sobre el proyecto en el panel de proyectos y selecciona Clean and Build.
Esto compilará el proyecto y generará un archivo WAR en el directorio target.

4- Ejecuta el Proyecto:

Haz clic derecho nuevamente sobre el proyecto en el panel de proyectos y selecciona Run para ejecutarlo en tu servidor de aplicaciones predeterminado.

5- Accede a la Aplicación:

Una vez que NetBeans haya desplegado la aplicación en tu servidor de aplicaciones, abre un navegador web y accede a la URL donde está alojada la aplicación. Por lo general, la URL será http://localhost:8080/ConsultorioOdontologiaFinal.


### Diagrama UML
<p>Se adjunta un <a href="https://drive.google.com/file/d/1Oj6dMJKmQlXK7qOcSj4QJf4MXfm3JW_q/view?usp=drive_link">diagrama UML</a> que muestra las relaciones entre las diferentes clases del sistema.</p>

