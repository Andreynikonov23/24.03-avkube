package ru.sapteh.daoipml;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.sapteh.dao.DAO;
import ru.sapteh.model.RadioElements;

import java.util.List;

public class RadioElementsImpl implements DAO<RadioElements, Integer> {

    SessionFactory factory;

    public RadioElementsImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(RadioElements radioElements) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.save(radioElements);
            session.getTransaction().commit();
        }
    }
    @Override
    public void delete(RadioElements radioElements) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(radioElements);
            session.getTransaction().commit();
        }
    }
    @Override
    public void update(RadioElements radioElements) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.update(radioElements);
            session.getTransaction().commit();
        }
    }
    @Override
    public RadioElements findById(Integer id) {
        try (Session session = factory.openSession()){
            return session.get(RadioElements.class, id);
        }
    }
    @Override
    public List<RadioElements> findByAll() {
        try (Session session = factory.openSession()){
            return session.createQuery("FROM RadioElements", RadioElements.class).list();
        }
    }
}
