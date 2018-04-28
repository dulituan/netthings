/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.dao.sql.plugin;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.thingsboard.server.dao.model.sql.PluginMetaDataEntity;
import org.thingsboard.server.dao.util.SqlDao;

import java.util.List;

/**
 * Created by Valerii Sosliuk on 5/1/2017.
 */
@SqlDao
public interface PluginMetaDataRepository extends CrudRepository<PluginMetaDataEntity, String> {

    PluginMetaDataEntity findByApiToken(String apiToken);

    @Query("SELECT pmd FROM PluginMetaDataEntity pmd WHERE pmd.tenantId = :tenantId " +
            "AND LOWER(pmd.searchText) LIKE LOWER(CONCAT(:textSearch, '%')) " +
            "AND pmd.id > :idOffset ORDER BY pmd.id")
    List<PluginMetaDataEntity> findByTenantIdAndPageLink(@Param("tenantId") String tenantId,
                                                         @Param("textSearch") String textSearch,
                                                         @Param("idOffset") String idOffset,
                                                         Pageable pageable);

    @Query("SELECT pmd FROM PluginMetaDataEntity pmd WHERE pmd.tenantId IN (:tenantId, :nullTenantId) " +
            "AND LOWER(pmd.searchText) LIKE LOWER(CONCAT(:textSearch, '%')) " +
            "AND pmd.id > :idOffset ORDER BY pmd.id")
    List<PluginMetaDataEntity> findAllTenantPluginsByTenantId(@Param("tenantId") String tenantId,
                                                              @Param("nullTenantId") String nullTenantId,
                                                              @Param("textSearch") String textSearch,
                                                              @Param("idOffset") String idOffset,
                                                              Pageable pageable);
}
