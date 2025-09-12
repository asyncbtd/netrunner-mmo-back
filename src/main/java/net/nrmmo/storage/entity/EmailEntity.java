package net.nrmmo.storage.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import static net.nrmmo.config.Constants.Db.NRMMO_SCHEMA;

@Value
@Table(name = "emails", schema = NRMMO_SCHEMA)
@Entity
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class EmailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "email_id", nullable = false)
    Long id;

    @ColumnDefault("0")
    @Column(name = "email_version", nullable = false)
    Integer version;

    @Size(max = 254)
    @Column(name = "email_address", nullable = false, length = 254)
    String address;

    @ColumnDefault("false")
    @Column(name = "email_active", nullable = false)
    Boolean active;
}
