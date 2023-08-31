package com.iranian.carpet.dao.contact;

import com.iranian.carpet.model.Contact;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.Optional;

public class ContactDaoImpl implements ContactDao{
    @PersistenceContext(unitName="aliUnit")
    private EntityManager em;

    @Override
    public Optional<Contact> findContactById(Long id) {
        Contact contact = em.find(Contact.class , id);
        return contact != null ? Optional.of(contact):Optional.empty();
    }
    @Transactional(Transactional.TxType.REQUIRED)
    @Override
    public Optional<Contact> save(Contact contact) throws Exception {
        try {
            if (contact.getId() == null) {
                em.persist(contact);
            } else {
                contact = em.merge(contact);
            }
            return Optional.of(contact);
        }catch (Exception e){
            throw new Exception();
        }
    }
}
