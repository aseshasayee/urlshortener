# URL Shortener Service

A simple, production-ready URL Shortener built with Spring Boot and MySQL.  
Create short links for long URLs and redirect users with ease — just like Bitly or TinyURL.

Live Project: https://urlshortener-aidq.onrender.com

---

## Features

- Shorten any long URL to a unique, shareable shortcode  
- Redirect users from the short URL to the original link  
- Persistent storage using MySQL (cloud-hosted)  
- RESTful API with JSON responses  
- Dockerized for easy deployment  
- CORS enabled for frontend integration  

---

## Tech Stack

- Java 17+  
- Spring Boot  
- Spring Data JPA (Hibernate)  
- MySQL (via Railway)  
- Docker (multi-stage build)  
- Deployed on Render.com  

---

## Getting Started

### 1. Clone the Repository

git clone https://github.com/aseshasayee/urlshortener.git  
cd urlshortener

### 2. Configure the Database

Update the file at:  
src/main/resources/application.properties

With:

spring.datasource.url=jdbc:mysql://<HOST>:<PORT>/<DATABASE>  
spring.datasource.username=<USERNAME>  
spring.datasource.password=<PASSWORD>  
spring.jpa.hibernate.ddl-auto=update

### 3. Build and Run

**With Maven:**  
./mvnw clean package  
java -jar target/urlshortener-0.0.1-SNAPSHOT.jar

**With Docker:**  
docker build -t urlshortener-app .  
docker run -p 8080:8080 urlshortener-app

---

## API Endpoints

### Shorten a URL

POST /shorten

Request Body:  
{ "url": "https://www.example.com/your/long/link" }

Response:  
{  
"shortcode": "abc123",  
"originalUrl": "https://www.example.com/your/long/link"  
}

---

### Redirect to Original URL

GET /{shortcode}

Example:  
Visiting https://urlshortener-aidq.onrender.com/abc123 will redirect to the original URL.

---


## Project Source

This project was built as part of the roadmap.sh URL Shortening Service Project.
https://roadmap.sh/projects/url-shortening-service


---
