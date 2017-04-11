package fifo.repository;

import org.springframework.data.repository.CrudRepository;

import fifo.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
  public User findByUserId(String userId);
}