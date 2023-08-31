package com.iranian.carpet.dao.contact;

import com.iranian.carpet.model.Contact;
import jakarta.transaction.Transactional;

import java.util.Optional;

public interface ContactDao {
    Optional<Contact> findContactById(Long id);

    @Transactional(Transactional.TxType.REQUIRED)
    Optional<Contact> save(Contact contact) throws Exception;
}
