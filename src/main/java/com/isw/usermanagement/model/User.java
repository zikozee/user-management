package com.isw.usermanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

/**
 * @author : Ezekiel Eromosei
 * @created : 06 April 2022
 */

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, updatable = false)
    private String applicationId;
    private String firstName;
    private String lastName;
    private String address;
    private int age;
    private int height;
    private String maritalStatus;

    @JsonIgnore
    private boolean deleted;

}
