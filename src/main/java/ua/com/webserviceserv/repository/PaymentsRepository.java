package ua.com.webserviceserv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.com.webserviceserv.models.Payments;

import java.util.List;

@Repository
public interface PaymentsRepository extends JpaRepository<Payments, Integer>{

//    Payments getCustomerPayment(@Param("id") int id, @Param("customerId") int customerId);

}
