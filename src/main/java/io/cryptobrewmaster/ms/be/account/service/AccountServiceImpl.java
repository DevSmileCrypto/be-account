package io.cryptobrewmaster.ms.be.account.service;

import io.cryptobrewmaster.ms.be.account.db.model.Account;
import io.cryptobrewmaster.ms.be.account.db.repository.AccountRepository;
import io.cryptobrewmaster.ms.be.account.web.model.AccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.Clock;

@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    private final Clock utcClock;

    @Override
    public Mono<AccountDto> createOrGet(String wallet) {
        return accountRepository.findByWallet(wallet)
                .switchIfEmpty(Mono.defer(() -> {
                    var account = Account.of(wallet, utcClock);
                    return accountRepository.save(account);
                }))
                .map(AccountDto::of);
    }

    @Override
    public Mono<AccountDto> initialize(String accountId) {
        return accountRepository.findById(accountId)
                .flatMap(account -> {
                    account.setInitialized(true);
                    return accountRepository.save(account);
                })
                .map(AccountDto::of);
    }

}
