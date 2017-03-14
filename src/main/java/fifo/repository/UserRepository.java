package fifo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fifo.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByName(String name);
}