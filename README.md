# ForoHub API ✨

ForoHub es una API REST desarrollada en **Java** y **Spring Boot**, diseñada para gestionar un foro dinámico con funcionalidades esenciales y avanzadas. Este proyecto es parte de mi formación en Alura Latam y se centra en tópicos, respuestas y cursos.

## 🚀 Características Principales
- **CRUD** de tópicos, respuestas y cursos.
- Filtros avanzados para organizar y buscar información.
- Gestión de estados de tópicos: abierto, cerrado, archivado, anclado.
- Autenticación y autorización utilizando **JWT**.
- Eliminación lógica de datos para mayor seguridad.

---

## 📏 Reglas de Negocio
1. **Registrar Tópico**
    - Los usuarios autenticados pueden crear nuevos tópicos con un título, descripción y etiquetas relevantes.

2. **Eliminar Tópico**
    - Los administradores pueden realizar eliminaciones lógicas de tópicos.

3. **Actualizar Tópico**
    - Administradores y moderadores pueden modificar la información de un tópico.

4. **Autenticación**
    - Se requiere autenticación para crear, actualizar o eliminar datos. Seguridad garantizada con **JWT**.

5. **Listar Tópicos**
    - Acceso público a la lista de tópicos con opciones de filtrado y ordenación.

6. **Crear Respuesta**
    - Usuarios y administradores pueden añadir respuestas a los tópicos.

7. **Actualizar Respuesta**
    - Corrección de contenido en respuestas ya publicadas.

---

## 🎁 Funcionalidades Adicionales
- **Eliminación lógica** de usuarios, tópicos y respuestas.
- **Cifrado de contraseñas** con **Bcrypt**.
- **Autorización por roles** para acceso controlado.
- Protección contra ataques (e.g., clickjacking).
- **Swagger** integrado para documentación interactiva.

---

## 🛢️ Esquema de Base de Datos
- **Tópico**
    - id, título, mensaje, fecha de creación, estado, autor, curso
- **Respuesta**
    - id, mensaje, tópico, fecha de creación, autor, solución
- **Curso**
    - id, nombre, categoría
- **Usuario**
    - id, nombre, correo electrónico, contraseña, perfiles
- **Perfil**
    - id, nombre

Relaciones:
- Tópico ↔ Respuestas (1:N)
- Tópico ↔ Curso (N:1)
- Respuesta ↔ Usuario (N:1)
- Usuario ↔ Perfil (1:N)

---

## 🛠️ Despliegue
### Pasos para Ejecutar:
1. Clona el repositorio en tu equipo:
   ```bash
   git clone https://github.com/tu-usuario/forohub.git
   ```
2. Importa el proyecto en IntelliJ u otro IDE compatible con Java.
3. Crea la base de datos `forohub` en MySQL.
4. Configura las variables de entorno en `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/forohub
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
   jwt.secret=tu_secreto
   ```
5. Ejecuta el proyecto.
6. Prueba los endpoints en **Postman**, **Insomnia** o **Swagger**.

---

## 📋 Ejemplo de Uso
Utiliza herramientas como Swagger o Insomnia para interactuar con la API:
- Crear un nuevo tópico:
  ```json
  POST /topicos
  {
    "titulo": "Nuevo en Spring",
    "mensaje": "¿Cómo usar Spring Boot?",
    "autor": "Usuario1",
    "curso": "Java Avanzado"
  }
  ```

---

## 👨‍💻 Tecnologías Utilizadas
- **Java 17**
- **Spring Boot 3**
- **MySQL 8**
- **JWT**
- **Lombok**
- **Swagger**

---

## 🤝 Contribuciones
Las contribuciones son bienvenidas. Por favor, sigue los pasos para pull requests y revisa las reglas de estilo antes de enviar tus cambios.

---

## 📄 Licencia
Este proyecto está bajo la Licencia MIT. Consulta el archivo LICENSE para más detalles.

---

¡Gracias por visitar ForoHub! 🌟
