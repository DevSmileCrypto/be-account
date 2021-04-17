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

    @Field(UID_FIELD)
    @Indexed(unique = true)
    private String uid;
    private static final String UID_FIELD = "uid";

    @Field(PUBLIC_UID_FIELD)
    private String publicUid;
    private static final String PUBLIC_UID_FIELD = "publicUid";

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
        var uid = UidGenerator.generate(utcClock);
        var publicUid = UidGenerator.generate(utcClock, uid);
        return new Account(null, uid, publicUid, "@" + wallet, wallet, now, now);
    }

}
