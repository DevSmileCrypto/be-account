package io.cryptobrewmaster.ms.be.account.db.repository;

import io.cryptobrewmaster.ms.be.account.db.model.Account;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface AccountRepository extends ReactiveMongoRepository<Account, String> {
    Mono<Account> findByWallet(String wallet);

}
