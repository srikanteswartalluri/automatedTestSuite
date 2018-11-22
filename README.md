# automatedTestSuite
This is an automated test suite to test my.bonify.de. 
This test suite is built using testNg, Selenium WebDriver and its Page Object Model. Page Object classes are created for the following pages
1. Home page - https://www.bonify.de/   (if login button is clicked , we move to Login Page)
2. Login Page - https://my.bonify.de/login/
3. LoginFirstPage - once the login is succesful you will land in this page

Focus of these tests are more on the item no. 2 (Login Page), Hence, all the components' locators of the login page such as 
1. user email
2. user password
3. login button
4. Forgot Password
5. New User Registration
6. Conditions
7. Imprint 
8. Data protection

are present in the Login Page Class. The actions that can be performed on the above elements are methods in the Login Page class such as
1. enterEmail(String)
2. enterPassword(String)
3. clickLogin()
4. clickRegister()
5. clickForgotPassword()
etc.,

TestNg tests are part of LoginTest class.
