## Professional Self-Assessment

## Code Review (Video)

FIXME: add link to youtube video here

## Polished Work

### Software Design and Engineering

##### Project: [Steve's Mower Repair Services](https://github.com/IanHefflefinger/CS-499/tree/master/StevesWebsite)

##### Narrative: 

Steves Mower Repair Services is a website that I initially created for IT-270: Web Site Design in early 2021. It was a simple HTML/CSS/JavaScript website that represented a fictional mower-repair business owned and operated by a man named, “Steve”. This website was strictly a front-end website that did not include a server.

The enhanced version of the website is a full-stack application with a Node.js/Express.js back-end. The enhanced application also contains several design modifications, security improvements, and features. The enhanced version of the site contains the same content (with a few exceptions) as the initial site, but with a functioning back-end. This site was created in March of 2022.

I selected this artifact because I knew I could significantly improve upon it. The initial application was strictly HTML/CSS/JavaScript and I knew enough about Node.js/Express to host it on a server. I also felt the website could be easily modified to look more presentable and to render information more appropriately. 

This site now contains a fully functioning form with client-side validation that sends a POST request to a server with server-side validation. The form renders a success page once the server receives and validates the request. The site also uses Bootstrap on the front-end so styling and UI features could be implemented more easily. Bootstrap also allowed for the site to be more mobile-friendly and now the site includes a nabber that can be used on a mobile-sized device. The site also no longer has resizing issues with the images, cards, and navigation bar.

The enhanced version of the site uses ejs on the backend to allow for templating - this significantly DRY’s up the code and allows for uniform headers and footers on each page. The templating engine ejs also allows for much easier dynamic rendering of data on each page and lays a foundation for a more dynamic future for the site (ejs could allows for a lot of future opportunities with each page). 

The planned outcome-coverage for these assignments are, “Demonstrate an ability to use well-founded and innovative techniques, skills, and tools in computing practices for the purpose of implementing computer solutions that deliver value and accomplish industry-specific goals (software engineering/design/database)”. This assignment specifically was meant to meets the goals of Software Design and Engineering. The enhanced artifact absolutely met the criteria for Software Design and Engineering. 

This enhanced application has visual design changes that are obvious improvements to the user interface. The mobile-first enhancement is a far better design and is more user-friendly. Adding Bootstrap allowed for a better user experience (especially with the navigation bar on mobile devices). The form is significantly enhanced and provides validation on the client and server levels. Images now render and resize appropriately and content within the pages reacts correctly to resizing.

Migrating the site to the back-end took engineering skills and allowed for an application that can actually be accessed by end-users in remote locations. Features were added on the back-end to allow the form to actually be useful and validate data before returning an appropriate response to the user. The back-end of the site uses Node.js/Express.js as a server-language/framework - this is a rising technology that is in high demand.

As I was improving this website, I ran into several issues with the new features I was adding and the updated styling. I initially ran into issues with Express.js and it’s router module where I was not able to render any pages except root and users but I was able to resolve the issue after some time on Stack Overflow. I also ran into issues with implementing actual functioning to the form. For the form validation, I used a package (express-validator) who’s documentation referenced dependancies that are now integrated with Express, so I had to modify the base code to omit some information that was outdated. All of the other issues I ran into were fairly straightforward to resolve. I learned a fair amount about Express.js, Bootstrap, and CSS throughout the process. For example, I learned that multiple views can be rendered to a single URL (this proved useful with the form pages success message).


### Algorithms and Data Structures

##### Project: [Apples & Oranges / Inventory Management System](https://github.com/IanHefflefinger/CS-499/tree/master/ApplesAndOranges)

##### Narrative: 

Apples and Oranges was an application I initially wrote in my IT-145 Foundations in Application Development course. It was a simple application that asked the user how many apples and oranges were in stock, how many needed to be in stock, and calculated the difference and showed the user how many needed to be ordered. It was a very simple application that served mostly as a module to teach about java variables and basic input/output.

Inventory Management System is an almost total re-work of Apples and Oranges that I created in late March of 2022. The application is now meant to include all objects, but with some facets still focused on fruits. The app asks the user for the fruits (or any non-fruit object) name, how many are in stock, an how many need to be in stock and then uploads the information to a database. There is a menu in the app that allows the user to add items, list all items, find specific items, update items, and delete items. The application contains full CRUD functionality, data validation, and a clear menu that the user can use to learn more.

I selected this item because it was very immature and needed a lot of work to be taken seriously as an application. I knew that I could upgrade the application to use a more diverse array of data types and algorithms to collect data from the user, process it, and insert it into a database (or query from it). The artifact was improved by adding a database, full CRUD functionality, a menu of commands, data validation, a user-friendly output to the terminal, and a broader array of data structures.

The course objectives were absolutely met. The application clearly uses more advanced algorithms and data structures to manage data in the program (Design and evaluate computing solutions that solve a given problem using algorithmic principles and computer science practices and standards appropriate to its solution, while managing the trade-offs involved in design choices (data structures and algorithms)). The application also offers slightly better security by providing an interface to a database that cannot be modified outside the scope of the application - this fulfills “Develop a security mindset that anticipates adversarial exploits in software architecture and designs to expose potential vulnerabilities, mitigate design flaws, and ensure privacy and enhanced security of data and resources”.

I initially started programming the application to use inventory item objects (to represent things like bananas, apples, etc.), but as I was going along I also wanted a database in order to legitimize the application. It felt cumbersome to created objects just to rip them apart, add their fields into a database, and destroy them. I ended up rewriting the application to include CRUD database API’s that could be used by the program to perform the applications objective. I learned how to use Javas JDBC to communicate with a MySQL database - this provided a huge advantage because it meant I could more directly communicate with the data store. I also learned how to gather user input in loops and sub-loops to gather large amounts of specific input.

### Databases

##### Project: [Database Commands](https://github.com/IanHefflefinger/CS-499/tree/master/DatabaseCommands)

##### Narrative: 

SQL Commands was a script I wrote in DAD-220 Introduction to SQL back in 2019. It is an SQL script that creates a database, three tables inside the database, and then seeds the tables with data (relating to the table). The script also defines the schema for the database (it decides what and how the data is entered).

NoSQL Commands is a script I wrote in early 2022. It is a JavaScript that creates a database, three collections (similar to tables in SQL), and seeds each collection with relevant data (the same data in the SQL database). This script does not define a schema as that is done by the client.

SQL and NoSQL are two sides to the same coin. Databases are vital to applications and knowing how to work with more than one type is very important for todays software developer. Being able to migrate from SQL to NoSQL and vice-versa displays a deep knowledge of how databases work and why they exist. The artifact was improved by being converted to a database that uses a data format that is closer to JSON, which is used by many applications, especially web-applications. MongoDB is also a very scalable database and can out-perform SQL in certain realms. 

I met the course objectives for databases in this assignment. I clearly demonstrated my knowledge of how each database is configured to enter data (the very same data) into each. I have no planned updates to this database so far, but will implement any that I might find in the future. 

I expected this to be the easier of my three enhancements, but it has proved to be the most difficult. SQL uses schemas to define how data is stored in tables, whereas MongoDB is schema-less. SQL also has the ability to use auto-incremented fields for id’s, but MongoDB uses it’s own auto-generated id’s which are not incremented. I had to enter the data into MongoDB in a very unique way to replicate one of the SQL tables (the messages table), which showed the relation between elements. 
