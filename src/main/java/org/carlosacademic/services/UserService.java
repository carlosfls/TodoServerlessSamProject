package org.carlosacademic.services;

import com.amazonaws.services.lambda.runtime.LambdaLogger;
import org.carlosacademic.dtos.UserDTO;
import org.carlosacademic.exeptions.InvalidMessageException;
import org.carlosacademic.mappers.UserMapper;
import org.carlosacademic.repositories.UserRepository;
import org.carlosacademic.tables.DUser;


public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    public void register(UserDTO user, LambdaLogger logger) {
        if (user != null){
            DUser dUser = UserMapper.toDUser(user);
            userRepository.saveIfNotExist(dUser, logger);
            return;
        }
        throw new InvalidMessageException("UserDTO is null");
    }
}
