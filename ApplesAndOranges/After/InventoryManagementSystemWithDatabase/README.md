#Inventory Management System

##About
Inventory Management System is an almost total re-work of Apples and Oranges that I created in late March of 2022. The application is now meant to include all objects, but with some facets still focused on fruits. The app asks the user for the fruits (or any non-fruit object) name, how many are in stock, an how many need to be in stock and then uploads the information to a database. There is a menu in the app that allows the user to add items, list all items, find specific items, update items, and delete items. The application contains full CRUD functionality, data validation, and a clear menu that the user can use to learn more.
    
## Usage:
*This application requires MySQL, Java, and a corresponding JDK to work  
1. Start the MySQL shell
2. In the shell, run `CREATE DATABASE fruits` to create a database for the application
3. run, `USE fruits` to go into the database
4. run, 
```
CREATE TABLE fruits (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL,
    price INT NOT NULL,
    numItems INT NOT NULL,
    maxNumItems INT NOT NULL,
    PRIMARY KEY (id)
);
```
to create the table that the application will use  
5. In a seperate terminal, cd into the project directory and compile Main.java: `javac Main.java`  
6. Run, `java Main` to start application  
