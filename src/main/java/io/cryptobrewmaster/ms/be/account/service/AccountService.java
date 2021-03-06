package io.cryptobrewmaster.ms.be.account.service;

import io.cryptobrewmaster.ms.be.account.web.model.AccountDto;

/**
 * The interface Account service.
 */
public interface AccountService {

    /**
     * Create or get account dto.
     *
     * @param wallet the wallet
     * @return the account dto
     */
    AccountDto createOrGet(String wallet);

    /**
     * Initialize account dto.
     *
     * @param accountId the account id
     * @return the account dto
     */
    AccountDto initialize(String accountId);

}
