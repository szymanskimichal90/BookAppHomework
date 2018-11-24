package pl.sda.intermediate12.users;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UserLoginService {
    @Autowired
    private UserDAO userDAO;

    public boolean checkIfUserCanBeLogged(UserLoginDTO userLoginDTO) {
        boolean loggedIn = userDAO.getUserList().stream()
                .filter(u -> u.getEMail().equals(userLoginDTO.getLogin()))
                .findFirst()
                .map(u -> u.getPasswordHash().equals(DigestUtils.sha512Hex(userLoginDTO.getPassword())))
                .orElse(false);
        return loggedIn;
    }
}
