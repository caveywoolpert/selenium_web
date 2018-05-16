# AutoTests for lifeBox project

### Folder/file structure:
```
/doc --test cases specification
/src 
    /main/java/utils  - contains constants of input data / selenide config / webdrivers
                        (used for .properties file)
    /main/resources   - contains property files itself, webdrivers and selenium standalone server
    
    /test --Test Suits/Cases
Gruntfile.js
package.json
```

### Steps to setup: 
- Clone the repository, then navigate to the folder

- Run `npm install` to install all necessary npm packages for the project.
- Run lifebox server locally (necessary to clone lifebox web repo & install in appropriate way). Or, change property param BASE_URL=http://localhost:3000 in appropriate way

- Run `npm run start` to start selenium hub & node with default preferences --`NOT NECESSARY YET`
- Run `TestSuiteRunner` class to run all tests

### Adding new tests&etc.
 Test cases separated by groups (welcome page, home page, etc.)
 To add/remove testcase to the test suite, modify, for example, TestSuiteHomePage.java