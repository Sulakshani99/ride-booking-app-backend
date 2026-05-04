# Ride Booking App Backend

Backend for a ride booking application built with Spring Boot microservices.

## Services

| Service | Port | Description |
| --- | ---: | --- |
| `discovery-service` | `8761` | Eureka server |
| `gateway-service` | `8080` | API gateway |
| `auth-service` | `8081` | Login, registration, JWT auth |
| `ride-service` | `8082` | Ride booking and ride status management |
| `payment-service` | `8083` | Payment records and payment status |
| `notification-service` | `8084` | Email notifications from ride events |
| `shared-service` | n/a | Shared DTOs and enums |

## Requirements

- Java 17
- MySQL
- Docker Desktop, for Kafka 

## Main Technologies

- Spring Boot
- Spring Cloud Eureka
- Spring Cloud Gateway
- Spring Security JWT
- MySQL
- Kafka
- AWS SES

## Setup

Start Kafka:

```powershell
cd "D:\Academic\NEW Courses\SE\ride-booking-app-backend\ride-service"
docker compose up -d
```

Install the shared module first:

```powershell
cd "D:\Academic\NEW Courses\SE\ride-booking-app-backend\shared-service"
.\mvnw.cmd clean install
```

## Run Services

Start each service in a separate terminal.

### 1. Discovery Service

```powershell
cd "D:\Academic\NEW Courses\SE\ride-booking-app-backend\discovery-service"
.\mvnw.cmd spring-boot:run
```

Eureka dashboard:

```text
http://localhost:8761
```

### 2. Auth Service

```powershell
cd "D:\Academic\NEW Courses\SE\ride-booking-app-backend\auth-service"
.\mvnw.cmd spring-boot:run
```

### 3. Ride Service

```powershell
cd "D:\Academic\NEW Courses\SE\ride-booking-app-backend\ride-service"
.\mvnw.cmd spring-boot:run
```

### 4. Payment Service

```powershell
cd "D:\Academic\NEW Courses\SE\ride-booking-app-backend\payment-service"
.\mvnw.cmd spring-boot:run
```

### 5. Notification Service

```powershell
cd "D:\Academic\NEW Courses\SE\ride-booking-app-backend\notification-service"
.\mvnw.cmd spring-boot:run
```

### 6. Gateway Service

```powershell
cd "D:\Academic\NEW Courses\SE\ride-booking-app-backend\gateway-service"
.\mvnw.cmd spring-boot:run
```

Gateway base URL:

```text
http://localhost:8080
```

## Gateway Routes

Use the gateway URL from the frontend.

| Path | Service |
| --- | --- |
| `/api/v1/auth/**` | Auth service |
| `/api/v1/rides/**` | Ride service |
| `/api/v1/payments/**` | Payment service |

## Important API Endpoints

### Auth

```text
POST /api/v1/auth/register
POST /api/v1/auth/login
POST /api/v1/auth/logout
POST /api/v1/auth/admin/drivers/create
GET  /api/v1/auth/users/{id}
```

### Rides

```text
POST  /api/v1/rides/estimate
POST  /api/v1/rides
GET   /api/v1/rides/{rideId}
GET   /api/v1/rides/history
GET   /api/v1/rides/available
PATCH /api/v1/rides/{rideId}/assign-driver
PATCH /api/v1/rides/{rideId}/status
```

### Payments

```text
GET   /api/v1/payments/{paymentId}
GET   /api/v1/payments/ride/{rideId}
GET   /api/v1/payments/passenger/{passengerId}
PATCH /api/v1/payments/{paymentId}/status
```

## Environment Variables

Optional variables:

```powershell
$env:EUREKA_SERVER_URL="http://localhost:8761/eureka/"
$env:DB_USERNAME="root"
$env:DB_PASSWORD="password"
$env:JWT_SECRET="base64-secret"
$env:KAFKA_BOOTSTRAP_SERVERS="localhost:9092"
$env:RIDE_EVENTS_TOPIC="ride-events"
```

For notification emails:

```powershell
$env:AWS_ACCESS_KEY_ID="access-key"
$env:AWS_SECRET_ACCESS_KEY="secret-key"
$env:AWS_REGION="us-east-1"
$env:AWS_SES_FROM="verified-email@example.com"
```

## Notes

- Start `discovery-service` first.
- Start MySQL before backend services.
- Start Kafka before using ride, payment, and notification flows.
- Use `http://localhost:8080` from the frontend.
- Keep real passwords and API keys in environment variables.
