package com.quantori.utils.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources("classpath:config/service.properties")
public interface ServiceConfig extends Config{

    @Config.Key("base_url")
    String baseUrl();
}
