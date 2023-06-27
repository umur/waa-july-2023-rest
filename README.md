
# Lab 2 - RestFUL Web Services

In this lab, you will create a spring boot application from scratch to implement the following requirements.

###  Phase I
---
* Use n-tier software architecture model.
* Make a domain model `Course` with  `id, name, code`.
* Make a domain model `Student` with `id, firstName, lastName, email, major, and coursesTaken`.
    * A student can take multiple courses.
* Create repositories for the domain models. 
	* Hold data in array lists.
* Implement CRUD operations for the domains.
* Implement `getStudentsByMajor(String major)` method.
	* Returns all students majoring `major`.
* Implement `getCoursesByStudentId(int studentId)` method.
* Returns all courses of the student.


---
*  Create UI with HTML and JavaScript.
*  You are not allowed to use any framework like React or Angular.
*  You are not allowed to use jQuery.
*  Use bootstrap for styling and responsive design.
*  Communicate with the backend app that you have created.

### Optional
---
* Create API documentation with `Swagger`.

## Submission

* Create a postman collection that includes sample requests for all of your endpoints.
* Fork the repository and push your changes.
* Once you finished your project, send a Pull Request. (Send only one Pull Request once you finish the assignment.)

### Important Notes

 * You are not allowed to share codes with your classmates. If detected, you will get NC.
 * **For pairs:**
	 * Individual's work will be checked from the commits.
	 *  Share tasks evenly and fairly.
	 *  To have a clearer understanding of pair programming:
		 *  > **Pair programming** is an agile software development technique in which two programmers work together at one workstation. One, the _driver_, writes code while the other, the _observer_ or _navigator_ reviews each line of code as it is typed in. The two programmers switch roles frequently. 
		 * [Wikipedia](https://en.wikipedia.org/wiki/Pair_programming#:~:text=Pair%20programming%20is%20an%20agile,two%20programmers%20switch%20roles%20frequently.)

-   Remember to respect the code honor submission policy. All written code must be original. Presenting something as one’s own work when it came from another source is plagiarism and is forbidden.
    
-   Plagiarism is a very serious thing in all American academic institutions and is guarded against vigilantly by every professor.

### Useful GIT Videos
* Command Line GIT
	* https://www.youtube.com/watch?v=USjZcfj8yxE
* GitHub Desktop
	* https://www.youtube.com/watch?v=0nzJXJAhlsk
* Pull Request
	* https://www.youtube.com/watch?v=For9VtrQx58

