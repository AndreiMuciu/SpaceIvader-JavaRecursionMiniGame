# 🛸 Space Invader Simulator — Dynamic Class Handling with Java Reflection

This project was developed as part of the **Advanced Software Architecture & Design** course and explores advanced Java features such as **reflection**, **custom class loading**, and **runtime polymorphism** — all in the context of simulating alien invaders!

## 🚀 Project Overview

The challenge: Build a **Space Invader simulator** that can interact with completely unknown alien classes at runtime — **no interfaces**, **no base classes**, and **no source code** ahead of time.

### What It Does

✅ Dynamically scans a folder for `.class` files  
✅ Uses reflection to **load and instantiate unknown classes**  
✅ Discovers and calls **methods** with **random parameters**  
✅ Introspects and manipulates **fields and constructors**  
✅ Operates with **zero compile-time knowledge** of the alien code

---

## 🧪 Technologies & Concepts Used

- **Java** (SE)
- `java.lang.reflect`
- **Custom class loaders**
- **Dynamic method invocation**
- **Runtime type discovery**
- **Random data generation**

---

## 🧠 Key Learnings

- Handling **unknown types** and structure dynamically
- Safely invoking methods and constructors at runtime
- Implementing logic that adapts to class structures on the fly
- Understanding **runtime introspection** and **polymorphism without inheritance**

---

## 💡 Example Use Case

Place compiled `.class` files of "alien" types into the `aliens/` directory. The simulator will:

1. Load each class dynamically
2. Create instances even without knowing constructors
3. Reflectively call available methods using generated input
4. Optionally inspect and modify public fields

---

## 📁 Project Structure

```
📂 src/
  └── SpaceInvaderSimulator.java
📂 aliens/
  └── (compiled .class files go here)
```

---

## ▶️ Running the Project

1. Compile the project:

```bash
javac src/SpaceInvaderSimulator.java
```

2. Run the simulator:

```bash
java -cp src SpaceInvaderSimulator
```

> Make sure `.class` files for alien invaders are placed in the `aliens/` folder before running.

---

## 🧰 Notes

- No alien source code is required — only compiled `.class` files.
- The project is robust against missing or malformed methods/constructors.
- Supports both public and non-public class members (with proper access permissions enabled).

---

## 🔗 Let's Connect!

Have feedback or ideas on how to push dynamic Java programming further?  
Feel free to connect and discuss!

🔗 [LinkedIn Post](https://lnkd.in/d8RKjami)

---

## 📜 License

This project is released for educational purposes. Modify and explore freely!
