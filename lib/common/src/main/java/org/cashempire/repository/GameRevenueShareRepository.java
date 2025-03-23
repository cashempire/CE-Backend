package org.cashempire.repository;

import org.cashempire.module.GameRevenueShare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GameRevenueShareRepository extends JpaRepository<GameRevenueShare,Long> {
    Optional<GameRevenueShare> findByGameIdAndPartnerId(String gameName, long partnerId);
}
