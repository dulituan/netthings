/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.service.install;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.thingsboard.server.dao.cassandra.CassandraInstallCluster;
import org.thingsboard.server.dao.util.NoSqlDao;
import org.thingsboard.server.service.install.cql.CQLStatementsParser;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@NoSqlDao
@Profile("install")
@Slf4j
public class CassandraDatabaseSchemaService implements DatabaseSchemaService {

    private static final String CASSANDRA_DIR = "cassandra";
    private static final String SCHEMA_CQL = "schema.cql";

    @Value("${install.data_dir}")
    private String dataDir;

    @Autowired
    private CassandraInstallCluster cluster;

    @Override
    public void createDatabaseSchema() throws Exception {
        log.info("Installing Cassandra DataBase schema...");

        Path schemaFile = Paths.get(this.dataDir, CASSANDRA_DIR, SCHEMA_CQL);
        loadCql(schemaFile);

    }

    private void loadCql(Path cql) throws Exception {
        List<String> statements = new CQLStatementsParser(cql).getStatements();
        statements.forEach(statement -> cluster.getSession().execute(statement));
    }
}
