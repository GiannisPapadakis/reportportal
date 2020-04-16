# Atypon Workshop

This a demo project for Atypon's workshop in Test Automation.

## API Tests

In order to start writing API tests you need to create a .json file

```json
{
  "users": [
    {
      "id": 1,
      "firstName": "Kasia",
      "lastName": "Słomka",
      "age": 45
    },
    {
      "id": 2,
      "firstName": "Piotr",
      "lastName": "Kowalski",
      "age": 19
    }
  ],
  "pets": [
    {
      "id": 1,
      "name": "Azor",
      "age": 2,
      "userId": 1
    },
    {
      "id": 2,
      "name": "Tosia",
      "age": 4,
      "userId": 1
    },
    {
      "id": 2,
      "name": "Burek",
      "age": 1,
      "userId": 2
    }
  ]
}
```
In order to create the fake API we need to start it by executing json-server --watch db.json

Allure has already integration with Rest Assured which is a Java library with a BDD like approach that can easily handle 
API testing. 

In order to view in Allure requests/responses/headers etc you need to create RequestSpecification that allows you to specify how the request will look like.

````
new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("http://localhost")
                .addFilter(new AllureRestAssured())
                .build();
````

## Web Tests

Download latest drivers from http://chromedriver.chromium.org/downloads and store it under src/test/resources/drivers

Page Object Pattern is being used for maintainable and object oriented Web UI functional tests

### Allure Features

Main features of allure that are covered on this demo are:

**_Steps_** <br>

Steps are important to break down the execution of a test case to individual tests.<br>
To use them just annotate any method you want with @Step("Description of the step")

**_Attachments_**

You can attach any type of file below just by annotating a function that returns String or byte[] with @Annotation. <br>
Supported file types are:
* csv
* html
* txt
* video
* png

**_Behaviour_**

Some times you need just to add behaviour driver tests. <br>
Allure gives a set of annotations:

* @Epic
* @Story
* @Feature

### Instructions
Environment Setup:
Install Virtual Box: https://www.virtualbox.org/wiki/Downloads<br>
Get the image Ubuntu18_04_1.vdi from ftp server: ftp://ftp.atypon.com with credentials: User: workshop / Password: Atypon_2018<br>
Create a virtual machine and for disk drive use Ubuntu18_04_1.vdi https://blogs.oracle.com/oswald/importing-a-vdi-in-virtualbox<br>
Start the image and use account user: guest/ password: 123 to login<br>
