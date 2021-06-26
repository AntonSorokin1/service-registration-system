package sorant.diplom.srs.services;

import sorant.diplom.srs.Customer;

public interface CustomerService extends CRUDService<Customer> {
    Customer findByNameAndAgeAndPhoneAndTheme(String name, int age, String phone, String theme);
}
