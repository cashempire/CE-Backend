package org.cashempire.module;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.Instant;

@Data
@Document
public class ClientLaunch {
    @MongoId
    private String token;
    private String playerName;
    private String displayName;
    private String serverUrl;
    private String sessionkey;
    private String language;
    private String currency;
    private boolean isSound;
    private String deviceType;
    private boolean isBonusGame;
    private long gameId;
    private long partnerId;
    private long revenuId;
    private Instant expire;
    private Instant createdOn;
    private Instant updatedOn;

    public ClientLaunch(String playerName, String serverUrl, String sessionkey, String language, String currency, boolean isSound, boolean isBonusGame, long gameId, long partnerId, long revenuId, String expire) {
        this.playerName = playerName;
        this.serverUrl = serverUrl;
        this.sessionkey = sessionkey;
        this.language = language;
        this.currency = currency;
        this.isSound = isSound;
        this.isBonusGame = isBonusGame;
        this.gameId = gameId;
        this.partnerId = partnerId;
        this.revenuId = revenuId;
        this.expire = Instant.ofEpochSecond(Instant.now().getEpochSecond()+Long.parseLong(expire));
        this.createdOn = Instant.now();
        this.updatedOn = Instant.now();
    }
}
