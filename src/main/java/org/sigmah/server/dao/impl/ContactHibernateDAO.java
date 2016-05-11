package org.sigmah.server.dao.impl;
/*
 * #%L
 * Sigmah
 * %%
 * Copyright (C) 2010 - 2016 URD
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

import java.util.List;

import org.sigmah.server.dao.ContactDAO;
import org.sigmah.server.dao.base.AbstractDAO;
import org.sigmah.server.domain.Contact;
import org.sigmah.shared.dto.referential.ContactModelType;

public class ContactHibernateDAO extends AbstractDAO<Contact, Integer> implements ContactDAO {
  @Override
  public Contact findInstanceContact(Integer organizationId) {
    return em()
        .createQuery(
            "SELECT c " +
            "FROM Contact c " +
            "JOIN c.contactModel cm " +
            "WHERE c.organization.id = :organizationId " +
            "AND cm.type = 'ORGANIZATION' ",
            Contact.class
        )
        .setParameter("organizationId", organizationId)
        .setMaxResults(1)
        .getSingleResult();
  }

  @Override
  public List<Contact> findTypedContacts(Integer organizationId, ContactModelType type) {
    return em()
        .createQuery(
            "SELECT c " +
            "FROM Contact c " +
            "JOIN c.contactModel cm " +
            "WHERE c.organization.id = :organizationId " +
            "AND cm.type = :type ",
            Contact.class
        )
        .setParameter("organizationId", organizationId)
        .setParameter("type", type)
        .getResultList();
  }
}
