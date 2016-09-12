package hello.business.repository;

import hello.business.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by lenovo on 2016/7/14.
 */
public interface UserRepository  extends CrudRepository<User, Long> {
    User  findById(Long id);
}
