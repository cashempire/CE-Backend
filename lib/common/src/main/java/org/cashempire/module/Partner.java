package org.cashempire.module;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Instant;
import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Partner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long partnerId;
    private String partnerName;
    private String userName;
    private String partnerkey;
    private String partnerIps;
    private String serviceUrl;
    private String password;
    private UUID guid;
    private boolean status;
    private long level1;
    private long level2;
    private long level3;
    private long level4;
    private long level5;
    private String level1Name;
    private String level2Name;
    private String level3Name;
    private String level4Name;
    private String level5Name;
    private Instant createdOn;
    private Instant updatedOn;
}
