package com.satvik.projects.familytree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FamilyTreeTest {

    private FamilyTree tree;

    @BeforeEach
    void buildThreeGenerations() {
        tree = new FamilyTree();
        tree.addRelation("Grandpa", "Dad");
        tree.addRelation("Grandma", "Dad");
        tree.addRelation("Dad", "Satvik");
        tree.addRelation("Mum", "Satvik");
        tree.addRelation("Dad", "Sister");
        tree.addRelation("Mum", "Sister");
    }

    @Test
    @DisplayName("reports both parents of a child")
    void findsParents() {
        assertEquals(List.of("Dad", "Mum"), tree.parentsOf("Satvik"));
    }

    @Test
    @DisplayName("reports every child of a parent")
    void findsChildren() {
        assertEquals(List.of("Satvik", "Sister"), tree.childrenOf("Dad"));
    }

    @Test
    @DisplayName("siblings exclude the person themselves and are not duplicated")
    void findsSiblingsWithoutDuplicates() {
        assertEquals(List.of("Sister"), tree.siblingsOf("Satvik"));
    }

    @Test
    @DisplayName("ancestors walk up recursively, depth first")
    void findsAncestorsRecursively() {
        assertEquals(List.of("Dad", "Grandpa", "Grandma", "Mum"), tree.ancestorsOf("Satvik"));
    }

    @Test
    @DisplayName("name matching ignores case")
    void matchesNamesCaseInsensitively() {
        assertEquals(List.of("Dad", "Mum"), tree.parentsOf("SATVIK"));
    }

    @Test
    @DisplayName("an unknown person has no relatives rather than blowing up")
    void unknownPersonReturnsEmptyLists() {
        assertTrue(tree.parentsOf("Nobody").isEmpty());
        assertTrue(tree.childrenOf("Nobody").isEmpty());
        assertTrue(tree.siblingsOf("Nobody").isEmpty());
        assertTrue(tree.ancestorsOf("Nobody").isEmpty());
    }

    @Test
    @DisplayName("a cycle in the data does not cause infinite recursion")
    void survivesCyclicData() {
        FamilyTree cyclic = new FamilyTree();
        cyclic.addRelation("A", "B");
        cyclic.addRelation("B", "A");
        assertEquals(List.of("A", "B"), cyclic.ancestorsOf("B"));
    }

    @Test
    @DisplayName("rejects blank names and self-parenthood")
    void rejectsBadInput() {
        assertThrows(IllegalArgumentException.class, () -> tree.addRelation("  ", "Child"));
        assertThrows(IllegalArgumentException.class, () -> tree.addRelation("Me", "me"));
    }

    @Test
    @DisplayName("relations round-trip every recorded edge")
    void listsAllRelations() {
        assertEquals(6, tree.relations().size());
    }
}
