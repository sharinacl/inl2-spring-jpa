# **Spring Data JPA – Customer & Vehicle REST API**

A Spring Boot REST application created for **Inlämningsuppgift 2** in the course *Backendutveckling 2* at Yrgo.
The system manages **customers** and their **vehicles** using Spring Data JPA, DTOs, and a file-based H2 database.

---
## 📦 Getting Started
1. Clone the Repository 
   First, clone this project to your local machine:
-
   git clone https://github.com/sharinacl/inl2-spring-jpa.git
2. Navigate to the Project Folder
-
   cd inl2-spring-jpa

## 🚀 **How to Run the Project**

You can start the project using the included scripts
---

## 🟦 **Windows (run.bat)**

1. Open the project folder
2. Double-click:

```
run.bat
```

3. Wait for the application to start
4. Use a REST client (Insomnia, HTTPie, browser) to test the endpoints below

---

## 🟩 **Mac/Linux (run.sh)**

1. Open Terminal in the project folder
2. Make the script executable (first time only):

```bash
chmod +x run.sh
```

3. Start the application:

```bash
./run.sh
```

4. Test the API using the endpoints listed below

---

## 🛠 **Run Manually (Optional)**

### Using Maven Wrapper (recommended):

```bash
./mvnw spring-boot:run
```

### Package & run JAR:

```bash
./mvnw clean package
java -jar target/spring-data-jpa-0.0.1-SNAPSHOT.jar
```

The server will start on:

```
http://localhost:8080/
```

---

## 🗄️ **Database (H2)**

The project uses a local **file-based H2 database**, automatically created at startup.

### H2 Console URL:

```
http://localhost:8080/h2-console
```

### Database settings:

```
Driver:      org.h2.Driver
JDBC URL:    jdbc:h2:file:./Database
Username:    (empty)
Password:    (empty)
```

---

# 📡 **REST API Endpoints**

Below are all endpoints implemented according to the assignment requirements:

---

## 👤 **Customers**

### ➤ **Create a customer**

**POST**

```
/customers?name=Anna&phone=123456789
```

### ➤ **Get customer ID by name**

**GET**

```
/customer-id?name=Anna
```

### ➤ **Get all customers with their vehicles (DTO)**

**GET**

```
/customers
```

---

## 🚗 **Vehicles**

### ➤ **Create a vehicle**

**POST**

```
/vehicles?registrationNumber=ABC123&brand=Volvo&model=V70&productionYear=2005&customerId=1
```

### ➤ **List all vehicles**

**GET**

```
/vehicles
```

### ➤ **List vehicles by brand**

**GET**

```
/vehicles-by-brand?brand=Volvo
```

---

## 📁 **Project Structure**

```
spring-data-jpa/
├── src/main/java/se/yrgo/spring_data_jpa/
│   ├── SpringDataJpaApplication.java
│   ├── controller/
│   │   └── CustomerServiceRestController.java
│   ├── domain/
│   │   ├── Customer.java
│   │   └── Vehicle.java
│   ├── dto/
│   │   ├── CustomerDTO.java
│   │   └── VehicleDTO.java
│   └── repository/
│       ├── CustomerRepository.java
│       └── VehicleRepository.java
├── run.bat     # Windows startup script
├── run.sh      # Mac/Linux startup script
├── application.properties
└── pom.xml
```

---

## ⚙️ **Technologies Used**

* Java 21
* Spring Boot 4
* Spring Data JPA
* H2 Database
* DTO pattern
* Maven

---

## 🐛 **Troubleshooting**

* **Port 8080 is already in use:**
  Close other apps using the port, or restart your machine.

* **H2 Console won't open:**
  Ensure this is in `application.properties`:

  ```
  spring.h2.console.enabled=true
  ```

* **API not responding:**
  Wait until the console shows:

  ```
  Started SpringDataJpaApplication
  ```

---


## 🧪 **Quick Testing Guide**

Here's a step-by-step example to verify the system works.
Copy and paste these URLs directly into **Insomnia** or **HTTPie**.

### 1. Create a customer
Method: **POST**

**Insomnia/Browser:**
```
http://localhost:8080/customers?name=Anna&phone=123456789
```

**HTTPie (Terminal):**
```bash
http POST "http://localhost:8080/customers?name=Anna&phone=123456789"
```

---

### 2. Get the customer ID
Method: **GET**

**Insomnia/Browser:**
```
http://localhost:8080/customer-id?name=Anna
```

**HTTPie:**
```bash
http GET "http://localhost:8080/customer-id?name=Anna"
```

Response example: `1`

---

### 3. Create a vehicle for that customer
Method: **POST**

**Insomnia/Browser:**
```
http://localhost:8080/vehicles?registrationNumber=ABC123&brand=Volvo&model=V70&productionYear=2005&customerId=1
```

**HTTPie:**
```bash
http POST "http://localhost:8080/vehicles?registrationNumber=ABC123&brand=Volvo&model=V70&productionYear=2005&customerId=1"
```

---

### 4. View all customers with their vehicles
Method: **GET**

**Insomnia/Browser:**
```
http://localhost:8080/customers
```

**HTTPie:**
```bash
http GET http://localhost:8080/customers
```

Response example:
```json
[
  {
    "name": "Anna",
    "phoneNumber": "123456789",
    "vehicles": [
      {
        "registrationNumber": "ABC123",
        "brand": "Volvo",
        "model": "V70",
        "productionYear": 2005
      }
    ]
  }
]
```

---

### 5. List all vehicles
Method: **GET**

**Insomnia/Browser:**
```
http://localhost:8080/vehicles
```

**HTTPie:**
```bash
http GET http://localhost:8080/vehicles
```

---

### 6. Filter vehicles by brand
Method: **GET**

**Insomnia/Browser:**
```
http://localhost:8080/vehicles-by-brand?brand=Volvo
```

**HTTPie:**
```bash
http GET "http://localhost:8080/vehicles-by-brand?brand=Volvo"
```

---

## 👤 **Author**

**Sharina Cl**
GitHub repository:
[https://github.com/sharinacl/inl2-spring-jpa.git](https://github.com/sharinacl/inl2-spring-jpa.git)

---