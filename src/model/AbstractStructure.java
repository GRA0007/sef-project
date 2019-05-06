package model;

import model.interfaces.CommentInt;
import model.interfaces.StructureInt;

import java.util.Date;

public abstract class AbstractStructure implements StructureInt{

	protected Student student;
	
	public AbstractStructure(Student student)
	{
		this.student = student;
	}

    public abstract String getDuration();

    public void addComment(CommentInt comment){

    }

    //Loop through all the comments for the structure
    //and return as a string is toString in comment class
    public String getComments(){
       return null;
    }

    public  String getComments(Staff staff){
        return null;
    }
    public  String getComments(Date dateTime){
       return null;
    }
    
    @Override
    public String toString() {
    	
    	return String.format("Student ID:\t\t%s\nStudent Name:\t\t%s\n",
    			student.getID(), student.getName());
    	
    };

}
