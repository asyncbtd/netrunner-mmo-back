package net.nrmmo.storage.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.hibernate.annotations.ColumnDefault;

import static net.nrmmo.config.Constants.Db.NRMMO_SCHEMA;

@Value
@Table(name = "users", schema = NRMMO_SCHEMA)
@Entity
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    Long id;

    @ColumnDefault("0")
    @Column(name = "user_version", nullable = false)
    Integer version;

    @Size(max = 255)
    @Column(name = "user_name", nullable = false)
    String username;

    @Size(max = 255)
    @Column(name = "user_password", nullable = false)
    String password;

    @ColumnDefault("0")
    @Column(name = "user_balance", nullable = false)
    Long balance;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "email_id", nullable = false)
    EmailEntity email;

    @ColumnDefault("false")
    @Column(name = "user_active", nullable = false)
    Boolean active;
}
