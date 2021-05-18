package io.cryptobrewmaster.ms.be.account.web.controller;

import io.cryptobrewmaster.ms.be.account.service.AccountService;
import io.cryptobrewmaster.ms.be.account.web.model.AccountDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/account")
@RestController
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/create/or/get/{wallet}")
    public AccountDto createOrGet(@Valid @NotNull @PathVariable String wallet) {
        log.info("Request to create or get account by wallet received. Wallet = {}", wallet);
        var accountDto = accountService.createOrGet(wallet);
        log.info("Response on create or get account by wallet. {}", accountDto);
        return accountDto;
    }

    @PutMapping("/initialize/{accountId}")
    public AccountDto initialize(@Valid @NotNull @PathVariable String accountId) {
        log.info("Request to initialize account by wallet received. Account id = {}", accountId);
        var accountDto = accountService.initialize(accountId);
        log.info("Response on initialize account by wallet. {}", accountDto);
        return accountDto;
    }

}
