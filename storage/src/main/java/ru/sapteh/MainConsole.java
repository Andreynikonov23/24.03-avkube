package ru.sapteh;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.SessionFactoryDelegatingImpl;
import ru.sapteh.dao.DAO;
import ru.sapteh.daoipml.RadioElementsImpl;
import ru.sapteh.model.RadioElements;

import java.util.List;

public class MainConsole {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        DAO<RadioElements, Integer> radioDaoImpl = new RadioElementsImpl(factory);

        List<RadioElements> byAll = radioDaoImpl.findByAll();
        byAll.forEach(System.out::println);
    }
}
