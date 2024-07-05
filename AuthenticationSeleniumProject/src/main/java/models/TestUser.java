package models;

import com.mailslurp.models.InboxDto;
import lombok.Data;

@Data
public class TestUser {

    private int id;
    private String username;
    private String email;
    private String phone;
    private String password;
    private String status;

    private InboxDto userInbox;
    private TwoFA twoFA;
}
