import entity.Student;
import entity.Teacher;
import util.ApplicationContext;

public class JpaApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = ApplicationContext.getInstance();

        System.out.println("-----------------------------teacher----------------------------------------------");
        System.out.println("-------save teacher1-------");
        Teacher teacher1 = new Teacher();
        teacher1.setFirstName("Amir");
        teacher1.setLastName("Hashemi");
        applicationContext.getTeacherService().save(teacher1);

        System.out.println("-------save teacher2-------");
        Teacher teacher2 = new Teacher();
        teacher2.setFirstName("zohre");
        teacher2.setLastName("Mohammadi");
        teacher2.setSalary(40000000L);
        applicationContext.getTeacherService().save(teacher2);

        System.out.println("-------save teacher3-------");
      /*  Teacher teacher3 = new Teacher();
        teacher3.setLastName("ghanbari");
        teacher3.setSalary(1000000l);
        teacher3.setDegree(Degree.DOCTOR);
        applicationContext.getTeacherService().save(teacher3);*/
        System.out.println("-------save teacher null -------");

        //applicationContext.getTeacherService().save(null);



        System.out.println("-----------------find teacher---------------------");
        Teacher teacher4 = new Teacher();
        teacher4.setFirstName("Amir");
        teacher4.setLastName("Hashemi");
        System.out.println(applicationContext.getTeacherService().find(teacher4));
        System.out.println("----------------update teacher----------------");

        if (applicationContext.getTeacherService().find(teacher4) != null) {
            teacher4.setFirstName("ahmad");
            teacher4.setSalary(2000000000l);
            applicationContext.getTeacherService().update(teacher4);
        }
        System.out.println("----");
        Teacher teacher123 = new Teacher();
        teacher123.setFirstName("Amir");
        teacher123.setLastName("Hashemi");
        if (applicationContext.getTeacherService().find(teacher123) != null) {
            teacher123.setFirstName("ahmad");
            teacher123.setSalary(2000000000l);
            applicationContext.getTeacherService().update(teacher123);
        }


        System.out.println("---------delete teacher-----------");
        Teacher teacher5 = new Teacher();
        teacher5.setFirstName("ahmad");
        teacher5.setLastName("Hashemi");

        applicationContext.getTeacherService().delete(teacher5);

        System.out.println("--------findAL---------");
        try {
            applicationContext.getTeacherService().findAll("Teacher").forEach(System.out::println);
            applicationContext.getTeacherService().findAll("Teacherrf").forEach(System.out::println);
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println("enter the correct table name:!! ");
        }


        System.out.println("--------contains---------");
        System.out.println(applicationContext.getTeacherService().contains(22l));

        System.out.println("---------------------------Student----------------------------------------------");

        System.out.println("-------save Student1-------");
        Student student1 = new Student();
        student1.setFirstName("mina");
        student1.setLastName("karimi");
        applicationContext.getStudentService().save(student1);

        System.out.println("-------save student2-------");
        Student student2 = new Student();
        student2.setFirstName("sara");
        student2.setLastName("kabiri");
        student2.setStudentCode("234567");
        applicationContext.getStudentService().save(student2);

        System.out.println("-------save student null -------");

        //applicationContext.getStudentService().save(null);


        System.out.println("-----------------find Student---------------------");
        Student student3 = new Student();
        student3.setFirstName("sara");
        student3.setLastName("kabiri");
        System.out.println(applicationContext.getStudentService().find(student3));
        System.out.println("----------------update teacher----------------");
        applicationContext.getStudentService().find(student3);
        student3.setFirstName("sara");
        student3.setStudentCode("22664455");
        applicationContext.getStudentService().update(student3);


        System.out.println("---------delete Student-----------");
        Student student4 = new Student();
        student4.setFirstName("sara");
        student4.setLastName("kabiri");

        applicationContext.getStudentService().delete(student4);
        applicationContext.getStudentService().delete(student4);



        System.out.println("--------findAL Students---------");
        try {
            applicationContext.getStudentService().findAll("Student").forEach(System.out::println);
            applicationContext.getStudentService().findAll("").forEach(System.out::println);
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println("enter the correct table name:!! ");
        }

    }

}


