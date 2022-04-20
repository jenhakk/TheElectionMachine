# TheElectionMachine
This is our school project for Server Programming course. Task was to make an election machine using Java, JSP, HTML and Servlets. The project is divided between Server Programming and Web Services courses. There were four features to choose from and the idea was to implement at least one per course. We used Scrum for the development process.

The features were:

 -  Admin can add, edit and remove candidates.
 -  Admin can add, edit and remove questions.
 -  Candidate can answer the questions and edit and delete their answers.
 -  End user (voter) can answer the questions and see which candidate is the best match for them.

We decided to make candidate's and voter's view. Admin features will be created in the next course. 
Candidate can answer questions, edit and delete answers. They can also see profile and edit their information. 
Voter can answer questions and browse candidates. After answering questions, they see three most suitable candidates based on their answers..

We started the project by deciding how the features would be implemented and what the site would look like. We designed the layout with Figma. Here is the link to [Figma](https://www.figma.com/file/OV6hQmNGV3PbAVEQjBtPgV/Election-Machine-Frontpage?node-id=0%3A1).

###### End users view

On the front page user can choose from three different functions: Browse candidates, Answer questions and Are you a candidate? First two are for the voter.
When user click Browse candidates button they will be directed to a page where all candidates are listed. Candidate's information comes from servlet which reads data from database using DAO class' method. User can select one of the candidates and see more specific information about them. They can also check candidate's answers. 
