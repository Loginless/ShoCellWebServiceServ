package ua.com.webserviceserv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.webserviceserv.models.Abonents;

@Repository
public interface AbonentsRepository extends JpaRepository<Abonents, Integer> {
}
