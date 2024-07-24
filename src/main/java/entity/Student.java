package entity;

import base.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity(name = Student.TABLE_NAME)
@PrimaryKeyJoinColumn(name = BaseEntity.ID)

public class Student extends Person {
    public static final String TABLE_NAME = "student";
    public static final String STUDENT_CODE = "student_code";
    public static final String FIELD_OF_STUDY = "field_of_study";
    public static final String ENTERING_YEAR = "entering_year";

    @Column(name = STUDENT_CODE)
    String studentCode;

    @Column(name = FIELD_OF_STUDY)
    String fieldOfStudy;

    @Column(name = ENTERING_YEAR)
    int enteringYear;
}
