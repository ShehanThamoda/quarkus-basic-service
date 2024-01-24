package org.acme.resteasy.dto;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import org.bson.types.ObjectId;

/**
 * @des entity for connection to mongo without using repository
 */
@MongoEntity(collection="usertwo")
public class User extends PanacheMongoEntity {

    private ObjectId id;
    private String name;
    private String nic;

    public static User findByName(String name){
        return find("name", name).firstResult();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }
}
