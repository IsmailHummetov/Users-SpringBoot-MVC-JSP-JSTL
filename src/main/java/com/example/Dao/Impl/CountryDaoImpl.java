package com.example.Dao.Impl;

import com.example.Dao.Inter.*;
import com.example.Entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryDaoImpl implements CountryDaoInter {

    @PersistenceContext
    EntityManager em;


    @Override
    public List<Country> getAll() {
        Query query = em.createQuery("SELECT c from Country c");
        List<Country> countries = query.getResultList();
        return countries;
    }

    @Override
    public Country getById(int CountryId) {
        Country country = em.find(Country.class,CountryId);
        return country;
    }

    @Override
    public boolean addCountry(Country country) {
        em.persist(country);
        return true;
    }

    @Override
    public boolean updateCountry(Country country) {
        em.merge(country);
        return true;
    }

    @Override
    public boolean deleteCountry(int CountryId) {
        Country country = em.find(Country.class,CountryId);
        em.remove(country);
        return true;
    }
}
