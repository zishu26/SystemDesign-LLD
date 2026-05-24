# Payment System using OOPs in Java – README

This project is a simple yet powerful demonstration of core Object-Oriented Programming (OOPs) concepts in Java using a real-world Payment System example.

The system supports multiple payment methods such as:

- Debit Card
- Credit Card
- UPI
- Wallet

A central `PaymentService` manages all payment methods and executes payments dynamically.

---

# 📂 Project Structure

```text
OOPS/
│
├── PaymentMethod.java
├── Card.java
├── DebitCard.java
├── CreditCard.java
├── UPI.java
├── Wallet.java
├── PaymentService.java
└── Client.java
```

---

# 🧠 OOP Concepts Covered

| OOP Concept | Where Used |
|---|---|
| Abstraction | `PaymentMethod` interface |
| Inheritance | `DebitCard` & `CreditCard` extend `Card` |
| Polymorphism | `pay()` method overriding |
| Encapsulation | Private fields in `Card` & `Wallet` |
| Runtime Polymorphism | `PaymentMethod pm = paymentMethods.get(name)` |
| Loose Coupling | Service depends on interface, not implementation |
| Open/Closed Principle | New payment methods can be added easily |

---

# 1️⃣ Abstraction

## What is Abstraction?

Abstraction means:

> Showing only essential behavior and hiding internal implementation details.

In this project, abstraction is achieved using the `PaymentMethod` interface.

```java
public interface PaymentMethod {
    void pay();
}
```

### Why is this important?

The `PaymentService` only knows:

```java
pm.pay();
```

It does NOT care whether it is:

- UPI
- Debit Card
- Credit Card
- Wallet

This is one of the biggest advantages of abstraction.

---

# 2️⃣ Interface Usage

## `PaymentMethod` Interface

```java
public interface PaymentMethod {
    void pay();
}
```

### Why interfaces are powerful?

Interfaces allow:

- Loose coupling
- Extensibility
- Runtime polymorphism
- Plug-and-play architecture

Very common in:

- Spring Boot
- Microservices
- Enterprise systems
- Strategy Design Pattern

---

# 3️⃣ Inheritance

## `Card` Abstract Class

```java
abstract public class Card implements PaymentMethod
```

### Why abstract class here?

Because:

- All cards have common properties
  - card number
  - username
- But payment implementation differs

So shared logic is centralized.

---

## Child Classes

### Debit Card

```java
public class DebitCard extends Card
```

### Credit Card

```java
public class CreditCard extends Card
```

These inherit:

- card number
- username
- getters
- constructor behavior

from `Card`.

---

# 4️⃣ Encapsulation

Encapsulation means:

> Wrapping data + controlling access to it.

Example:

```java
private String cardNo;
private String userName;
```

These fields are private.

Access is controlled using getters:

```java
public String getCardNo()
public String getUserName()
```

### Why encapsulation matters?

Benefits:

- Data protection
- Validation capability
- Maintainability
- Controlled access

---

# 5️⃣ Polymorphism

## Method Overriding

Each payment method provides its own implementation of:

```java
pay()
```

Example:

```java
@Override
public void pay() {
    System.out.println("Paid using UPI");
}
```

Another example:

```java
@Override
public void pay() {
    System.out.println("Paid using Wallet");
}
```

---

# 6️⃣ Runtime Polymorphism

This is one of the MOST IMPORTANT concepts.

Inside `PaymentService`:

```java
PaymentMethod pm = paymentMethods.get(name);
pm.pay();
```

At runtime:

- `pm` may become:
  - UPI
  - Wallet
  - DebitCard
  - CreditCard

This is called:

# 🔥 Runtime Dynamic Dispatch

Java decides at runtime which `pay()` to execute.

---

# 7️⃣ HashMap Usage

```java
HashMap<String, PaymentMethod> paymentMethods = new HashMap<>();
```

### Why this is powerful?

This acts like a registry.

You can dynamically add:

```java
paymentService.addPaymentMethod(...)
```

without changing existing code.

---

# 8️⃣ Loose Coupling

Your service depends on:

```java
PaymentMethod
```

NOT:

- DebitCard
- CreditCard
- UPI
- Wallet

This is called:

# 🔥 Loose Coupling

Enterprise systems ALWAYS prefer this.

---

# 9️⃣ Open Closed Principle (SOLID)

Your design already follows:

# OCP – Open Closed Principle

Meaning:

> Open for extension, closed for modification.

You can add:

```java
NetBanking
Crypto
PayPal
ApplePay
```

WITHOUT changing existing logic.

Only create a new class implementing:

```java
PaymentMethod
```

---

# 🔟 Client Flow

Main execution happens here:

```java
PaymentService paymentService = new PaymentService();
```

Payment methods are registered:

```java
paymentService.addPaymentMethod(...)
```

Payments are executed dynamically:

```java
paymentService.makePayment(...)
```

---

# 🔥 Real Industry Mapping

Your implementation is VERY similar to how real systems work.

| Real Industry Concept | Your Code |
|---|---|
| Payment Gateway | PaymentMethod |
| Stripe/PayPal/Razorpay | DebitCard/UPI/Wallet |
| Service Layer | PaymentService |
| Strategy Pattern | Runtime payment selection |
| Dependency Injection | Interface-based design |

---

# 🚀 Design Pattern Used

Your implementation resembles:

# ✅ Strategy Design Pattern

Different payment strategies are selected dynamically at runtime.

Example:

- UPI Strategy
- Wallet Strategy
- DebitCard Strategy

---

# 🧪 Example Output

```text
Paid using UPI
Paid using Credit Card
Paid using Debit Card
Paid using Wallet
```

---

# 📈 Possible Future Enhancements

You can extend this project further by adding:

## Beginner Enhancements

- amount field
- transaction ID
- payment status
- balance deduction

## Intermediate Enhancements

- exception handling
- payment validation
- card expiry
- CVV masking

## Advanced LLD Enhancements

- Factory Pattern
- Singleton Pattern
- Observer Pattern
- Notification Service
- Transaction History
- Thread Safety
- Database integration

---

# 🎯 Interview Questions You Can Now Answer

## OOP Questions

- What is abstraction?
- Interface vs Abstract Class?
- What is runtime polymorphism?
- What is encapsulation?
- What is inheritance?
- What is loose coupling?

## LLD Questions

- Explain Strategy Pattern
- Explain Open Closed Principle
- How to make system extensible?
- Why use interfaces?
- How does runtime dispatch work?

---

# 🏁 Final Learning Summary

This project is a VERY good foundational LLD/OOP practice project because it demonstrates:

✅ Real-world modeling  
✅ Clean extensible design  
✅ SOLID principles  
✅ Runtime polymorphism  
✅ Interface-driven architecture  
✅ Beginner-friendly Strategy Pattern implementation

Especially this part:

```java
PaymentMethod pm = paymentMethods.get(name);
pm.pay();
```

…is the heart of modern extensible backend architecture.
