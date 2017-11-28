package ua.com.webserviceserv.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.webserviceserv.models.Abonents;
import ua.com.webserviceserv.repository.AbonentsRepository;

@Service
public class AbonentsServiceImpl implements AbonentsService{

    @Autowired
    AbonentsRepository abonentsRepository;

    public Abonents getAbonentByID(Integer abonID){
        return abonentsRepository.findOne(abonID);
    }


}
