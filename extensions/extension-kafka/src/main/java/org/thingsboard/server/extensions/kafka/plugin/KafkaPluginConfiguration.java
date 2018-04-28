/**
 *
 */
package org.thingsboard.server.extensions.kafka.plugin;

import lombok.Data;
import org.thingsboard.server.extensions.core.plugin.KeyValuePluginProperties;

import java.util.List;

@Data
public class KafkaPluginConfiguration {
    private String bootstrapServers;
    private int retries;
    private int batchSize;
    private int linger;
    private int bufferMemory;
    private int acks;
    private String keySerializer;
    private String valueSerializer;
    private List<KeyValuePluginProperties> otherProperties;
}