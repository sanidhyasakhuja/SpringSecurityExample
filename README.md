📘 README.md
# SecurityExample

A sample Spring Boot project demonstrating **Spring Security** integration with REST APIs.  
This project covers basic authentication, authorization, and role-based access control.

---

## 🚀 Features
- Spring Boot REST API
- Spring Security with role-based access
- Secure endpoints for `User`, `Student`, and `Home`
- Maven build system
- Configurable with `application.properties`

---

## 🛠️ Tech Stack
- **Java 17+**
- **Spring Boot 3.x**
- **Spring Security**
- **Maven**
- **REST APIs**

---

## 📂 Project Structure


SecurityExample
├── src/main/java/com/example/SecurityExample
│ ├── SecurityExampleApplication.java # Main Spring Boot application
│ ├── config/SecurityConfig.java # Security configuration
│ ├── controller/
│ │ ├── HomeController.java
│ │ ├── StudentController.java
│ │ └── UserController.java
├── pom.xml # Maven configuration


---

## ⚙️ Setup & Run

### 1️⃣ Prerequisites
- Java 17 or later
- Maven 3.8+
- IDE (IntelliJ / Eclipse / VS Code)

### 2️⃣ Build & Run
```bash
# Clone repository
git clone https://github.com/your-username/SecurityExample.git
cd SecurityExample

# Build project
mvn clean install

# Run application
mvn spring-boot:run


The application will start at:
👉 http://localhost:8080

🔑 API Endpoints
Endpoint	Method	Access
/home	GET	Public
/students	GET	Requires ROLE_USER or ROLE_ADMIN
/users	GET	Requires ROLE_ADMIN
🛡️ Security

Configured with SecurityConfig.java

Uses in-memory authentication (default)

Roles: USER, ADMIN

Can be extended to use database authentication

🤝 Contribution

Feel free to fork this repo, raise issues, and submit PRs.

📜 License

This project is licensed under the MIT License.


