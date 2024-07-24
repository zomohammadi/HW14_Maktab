package entity;

import base.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;


@Builder

@Entity
@Table(name = Person.TABLE_NAME,
        uniqueConstraints = @UniqueConstraint(columnNames = {Person.FIRSTNAME, Person.LASTNAME}))


@Inheritance(strategy = InheritanceType.JOINED)

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

    @Column(name = FIRSTNAME, nullable = false)
    String firstName;

    @Column(name = LASTNAME, nullable = false)
    String lastName;

    @Column(name = BIRTHDATE)
    LocalDate birthDate;

    @Override
    public String toString() {
        return "Person{" +
                "Id= " + super.getId() +
                ", firstName= " + firstName +
                ", lastName= " + lastName +
                ", birthDate= " + birthDate +
                "}";
    }
}
