# Online Food Ordering System — Low Level Design

This project is a **Low-Level Design (LLD)** implementation of an online food ordering system inspired by apps like Zomato and Swiggy. It showcases how to design and organize a scalable, maintainable food delivery application using core object-oriented design principles, design patterns, and modular Java code.

---

## Overview

The system enables users to search restaurants, view menus, add items to a cart, place orders (delivery or pickup), make payments through multiple methods, and receive notifications. This design focuses on the **user perspective**, encapsulating key entities and workflows.

---

## Project Structure & Responsibilities

### Root Files
- **Main.java**  
  The **application entry point**, responsible for bootstrapping the system.
- **TomatoApp.java**  
  Acts as a **Facade or orchestrator**, managing high-level workflows by interacting with managers, factories, and services.

---

### 1. Models (`models/`)

These classes represent the core **domain entities** of the system. They hold data and basic accessors but minimal business logic.

- **User.java**: User information and associated cart.
- **Restaurant.java**: Contains restaurant details and a menu of menu items.
- **MenuItem.java**: Represents each dish with ID, name, and price.
- **Cart.java**: Stores currently selected menu items for a user.
- **Order.java** (abstract): Base class for orders.
- **DeliveryOrder.java** and **PickupOrder.java**: Concrete classes representing different order types.

*Key concept:* Models are linked using clear object relationships like composition and aggregation (e.g., Restaurant composes MenuItems, User owns Cart).

---

### 2. Managers (`managers/`)

Manager classes are **Singletons** responsible for managing collections of core entities and business logic related to CRUD operations:

- **RestaurantManager.java**: Adds, deletes, searches restaurants based on location.
- **OrderManager.java**: Tracks and manages all orders in the system.

*Key concept:* Managers act as a central, loosely coupled access point to entities, preventing direct access and promoting clean architecture.

---

### 3. Strategies (`strategies/`)

Implements the **Strategy design pattern** to encapsulate payment algorithms, allowing to flexibly add or modify payment methods without changing client code:

- **PaymentStrategy.java**: Base interface/abstract class defining payment behavior.
- **CreditCardPaymentStrategy.java**: Handles credit/debit card payments.
- **UpiPaymentStrategy.java**: Handles UPI payments.

*Key concept:* The system can easily support multiple payment types and extend to new ones.

---

### 4. Factories (`factories/`)

Implements the **Factory design pattern** to create different types of orders flexibly:

- **OrderFactory.java**: Abstract factory interface.
- **NowOrderFactory.java**: Creates immediate orders.
- **ScheduledOrderFactory.java**: Creates scheduled (future) orders.

*Key concept:* Factories encapsulate object creation logic and support scalability as new order types emerge.

---

### 5. Services (`services/`)

- **NotificationService.java**: Handles notifications to users about order status changes, payments, etc.

*Key concept:* Services encapsulate reusable business functions separate from models/managers.

---

### 6. Utils (`utils/`)

- **TimeUtils.java**: Helper class for date/time calculations like scheduling orders.

*Key concept:* Helps reduce duplicated code by placing utility functions centrally.

---

## How Components Connect & Work Together (Flow)

1. **User Interaction**  
   User searches restaurants via `RestaurantManager`.

2. **View Menu & Cart**  
   User views `MenuItem`s of a `Restaurant` and adds items into their `Cart`.

3. **Order Placement**  
   User initiates an order; `OrderFactory` creates an immediate or scheduled order (`DeliveryOrder` or `PickupOrder`).

4. **Order Management**  
   `OrderManager` manages order lifecycle.

5. **Payment Handling**  
   Payment is triggered using a selected `PaymentStrategy` (credit card, UPI, etc.).

6. **Notification**  
   `NotificationService` sends updates to the user.

7. **Utilities**  
   Support scheduled operations, timing, and calculations.

---

## Design Principles & Patterns Used

- **Single Responsibility Principle:** Each class has one clear responsibility.
- **Loose Coupling:** Managers mediate access to models.
- **Strategy Pattern:** For flexible payment methods.
- **Factory Pattern:** For scalable order creation.
- **Singleton Pattern:** Ensures single manager instances.
- **Composition & Aggregation:** Defining solid object relationships.

---

## How to Use This Project for Revision

- Start with **models/** to understand core domain entities and their relationships.
- Move to **managers/** to see entity lifecycle and operation handling.
- Explore **strategies/** and **factories/** to understand how design patterns enable flexible payment and order creation.
- Check **services/** for app-wide features like notifications.
- Use **utils/** for supportive helper functions.
- Follow the flow from user action to order completion to see how components interact step-by-step.
- Review main entry points (`Main.java`, `TomatoApp.java`) for orchestration overview.

---

This README aims to be a comprehensive revision guide capturing the architecture, design, and workflow of an online food ordering system implemented in Java.

---

*By revisiting this structure and flow, one can recap how to design a large-scale yet modular food delivery application leveraging key OOP and design patterns.*
