### Problem Statement: Resource Management and Optimization
The goal is to create a system for managing and optimizing limited resources on Mars (like water, food, and energy). This system includes:

Backend: APIs to manage resource inventory, consumption tracking, and predictive analytics.
Frontend: Dashboard to visualize resources, trends, and predictions.
Real-Time Data: Simulated real-time updates.

```
mars-resource-management/
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.example.mars
│   │   │       ├── controller
│   │   │       │   └── ResourceController.java
│   │   │       ├── service
│   │   │       │   └── ResourceService.java
│   │   │       ├── model
│   │   │       │   └── Resource.java
│   │   │       ├── repository
│   │   │       │   └── ResourceRepository.java
│   │   │       └── MarsResourceManagementApplication.java
│   │   └── resources
│   │       ├── application.properties
│   │       └── data.sql
│   └── test
│       └── java
│           └── com.example.mars
│               └── ResourceControllerTest.java

```

Explanation of Methods
findByQuantityLessThan(double threshold)

Finds all resources where the quantity is less than the specified threshold.
Useful for alerting when resource levels are critically low.
findAllByOrderByConsumptionRateDesc()

Fetches all resources sorted by consumptionRate in descending order.
Helps prioritize resources with the highest consumption rates.
findByType(String type)

Retrieves resources of a specific type (e.g., "Oxygen," "Water").
Useful for filtering data in the application.