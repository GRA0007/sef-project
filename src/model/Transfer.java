package model;

import java.util.Date;

public class Transfer extends AbstractCategory {

    private String fromProgram;
    private String toProgram;


    public Transfer(String fromProgram, String toProgram, Date startDate, boolean isTransferred, Date endDate, Staff staff) {
        this.fromProgram = fromProgram;
        this.toProgram = toProgram;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isCompleted = isTransferred;
        this.staff = staff;
    }

    public String getFromProgram() {
        return this.fromProgram;
    }

    public String getToProgram() {
        return this.toProgram;
    }

    public Date getDate() {
        return this.startDate;
    }

    public boolean isTransferred(){
        return this.isCompleted;
    }

    @Override
    public String toString() {
        String toString = "";

        toString = String.format("%s\n%-30s%s", toString, "Transferred from:", this.fromProgram);
        toString = String.format("%s\n%-30s%s", toString, "Transferred to:", this.toProgram);
        toString = String.format("%s\n%-30s%s", toString, "Date:", this.startDate.toString());


        String transferredOrNot = "";
        if (isCompleted) {
            transferredOrNot = "Transferred";
        } else {
            transferredOrNot = "Not Transferred";
        }
        toString = String.format("%s\n%-30s%s", toString, "Status:", transferredOrNot);
        return toString;
    }

    public String getDuration() {
        return null;
    }
}


