package models;

import java.util.Objects;

public class Departments {
    private String departmentName;
    private int staffNumber;
    private int id;

    public Departments(String departmentName, int staffNumber) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Departments)) return false;
        Departments dept = (Departments) o;
        return id == dept.id &&
                Objects.equals(departmentName, dept.departmentName) &&
                Objects.equals(staffNumber, dept.staffNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentName, staffNumber, id);
    }
}
