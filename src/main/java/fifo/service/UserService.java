package fifo.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;

import fifo.repository.UserRepository;
import fifo.entity.User;

@Service
public class UserService implements UserDetailsService {
  @Autowired
  private UserRepository userRepository;

  // メソッド名はオーバーライドのためusernameだが，userIdで認証する
  @Override
  public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
    if (userId == null || "".equals(userId)) {
      throw new UsernameNotFoundException("Username is empty");
    }

    User user = userRepository.findByUserId(userId);
    if (user == null) {
      throw new UsernameNotFoundException("User not found for name: " + userId);
    }

    return user;
  }
}