package pro.aloginov.revoluttest.protocol;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountCreationResponse {

    @JsonProperty("account_id")
    public final Integer id;

    public AccountCreationResponse(Integer id) {
        this.id = id;
    }
}
