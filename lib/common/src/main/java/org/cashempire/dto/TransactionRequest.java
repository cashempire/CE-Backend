package org.cashempire.dto;

import java.math.BigDecimal;

public class TransactionRequest {
    private BigDecimal betAmount;
    private BigDecimal winAmount;
    private String partnerName;
    private String type;
    private String isGameComplete;

    public TransactionRequest(BigDecimal betAmount, BigDecimal winAmount, String partnerName, String type, String isGameComplete) {
        this.betAmount = betAmount;
        this.winAmount = winAmount;
        this.partnerName = partnerName;
        this.type = type;
        this.isGameComplete = isGameComplete;
    }

    public BigDecimal getBetAmount() {
        return betAmount;
    }

    public void setBetAmount(BigDecimal betAmount) {
        this.betAmount = betAmount;
    }

    public BigDecimal getWinAmount() {
        return winAmount;
    }

    public void setWinAmount(BigDecimal winAmount) {
        this.winAmount = winAmount;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIsGameComplete() {
        return isGameComplete;
    }

    public void setIsGameComplete(String isGameComplete) {
        this.isGameComplete = isGameComplete;
    }
}
