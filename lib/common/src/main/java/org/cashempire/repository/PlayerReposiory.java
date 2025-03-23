package org.cashempire.repository;

import org.cashempire.module.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerReposiory extends JpaRepository<Player,Long> {

    Optional<Player> findByPlayerName(String playerName);
}
