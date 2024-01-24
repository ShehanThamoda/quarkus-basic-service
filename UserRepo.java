package org.acme.resteasy.repository;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import org.acme.resteasy.dto.User;
import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class UserRepo implements PanacheMongoRepository<User> {

    public List<User> findAllByName(String name){
        return list("name",name);
    }
}
