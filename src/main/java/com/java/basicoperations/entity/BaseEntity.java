package com.java.basicoperations.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@EqualsAndHashCode
public abstract class BaseEntity {

    @Id
    @GeneratedValue
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    protected Integer id;

    @CreatedDate
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    protected LocalDateTime createdDate;

    @LastModifiedDate
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    protected LocalDateTime updatedDate;

    @Version
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    protected Long version;
}


