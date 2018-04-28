/**
 *
 */
package org.thingsboard.server.common.transport.quota;

/**
 * @author Vitaliy Paromskiy
 * @version 1.0
 */
public interface QuotaService {

    boolean isQuotaExceeded(String key);
}
