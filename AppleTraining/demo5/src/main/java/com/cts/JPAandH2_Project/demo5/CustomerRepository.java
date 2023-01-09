package com.cts.JPAandH2_Project.demo5;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	List<Customer> findByLastName(String LastName);

    Customer findById(long id);
} 