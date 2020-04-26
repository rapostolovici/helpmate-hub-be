package ro.euvsvirus.helpmatehub.be.model.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import ro.euvsvirus.helpmatehub.be.model.UserCategory;


@Schema(description = "The class which models a user")
@Table(name = "t_user")
@Entity
public class User extends PanacheEntity {
    
    @Column(name = "first_name")
    public String firstName;
    @Column(name="last_name")
    public String lastName;



    @Enumerated
    @Column(name = "user_category")
    private UserCategory userCategory;


    //TODO RAP: move to a base entity in the future
    //TODO RAP: create the sql migration script to add the columns to the user table


    @CreationTimestamp
    @Column(name = "creation_date")
    public LocalDateTime creationDate;

    @UpdateTimestamp
    @Column(name = "update_date")
    public LocalDateTime updatedDate;


}