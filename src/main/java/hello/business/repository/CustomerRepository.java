package hello.business.repository;

import java.util.List;

import hello.business.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);

    @Query(value = "select r.* from customer r where r.id=?1",nativeQuery = true)
    Customer findUser(Long id);

    Customer findById(Long id);

}
