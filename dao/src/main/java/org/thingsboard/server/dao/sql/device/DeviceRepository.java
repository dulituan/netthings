/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.dao.sql.device;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.thingsboard.server.dao.model.sql.DeviceEntity;
import org.thingsboard.server.dao.util.SqlDao;

import java.util.List;

/**
 * Created by Valerii Sosliuk on 5/6/2017.
 */
@SqlDao
public interface DeviceRepository extends CrudRepository<DeviceEntity, String> {


    @Query("SELECT d FROM DeviceEntity d WHERE d.tenantId = :tenantId " +
            "AND d.customerId = :customerId " +
            "AND LOWER(d.searchText) LIKE LOWER(CONCAT(:searchText, '%')) " +
            "AND d.id > :idOffset ORDER BY d.id")
    List<DeviceEntity> findByTenantIdAndCustomerId(@Param("tenantId") String tenantId,
                                                   @Param("customerId") String customerId,
                                                   @Param("searchText") String searchText,
                                                   @Param("idOffset") String idOffset,
                                                   Pageable pageable);

    @Query("SELECT d FROM DeviceEntity d WHERE d.tenantId = :tenantId " +
            "AND LOWER(d.searchText) LIKE LOWER(CONCAT(:textSearch, '%')) " +
            "AND d.id > :idOffset ORDER BY d.id")
    List<DeviceEntity> findByTenantId(@Param("tenantId") String tenantId,
                                      @Param("textSearch") String textSearch,
                                      @Param("idOffset") String idOffset,
                                      Pageable pageable);

    @Query("SELECT d FROM DeviceEntity d WHERE d.tenantId = :tenantId " +
            "AND d.type = :type " +
            "AND LOWER(d.searchText) LIKE LOWER(CONCAT(:textSearch, '%')) " +
            "AND d.id > :idOffset ORDER BY d.id")
    List<DeviceEntity> findByTenantIdAndType(@Param("tenantId") String tenantId,
                                             @Param("type") String type,
                                             @Param("textSearch") String textSearch,
                                             @Param("idOffset") String idOffset,
                                             Pageable pageable);

    @Query("SELECT d FROM DeviceEntity d WHERE d.tenantId = :tenantId " +
            "AND d.customerId = :customerId " +
            "AND d.type = :type " +
            "AND LOWER(d.searchText) LIKE LOWER(CONCAT(:textSearch, '%')) " +
            "AND d.id > :idOffset ORDER BY d.id")
    List<DeviceEntity> findByTenantIdAndCustomerIdAndType(@Param("tenantId") String tenantId,
                                                          @Param("customerId") String customerId,
                                                          @Param("type") String type,
                                                          @Param("textSearch") String textSearch,
                                                          @Param("idOffset") String idOffset,
                                                          Pageable pageable);

    @Query("SELECT DISTINCT d.type FROM DeviceEntity d WHERE d.tenantId = :tenantId")
    List<String> findTenantDeviceTypes(@Param("tenantId") String tenantId);

    DeviceEntity findByTenantIdAndName(String tenantId, String name);

    List<DeviceEntity> findDevicesByTenantIdAndCustomerIdAndIdIn(String tenantId, String customerId, List<String> deviceIds);

    List<DeviceEntity> findDevicesByTenantIdAndIdIn(String tenantId, List<String> deviceIds);
}
