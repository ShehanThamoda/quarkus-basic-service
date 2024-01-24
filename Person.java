package org.acme.resteasy.dto;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import javax.persistence.*;

/**
 * @des: entity for connect mysql without using repository
 */
@Entity
@Table(name = "person_tbl")
public class Person extends PanacheEntity {

    private Long id;
    private String name;
    private int age;
    private String town;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
