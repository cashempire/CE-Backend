package org.cashempire.module;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MiniGames {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long gameId;
    private String gameName;
    private String Title;
    private String guid;
    private String Description;
    private String refCode;
    private String category;
    private long categoryId;
    private String clientUrl;
    private String serverUrl;
    private String providerId;
    private String payout;
    private String maxWinAmount;
    private String ProviderName;
    private String deviceType;
    private boolean status;
    private String createdOn;
    private String updateOn;
}
