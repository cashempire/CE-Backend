package org.cashempire.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserDetails {
    private String playerName;
    private String displayName;
    private long partnerId;
    private String gameName;
    private String partnerName;
    private long level1;
    private long level2;
    private long level3;
    private long level4;
    private long level5;
    private String deviceType;
    private String level1Name;
    private String level2Name;
    private String level3Name;
    private String level4Name;
    private String level5Name;
}

