package org.acme.resteasy.service;

import org.acme.resteasy.dto.Department;
import org.acme.resteasy.dto.Person;
import org.acme.resteasy.dto.User;
import org.acme.resteasy.repository.DepartmentRepo;
import org.acme.resteasy.repository.UserRepo;
import org.bson.types.ObjectId;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class UserService {

    @Inject
    DepartmentRepo departmentRepo;

    @Inject
    UserRepo userRepo;

    public void add(User user){
        user.persist();
        //userRepo.persist(user1);
        System.out.println("Insert Record Successfully!");
    }

    public List<User> getAllDetails(){
        User user = User.findByName("rosa");
        //List<User> users = User.list("name", "Shehan");        ;
        System.out.println(user.getName());
        return User.listAll();

    }

    public List<User> getAllUserDetailsUsingRepo(){
        ObjectId o = new ObjectId("6130912dd2610810fb5919a0");
        User user = userRepo.findById(o);
        System.out.println("-Pass the Object ID and get the result.name:"+user.getName());

        List<User> list = userRepo.findAllByName("Shehan");
        for (User u:list) {
            System.out.println("Name:"+u.getName());
        }
        return userRepo.listAll();

    }

    public User getUserById(String id){
        ObjectId userId = new ObjectId(id);
        User user = User.findById(userId);
        return user;
    }

    @Transactional
    public void addPerson(Person person){
        person.persist();
        System.out.println("Insert Person Record Successfully!");

        List<Person> personList = Person.list("name","Shehan");
        System.out.println("List size:"+personList.size());
        personList.stream()
                .map(p -> p.getName().toLowerCase())
                .forEach(System.out::println);

        long count = Person.count();
        System.out.println("Person count:"+count);
        long countByAge = Person.count("age",19);
        System.out.println("Person count age 19:"+countByAge);
    }

    @Transactional
    public void addDepartment(Department department){
        departmentRepo.persist(department);
        System.out.println("Insert Department Record Successfully!");

        long count = departmentRepo.count();
        System.out.println("Department count:"+count);
    }

    @Transactional
    public List<Department> getAllDepartment(){
        return departmentRepo.listAll();
    }


}
