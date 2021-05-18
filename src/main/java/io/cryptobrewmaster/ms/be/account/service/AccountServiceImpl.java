package io.cryptobrewmaster.ms.be.account.service;

import io.cryptobrewmaster.ms.be.account.db.model.Account;
import io.cryptobrewmaster.ms.be.account.db.repository.AccountRepository;
import io.cryptobrewmaster.ms.be.account.web.model.AccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    private final Clock utcClock;

    @Override
    public AccountDto createOrGet(String wallet) {
        Optional<Account> accountOptional = accountRepository.findByWallet(wallet);
        if (accountOptional.isEmpty()) {
            var account = Account.of(wallet, utcClock);
            account = accountRepository.save(account);
            return AccountDto.of(account);
        }
        return AccountDto.of(accountOptional.get());
    }

    @Override
    public AccountDto initialize(String accountId) {
        var account = accountRepository.getById(accountId);
        account.setInitialized(true);
        account = accountRepository.save(account);
        return AccountDto.of(account);
    }

}
