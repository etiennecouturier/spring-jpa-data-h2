package com.etienne.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tbl_book")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="my_seq")
    @SequenceGenerator(
            name="my_seq",
            sequenceName="my_seq",
            allocationSize=20
    )
    private Long id;
    private String name;
    private Double price;

    public Book() {
    }

    public Book(String name, Double price) {
        this.name = name;
        this.price = price;
    }

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
