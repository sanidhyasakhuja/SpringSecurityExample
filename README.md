📘 README.md
# Spring Security Example

This project is a **Spring Boot application** demonstrating the integration of **Spring Security** with simple REST APIs.  
It shows how to secure endpoints using **role-based access control** and serves as a learning reference for developers.

---

## 🚀 Features
- Spring Boot REST API
- Spring Security with authentication & authorization
- Role-based access (`USER`, `ADMIN`)
- Public and protected endpoints
- Maven build system

---

## 📂 Project Structure
```text
SecurityExample
├── src/main/java/com/example/SecurityExample
│   ├── SecurityExampleApplication.java   # Main Spring Boot application
│   ├── config/
│   │   └── SecurityConfig.java           # Security configuration
│   └── controller/
│       ├── HomeController.java           # Public endpoint
│       ├── StudentController.java        # Requires USER/ADMIN
│       └── UserController.java           # Requires ADMIN
└── pom.xml                               # Maven configuration
```
---

⚙️ Setup & Run
Prerequisites

Java 17+

Maven 3.8+

IDE (IntelliJ, Eclipse, VS Code)

Steps
```text
# Clone repository
git clone https://github.com/sanidhyasakhuja/SpringSecurityExample.git
cd SpringSecurityExample

# Build project
mvn clean install

# Run application
mvn spring-boot:run

```
The app starts at 👉 http://localhost:8080

---

🔑 API Endpoints

| Endpoint    | Method | Access Level |
| ----------- | ------ | ------------ |
| `/home`     | GET    | Public       |
| `/students` | GET    | USER, ADMIN  |
| `/users`    | GET    | ADMIN only   |

---

🛡️ Security

Configured in SecurityConfig.java

In-memory authentication with predefined users

Roles supported: USER, ADMIN

Easily extendable to DB authentication

--- 

🤝 Contribution

Contributions are welcome!
Feel free to fork this repo, raise issues, and submit PRs.

---

📜 License

This project is licensed under the MIT License

---


---

