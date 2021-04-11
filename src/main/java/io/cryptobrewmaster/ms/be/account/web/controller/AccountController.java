package io.cryptobrewmaster.ms.be.account.web.controller;

import io.cryptobrewmaster.ms.be.account.service.AccountService;
import io.cryptobrewmaster.ms.be.account.web.model.AccountDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Slf4j
@Valid
@RequiredArgsConstructor
@RequestMapping("/api/account")
@RestController
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/create/or/get/{wallet}")
    public AccountDto createOrGet(@NotNull @PathVariable String wallet) {
        log.info("Request to create or get account by wallet received. {}", wallet);
        AccountDto accountDto = accountService.createOrGet(wallet);
        log.info("Response on create or get account by wallet. {}", accountDto);
        return accountDto;
    }

}
