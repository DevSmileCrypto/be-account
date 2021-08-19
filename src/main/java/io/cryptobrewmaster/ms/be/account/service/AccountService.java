package io.cryptobrewmaster.ms.be.account.service;

import io.cryptobrewmaster.ms.be.account.web.model.AccountDto;
import reactor.core.publisher.Mono;

public interface AccountService {

    Mono<AccountDto> createOrGet(String wallet);

}
