package entity;

import base.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Builder

@Entity
@Table(name = Person.TABLE_NAME)

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Person extends BaseEntity<Long> {
    public static final String TABLE_NAME = "person";
    public static final String FIRSTNAME = "first_name";

    public static final String LASTNAME = "last_name";

    public static final String BIRTHDATE = "birthDate";

    @Column(name = FIRSTNAME)
    String firstName;

    @Column(name = LASTNAME)
    String lastName;

    @Column(name = BIRTHDATE)
    Date birthDate;
}
