# Selenium Cucumber TestNG Automation Framework

## 📌 Overview
This is a **Maven-based automation framework** using **Selenium, Cucumber, and TestNG**.  
It supports **parallel execution** and generates **detailed HTML, JSON, Extent, and Allure reports**.

## 📂 Project Structure
```
JyotiChaurasiaSeleniumAssessment2/
│── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com.automation.base/
│   │   │   ├── com.automation.image/
│   │   │   ├── com.automation.login/
│   │   │   ├── com.automation.pages/
│   │   │   ├── com.automation.screen/
│   │   │   ├── com.automation.url/
│   │   │   ├── com.automation.utils/
│   │   │   ├── configurationProperties/
│   │   │   │   ├── ConfigureProperties.java
│   ├── test/
│   │   ├── java/
│   │   │   ├── com.automation.runners/
│   │   │   │   ├── **TestRunner.java**
│   │   │   ├── com.automation.stepdefinitions/
│   │   │   ├── com.automation.utils/
│   │   ├── resources/
│   │   │   ├── configuration/
│   │   │   │   ├── config.properties
│   │   │   ├── features/
│   │   │   │   ├── screenshots/
│   │   │   ├── product_inventory.xlsx
│── pom.xml
│── test-output/
│── target/
│── allure-results/
│── Maven Dependencies/
│── JRE System Library (JavaSE-1.8)

```

---

## **🛠️ Setup Instructions**

### **Step 1: Clone the Repository**
Open **Git Bash / Terminal** and run:
```sh
git clone https://github.com/your-username/your-repo-name.git
cd your-repo-name
```

---

## **⚙️ Configuring the Project**

### **Step 2: Configure `config.properties` File**
Navigate to:
```
src/test/resources/configuration/config.properties
```
Modify the following:

```properties
# Change if testing a different site
URL= https://www.mycontactform.com/

validUsername= Prabhu123
validPassword= 12345

# Set correct paths for screenshots and Excel files
screenshotDir= C:\path\to\screenshots\
excelDir= C:\\path\\to\\excel\\directory\\
```

### **Step 3: Update `ConfigureProperties.java` Path**
Navigate to:
```
src/main/java/configurationProperties/ConfigureProperties.java
```
Change the **absolute path** of `config.properties` in:

```java
String directoryPath = "C:\\path\\to\\config.properties";
```
📌 **Ensure double backslashes (`\\`) in Windows paths.**

---

## **📍 How to Find the Absolute Path of a File**
### **Windows**
1. Navigate to the required file in **File Explorer**.
2. **Right-click → Properties**.
3. Copy the **full location** from the **Location** field.
4. Append the **file name** at the end.
   Example:
   ```
   C:\Users\YourName\Documents\config.properties
   ```
5. Convert `\` to `\\` when adding it to Java files.

### **Mac/Linux**
1. Open **Terminal**.
2. Navigate to the folder:  
   ```sh
   cd /path/to/directory
   ```
3. Run:
   ```sh
   pwd
   ```
4. Append the **file name** at the end.

---

## **🚀 Running Tests**

### **Step 4: Running Tests in Eclipse**
1. **Import the Maven Project**:  
   - Open Eclipse → **File → Open Projects from File System** → Select the project folder.
   - Right-click the project → **Maven → Update Project**.

2. **Run `TestRunner.java`**:  
   - Navigate to:
     ```
     src/test/java/com/automation/runners/TestRunner.java
     ```
   - Right-click **TestRunner.java** → **Run As → TestNG Test**.

### **Step 5: Running Tests via Maven**
Run all tests using:
```sh
mvn test
```

---

## **📑 Using Tags in `TestRunner.java`**
Navigate to:
```
src/test/java/com/automation/runners/TestRunner.java
```
Modify:
```java
@CucumberOptions(features = "src/test/resources/features", 
                 //tags = "not @LoginValidation",  // Uncomment if needed
				 glue = { "com.automation.stepdefinitions", "com.automation.base" }, 
				 plugin = { "pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" }, 
				 monochrome = true)
```
- **Default:** Runs all tests.
- **To exclude login tests** (if testing another site):  
  ```java
  tags = "not @LoginValidation"
  ```
- **To run only login tests**:
  ```java
  tags = "@LoginValidation"
  ```

---

## **📊 Viewing Reports**
### **1️⃣ Cucumber HTML Report**
📌 **Location:**  
```
target/cucumber-reports.html
```
📌 **Open in Browser:**  
- **Windows:** Double-click the file.
- **Mac/Linux:**  
  ```sh
  open target/cucumber-reports.html
  ```

### **2️⃣ JSON Report**
```
target/cucumber.json
```

### **3️⃣ Extent Report**
```
target/extent-reports/
```

### **4️⃣ Allure Report**
📌 **Generate & View Allure Report**
```sh
allure serve target/allure-results/
```

---

## **🛠️ Troubleshooting**

### **❓ Maven Not Recognized**
- Ensure Maven is installed (`mvn -version`).
- Set `MAVEN_HOME` in system variables.

### **❓ TestNG Not Working**
- Ensure `testng.xml` is configured properly.
- Right-click the project → **Maven → Update Project**.

### **❓ Element Not Found**
- Ensure locators match the current website.

---

## **🔧 Customization Guide**
If testing **a different site**, modify:
1. `URL` in `config.properties`.
2. **Element locators** in step definitions.

---

## **📜 License**
This project is **open-source** under the **MIT License**.

---

## **🎯 Final Notes**
✅ **Change file paths properly before running.**  
✅ **Modify `TestRunner.java` tags if needed.**  
✅ **Run tests via Eclipse or Maven (`mvn test`).**  
✅ **View reports in `target/` folder.**  

🎉 **Now you're ready to automate! 🚀**  
```
