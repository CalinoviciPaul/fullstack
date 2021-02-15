/*
 * Copyright (c) 2014 Irian Software Development SRL. All Rights Reserved.
 * This software is the proprietary information of Irian Software Development SRL.
 * Use is subject to license and non-disclosure terms
 */

package ro.irian.fullstack.pizza.domain;


import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

/**
 * @author Georgia Papp
 */
@MappedSuperclass
public class BaseEntity {

    @Id
    @Column(name = "id", length = 32)
    private String _id;

    @Version
    @Column(name = "version", nullable = false)
    private Long version;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false)
    private Date createdAt;


    public String get_id() {
        if (_id == null) {
            _id = createUUID();
        }
        return _id;
    }

    public void set_id(String uuid) {
        this._id = uuid;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Transient
    public boolean isTransient() {
        //TODO
        return this._id == null;
    }

    @PrePersist
    public void prePersist() {
        if (_id == null) {
            _id = createUUID();
        }

        createdAt = new Date();
    }

    protected String createUUID() {
        return UUID.randomUUID().toString().replaceAll("-", ""); // replace "-" 36 -> 32 char
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseEntity)) return false;
        BaseEntity that = (BaseEntity) o;
        return get_id().equals(that.get_id());
    }

    @Override
    public int hashCode() {
        return Objects.hash(get_id());
    }
}
