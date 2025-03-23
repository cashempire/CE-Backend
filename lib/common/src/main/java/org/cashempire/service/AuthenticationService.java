package org.cashempire.service;

import org.cashempire.dto.UserDetails;
import org.cashempire.exception.AuthException;
import org.cashempire.module.*;
import org.cashempire.repository.*;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthenticationService {
    public PartnerRepository partnerRepository;
    public GameRevenueShareRepository gameRevenueShareRepository;
    public MiniGamesRepository miniGamesRepository;
    public ClientLaunchRepository clientLaunchRepository;
    public PlayerReposiory playerReposiory;

    public UserDetails authentication(String token) throws AuthException {
        Player player;
        ClientLaunch clientLaunch = clientLaunchRepository.findById(token).orElseThrow(() -> new AuthException(""));
        Partner partner = partnerRepository.findById(clientLaunch.getPartnerId()).orElseThrow(()->new AuthException(""));
        MiniGames miniGames = miniGamesRepository.findById(clientLaunch.getGameId()).orElseThrow(()->new AuthException(""));
        GameRevenueShare gameRevenueShare = gameRevenueShareRepository.findById(clientLaunch.getRevenuId()).orElseThrow(()->new AuthException(""));
        Optional<Player>  optionalPlayer= playerReposiory.findByPlayerName(clientLaunch.getPlayerName());
        if(optionalPlayer.isPresent()){
            player = optionalPlayer.get();
            player.setSessionKey(clientLaunch.getSessionkey());
        }else{
            player = new Player(clientLaunch.getPlayerName(), UUID.randomUUID().toString(), partner.getPartnerId(), clientLaunch.getSessionkey(), partner.getPartnerName(), clientLaunch.getCurrency(), partner.getLevel1(), partner.getLevel2(), partner.getLevel3(), partner.getLevel4(), partner.getLevel5(), partner.getLevel1Name(), partner.getLevel2Name(), partner.getLevel3Name(), partner.getLevel4Name(), partner.getLevel5Name(), true, Instant.now(), Instant.now());
        }
        playerReposiory.save(player);
        return getUserDetails(clientLaunch, partner, miniGames);
    }

    private static UserDetails getUserDetails(ClientLaunch clientLaunch, Partner partner, MiniGames miniGames) {
        return UserDetails.builder()
                .playerName(clientLaunch.getPlayerName())
                .displayName(clientLaunch.getDisplayName())
                .partnerId(partner.getPartnerId())
                .gameName(miniGames.getGameName())
                .partnerName(partner.getPartnerName())
                .level1(partner.getLevel1())
                .level2(partner.getLevel2())
                .level3(partner.getLevel3())
                .level4(partner.getLevel4())
                .level5(partner.getLevel5())
                .level1Name(partner.getLevel1Name())
                .level2Name(partner.getLevel2Name())
                .level3Name(partner.getLevel3Name())
                .level4Name(partner.getLevel4Name())
                .level5Name(partner.getLevel5Name())
                .deviceType(clientLaunch.getDeviceType())
                .build();
    }
}
