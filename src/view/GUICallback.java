package view;

public class GUICallback {
    //write the menu
    //Integrate with the other classes

    /*
    -- Prompt to login --
    * New staff gets created below
    Login
    Sign up

    *Specify their position here

    - Add new student
        - Create program structure (if new student)
            - Add current courses
            - Add previous courses
            - Add exemptions for courses (if exempted)
            - Add transfers (if exists)
            - Add internships (if completed)

     - View student details
       - Add student number to view the student's program structure
       * Show student details

        - Access existing program structure
            * View of program structure -- toStrings of all the classes

            - View program structure #programStructure

            - Filter by type #programStructure
            * Courses
            * Exemptions
            * Transfers
            * Internships


            * View all the courses when selected courses
            - Select a course #call the toString of course
                * View the specific course

                - View the duration of the course #getDuration of Course

                - Add a comment

                #call the comment class and create the bloody comment
                #pass the comment as a para to Course ie specific structure
                    - Confirmation to add to the student record
                    #call the addComment on Course
                    - Send email to student
                    #call sendCommentEmail on student

            - Add new course
            #call the constructor of the desired structure
                - Confirm the course
                #call add new structure on programStructure


            - Delete a course
            #call getCategory(int listNumber)
                - Confirm deletion


            - View comments
            #call getComments on structure
                * List of comments in chronological order
                * Date and time is displayed for each comment
                * The program manager who wrote it is attached

                - Filter comments
                #calls getComments on structure
                    - By program manager
                    - By date and time

                - Append comment
                    - Select comment to append to
                        - Add a comment
                        - Confirmation to add to the student record
                        - Send email to student

            - View internships

            - View transfers

            - View exemptions
            * Authority should be applied here for editing

     */
}
