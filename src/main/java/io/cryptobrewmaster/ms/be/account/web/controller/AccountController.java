package io.cryptobrewmaster.ms.be.account.web.controller;

import io.cryptobrewmaster.ms.be.account.service.AccountService;
import io.cryptobrewmaster.ms.be.account.web.model.AccountDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/account")
@RestController
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/create/or/get/{wallet}")
    public Mono<AccountDto> createOrGet(@Valid @NotNull @PathVariable String wallet) {
        return accountService.createOrGet(wallet);
    }

}
