package io.cryptobrewmaster.ms.be.account.db.model;

import io.cryptobrewmaster.ms.be.account.util.UidGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    private String id;
    private static final String ID_FIELD = "_id";

    @Field(PUBLIC_ID_FIELD)
    private String publicId;
    private static final String PUBLIC_ID_FIELD = "publicId";

    @Field(NICKNAME_FIELD)
    private String nickname;
    private static final String NICKNAME_FIELD = "nickname";

    @Field(WALLET_FIELD)
    @Indexed(unique = true)
    private String wallet;
    private static final String WALLET_FIELD = "wallet";

    @Field(INITIALIZED_FIELD)
    private boolean initialized;
    private static final String INITIALIZED_FIELD = "initialized";

    @Field(CREATED_DATE_FIELD)
    private Long createdDate;
    private static final String CREATED_DATE_FIELD = "createdDate";

    @Field(LAST_MODIFIED_DATE_FIELD)
    private Long lastModifiedDate;
    private static final String LAST_MODIFIED_DATE_FIELD = "lastModifiedDate";

    public static Account of(String wallet, Clock utcClock) {
        long now = utcClock.millis();
        var id = UidGenerator.generate(utcClock);
        var publicId = UidGenerator.generate(utcClock, id);
        return new Account(id, publicId, "@" + wallet, wallet, true, now, now);
    }

}
