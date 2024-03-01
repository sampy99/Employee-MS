package employeems.springboot.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "employees")

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long emp_id;
    @Column(name = "employee_name")
    private String emp_name;
    @Column(name = "employee_email")
    private String emp_email;
    @Column(name = "employee_city")
    private String emp_city;
    @Column(name = "employee_DOB")
    private float emp_bday;

    public Employee(){

    }
    public Employee(String emp_name, String emp_email, String emp_city, float emp_bday) {
        this.emp_name = emp_name;
        this.emp_email = emp_email;
        this.emp_city = emp_city;
        this.emp_bday = emp_bday;
    }

    public long getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(long emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getEmp_email() {
        return emp_email;
    }

    public void setEmp_email(String emp_email) {
        this.emp_email = emp_email;
    }

    public String getEmp_city() {
        return emp_city;
    }

    public void setEmp_city(String emp_city) {
        this.emp_city = emp_city;
    }

    public float getEmp_bday() {
        return emp_bday;
    }

    public void setEmp_bday(float emp_bday) {
        this.emp_bday = emp_bday;
    }
}
