package org.cashempire.repository;

import org.cashempire.module.MiniGames;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MiniGamesRepository extends JpaRepository<MiniGames,Long> {
    Optional<MiniGames> findByGuid(String gameId);
}
