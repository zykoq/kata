package org.zykoq.dependency;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * @author <a href="mailto:mr@mobi4friends.de">Maarten Roowaan</a>
 */
public class TransitiveDependencyTest {

    private static final String DIRECT_DO_NOT_MATCH = "Direct dependencies do not match!";
    private static final String TRANSITIVE_DO_NOT_MATCH = "Transitive dependencies do not match!";
    private TransitiveDependency transitiveDependency;

    @Before
    public void initCollaborateurs() {
        transitiveDependency = new TransitiveDependency();
    }

    @Test
    public void testDirectDependencyA() {
        setDependencies("A", "B", "C");
        Set<String> expectedDependencies = setExpectedDependencies("B", "C");
        assertEquals(DIRECT_DO_NOT_MATCH, expectedDependencies, transitiveDependency.getDependencies("A"));
    }

    @Test
    public void testDirectDependencyB() {
        setDependencies("B", "C", "E");
        Set<String> expectedDependencies = setExpectedDependencies("C", "E");
        assertEquals(DIRECT_DO_NOT_MATCH, expectedDependencies, transitiveDependency.getDependencies("B"));
    }

    @Test
    public void testDirectDependencyC() {
        setDependencies("C", "G");
        Set<String> expectedDependencies = setExpectedDependencies("G");
        assertEquals(DIRECT_DO_NOT_MATCH, expectedDependencies, transitiveDependency.getDependencies("C"));
    }

    @Test
    public void testTransitiveDependencyA() {
        setDependencies("A", "B", "C");
        setDependencies("B", "C", "E");
        setDependencies("C", "G");
        Set<String> expectedDependencies = setExpectedDependencies("B", "C", "E", "G");
        assertEquals(TRANSITIVE_DO_NOT_MATCH, expectedDependencies, transitiveDependency.getDependencies("A"));
    }

    @Test
    public void testTransitiveDependencyAll() {
        setDependencies("A", "B", "C");
        setDependencies("B", "C", "E");
        setDependencies("C", "G");
        setDependencies("D", "A", "F");
        setDependencies("E", "F");
        setDependencies("F", "H");
        Set<String> expectedDependenciesA = setExpectedDependencies("B", "C", "E", "F", "G", "H");
        Set<String> expectedDependenciesB = setExpectedDependencies("C", "E", "F", "G", "H");
        Set<String> expectedDependenciesC = setExpectedDependencies("G");
        Set<String> expectedDependenciesD = setExpectedDependencies("A", "B", "C", "E", "F", "G", "H");
        Set<String> expectedDependenciesE = setExpectedDependencies("F", "H");
        Set<String> expectedDependenciesF = setExpectedDependencies("H");
        assertEquals(TRANSITIVE_DO_NOT_MATCH, expectedDependenciesA, transitiveDependency.getDependencies("A"));
        assertEquals(TRANSITIVE_DO_NOT_MATCH, expectedDependenciesB, transitiveDependency.getDependencies("B"));
        assertEquals(TRANSITIVE_DO_NOT_MATCH, expectedDependenciesC, transitiveDependency.getDependencies("C"));
        assertEquals(TRANSITIVE_DO_NOT_MATCH, expectedDependenciesD, transitiveDependency.getDependencies("D"));
        assertEquals(TRANSITIVE_DO_NOT_MATCH, expectedDependenciesE, transitiveDependency.getDependencies("E"));
        assertEquals(TRANSITIVE_DO_NOT_MATCH, expectedDependenciesF, transitiveDependency.getDependencies("F"));
    }

    private void setDependencies(String key, String... values) {
        for (String value : values) {
            transitiveDependency.addDependency(key, value);
        }
    }

    private Set<String> setExpectedDependencies(String... expectedValues) {
        Set<String> expectedDependencies = new HashSet<String>(expectedValues.length);
        expectedDependencies.addAll(Arrays.asList(expectedValues));
        return expectedDependencies;
    }
}
