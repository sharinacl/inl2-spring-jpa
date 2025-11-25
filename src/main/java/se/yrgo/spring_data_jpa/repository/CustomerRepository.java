package se.yrgo.spring_data_jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import se.yrgo.spring_data_jpa.domain.Customer;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByName(String name);


    @Query("SELECT c, v FROM Customer c LEFT JOIN c.vehicles v")
    List<Object[]> findAllCustomerWithVehicles();

}
