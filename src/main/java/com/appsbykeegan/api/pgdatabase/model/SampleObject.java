package com.appsbykeegan.api.pgdatabase.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "sample_table")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SampleObject {

    @SequenceGenerator(
            name = "sample_sequence",
            sequenceName = "sample_sequence",
            allocationSize = 1
    )


    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sample_sequence"
    )
    private int id;
    private String email;
    private long phoneNumber;
    private String country;
}
