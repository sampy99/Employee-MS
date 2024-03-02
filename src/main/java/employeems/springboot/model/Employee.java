
package employeems.springboot.model;

import jakarta.persistence.*;


@Entity
@Table(name = "employees")

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long emp_id;
    private String emp_name;
    private String emp_email;
    private String emp_city;
    private float emp_dob;

    public Employee(){

    }
    public Employee(String emp_name, String emp_email, String emp_city, float emp_dob) {
        super();
        this.emp_name = emp_name;
        this.emp_email = emp_email;
        this.emp_city = emp_city;
        this.emp_dob = emp_dob;
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

    public float getEmp_dob() {
        return emp_dob;
    }

    public void setEmp_dob(float emp_dob) {
        this.emp_dob = emp_dob;
    }
}
