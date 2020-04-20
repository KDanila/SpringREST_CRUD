package kdv.repository;

import kdv.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

// Can change path in get request @RepositoryRestResource(path = "members")
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
