package io.cryptobrewmaster.ms.be.account.db.model;

import io.cryptobrewmaster.ms.be.account.util.UidGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.Clock;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = Account.COLLECTION_NAME)
public class Account {

    public static final String COLLECTION_NAME = "account";

    @Id
    @Field(ID_FIELD)
    private ObjectId id;
    private static final String ID_FIELD = "_id";

    @Field(ACCOUNT_ID_FIELD)
    @Indexed(unique = true)
    private String accountId;
    private static final String ACCOUNT_ID_FIELD = "accountId";

    @Field(PUBLIC_ACCOUNT_ID_FIELD)
    private String publicAccountId;
    private static final String PUBLIC_ACCOUNT_ID_FIELD = "publicAccountId";

    @Field(NICKNAME_FIELD)
    private String nickname;
    private static final String NICKNAME_FIELD = "nickname";

    @Field(WALLET_FIELD)
    @Indexed(unique = true)
    private String wallet;
    private static final String WALLET_FIELD = "wallet";

    @Field(CREATED_DATE_FIELD)
    private Long createdDate;
    private static final String CREATED_DATE_FIELD = "createdDate";

    @Field(LAST_MODIFIED_DATE_FIELD)
    private Long lastModifiedDate;
    private static final String LAST_MODIFIED_DATE_FIELD = "lastModifiedDate";

    public static Account of(String wallet, Clock utcClock) {
        long now = utcClock.millis();
        var accountId = UidGenerator.generate(utcClock);
        var publicAccountId = UidGenerator.generate(utcClock, accountId);
        return new Account(null, accountId, publicAccountId, "@" + wallet, wallet, now, now);
    }

}
