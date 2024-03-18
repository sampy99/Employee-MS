
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


}
