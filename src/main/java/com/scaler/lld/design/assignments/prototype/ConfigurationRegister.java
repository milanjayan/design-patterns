package com.scaler.lld.design.assignments.prototype;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class ConfigurationRegister implements ConfigurationPrototypeRegistry{

    private Map<ConfigurationType, Configuration> register = new ConcurrentHashMap<>();
    @Override
    public void addPrototype(Configuration user) {
        register.put(user.getType(), user);
    }

    @Override
    public Configuration getPrototype(ConfigurationType type) {
        return register.get(type);
    }

    @Override
    public Configuration clone(ConfigurationType type) {
        Optional<Configuration> maybeConfiguration = Optional.ofNullable(register.get(type));
        if(maybeConfiguration.isPresent()) {
            return register.get(type).cloneObject();
        } else {
            return null;
        }
    }
}
