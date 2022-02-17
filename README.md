#Code Challenge - Online Store APIs - Solutions
—----------------------------------------------------------------------------------------------------------------------------
##API endpoints: 
To add a product to Cart - HTTP POST
http://localhost:8080/api/cart/products/{product-id}
	{product-id} is an Integer. 
To retrieve the cart details - HTTP GET
http://localhost:8080/api/cart
To create an order from the Cart - HTTP POST
http://localhost:8080/api/order 
To retrieve order details from an Order - HTTP GET
http://localhost:8080/api/order/{order-id}
{order-id} is an Integer. 

##One Sample Product data in JSON Format:
{
        "id": 1,
        "product_category": 1,
        "product_label": "mango",
        "downloadURL": "",
        "weight": "300g"
}

##Technologies and Tools Used:
Java (Compiled and run on JDK 11).
MySql database.
SpringBoot.
Maven
Postman Client
Tomcat Server(Embedded). 

##How to Run the code:
Import the Code in Spring Tool Suite(STS)/ Eclipse.
Maven Update in case of dependency Jar issues.
Run the MySql queries (queries.sql) on MySql Workbench.
Add MySql database details in application.properties(src/main/resources) file.
Run the code as Spring Boot App from STS. 
Test the URL from Postman. 

##Execution steps and Expected Output:
Using API Endpoint 1, any product can be added to the Cart. 
Cart details can be checked using API Endpoint 2. 
Once the order has been created using API Endpoint 3, the Cart will become empty. 
Now, in order to make another order, steps 1 to step 3 above will have to be repeated. 
Using API Endpoint 4, any order details can be checked anytime. 

##Future Improvement Scopes:
Since no. of products is almost 5000, Pagination functionality has to be added, otherwise complete Cart details or complete Order details will not appear on REST API client’s UI 
Categories have a tree structure - This has not been taken care of in this Code. 
Exception and Error Handling can be improved. For example, if the product is not present in the database then API Endpoint 1 will throw an error.Also, in case of empty result sets(e,g. If the cart is empty, if order is empty) proper message should be displayed in JSON format. 




