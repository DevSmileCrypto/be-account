package io.cryptobrewmaster.ms.be.account.db.repository;

import io.cryptobrewmaster.ms.be.account.db.model.Account;
import io.cryptobrewmaster.ms.be.library.exception.ParametersAbsentOrInvalidException;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AccountRepository extends MongoRepository<Account, String> {

    Optional<Account> findByAccountId(String accountId);

    default Account getByAccountId(String accountId) {
        return findByAccountId(accountId)
                .orElseThrow(() -> new ParametersAbsentOrInvalidException(
                        String.format("Account with id = %s not exists in system", accountId)
                ));
    }

    Optional<Account> findByWallet(String wallet);

    default Account getByWallet(String wallet) {
        return findByWallet(wallet)
                .orElseThrow(() -> new ParametersAbsentOrInvalidException(
                        String.format("Account with wallet = %s not exists in system", wallet)
                ));
    }

}
