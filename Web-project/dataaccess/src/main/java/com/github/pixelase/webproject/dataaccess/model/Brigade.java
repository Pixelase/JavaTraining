package com.github.pixelase.webproject.dataaccess.model;
// Generated 02.12.2015 21:41:29 by Hibernate Tools 4.3.1.Final

import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Brigade generated by hbm2java
 */
@Entity
@Table(name = "brigade")
public class Brigade implements Persistable<Integer> {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private WorkRequest workRequest;
    private Date realDate;
    private Set<Employee> employees = new HashSet<Employee>(0);

    public Brigade() {
        super();
    }

    public Brigade(Integer id) {
        super();
        this.id = id;
    }

    public Brigade(WorkRequest workRequest, Date realDate) {
        super();
        this.workRequest = workRequest;
        this.realDate = realDate;
    }

    public Brigade(Integer id, WorkRequest workRequest, Date realDate) {
        super();
        this.id = id;
        this.workRequest = workRequest;
        this.realDate = realDate;
    }

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "work_request_id", nullable = false)
    public WorkRequest getWorkRequest() {
        return this.workRequest;
    }

    public void setWorkRequest(WorkRequest workRequest) {
        this.workRequest = workRequest;
        if (workRequest.getBrigade() != this) {
            workRequest.setBrigade(this);
        }
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "real_date", length = 13)
    public Date getRealDate() {
        return this.realDate;
    }

    public void setRealDate(Date realDate) {
        this.realDate = realDate;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "brigade_member", joinColumns = {
            @JoinColumn(name = "brigade_id", nullable = false, updatable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "employee_id", nullable = false, updatable = false)})
    public Set<Employee> getEmployees() {
        return this.employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
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
        if (!(obj instanceof Brigade))
            return false;
        Brigade other = (Brigade) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Brigade [id=" + id + ", workRequest=" + workRequest + ", realDate=" + realDate + ", employees="
                + employees + "]";
    }

    @Override
    @Transient
    public boolean isNew() {
        return id == null;
    }

}
