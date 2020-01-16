package dbconnection.service;

import dbconnection.model.TableCustomer;
import dbconnection.repository.TableCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl {

    @Autowired
    TableCustomerRepository tableCustomerRepository;

    public TableCustomer getCustomerByObjid(Long id) {
        return tableCustomerRepository.findById(id).orElse(null);
    }
}
