package com.ezboot.system.admin.entity;

import com.ezboot.core.base.entity.UpdatedEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author wang
 */
@Data
@Entity
@Table(name = "t_system_admin")
@EqualsAndHashCode(callSuper = false)
public class Admin extends UpdatedEntity {

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "last_login_ip")
    private String lastLoginIp;

    @Column(name = "last_login_time")
    private Date lastLoginTime;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "enabled")
    private boolean enabled;

}
