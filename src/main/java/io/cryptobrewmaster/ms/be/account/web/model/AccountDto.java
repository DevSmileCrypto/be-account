package io.cryptobrewmaster.ms.be.account.web.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.cryptobrewmaster.ms.be.account.db.model.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountDto {
    @NotBlank
    private String accountId;
    @NotBlank
    private String publicAccountId;
    @NotBlank
    private String nickname;
    @NotBlank
    private String wallet;

    public static AccountDto of(Account account) {
        return new AccountDto(
                account.getAccountId(), account.getPublicAccountId(), account.getNickname(), account.getWallet()
        );
    }
}
