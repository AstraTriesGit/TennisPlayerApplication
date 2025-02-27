//package com.example.demo;
//
//import jakarta.persistence.*;
//
//import java.sql.Date;
//
//@Entity
//@Table(name = "Player")
//@NamedQuery(name = "get_all_players", query = "select p from PlayerRestModel p")
//public class Player {
//    @Id
//    @GeneratedValue
//    private int id;
//    private String name;
////    @Column(name = "nationality")
//    private String nationality;
//    private Date birthDate;
//    private int titles;
//
//    public Player() {
//
//    }
//
//    public Player(String name, String nationality, Date birthDate, int titles) {
//        super();
//        this.name = name;
//        this.nationality = nationality;
//        this.birthDate = birthDate;
//        this.titles = titles;
//    }
//
//    public Player(int id, String name, String nationality, Date birthDate, int titles) {
//        this.id = id;
//        this.name = name;
//        this.nationality = nationality;
//        this.birthDate = birthDate;
//        this.titles = titles;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getNationality() {
//        return nationality;
//    }
//
//    public void setNationality(String nationality) {
//        this.nationality = nationality;
//    }
//
//    public Date getBirthDate() {
//        return birthDate;
//    }
//
//    public void setBirthDate(Date birthDate) {
//        this.birthDate = birthDate;
//    }
//
//    public int getTitles() {
//        return titles;
//    }
//
//    public void setTitles(int titles) {
//        this.titles = titles;
//    }
//
//    @Override
//    public String toString() {
//        return "Player{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", nationality='" + nationality + '\'' +
//                ", birthDate=" + birthDate +
//                ", titles=" + titles +
//                '}';
//    }
//}

package com.example.demo;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String nationality;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date birthDate;

    private int titles;

    public Player() {

    }
    public Player(String name, String nationality, Date birthDate, int titles) {
        this.name = name;
        this.nationality = nationality;
        this.birthDate = birthDate;
        this.titles = titles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getTitles() {
        return titles;
    }

    public void setTitles(int titles) {
        this.titles = titles;
    }
}
