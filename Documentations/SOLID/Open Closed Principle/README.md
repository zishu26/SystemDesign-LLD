# Open Closed Principle (OCP) - Java Example

# Definition

The Open Closed Principle (OCP) states:

> Software entities should be OPEN for extension but CLOSED for modification.

This means:

- We should be able to add new functionality
- WITHOUT changing existing working code

---

# Goal of OCP

We should avoid modifying existing classes repeatedly whenever new requirements arrive.

Instead:

- Extend behavior using interfaces, abstraction, and polymorphism

---

# Project Structure

```text
OpenClosePrinciple
│
├── Client.java
├── PaymentMethod.java
├── PaymentProcessor.java
├── UPI.java
├── DebitCard.java
├── CreditCard.java
└── PayPal.java
```

---

# 1. PaymentMethod Interface

```java
package SolidResponsibilityPrinciples.OpenClosePrinciple;

public interface PaymentMethod {

    void pay(double amount);
}
```

## Responsibility

This interface defines a common payment contract.

Any new payment type must implement this interface.

---

# 2. UPI Class

```java
package SolidResponsibilityPrinciples.OpenClosePrinciple;

public class UPI implements PaymentMethod {

    @Override
    public void pay(double amount) {
        System.out.println("Paid using UPI : "+amount);
    }
}
```

## Responsibility

Handles payment using UPI.

---

# 3. DebitCard Class

```java
package SolidResponsibilityPrinciples.OpenClosePrinciple;

public class DebitCard implements PaymentMethod {

    @Override
    public void pay(double amount) {
        System.out.println("Paid using Debit Card : "+ amount);
    }
}
```

## Responsibility

Handles payment using Debit Card.

---

# 4. CreditCard Class

```java
package SolidResponsibilityPrinciples.OpenClosePrinciple;

public class CreditCard implements PaymentMethod {

    @Override
    public void pay(double amount) {
        System.out.println("Paid using Credit Card : "+amount);
    }
}
```

## Responsibility

Handles payment using Credit Card.

---

# 5. PayPal Class

```java
package SolidResponsibilityPrinciples.OpenClosePrinciple;

public class PayPal implements PaymentMethod {

    @Override
    public void pay(double amount) {
        System.out.println("Paid using PayPal  : "+amount);
    }
}
```

## Responsibility

Handles payment using PayPal.

---

# 6. PaymentProcessor Class

```java
package SolidResponsibilityPrinciples.OpenClosePrinciple;

public class PaymentProcessor {

    public void processPayment(PaymentMethod paymentMethod, double amount){
        paymentMethod.pay(amount);
    }
}
```

## Responsibility

The `PaymentProcessor` works with abstraction (`PaymentMethod`) instead of concrete classes.

It does NOT care whether payment is:

- UPI
- Debit Card
- Credit Card
- PayPal
- Future payment methods

This is the key idea behind OCP.

---

# 7. Client Class

```java
package SolidResponsibilityPrinciples.OpenClosePrinciple;

public class Client {

    public static void main(String[] args) {

        PaymentProcessor paymentProcessor = new PaymentProcessor();

        paymentProcessor.processPayment(new UPI(), 1000);

        paymentProcessor.processPayment(new DebitCard(), 1000);

        paymentProcessor.processPayment(new CreditCard(), 1000);

        paymentProcessor.processPayment(new PayPal(), 1000);
    }
}
```

---

# Execution Flow

```text
Client
   |
   |----> PaymentProcessor
                    |
                    |----> PaymentMethod.pay()
                                   |
                                   |----> UPI
                                   |----> DebitCard
                                   |----> CreditCard
                                   |----> PayPal
```

---

# Output

```text
Paid using UPI : 1000.0
Paid using Debit Card : 1000.0
Paid using Credit Card : 1000.0
Paid using PayPal  : 1000.0
```

---

# Why This Follows OCP

The system is:

## CLOSED for modification

We never modify:

```java
PaymentProcessor
```

whenever a new payment method is added.

---

## OPEN for extension

We can create new payment types easily.

Example:

```java
public class ApplePay implements PaymentMethod {

    @Override
    public void pay(double amount) {
        System.out.println("Paid using Apple Pay : " + amount);
    }
}
```

Now directly use:

```java
paymentProcessor.processPayment(new ApplePay(), 1000);
```

WITHOUT changing existing code.

This is OCP.

---

# Key Design Concept

The major reason OCP works here is:

## Programming to Interface

Instead of:

```java
public void processPayment(UPI upi)
```

we use:

```java
public void processPayment(PaymentMethod paymentMethod)
```

This creates flexibility and extensibility.

---

# Polymorphism in Action

This line:

```java
paymentMethod.pay(amount);
```

calls different implementations at runtime.

This is runtime polymorphism.

---

# Bad Example (OCP Violation)

```java
public class PaymentProcessor {

    public void processPayment(String type, double amount){

        if(type.equals("UPI")){
            System.out.println("Paid using UPI");
        }
        else if(type.equals("Debit")){
            System.out.println("Paid using Debit Card");
        }
        else if(type.equals("Credit")){
            System.out.println("Paid using Credit Card");
        }
    }
}
```

---

# Why This Is Wrong

Every time a new payment method comes:

- Apple Pay
- PayPal
- Crypto
- Net Banking

We must modify:

```java
PaymentProcessor
```

This violates OCP.

---

# Problems with Bad Design

## 1. High Risk

Changing old code can break working functionality.

---

## 2. Difficult Maintenance

Large if-else chains become messy.

---

## 3. Poor Scalability

New features require modifying core logic repeatedly.

---

# Advantages of OCP

| Advantage | Description |
|---|---|
| Extensible | Easy to add new features |
| Maintainable | Existing code remains untouched |
| Scalable | System grows cleanly |
| Reusable | Interface-based design |
| Flexible | Supports polymorphism |

---

# Interview Explanation

## Short Version

The Open Closed Principle states that software entities should be open for extension but closed for modification.

In this example:

- `PaymentMethod` is an interface
- Different payment types implement the interface
- `PaymentProcessor` works with abstraction

When a new payment method is introduced, we create a new class implementing `PaymentMethod`.

We do NOT modify `PaymentProcessor`.

This follows OCP.

---

# Real-World Analogy

Think of a mobile charger socket.

The socket remains unchanged.

Different chargers can plug into it.

The socket is:

- CLOSED for modification
- OPEN for extension

Same concept applies here.

---

# Relation with Spring Boot

OCP is heavily used in Spring Boot:

Examples:

- Strategy Pattern
- Payment Gateways
- Notification Services
- Authentication Providers
- Database Drivers

Spring internally depends heavily on interfaces and dependency injection.

---

# Core Concepts Used

| Concept | Used Here |
|---|---|
| Interface | PaymentMethod |
| Abstraction | PaymentProcessor uses interface |
| Polymorphism | pay() runtime resolution |
| Extensibility | Add new payment methods |
| Loose Coupling | Processor independent of concrete classes |

---

# Important Interview Keywords

Remember these terms:

```text
Open for Extension
Closed for Modification
Programming to Interface
Abstraction
Polymorphism
Loose Coupling
Extensibility
Strategy Pattern
```

---

# Final Summary

```text
PaymentMethod     → Common contract

UPI               → Payment implementation
DebitCard         → Payment implementation
CreditCard        → Payment implementation
PayPal            → Payment implementation

PaymentProcessor  → Uses abstraction

Client            → Executes flow
```

The system can easily support new payment methods WITHOUT modifying existing working code.

This is a proper implementation of the Open Closed Principle (OCP).
