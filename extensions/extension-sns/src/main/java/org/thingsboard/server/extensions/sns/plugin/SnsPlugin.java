/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.extensions.sns.plugin;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import org.thingsboard.server.extensions.api.component.Plugin;
import org.thingsboard.server.extensions.api.plugins.AbstractPlugin;
import org.thingsboard.server.extensions.api.plugins.PluginContext;
import org.thingsboard.server.extensions.api.plugins.handlers.RuleMsgHandler;
import org.thingsboard.server.extensions.sns.action.SnsTopicPluginAction;

/**
 * Created by Valerii Sosliuk on 11/15/2017.
 */
@Plugin(name = "SNS Plugin", actions = {SnsTopicPluginAction.class},
        descriptor = "SnsPluginDescriptor.json", configuration = SnsPluginConfiguration.class)
public class SnsPlugin extends AbstractPlugin<SnsPluginConfiguration> {

    private SnsMessageHandler snsMessageHandler;
    private SnsPluginConfiguration configuration;

    @Override
    public void init(SnsPluginConfiguration configuration) {
        this.configuration = configuration;
        init();
    }

    private void init() {
        AWSCredentials awsCredentials = new BasicAWSCredentials(configuration.getAccessKeyId(), configuration.getSecretAccessKey());
        AWSStaticCredentialsProvider credProvider = new AWSStaticCredentialsProvider(awsCredentials);
        AmazonSNS sns = AmazonSNSClient.builder()
                .withCredentials(credProvider)
                .withRegion(configuration.getRegion())
                .build();
        this.snsMessageHandler = new SnsMessageHandler(sns);

    }

    private void destroy() {
        this.snsMessageHandler = null;
    }

    @Override
    protected RuleMsgHandler getRuleMsgHandler() {
        return snsMessageHandler;
    }

    @Override
    public void resume(PluginContext ctx) {
        init();
    }

    @Override
    public void suspend(PluginContext ctx) {
        destroy();
    }

    @Override
    public void stop(PluginContext ctx) {
        destroy();
    }
}
