# Vending Master

Vending Master is a simple web-based application created to support owners of vending machines

## Usage

Just go to [https://vending-master.herokuapp.com/](https://vending-master.herokuapp.com/) to try the application 
(*not always working - heroku DB works according to its own rules* :smiley: )
1. ADMIN  test user       *tom@gmail.com*,    pwd:*111*
2. USER   test user       *tom1@gmail.com*,   pwd:*111*
3. READER test user       *tom2@gmail.com*,   pwd:*111*


## Main Features

**Spring Security**, including new user registration and full user management for ADMIN. 
Users can get roles assigned by admin. ADMIN - full access and rights to manage all users. 
USER - can edit and contribute but without deletion. READER - only contribution and reading.

Menu:
- **File** **Center** - you can upload multiple files of any type. Function intended for machine logs and future stock update.
- **Machines** - list of all vending machines. If you have sufficient priviliges you can edit any data of machine. Special function is Slot Generator. 
  Based on number of shelves and number of slots on shelf it generates slot layout specific for this machine. You can see all products assignet for machine, 
  edit them, block some slots to create double slots for bigger products or in case of malfunction. Extra feature - floating header.
- **Products** - full paginated list of products with sorting function. You can edit individual products. Its name, price, packaging type, size.
- **Users** - visible only for ADMIN - full user management.

## Technologies used in project
- Java 8
- Maven
- Spring
- Hibernate
- Thymeleaf

## Plans for the future

File interpreter to read all usefull data from machine logs. So far, the file center is just a web file storage.

## Contact
[Tomasz Kalwasiński](mailto:tomasz.kski@gmail.com)
