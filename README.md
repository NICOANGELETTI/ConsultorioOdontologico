<h1>Consultorio Odontológico   :smile: </h1>

<img src="https://consultorio-odontologico.onrender.com/ConsultorioOdontologico-1.0-SNAPSHOT/login.jsp" alt="Consultorio Odontológico">

<p>Este proyecto consiste en un sistema de gestión para un consultorio odontológico, diseñado para ser utilizado principalmente por un secretario administrativo y 
  los odontólogos del consultorio. Permite la administración de pacientes, sus datos, tratamientos y la asignación de turnos.</p>

### Acceso de Prueba</h2>

<p>Puedes acceder al sistema utilizando las siguientes credenciales de prueba:</p>
<ul>
    <li><strong>Usuario:</strong> Admin</li>
    <li><strong>Contraseña:</strong> 1234</li>
</ul>

<p><strong>Nota:</strong> Debido a que se utiliza un servidor de pruebas (Clever Cloud), es posible que experimentes demoras en la carga de información. Por favor, ten paciencia.</p>

### Tecnologías Utilizadas 

<ul>
    <li><strong>Frontend:</strong> Se ha utilizado Bootstrap para la interfaz de usuario, junto con JSP para la estructura de las páginas.</li>
    <li><strong>Backend:</strong> El backend se ha desarrollado utilizando Servlets para las diferentes funciones. Las principales tecnologías utilizadas son:
        <ul>
            <li>Java</li>
            <li>Servlets</li>
            <li>JPA (EclipseLink) para la persistencia</li>
            <li>MySQL como base de datos</li>
        </ul>
    </li>
    <li><strong>Arquitectura:</strong> Se sigue el patrón de diseño MVC (Modelo-Vista-Controlador) para organizar el proyecto en capas, principalmente las de Lógica y Persistencia.</li>
    <li><strong>Base de Datos:</strong> Se utiliza MySQL a través del servicio de Clever Cloud para almacenar los datos del consultorio.</li>
    <li><strong>Docker:</strong> La aplicación se ha dockerizado para facilitar su despliegue y ejecución en diferentes entornos.</li>
</ul>

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
