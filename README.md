# Subscription Management SaaS

A multi-tenant SaaS platform for gyms, cricket academies, dance studios, and other membership-based businesses to manage members, subscription plans, payments, coupons, and business analytics.

---

## 🚀 Features

### Multi-Tenant Architecture
- Support for multiple organizations in a single application
- Organization-specific data isolation
- Role-based access control for admins and members

### Membership Management
- Global user profiles
- Organization memberships
- Roles such as `ADMIN` and `MEMBER`

### Subscription & Billing
- Configurable plans (monthly, quarterly, annual)
- Subscription renewals with complete historical tracking
- Custom pricing and percentage-based concessions
- Coupon-based discounts (fixed or percentage)
- Automatic server-side amount calculation
- Payment recording and payment method tracking

### Coupon Management
- Organization-specific coupon codes
- Usage limits
- Validity periods
- Manual activation/deactivation

### Analytics
- Total revenue
- Active members and subscriptions
- Expiring subscriptions
- Coupon usage statistics

### Engineering Features
- DTO-based API design
- Service-layer business logic
- Transaction management
- Sequence-based primary keys
- Domain methods for pricing and validation

---

## 🛠️ Tech Stack

### Backend
- Java 21
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Lombok

### Testing
- JUnit 5
- Mockito

### Planned Frontend
- React
- TypeScript
- Tailwind CSS
- Recharts

### Planned Infrastructure
- Docker
- GitHub Actions
- AWS / Render / Railway

### Planned Future Enhancements
- Microservices with Apache Kafka and Redis
- Kubernetes
- Razorpay integration
- Mobile application (React Native)

---

## 🏗️ Domain Model

```text
User
  └── Membership
        ├── Organization
        ├── Subscription
        │      ├── Plan
        │      └── Payment
        └── Coupon
```

---

## 📦 Core Entities

- `User`
- `Organization`
- `Membership`
- `Plan`
- `Subscription`
- `Payment`
- `Coupon`

---

## 📊 Implemented APIs

### Users
- `POST /users`
- `GET /users`

### Organizations
- `POST /organizations`

### Memberships
- `POST /memberships`

### Plans
- `POST /plans`

### Subscriptions
- `POST /subscriptions`

### Payments
- `POST /payments`

### Coupons
- `POST /coupons`

### Analytics
- `GET /analytics/summary?organizationId={id}`

---

## 💰 Pricing Logic

1. Use `customPrice` if provided.
2. Otherwise use the plan price.
3. Apply subscription-level percentage discount.
4. Apply coupon discount.
5. Ensure the final amount is not negative.

---

## 📈 Analytics Summary

The analytics endpoint returns:
- Total members
- Active members
- Active subscriptions
- Total revenue
- Subscriptions expiring in the next 7 days
- Coupon usage breakdown

---

## 🧪 Running the Project Locally

### Prerequisites
- Java 21+
- Maven
- PostgreSQL

### Clone the Repository

```bash
git clone https://github.com/<your-username>/subscription-management-saas.git
cd subscription-management-saas
```

### Configure Database

Create a PostgreSQL database and update `src/main/resources/application.properties`.

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/subscription_db
spring.datasource.username=postgres
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

### Start the Application

```bash
./mvnw spring-boot:run
```

The API will be available at:

```text
http://localhost:8080
```

---

## 🧪 Example Workflow

1. Create a user
2. Create an organization
3. Create a membership
4. Create a plan
5. Create a subscription
6. Create a coupon
7. Record a payment
8. View analytics

---

## 📌 Project Status

**Ongoing**

Completed:
- Backend domain model
- Core REST APIs
- Pricing and coupon engine
- Analytics summary endpoint

In Progress:
- React + TypeScript frontend

Planned:
- Authentication and authorization
- Razorpay integration
- Cloud deployment
- Microservices architecture

---

## 🎯 Resume Highlights

This project demonstrates:
- Java and Spring Boot backend development
- REST API design
- PostgreSQL data modeling
- Business logic implementation
- Analytics and reporting
- Full-stack architecture
- Cloud and DevOps readiness

---

## 📄 License

This project is for educational and portfolio purposes.
