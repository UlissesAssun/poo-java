# TECHNICAL DOCUMENTATION AND OOP ARCHITECTURE

Academic project developed for the **Object-Oriented Programming (OOP) Practical Assignment - Stage 1**.

---

## 1. Class Diagram (UML)

```mermaid
classDiagram
    direction TB

    class Publication {
        <<interface>>
        +open() void
        +close() void
        +browse(int page) void
        +advancePage() void
        +backPage() void
    }

    class Person {
        -String name
        -int age
        -String gender
        +Person(String name, int age, String gender)
        +getName() String
        +setName(String name) void
        +getAge() int
        +setAge(int age) void
        +getGender() String
        +setGender(String gender) void
        +haveBirthday() void
    }

    class Book {
        -String title
        -String author
        -int totalPages
        -int currentPage
        -boolean open
        -Person reader
        +Book(String title, String author, int totalPages, Person reader)
        +details() String
        +getTitle() String
        +setTitle(String title) void
        +getAuthor() String
        +setAuthor(String author) void
        +getTotalPages() int
        +setTotalPages(int totalPages) void
        +getCurrentPage() int
        +setCurrentPage(int currentPage) void
        +isOpen() boolean
        +setOpen(boolean open) void
        +getReader() Person
        +setReader(Person reader) void
        +open() void
        +close() void
        +browse(int page) void
        +advancePage() void
        +backPage() void
    }

    Book ..|> Publication : implements
    Book o-- Person : aggregates (reader)
```

---

## 2. Core OOP Concepts Applied

1. **Abstraction:** Extraction of essential domain attributes for `Person` and `Book`.
2. **Strict Encapsulation:** All attributes declared `private` with controlled access via Getters and Setters (`JavaBeans` standard).
3. **Aggregation:** Association between `Book` and `Person` (`reader: Person`), with independent lifecycles.
4. **Interfaces and Polymorphism:** `Publication` interface formalizing navigation behaviors implemented by `Book`.
5. **Business Rules and Boundaries:**
   - A book is always instantiated closed (`open = false`) on page 0 (`currentPage = 0`).
   - If attempting to turn pages beyond total capacity ($page > totalPages$), current page is reset to `0` (Slide 37 rule).
