package org.cashempire.module;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long playerId;
    private String playerName;
    private String displayName;
    private String uuid;
    private long partnerId;
    private String sessionKey;
    private String partnerName;
    private String currency;
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
    private boolean status;
    private Instant createdOn;
    private Instant updatedOn;

    public Player(String playerName, String uuid, long partnerId, String sessionKey, String partnerName, String currency, long level1, long level2, long level3, long level4, long level5, String level1Name, String level2Name, String level3Name, String level4Name, String level5Name, boolean status, Instant createdOn, Instant updatedOn) {
        this.playerName = playerName;
        this.uuid = uuid;
        this.partnerId = partnerId;
        this.sessionKey = sessionKey;
        this.partnerName = partnerName;
        this.currency = currency;
        this.level1 = level1;
        this.level2 = level2;
        this.level3 = level3;
        this.level4 = level4;
        this.level5 = level5;
        this.level1Name = level1Name;
        this.level2Name = level2Name;
        this.level3Name = level3Name;
        this.level4Name = level4Name;
        this.level5Name = level5Name;
        this.status = status;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
    }
}
