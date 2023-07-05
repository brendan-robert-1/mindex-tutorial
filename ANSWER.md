## Answers

My solution to part 1 was to add a new endpoint to the controller for reporting structure that calls a new method
in `EmployeeService` the logic for counting the hierarchy of reports is in the method `getDirectReportsCount` which
uses a Java Stream and a recursive call to count them up. 

I've attached a postman collection `answer-collection.json` in the root directory that can be imported into any postman runtime to check 3 solutions:
Multi-level nesting, 1, and zero reports.

For part 2 I created all the endpoints and relevant persistence classes. I created a new mongo repository for `Compensation`
I also added an "Advice" class to handle `NotFoundException` and `IllegalArgumentException`