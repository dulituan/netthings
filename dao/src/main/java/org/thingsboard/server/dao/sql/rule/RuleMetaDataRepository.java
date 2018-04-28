/**
 *
 */
package org.thingsboard.server.dao.sql.rule;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.thingsboard.server.dao.model.sql.RuleMetaDataEntity;
import org.thingsboard.server.dao.util.SqlDao;

import java.util.List;

/**
 * Created by Valerii Sosliuk on 4/30/2017.
 */
@SqlDao
public interface RuleMetaDataRepository extends CrudRepository<RuleMetaDataEntity, String> {

    List<RuleMetaDataEntity> findByPluginToken(String pluginToken);

    @Query("SELECT rmd FROM RuleMetaDataEntity rmd WHERE rmd.tenantId = :tenantId " +
            "AND LOWER(rmd.searchText) LIKE LOWER(CONCAT(:textSearch, '%')) " +
            "AND rmd.id > :idOffset ORDER BY rmd.id")
    List<RuleMetaDataEntity> findByTenantIdAndPageLink(@Param("tenantId") String tenantId,
                                                       @Param("textSearch") String textSearch,
                                                       @Param("idOffset") String idOffset,
                                                       Pageable pageable);

    @Query("SELECT rmd FROM RuleMetaDataEntity rmd WHERE rmd.tenantId IN (:tenantId, :nullTenantId) " +
            "AND LOWER(rmd.searchText) LIKE LOWER(CONCAT(:textSearch, '%')) " +
            "AND rmd.id > :idOffset ORDER BY rmd.id")
    List<RuleMetaDataEntity> findAllTenantRulesByTenantId(@Param("tenantId") String tenantId,
                                                          @Param("nullTenantId") String nullTenantId,
                                                          @Param("textSearch") String textSearch,
                                                          @Param("idOffset") String idOffset,
                                                          Pageable pageable);
}
