# Notification System - Clojure

This project is a **Notification System** built in Clojure. It receives messages with categories (Sports, Finance, Movies) and forwards them to pre-defined users based on their subscriptions and preferred channels (SMS, Email, Push Notification).  

---

## Features

- Users can subscribe to message categories:
  - Sports
  - Finance
  - Movies
- Users specify preferred channels:
  - SMS
  - Email
  - Push Notification
- Message routing selects the correct channels for each user
- Logging of notification attempts
- 'Mocked' users and messages for simplicity
- Unit tests for all services, channels, and controllers

---

## How It Works

1. **User Subscriptions**  
   Each user is pre-populated with:
   - ID, Name, Email, Phone Number
   - Subscribed categories
   - Preferred channels

2. **Message Submission**  
   - Users submit a message via a simple form:
     - Category (dropdown)
     - Message body (text area)
   - Validation ensures fields are not empty

3. **Notification Delivery**  
   - The system sends the message only to users subscribed to that category
   - The message is sent through the user's selected channels
   - Each channel has its own class to manage sending logic
   - Logs store the message, user, channel, timestamp, and status

---

## Running the Project

### Prerequisites
- [Clojure](https://clojure.org/guides/getting_started)
- [Leiningen](https://leiningen.org/)

### Steps

1. Clone the repository
```bash
git clone git@github.com:brendska/notification-system-clojure.git
cd notification-system-clojure
Install dependencies

bash
Copy code
lein deps
Run the application (REPL or server)

bash
Copy code
lein repl
Execute tests

bash
Copy code
lein test
Unit Testing
All services, channels, and controllers are covered

Example test commands:

bash
Copy code
lein test notification-system-clojure.test-channels
lein test notification-system-clojure.test-controller
lein test notification-system-clojure.test-service
Tests use mock users and messages

100% of tests should pass if setup correctly

Architecture & Principles
OOP & SOLID:

Separation of concerns: Controllers, Services, Channels, Models

Abstraction and interfaces for notification channels

Dependency inversion: Controller depends on service, not on channels directly

Design Patterns:

Strategy pattern for selecting notification channel

Factory or simple dispatch for channel logic

Scalability:

Easy to add new notification channels

Easy to add new message categories

Minimal changes needed for new requirements

Error Handling:

Validation for required fields

Logging of delivery attempts and failures

Notes
No real messages are sent; channels print to console for demonstration

Users are mocked inside the code (src/notification_system_clojure/models/user.clj)

The system is ready to integrate with actual SMS/Email/Push providers in the future

Author
Brenda Azeredo
