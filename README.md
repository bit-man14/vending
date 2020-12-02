# Vending Master

Vending Master is a simple web-based application created to support owners of vending machines

## Usage

Just go to [https://vending-master.herokuapp.com/](https://vending-master.herokuapp.com/) to try the application 
(*not always working - heroku DB works according to its own rules* :smiley: )
1. ADMIN  test user       *tom@gmail.com*,    pwd:*111*
2. USER   test user       *tom1@gmail.com*,   pwd:*111*
3. READER test user       *tom2@gmail.com*,   pwd:*111*


## Main Features

**Spring Security**, including new user registration and full user management for ADMIN.<br />
Users can get roles assigned by the ADMIN.<br />ADMIN - has full access and rights to manage all users.<br />
USER - can edit and contribute, but without deletion.<br />READER - only contribution and reading.

**Menu:**
- **File** **Center** - you can upload multiple files of any type. Function intended for machine logs and future stock update.
- **Machines** - list of all vending machines. If you have sufficient privileges you can edit any data of machine.<br /> Special function is Slot Generator. 
  Based on number of shelves and number of slots on shelf it generates slot layout specific for this machine. Available only for ADMIN.<br /> You can see all products assigned to the machine, 
  edit them, block some slots to create double slots for bigger products or in case of malfunction.<br />An extra feature - floating header.
- **Products** - fully paginated list of products with sorting function.<br />You can edit individual products. Its name, price, packaging type, size.
- **Users** - visible only for ADMIN - full user management.

## Technologies used in project
- Java 8
- Maven
- Spring
- Hibernate
- Thymeleaf

## Plans for the future
- **Stock management**
- **File interpreter** to read all useful data from machine logs via the machine printer port (RS 232). <br />
So far, the **File Center** is just a web file storage.

## Contact
[Tomasz Kalwasiński](mailto:tomasz.kski@gmail.com)
