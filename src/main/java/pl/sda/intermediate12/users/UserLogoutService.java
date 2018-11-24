package pl.sda.intermediate12.users;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UserLogoutService {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private UserContextHolder userContextHolder;

    public boolean checkIfUserCanBeLoggedOut() {
        return userContextHolder.getUserLoggedIn() != null;
    }
}
