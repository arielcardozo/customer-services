package com.allait.soap.dataJpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "departments")
public class Departments {

    @Id
    @Column(name="deptNo",columnDefinition="char(4)")
    private char primary;

    @Column(name = "deptName")
    @Size(min = 4, max = 40)
    private String depName;

    public long getPrimary() {
        return primary;
    }

    public void setPrimary(char primary) {
        this.primary = primary;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public Departments() {
    }

    public Departments(char primary, @Size(min = 4, max = 40) String depName) {
        this.primary = primary;
        this.depName = depName;
    }

    @Override
    public String toString() {
        return "Departments{" +
                "primary=" + primary +
                ", depName='" + depName + '\'' +
                '}';
    }
}
