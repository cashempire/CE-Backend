package org.cashempire.service;

import org.cashempire.dto.TransactionRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
public class TransactionService {

    public final RestTemplate restTemplate;
    public final HttpHeaders httpHeaders;
    @Value("${wallet.uri}")
    public String walletUri;

    public TransactionService(RestTemplate restTemplate, HttpHeaders httpHeaders) {
        this.restTemplate = restTemplate;
        this.httpHeaders = httpHeaders;
    }

    private HttpEntity<TransactionRequest> getEntity(TransactionRequest transactionRequest) {
        return new HttpEntity<>(transactionRequest, httpHeaders);
    }

    public ResponseEntity<BigDecimal> withDraw(TransactionRequest transactionRequest){
        return restTemplate.postForEntity(walletUri+"/withdraw",getEntity(transactionRequest), BigDecimal.class);
    }

    public ResponseEntity<BigDecimal> deposit(TransactionRequest transactionRequest){
        return restTemplate.postForEntity(walletUri+"/deposit",getEntity(transactionRequest), BigDecimal.class);
    }

    public ResponseEntity<BigDecimal> history(TransactionRequest transactionRequest){
        return restTemplate.postForEntity(walletUri+"/history",getEntity(transactionRequest), BigDecimal.class);
    }

}
