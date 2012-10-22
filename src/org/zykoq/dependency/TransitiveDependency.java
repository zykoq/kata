package org.zykoq.dependency;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TransitiveDependency {

    private Map<Dependency, Set<Dependency>> dependencies;

    public TransitiveDependency() {
        dependencies = new HashMap<Dependency, Set<Dependency>>();
    }

    public void addDependency(Dependency key, Dependency dependency) {
        Set<Dependency> dependenciesByItem = dependencies.get(key);
        if (dependenciesByItem == null) {
            dependenciesByItem = new HashSet<Dependency>();
            dependencies.put(key, dependenciesByItem);
        }
        dependenciesByItem.add(dependency);
    }

    public Set<Dependency> getDependencies(Dependency key) {
        Set<Dependency> directDependencies = dependencies.get(key);
        Set<Dependency> transitiveDependencies = new HashSet<Dependency>();
        if (directDependencies != null) {
            transitiveDependencies.addAll(directDependencies);
            //Should not allow cross-dependencies!
            for (Dependency directDependency : directDependencies) {
                transitiveDependencies.addAll(getDependencies(directDependency));
            }
        }
        return transitiveDependencies;
    }
}
