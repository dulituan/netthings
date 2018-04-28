/**
 *
 */
package org.thingsboard.server.common.transport.quota;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Vitaliy Paromskiy
 * @version 1.0
 */
public class HostRequestLimitPolicyTest {

    private HostRequestLimitPolicy limitPolicy = new HostRequestLimitPolicy(10L);

    @Test
    public void ifCurrentValueLessThenLimitItIsValid() {
        assertTrue(limitPolicy.isValid(9));
    }

    @Test
    public void ifCurrentValueEqualsToLimitItIsValid() {
        assertTrue(limitPolicy.isValid(10));
    }

    @Test
    public void ifCurrentValueGreaterThenLimitItIsValid() {
        assertFalse(limitPolicy.isValid(11));
    }

}