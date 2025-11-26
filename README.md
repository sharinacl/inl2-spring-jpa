# **Spring Data JPA – Customer & Vehicle REST API**

A Spring Boot REST application created for **Inlämningsuppgift 2** in the course *Backendprogrammering del 2* at Yrgo.
The system manages **customers** and their **vehicles** using Spring Data JPA, DTOs, and a file-based H2 database.

---

## 📦 **Getting Started**

### 1. Clone the Repository

First, clone this project to your local machine:

```bash
git clone https://github.com/sharinacl/inl2-spring-jpa.git
```

### 2. Navigate to the Project Folder

```bash
cd inl2-spring-jpa
```

---

## 🚀 **How to Run the Project**

You can start the project using the included scripts — easiest way

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



## 🧪 **Testing the API Endpoints**

Below are all endpoints with copy-paste ready examples for **Insomnia** and **HTTPie**.

> **Important for Insomnia users:** When you see URLs with `&` symbols, either:
> - Use the **Query tab** in Insomnia to add parameters separately, OR
> - Copy the full URL and Insomnia will parse it automatically

---

### 1️⃣ Create a customer

**Method:** `POST`

**Insomnia URL:**
```
http://localhost:8080/customers?name=Anna&phone=123456789
```

**OR use Query tab in Insomnia:**
- URL: `http://localhost:8080/customers`
- Query params:
    - `name` = `Anna`
    - `phone` = `123456789`

**HTTPie:**
```bash
http POST "http://localhost:8080/customers?name=Anna&phone=123456789"
```

---

### 2️⃣ Get customer ID by name

**Method:** `GET`

**Insomnia URL:**
```
http://localhost:8080/customer-id?name=Anna
```

**HTTPie:**
```bash
http GET "http://localhost:8080/customer-id?name=Anna"
```

**Response example:** `1`

---

### 3️⃣ Create a vehicle

**Method:** `POST`

**Insomnia URL:**
```
http://localhost:8080/vehicles?registrationNumber=ABC123&brand=Volvo&model=V70&productionYear=2005&customerId=1
```

**OR use Query tab in Insomnia:**
- URL: `http://localhost:8080/vehicles`
- Query params:
    - `registrationNumber` = `ABC123`
    - `brand` = `Volvo`
    - `model` = `V70`
    - `productionYear` = `2005`
    - `customerId` = `1`

**HTTPie:**
```bash
http POST "http://localhost:8080/vehicles?registrationNumber=ABC123&brand=Volvo&model=V70&productionYear=2005&customerId=1"
```

---

### 3️⃣ Assign an existing vehicle to a customer

**Method:** `POST`

**Insomnia URL:**
```
http://localhost:8080/assign-vehicle?id=1&vehicleId=1
```

**OR use Query tab in Insomnia:**
- URL: `http://localhost:8080/assign-vehicle`
- Query params:
    - `id` = `1` (customer ID)
    - `vehicleId` = `1` (vehicle ID)

**HTTPie:**
```bash
http POST "http://localhost:8080/assign-vehicle?id=1&vehicleId=1"
```

---

### 4️⃣ Get all customers with their vehicles (DTO)

**Method:** `GET`

**Insomnia URL:**
```
http://localhost:8080/customers
```

**HTTPie:**
```bash
http GET http://localhost:8080/customers
```

**Response example:**
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

### 5️⃣ List all vehicles

**Method:** `GET`

**Insomnia URL:**
```
http://localhost:8080/vehicles
```

**HTTPie:**
```bash
http GET http://localhost:8080/vehicles
```

---

### 6️⃣ Filter vehicles by brand

**Method:** `GET`

**Insomnia URL:**
```
http://localhost:8080/vehicles-by-brand?brand=Volvo
```

**OR use Query tab in Insomnia:**
- URL: `http://localhost:8080/vehicles-by-brand`
- Query param: `brand` = `Volvo`

**HTTPie:**
```bash
http GET "http://localhost:8080/vehicles-by-brand?brand=Volvo"
```

---

### 📝 **Complete Testing Workflow**

To test the full system in order:

1. **POST** Create customer Anna → Get response
2. **GET** Get Anna's ID → Note the ID (e.g., `1`)
3. **POST** Create vehicle ABC123 for customer 1 (or create vehicle separately and use assign-vehicle endpoint)
4. **POST** (Optional) Assign vehicle to customer using `/assign-vehicle`
5. **GET** View all customers → See Anna with her vehicle
6. **GET** List all vehicles → See ABC123
7. **GET** Filter by brand Volvo → See ABC123

---

## 👤 **Author**

**Sharina Cl**
GitHub repository:

[https://github.com/sharinacl/inl2-spring-jpa.git](https://github.com/sharinacl/inl2-spring-jpa.git)

---