/*
 * Axelor Business Solutions
 *
 * Copyright (C) 2020 Axelor (<http://axelor.com>).
 *
 * This program is free software: you can redistribute it and/or  modify
 * it under the terms of the GNU Affero General Public License, version 3,
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.axelor.apps.base.service.groupExport;

public interface ConfigGeneratorText {

  public static final String CONFIG_START = /*$$(*/
      "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
          + "<csv-inputs xmlns=\"http://axelor.com/xml/ns/data-import\"\r\n"
          + "  xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\r\n"
          + "  xsi:schemaLocation=\"http://axelor.com/xml/ns/data-import http://axelor.com/xml/ns/data-import/data-import_5.3.xsd\">\n\n" /*)*/;

  public static final String CONFIG_END = /*$$(*/ "</csv-inputs>" /*)*/;

  public static final String BIND_START = /*$$(*/ "\n\t<bind to=" /*)*/;

  public static final String BIND_END = /*$$(*/ "\n\t</bind>\n" /*)*/;

  public static final String QUOTE = /*$$(*/ "\"" /*)*/;
}
