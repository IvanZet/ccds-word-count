# George Backend Chapter - Coding Challenge
Congratulations. You made it to our next recruiting stage which is a coding challenge. In this stage you have to show practical skills in the things which we discussed in the previous recruiting stage:
- Object-Oriented Programming
- Refactoring
- Automated Testing (Developer Tests) 

### Remote-Pair-Programming Sessions
You will collaborate in five sessions with George Backend Chapter team members in a remote fashion using Skype. The first session starts at 9am. Every session takes one hour. There will be a one-hour lunch break from 12am to 1pm. The last session goes from 2pm to 3pm. At the beginning of every session a new George Backend team member will join the Skype call while the previous colleague leaves.

In the Remote-Pair-Programming Sessions you need to share your screen so that we can follow your progress. In case you have a dual monitor setup, please make sure that you also share your browser window. Of course, you can use the web to research in case you need to look up something. In general it should feel as if you would have a regular working day at work. 

### Exercise: Word Count Kata
Please find the requirements for the Word Count Kata on the following [website](https://ccd-school.de/coding-dojo/#cd8). At the bottom of that page you will find all requirements split into 9 iterations. The goal of this exercise is __not__ to finish as many iterations as possible. We will evaluate your solution based on quality over quantity. 

Please focus on code quality by applying
- Object-Oriented Design, 
- Refactoring and 
- Developer-Tests (aka Unit- and Integration-Tests).

Please always look only at one iteration at a time. The goal is to come up with a design which makes future changes to your code base as easy as possible. Of course, you shouldn't over-engineer your solution but only design as much as needed. This is exactly what we are going to evaluate.

### Feature Branches
In the George Backend Chapter you have to work in feature branches for each task. As soon as you finish your task you will open up a pull request on GitHub which then will be reviewed at least by two of your colleagues (you don't have to do this in your coding interview!). Therefore, think of solving an iteration as if you would solve a task for our team. Always focus on quality and come up with a codebase which you would be happy working in. Empathy in our team is highly valued. We always put ourselves into our reviewers position to improve their life when reviewing our code.

For each iteration, please create a branch with the following pattern: `firstname_lastname_iteration_nr_name`. Your first iteration must branch off `master`, or in case you want to use Kotlin, please branch of `kotlin_maven_baseline`. Your branches won't be merged back to master. Every new branch must branch of the previous branch. At the end of every branch, you have to add the first name of the person you are working with.

### Assumptions 
In case the requirements are ambiguous, please write down your assumptions into the project's `assumptions.txt` file. Please always create a section for each iteration and put your assumptions under this section. The reason for this is, so that we can follow certain design decisions in your code which you came up with based on your assumptions.

### Evaluation
We will only evaluate your finished iterations. Please make sure that your code is compiling, your tests aren't failing, the requirements are met, and the code is in a state that you are happy with. You can see these rules as the definition of done for an iteration.

This example might also seem a bit hypothetical, but we believe it's small but complicated enough, that it makes sense to come up with an Object-Oriented Design which is more than implementing your whole solution in a single main method 😉. The evaluation won't take longer than 1 work day. If we are happy with your solution we will send you the information for the Remote-Pair-Programming Sessions. In case we won't continue the recruiting process with you, we will send you a detailed feedback of our evaluation.

### Requirements
Please use Java 8 or Kotlin as a programming language. No Framework is allowed for this exercise. No other library than JUnit must be used. Currently, JUnit 5 is configured in the `pom.xml`. In case you prefer JUnit 4 over 5 please change the `pom.xml` file accordingly. We don’t allow any mocking library. In case you see the need for mocking, please hand-roll your mocks.

### Let's Get Started
1. Please clone the repository.
2. Create a branch off master (if you use Java) or off kotlin_maven_baseline (in case you use Kotlin): `firstname_lastname_iteration_1_colleague`
3. Push this branch to the repository.
4. Run `mvn clean install` via your terminal.
5. Open the project in your IDE of choice.
6. Create a dummy unit test and run it.
7. Read the requirements from the Requirements section. Please only read one iteration at a time starting with iteration 1.
8. Please think about how you will approach this problem in code for a few minutes without coding.
