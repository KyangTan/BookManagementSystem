# Book Management System 📚

Book Management System is an open-source project designed to help book-selling businesses establish their online presence quickly and efficiently. With robust features like CRUD operations for books, orders, and promos, this system makes it easy to manage your bookstore online. The system also includes a powerful Analysis module to gain insights into your business performance.

---

## 🌟 Features

### 📖 Books Management
- Add, update, delete, and view books in your inventory.
- Track stock quantities and update them automatically with order placement or cancellations.

### 🛒 Orders Management
- Create and manage customer orders with ease.
- Automatically update stock quantities for purchased books.
- Cancel orders and revert stock levels for active orders (e.g., in processing or delivery).

### 🎉 Promos
- Add promo codes with percentage-based discounts.
- Apply promo codes to orders to reduce the total price.

### 📊 Analysis
- Retrieve top-selling books based on the number of copies sold.
- Retrieve top-earning books based on total revenue generated.
- Limit query parameters to customize the number of results.

---

## 🚀 Getting Started

### Prerequisites
- **Java 17+**
- **Spring Boot 3.x**
- **MySQL 8+**
- **Maven 3.6+**

### Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/yourusername/BookManagementSystem.git
   cd BookManagementSystem
2. **Configure the database:**
    ```
    spring.application.name=BookManagementSystem
    spring.datasource.url=jdbc:mysql://127.0.0.1:3306/book_management_system
    spring.datasource.username=root
    spring.datasource.password=
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.jpa.generate-ddl=true
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
3. **Run the application:**
    ```bash
    mvn spring-boot:run

## 🎯 Use Cases
1. **Manage Books**: Add books to your inventory, update stock quantities, and remove outdated listings.
2. **Simplify Orders**: Process customer orders with automatic stock adjustments.
3. **Boost Sales with Promos**: Offer percentage discounts to customers using promo codes.
4. **Analyze Performance**: Identify top-selling and top-earning books to make data-driven decisions.

## 🛠 API Endpoints

### 📖 Books
| Method   | Endpoint       | Description             |
|----------|----------------|-------------------------|
| `POST`   | `/books`       | Add a new book          |
| `GET`    | `/books`       | List all books          |
| `GET`    | `/books/{id}`  | Get book details by ID  |
| `PUT`    | `/books/{id}`  | Update book details     |
| `DELETE` | `/books/{id}`  | Delete a book           |

### 🛒 Orders
| Method   | Endpoint        | Description               |
|----------|-----------------|---------------------------|
| `POST`   | `/orders`       | Create a new order        |
| `GET`    | `/orders`       | List all orders           |
| `GET`    | `/orders/{id}`  | Get order details by ID   |
| `DELETE` | `/orders/{id}`  | Cancel or delete an order |

### 🎉 Promos
| Method   | Endpoint          | Description               |
|----------|-------------------|---------------------------|
| `POST`   | `/promos`         | Add a new promo code      |
| `GET`    | `/promos`         | List all promo codes      |
| `PUT`    | `/promos/{code}`  | Update a promo code       |
| `DELETE` | `/promos/{code}`  | Delete a promo code       |

### 📊 Analysis
| Method   | Endpoint                  | Description                           |
|----------|---------------------------|---------------------------------------|
| `GET`    | `/analysis/top-selling-books`   | Retrieve top-selling books (limit)    |
| `GET`    | `/analysis/top-earning-books`   | Retrieve top-earning books (limit)    |

## 🧑‍💻 Contributing
We welcome contributions from the community! Here's how you can help:

1. Fork the repository.
2. Create a feature branch:
```bash
  git checkout -b feature-name
```
3. Commit your changes:
```bash
  git commit -m "Add new feature"
```
4. Push to the branch:
```bash
  git push origin feature-name
```
5. Open a Pull Request.

## 📄 License
This project is licensed under the MIT License. See the LICENSE file for more details.

## 🙌 Acknowledgments
Thanks to the open-source community for inspiring and supporting this project. Let's empower small businesses to go online! 🎉
