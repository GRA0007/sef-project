package model;

public class Transfer extends AbstractStructure {

    private String programName;
    private String programCode;
    private Date startDate;
    private Date endDate;
    private String transferredOrNot = "";
    private boolean isTransferred = true;


    public Transfer(String programName, String programCode, Date startDate, boolean isTransferred, Date endDate) {
        this.programName = programName;
        this.programCode = programCode;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isTransferred= isTransferred;


    }

    @Override

    public String getProgramName() {
        return this.programName;
    }

    public String getProgramCode() {
        return this.programCode;
    }

    public Date getDate() {
        return this.startDate;
    }

    public boolean isTransferred(){
        return this.isTransferred;
    }


    public void toString() {
        String toString = "";

        toString = String.format("%s\n%-30s%s", toString, "Program Name:", this.programName);
        toString = String.format("%s\n%-30s%s", toString, "Program Code:", this.programCode);
        toString = String.format("%s\n%-30s%s", toString, "Date:", this.date.toString());


        if (isTransferred) {
            transferredOrNot = "Transferred";
        } else {
            transferredOrNot = "Not Transferred";
        }
        toString = String.format("%s\n%-30s%s", toString, "Status:", this.transferredOrNot);

    }
}


