package entity;


import base.domain.BaseEntity;
import enumaration.Degree;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity(name = Teacher.TABLE_NAME)
@PrimaryKeyJoinColumn(name = BaseEntity.ID)

public class Teacher extends Person {
    public static final String TABLE_NAME = "teacher";
    public static final String TEACHER_CODE = "teacher_code";
    public static final String DEGREE = "degree";
    public static final String SALARY = "salary";

    @Column(name = TEACHER_CODE)
    String teacherCode;

    @Column(name = DEGREE)
    @Enumerated(EnumType.STRING)
    Degree degree;

    @Column(name = SALARY)
    double salary;

    @Override
    public String toString() {
        return "Teacher{" +
                "id= "+getId()+
                ", FirstName= "+super.getFirstName()+
                ", LastNam= "+super.getLastName()+
                ", BirthDate= "+super.getBirthDate()+
                ", teacherCode='" + teacherCode +
                ", degree=" + degree +
                ", salary=" + salary +
                "}";
    }
}
