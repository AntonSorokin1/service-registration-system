package sorant.diplom.srs.services.impl;

import org.springframework.stereotype.Service;
import sorant.diplom.srs.Customer;
import sorant.diplom.srs.repositories.CustomerRepository;
import sorant.diplom.srs.services.CustomerService;

@Service
public class CustomerServiceImpl extends CRUDServiceImpl<Customer, CustomerRepository> implements CustomerService {
    @Override
    public Customer findByNameAndAgeAndPhoneAndTheme(String name, int age, String phone, String theme) {
        return repository.findByNameAndAgeAndPhoneAndTheme(name, age, phone, theme);
    }
}
