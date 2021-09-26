package models;

public class Departments {
    private String departmentName;
    private int staffNumber;
    private int id;

    public Departments(String departmentName, int staffNumber){
        this.departmentName = departmentName;
        this.staffNumber = staffNumber;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getStaffNumber() {
        return staffNumber;
    }

    public void setStaffNumber(int staffNumber) {
        this.staffNumber = staffNumber;
    }
}
