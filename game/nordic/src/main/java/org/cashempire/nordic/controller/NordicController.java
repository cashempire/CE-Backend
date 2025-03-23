package org.cashempire.nordic.controller;

import org.cashempire.nordic.dto.BetResponse;
import org.cashempire.nordic.dto.InitResponse;
import org.cashempire.nordic.service.NordicService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.cashempire.nordic.util.Static.*;

@RestController
@RequestMapping(GAMEPATH)
public class NordicController {

    public NordicService nordicService;

    @PostMapping(INIT)
    public ResponseEntity<InitResponse> init(){
        InitResponse initResponse = null;
        return ResponseEntity.ok(initResponse);
    }

    @PostMapping(BET)
    public ResponseEntity<BetResponse> bet(){
        BetResponse betResponse = null;
        return ResponseEntity.ok(betResponse);
    }


}
