package sorant.diplom.srs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sorant.diplom.srs.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findByNameAndAgeAndPhoneAndTheme(String name, int age, String phone, String theme);
}
