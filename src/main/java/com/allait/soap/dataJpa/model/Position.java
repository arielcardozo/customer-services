package com.allait.soap.dataJpa.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "position")
public class Position implements Serializable {

    @Id
    private long id;
    @Column(name = "name")
    @Getter @Setter private String name;

//    @OneToMany(mappedBy = "position")
//    private List<Employee> employees;

    public Position(long id, String name) {
        this.id = id;
        this.name = name;
    }



//    public List<Employee> getEmployees() {
//        return employees;
//    }
//
//    public void setEmployees(List<Employee> employees) {
//        this.employees = employees;
//    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position = (Position) o;
        return id == position.id &&
                Objects.equals(name, position.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }*/
}
