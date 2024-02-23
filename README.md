

# CONSULTORIO ODONTOLÓGICO  <a href="https://www.java.com" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="50" height="50"/> </a> <a href="https://www.mysql.com/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/mysql/mysql-original-wordmark.svg" alt="mysql" width="50" height="50"/> </a> 
<a href="https://getbootstrap.com" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/bootstrap/bootstrap-plain-wordmark.svg" alt="bootstrap" width="40" height="40"/> </a>


[![My Skills](https://skillicons.dev/icons?i=java,mysql,bootstrap,css,html&theme=light)](https://skillicons.dev)

<p>Este proyecto consiste en un sistema de gestión para un consultorio odontológico, diseñado para ser utilizado principalmente por un secretario administrativo y 
  los odontólogos del consultorio. Permite la administración de pacientes, sus datos, tratamientos y la asignación de turnos.</p>

### Acceso de Prueba</h2>

<p>Puedes acceder al sistema utilizando las siguientes credenciales de prueba:</p>
<ul>
    <li><strong>Usuario:</strong> Nicolas</li>
    <li><strong>Contraseña:</strong> 12345</li>
</ul>

<p><strong>Nota:</strong> Debido a que se utiliza un servidor de pruebas (Clever Cloud), es posible que experimentes demoras en la carga de información. Por favor, ten paciencia.</p>

### Tecnologías Utilizadas 

### Tecnologías



![MySQL](https://img.shields.io/badge/-MySQL-4479A1?style=flat&logo=mysql&logoColor=white)
![Bootstrap](https://img.shields.io/badge/-Bootstrap-563D7C?style=flat&logo=bootstrap)
![HTML](https://img.shields.io/badge/-HTML-E34F26?style=flat&logo=html5&logoColor=white)
![CSS](https://img.shields.io/badge/-CSS-1572B6?style=flat&logo=css3)



### Diagrama UML

<p>Se adjunta un <a href="https://drive.google.com/file/d/13NLkbEsxkjllju42LSSjwZ-1V499CiKj/view?usp=sharing">diagrama UML</a> que muestra las relaciones entre las diferentes clases del sistema.</p>

### Instrucciones de Ejecución

<p>Para ejecutar la aplicación localmente, sigue estos pasos:</p>
<ol>
    <li>Clona este repositorio en tu máquina local.</li>
    <li>Asegúrate de tener Docker instalado en tu sistema.</li>
    <li>Abre una terminal y navega hasta el directorio del proyecto.</li>
    <li>Ejecuta el siguiente comando para construir la imagen de Docker:</li>
</ol>

<pre><code>docker build -t consultorio-odontologico .
</code></pre>

<ol start="5">
    <li>Una vez que se haya construido la imagen, ejecuta el siguiente comando para iniciar el contenedor:</li>
</ol>

<pre><code>docker run -d -p 8080:8080 consultorio-odontologico
</code></pre>

<p>Abre un navegador web y navega a <code>http://localhost:8080/ConsultorioOdontologico-1.0-SNAPSHOT/login.jsp</code> para acceder a la aplicación.</p>

### Contribuciones

<p>Las contribuciones son bienvenidas. Si deseas contribuir a este proyecto, por favor crea un "issue" detallando tu propuesta de mejora o envía una solicitud de extracción con tus cambios.</p>

### Licencia

<p>Este proyecto está bajo la Licencia MIT. Consulta el archivo <code>LICENSE</code> para más detalles.</p>

<hr>

<p><strong>Autor:</strong> <a href="https://github.com/tu-usuario">Tu Nombre</a></p>
<p><strong>Fecha:</strong> 23 de Febrero, 2024</p>
