package org.qks.main.repository.hibernate.po;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class UserPo {
    @Id
    @GeneratedValue
    private Long id;

    private String username;
}
