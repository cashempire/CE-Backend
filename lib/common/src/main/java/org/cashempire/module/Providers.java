package org.cashempire.module;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Providers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String providerId;
    private String providerName;
    private String providerOrder;
    private boolean status;
    private UUID guid;
    private String createdOn;
    private String updatedOn;
}
