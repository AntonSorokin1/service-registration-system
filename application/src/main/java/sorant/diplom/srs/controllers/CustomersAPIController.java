package sorant.diplom.srs.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sorant.diplom.srs.entities.Customer;
import sorant.diplom.srs.services.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomersAPIController extends CRUDController<Customer, CustomerService> {

}
