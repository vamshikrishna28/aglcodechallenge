Required Softwares :
- JDK 1.8
- Maven 3.x

Installation and Getting Started
Steps for running the application
- Check out the source from git hub
- Run the command "mvn spring-boot:run"(start spring boot application)


This is a spring boot based application which reads data from a webservice http://agl-developer-test.azurewebsites.net/

The idea is to display the Gender of the owner and associated pets in alphabetical order.
Once the application is up and running, access the static html - http://localhost:8080/ViewPeopleDataPage.html to show the following desired output:

**Male**

- Angel
- Molly
- Tigger

**Female**

- Gizmo
- Jasper


Note : The application has been developed using Spring boot(api), static HTML & vanilla Javascript have been used to render UI. 
However, ideally the UI should be developed using one of the modern javascript frameworks like ReactJs.
But html and javascript has been chosen for the sake of simplicity.
