package com.be.be_app.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // cái này đê chung 1 bảng tự tăng id r, nên nó tằng cả trong tất cả bảng
    @Column(insertable = false, updatable = false, nullable = false)
    private Long id;
    private String firstName;
    private String lastName;

    // Bao ve, lao cong, nhan vien ki thuat,....
    private String position;
    private String email;

    @ManyToOne
    @JoinColumn(
            name = "building_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "building_employee_fk"
            )
    )
    private Building building;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Employee employee = (Employee) o;
        return id != null && Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
