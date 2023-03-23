package com.emplyeemanagement.employeeManagment.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity(name = "attendence")
public class Attendence {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long AttendenceId;
    @Column(name = "date")
    @CreationTimestamp
    private Date day;
    @Column(name = "Present")
    private boolean isPresent;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @ManyToOne()
    @JoinColumn(name = "employee_id")
    @JsonIgnore
    Employee employee;

    public Attendence(long attendenceId, long attendenceId1, Date day, boolean isPresent) {
        AttendenceId = attendenceId;
        this.day = day;
        this.isPresent = isPresent;
    }


     public Attendence()
     {

     }

    public long getAttendenceId() {
        return AttendenceId;
    }

    public void setAttendenceId(long attendenceId) {
        AttendenceId = attendenceId;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public void setPresent(boolean present) {
        isPresent = present;
    }

    @Override
    public String toString() {
        return "Attendence{" +
                "AttendenceId=" + AttendenceId +
                ", day=" + day +
                ", isPresent=" + isPresent +
                '}';
    }
}
