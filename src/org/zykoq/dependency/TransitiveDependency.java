package org.zykoq.dependency;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author <a href="mailto:mr@mobi4friends.de">Maarten Roowaan</a>
 */
public class TransitiveDependency {

    private Map<String, Set<String>> dependencies;

    public TransitiveDependency() {
        dependencies = new HashMap<String, Set<String>>();
    }

    public void addDependency(String key, String dependency) {
        Set<String> dependenciesByItem = dependencies.get(key);
        if (dependenciesByItem == null) {
            dependenciesByItem = new HashSet<String>();
            dependencies.put(key, dependenciesByItem);
        }
        dependenciesByItem.add(dependency);
    }

    public Set<String> getDependencies(String key) {
        Set<String> directDependencies = dependencies.get(key);
        Set<String> transitiveDependencies = new HashSet<String>();
        if (directDependencies != null) {
            transitiveDependencies.addAll(directDependencies);
            //Should not allow cross-dependencies!
            for (String directDependency : directDependencies) {
                transitiveDependencies.addAll(getDependencies(directDependency));
            }
        }
        return transitiveDependencies;
    }
}
