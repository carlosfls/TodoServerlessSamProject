package org.carlosacademic.repositories;

import com.amazonaws.services.lambda.runtime.LambdaLogger;
import org.carlosacademic.tables.DUser;

public interface UserRepository {

    void saveIfNotExist(DUser user, LambdaLogger logger);
}
