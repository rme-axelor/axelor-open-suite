/*
 * Axelor Business Solutions
 *
 * Copyright (C) 2005-2024 Axelor (<http://axelor.com>).
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.axelor.apps.base.service;

import com.axelor.apps.base.db.DataSharingReferentialLine;
import com.axelor.apps.base.db.repo.DataSharingReferentialLineRepository;
import com.axelor.db.JPA;
import com.axelor.db.Model;
import com.axelor.db.Query;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;

public class DataSharingReferentialLineServiceImpl implements DataSharingReferentialLineService {

  protected DataSharingReferentialLineRepository dataSharingReferentialLineRepository;

  @Inject
  public DataSharingReferentialLineServiceImpl(
      DataSharingReferentialLineRepository dataSharingReferentialLineRepository) {
    this.dataSharingReferentialLineRepository = dataSharingReferentialLineRepository;
  }

  @Override
  public Query<? extends Model> getQuery(Class<? extends Model> modelClass) {
    List<DataSharingReferentialLine> dataSharingReferentialLineList =
        getDataSharingReferentialLineList(modelClass);
    if (CollectionUtils.isEmpty(dataSharingReferentialLineList)) {
      return null;
    }
    List<String> conditionList = getConditionList(dataSharingReferentialLineList);
    if (CollectionUtils.isEmpty(conditionList)) {
      return null;
    }
    String condition = String.join(" OR ", conditionList);
    return JPA.all(modelClass).filter(condition);
  }

  protected List<DataSharingReferentialLine> getDataSharingReferentialLineList(
      Class<? extends Model> modelClass) {
    return dataSharingReferentialLineRepository
        .all()
        .filter("self.metaModel.name = :modelName")
        .bind("modelName", modelClass.getSimpleName())
        .fetch();
  }

  protected List<String> getConditionList(
      List<DataSharingReferentialLine> dataSharingReferentialLineList) {
    List<String> conditionList = new ArrayList<>();

    for (DataSharingReferentialLine dataSharingReferentialLine : dataSharingReferentialLineList) {
      String condition = dataSharingReferentialLine.getQueryCondition();
      if (condition != null && !condition.trim().isEmpty()) {
        conditionList.add(condition.trim());
      }
    }
    return conditionList;
  }
}