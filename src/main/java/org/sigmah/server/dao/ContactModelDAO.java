package org.sigmah.server.dao;
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

import org.sigmah.server.dao.base.DAO;
import org.sigmah.server.domain.ContactModel;
import org.sigmah.shared.dto.referential.ContactModelType;

public interface ContactModelDAO extends DAO<ContactModel, Integer> {
  /**
   * Return the default contact model
   */
  ContactModel getDefaultContactModel(Integer organizationId, ContactModelType type);

  List<ContactModel> findByOrganization(Integer organizationId);

  List<ContactModel> findByOrganizationAndType(Integer organizationId, ContactModelType type);
}
