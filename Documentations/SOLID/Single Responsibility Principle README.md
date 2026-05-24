# Single Responsibility Principle (SRP) - Java Example

## Definition

The Single Responsibility Principle (SRP) states:

> A class should have only one reason to change.

This means a class should handle only one responsibility/job.

---

# Project Structure

```text
SingleResponsibilityPrinciple
│
├── Client.java
├── Invoice.java
├── InvoiceRepository.java
└── EmailService.java
```

---

# 1. Invoice Class

```java
package SolidResponsibilityPrinciples.SingleResponsibilityPrinciple;

public class Invoice {

    private double amount;

    Invoice(double amount){
        this.amount = amount;
    }

    public void generateInvoice(){
        System.out.println("Invoice generated and printed for amount : "+amount);
    }
}
```

## Responsibility

The `Invoice` class is responsible only for invoice-related logic.

### What it does

- Holds invoice data
- Generates/prints invoice

### What it SHOULD NOT do

- Save invoice to database
- Send emails
- Handle notifications

---

# 2. InvoiceRepository Class

```java
package SolidResponsibilityPrinciples.SingleResponsibilityPrinciple;

public class InvoiceRepository {

    public void saveInvoiceToDatabase(){
        System.out.println("Invoice saved to database successfully");
    }
}
```

## Responsibility

The `InvoiceRepository` class handles database/persistence operations.

### What it does

- Saves invoice to database

### What it SHOULD NOT do

- Generate invoice
- Send email notifications

---

# 3. EmailService Class

```java
package SolidResponsibilityPrinciples.SingleResponsibilityPrinciple;

public class EmailService {

    public void sendEmailNotification(){
        System.out.println("Email notification sent for the invoice");
    }
}
```

## Responsibility

The `EmailService` class handles notification/email operations.

### What it does

- Sends invoice-related email notifications

### What it SHOULD NOT do

- Save invoice
- Generate invoice

---

# 4. Client Class

```java
package SolidResponsibilityPrinciples.SingleResponsibilityPrinciple;

public class Client {

    public static void main(String[] args){

        Invoice invoice = new Invoice(10000);
        invoice.generateInvoice();

        EmailService emailService = new EmailService();
        emailService.sendEmailNotification();

        InvoiceRepository invoiceRepository = new InvoiceRepository();
        invoiceRepository.saveInvoiceToDatabase();
    }
}
```

## Responsibility

The `Client` class coordinates the execution flow.

### What it does

- Creates objects
- Calls methods in sequence

The client only orchestrates the workflow.

---

# Execution Flow

```text
Client
   |
   |----> Invoice.generateInvoice()
   |
   |----> EmailService.sendEmailNotification()
   |
   |----> InvoiceRepository.saveInvoiceToDatabase()
```

---

# Output

```text
Invoice generated and printed for amount : 10000.0
Email notification sent for the invoice
Invoice saved to database successfully
```

---

# Why This Follows SRP

Each class has only one responsibility.

| Class | Responsibility |
|------|----------------|
| Invoice | Invoice generation |
| InvoiceRepository | Database persistence |
| EmailService | Email notification |
| Client | Application flow |

Each class has only one reason to change.

---

# Benefits of SRP

## 1. Easy Maintenance

Changes in email logic affect only `EmailService`.

---

## 2. Better Readability

Each class has clear responsibility.

---

## 3. Easy Testing

Every class can be tested independently.

---

## 4. Better Scalability

New features can be added easily.

Example:

```text
SMSService
WhatsAppService
PDFInvoiceGenerator
```

---

# Bad Example (SRP Violation)

```java
public class Invoice {

    private double amount;

    public void generateInvoice(){
        System.out.println("Invoice generated");
    }

    public void saveInvoiceToDatabase(){
        System.out.println("Invoice saved");
    }

    public void sendEmailNotification(){
        System.out.println("Email sent");
    }
}
```

---

# Why This Is Wrong

This class has multiple responsibilities:

1. Invoice generation
2. Database saving
3. Email sending

Now this class has multiple reasons to change.

If database changes → class changes.

If email logic changes → class changes.

If invoice logic changes → class changes.

This violates SRP.

---

# Interview Explanation

## Short Version

The Single Responsibility Principle says a class should have only one reason to change.

In this example:

- `Invoice` handles invoice generation
- `InvoiceRepository` handles database persistence
- `EmailService` handles notifications
- `Client` coordinates the flow

Each class focuses on one responsibility, making the system modular, maintainable, and scalable.

---

# Real-World Mapping

| Example | Real Application |
|---|---|
| Invoice | Business Model |
| InvoiceRepository | Repository Layer |
| EmailService | Notification Service |
| Client | Controller/Main Application |

---

# Relation with Spring Boot

Typical Spring Boot architecture:

```text
Controller
   ↓
Service
   ↓
Repository
```

SRP is heavily used in layered architecture.

---

# Key Points to Remember

- One class → One responsibility
- One class → One reason to change
- Separate business logic from persistence and notification logic
- SRP improves:
  - Maintainability
  - Readability
  - Testability
  - Scalability

---

# Final Summary

```text
Invoice            → Generate invoice
InvoiceRepository  → Save invoice
EmailService       → Send email
Client             → Coordinate flow
```

This is a proper implementation of the Single Responsibility Principle (SRP).
