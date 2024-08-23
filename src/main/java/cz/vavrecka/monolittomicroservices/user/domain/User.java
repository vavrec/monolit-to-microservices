package cz.vavrecka.monolittomicroservices.user.domain;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("dms_user")
public record User(@Column("user_id") Long id, String firstName, String lastName, String email) {
}
