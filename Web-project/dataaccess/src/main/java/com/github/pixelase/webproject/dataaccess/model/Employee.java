package com.github.pixelase.webproject.dataaccess.model;
// Generated 02.12.2015 21:41:29 by Hibernate Tools 4.3.1.Final

import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Employee generated by hbm2java
 */
@Entity
@Table(name = "employee")
public class Employee implements Persistable<Integer> {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private Account account;
    private WorkType workType;
    private Long salary;
    private Set<Brigade> brigades = new HashSet<>(0);

    public Employee() {
        super();
    }

    public Employee(Integer id) {
        super();
        this.id = id;
    }

    public Employee(Account account, WorkType workType, Long salary) {
        super();
        this.account = account;
        this.workType = workType;
        this.salary = salary;
    }

    public Employee(Integer id, Account account, WorkType workType, Long salary) {
        super();
        this.id = id;
        this.account = account;
        this.workType = workType;
        this.salary = salary;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_gen")
    @SequenceGenerator(name = "employee_gen", sequenceName = "employee_id_seq", allocationSize = 1)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "account_id", nullable = false)
    public Account getAccount() {
        return this.account;
    }

    public void setAccount(Account account) {
        this.account = account;
        if (account.getEmployee() != this) {
            account.setEmployee(this);
        }
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "work_type_id")
    public WorkType getWorkType() {
        return this.workType;
    }

    public void setWorkType(WorkType workType) {
        this.workType = workType;
        if (!workType.getEmployees().contains(this)) {
            workType.getEmployees().add(this);
        }
    }

    @Column(name = "salary")
    public Long getSalary() {
        return this.salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "brigade_member", schema = "public", joinColumns = {
            @JoinColumn(name = "employee_id", nullable = false, updatable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "brigade_id", nullable = false, updatable = false)})
    public Set<Brigade> getBrigades() {
        return this.brigades;
    }

    public void setBrigades(Set<Brigade> brigades) {
        this.brigades = brigades;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Employee))
            return false;
        Employee other = (Employee) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", account=" + account + ", workType=" + workType + ", salary=" + salary + "]";
    }

    @Override
    @Transient
    public boolean isNew() {
        return id == null;
    }

}
