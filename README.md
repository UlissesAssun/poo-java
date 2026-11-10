# Object-Oriented Programming (OOP) in Java — Practical Project

Academic project developed for the **Object-Oriented Programming (POO)** course.

The application models and implements the interaction between a reader (`Person`) and a literary work (`Book`), establishing an operational contract through the `Publication` interface. The codebase is organized entirely in English, while the terminal user interface is presented in Portuguese for intuitive navigation.

---

## 🏛️ Project Structure

The project follows standard professional Java source code conventions:

```text
POO/
├── src/                          # Java source code (.java)
│   ├── Person.java               # Reader entity model (encapsulation)
│   ├── Book.java                 # Book entity model (aggregation & interface implementation)
│   ├── Publication.java          # Contract interface for publications
│   ├── Main.java                 # Automated test suite (Slides 33 to 38)
│   └── TerminalInterface.java    # Interactive console interface (in Portuguese)
│
├── bin/                          # Compiled bytecode binaries (.class)
│   ├── Person.class
│   ├── Book.class
│   ├── Publication.class
│   ├── Main.class
│   └── TerminalInterface.class
│
├── docs/                         # Technical documentation and diagrams
│   └── stage1_architecture.md    # Architecture specification & UML Mermaid diagram
│
├── build.bat                     # Automatic build script (src/ -> bin/)
├── run-tests.bat                 # Run the test suite (Main.java)
├── run-interactive.bat           # Launch the interactive terminal reader (in Portuguese)
├── .gitignore                    # Git rules ignoring binaries and IDE folders
└── README.md                     # Project documentation
```

---

## 🧩 OOP Concepts Implemented

* **Abstraction:** Modeling essential attributes for `Person` (`name`, `age`, `gender`) and `Book` (`title`, `author`, `totalPages`, `currentPage`, `open`, `reader`).
* **Strict Encapsulation:** Private attributes accessed and modified exclusively through Getters and Setters (`JavaBeans` standard).
* **Aggregation:** `Book` holds a reference to `Person` as its `reader`. Both instances maintain independent lifecycles.
* **Interface & Polymorphism:** `Publication` declares `open()`, `close()`, `browse(int page)`, `advancePage()`, and `backPage()`, implemented with `@Override` in `Book`.
* **State & Boundaries (Slide 37):**
  - Initial state: closed (`open = false`) and page zero (`currentPage = 0`).
  - Attempting to turn pages beyond book limit ($page > totalPages$) resets `currentPage` to `0`.

---

## 🚀 How to Build and Run

### 1. Build the Project
Double-click `build.bat` or run:
```powershell
javac -encoding UTF-8 -d bin src/*.java
```

### 2. Run Integrated Tests
Double-click `run-tests.bat` or run:
```powershell
java -cp bin Main
```

### 3. Run Interactive Reader (Portuguese UI)
Double-click `run-interactive.bat` or run:
```powershell
java -cp bin TerminalInterface
```
*(Or run `java -cp bin Main --interactive`)*
