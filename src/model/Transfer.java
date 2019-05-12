package model;

import java.util.Date;

public class Transfer extends AbstractCategory {

    private String fromProgram;
    private String toProgram;
    private Date startDate;
    private Date endDate;
    private boolean isTransferred;


    public Transfer(String fromProgram, String toProgram, Date startDate, boolean isTransferred, Date endDate) {
        this.fromProgram = fromProgram;
        this.toProgram = toProgram;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isTransferred= isTransferred;
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
        return this.isTransferred;
    }

    @Override
    public String toString() {
        String toString = "";

        toString = String.format("%s\n%-30s%s", toString, "Transferred from:", this.fromProgram);
        toString = String.format("%s\n%-30s%s", toString, "Transferred to:", this.toProgram);
        toString = String.format("%s\n%-30s%s", toString, "Date:", this.startDate.toString());


        String transferredOrNot = "";
        if (isTransferred) {
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


