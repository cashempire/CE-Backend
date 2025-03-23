package org.cashempire.module;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Instant;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class GameRevenueShare {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long revenuId;
    private long gameId;
    private long partnerId;
    private boolean status;
    private Instant createDate;
    private Instant updateDate;
}
