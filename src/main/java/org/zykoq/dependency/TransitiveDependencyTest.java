package org.zykoq.dependency;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

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
        setDependencies(Dependency.A, Dependency.B, Dependency.C);
        assertEquals(DIRECT_DO_NOT_MATCH,
                setExpectedDependencies(Dependency.B, Dependency.C), transitiveDependency.getDependencies(Dependency.A));
    }

    @Test
    public void testDirectDependencyB() {
        setDependencies(Dependency.B, Dependency.C, Dependency.E);
        assertEquals(DIRECT_DO_NOT_MATCH,
                setExpectedDependencies(Dependency.C, Dependency.E), transitiveDependency.getDependencies(Dependency.B));
    }

    @Test
    public void testDirectDependencyC() {
        setDependencies(Dependency.C, Dependency.G);
        assertEquals(DIRECT_DO_NOT_MATCH,
                setExpectedDependencies(Dependency.G), transitiveDependency.getDependencies(Dependency.C));
    }

    @Test
    public void testTransitiveDependencyA() {
        setDependencies(Dependency.A, Dependency.B, Dependency.C);
        setDependencies(Dependency.B, Dependency.C, Dependency.E);
        setDependencies(Dependency.C, Dependency.G);
        assertEquals(TRANSITIVE_DO_NOT_MATCH,
                setExpectedDependencies(Dependency.B, Dependency.C, Dependency.E, Dependency.G),
                transitiveDependency.getDependencies(Dependency.A));
    }

    @Test
    public void testTransitiveDependencyAll() {
        setDependencies(Dependency.A, Dependency.B, Dependency.C);
        setDependencies(Dependency.B, Dependency.C, Dependency.E);
        setDependencies(Dependency.C, Dependency.G);
        setDependencies(Dependency.D, Dependency.A, Dependency.F);
        setDependencies(Dependency.E, Dependency.F);
        setDependencies(Dependency.F, Dependency.H);
        assertTransitiveDependencies(
                setExpectedDependencies(Dependency.B, Dependency.C, Dependency.E, Dependency.F, Dependency.G, Dependency.H),
                transitiveDependency.getDependencies(Dependency.A));
        assertTransitiveDependencies(
                setExpectedDependencies(Dependency.C, Dependency.E, Dependency.F, Dependency.G, Dependency.H),
                transitiveDependency.getDependencies(Dependency.B));
        assertTransitiveDependencies(setExpectedDependencies(Dependency.G), transitiveDependency.getDependencies(Dependency.C));
        assertTransitiveDependencies(
                setExpectedDependencies(Dependency.A, Dependency.B, Dependency.C, Dependency.E, Dependency.F, Dependency.G, Dependency.H),
                transitiveDependency.getDependencies(Dependency.D));
        assertTransitiveDependencies(
                setExpectedDependencies(Dependency.F, Dependency.H),
                transitiveDependency.getDependencies(Dependency.E));
        assertTransitiveDependencies(setExpectedDependencies(Dependency.H), transitiveDependency.getDependencies(Dependency.F));
    }

    private void assertTransitiveDependencies(Set<Dependency> expectedDependencies, Set<Dependency> actualDependencies) {
        assertEquals(TRANSITIVE_DO_NOT_MATCH, expectedDependencies, actualDependencies);
    }

    private void setDependencies(Dependency key, Dependency... values) {
        for (Dependency value : values) {
            transitiveDependency.addDependency(key, value);
        }
    }

    private Set<Dependency> setExpectedDependencies(Dependency... expectedValues) {
        Set<Dependency> expectedDependencies = new HashSet<Dependency>(expectedValues.length);
        expectedDependencies.addAll(Arrays.asList(expectedValues));
        return expectedDependencies;
    }
}
