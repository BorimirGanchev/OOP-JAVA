# SQLReturnTypeChecker

## 📌 Описание
CLI програма на Java, която приема SQL файл и флага `--java`, за да върне типовете на колоните от заявката.
Използва **JDBC** за свързване с PostgreSQL.

## 🚀 Инсталация и Стартиране

### 1️⃣ **Компилиране и Стартиране с Java**
Ако имаш **Java (JDK 17+)** и **PostgreSQL JDBC Driver**, можеш да я стартираш така:

#### **Компилиране:**
```sh
javac -cp .:postgresql-<version>.jar SQLReturnTypeChecker.java
```
*(Замени `<version>` с текущата версия на драйвъра, напр. `postgresql-42.5.0.jar`)*

#### **Стартиране:**
```sh
java -cp .:postgresql-<version>.jar SQLReturnTypeChecker <sql_file> --java
```
**Пример:**
```sh
java -cp .:postgresql-42.5.0.jar SQLReturnTypeChecker query.sql --java
```

---
### 2️⃣ **Създаване на .exe (Windows)**

#### **С GraalVM (Native Image)**
1. Инсталирай **GraalVM** и активирай `native-image`:
   ```sh
   gu install native-image
   ```
2. Компилирай в `.exe`:
   ```sh
   native-image -cp postgresql-<version>.jar SQLReturnTypeChecker
   ```
3. Стартирай:
   ```sh
   SQLReturnTypeChecker.exe query.sql --java
   ```

#### **С Launch4j (GUI Tool)**
1. Инсталирай **Launch4j**
2. Укажи `.jar` файла и настрой изхода като `.exe`
3. Генерирай `.exe` и стартирай:
   ```sh
   SQLReturnTypeChecker.exe query.sql --java
   ```