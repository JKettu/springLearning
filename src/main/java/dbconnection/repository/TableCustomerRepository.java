package dbconnection.repository;

import dbconnection.model.TableCustomer;
import org.springframework.data.repository.CrudRepository;

public interface TableCustomerRepository extends CrudRepository<TableCustomer, Long> {
}
