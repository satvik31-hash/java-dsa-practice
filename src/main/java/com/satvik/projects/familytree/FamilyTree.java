package com.satvik.projects.familytree;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * <h2>Family tree</h2>
 *
 * <p>Stores parent-child edges and answers relationship queries over them. Names are
 * matched case-insensitively but reported in the casing they were entered with.
 *
 * <p>The original version kept two parallel {@code ArrayList}s and scanned both on every
 * query, which is O(n) per lookup and lets the two lists fall out of step. This keeps an
 * adjacency map in each direction instead, so parent and child lookups are O(1) and the
 * two views cannot disagree.
 *
 * <p>{@link #ancestorsOf(String)} is the recursive part: walk up to each parent, then
 * recurse from there, tracking visited names so a cycle in bad input cannot loop forever.
 */
public class FamilyTree {

    private final Map<String, Set<String>> childrenByParent = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    private final Map<String, Set<String>> parentsByChild = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    /** Records that {@code parent} is a parent of {@code child}. */
    public void addRelation(String parent, String child) {
        requireName(parent, "parent");
        requireName(child, "child");
        if (parent.equalsIgnoreCase(child)) {
            throw new IllegalArgumentException("A person cannot be their own parent");
        }
        childrenByParent.computeIfAbsent(parent, k -> new LinkedHashSet<>()).add(child);
        parentsByChild.computeIfAbsent(child, k -> new LinkedHashSet<>()).add(parent);
    }

    public List<String> parentsOf(String name) {
        return copyOf(parentsByChild.get(name));
    }

    public List<String> childrenOf(String name) {
        return copyOf(childrenByParent.get(name));
    }

    /** @return everyone sharing at least one parent with {@code name}, excluding {@code name} */
    public List<String> siblingsOf(String name) {
        Set<String> siblings = new LinkedHashSet<>();
        for (String parent : parentsOf(name)) {
            for (String child : childrenOf(parent)) {
                if (!child.equalsIgnoreCase(name)) {
                    siblings.add(child);
                }
            }
        }
        return new ArrayList<>(siblings);
    }

    /**
     * @return every ancestor in depth-first order: each parent, then that parent's own
     *         ancestors, before moving on to the next parent. Duplicates are collapsed,
     *         so a person reachable by two paths appears once.
     */
    public List<String> ancestorsOf(String name) {
        Set<String> found = new LinkedHashSet<>();
        collectAncestors(name, found);
        return new ArrayList<>(found);
    }

    private void collectAncestors(String name, Set<String> found) {
        for (String parent : parentsOf(name)) {
            if (found.add(parent)) {
                collectAncestors(parent, found);
            }
        }
    }

    /** @return every recorded parent-child pair, as {@code {parent, child}} rows */
    public List<String[]> relations() {
        List<String[]> rows = new ArrayList<>();
        childrenByParent.forEach((parent, children) ->
                children.forEach(child -> rows.add(new String[]{parent, child})));
        return rows;
    }

    public boolean isEmpty() {
        return childrenByParent.isEmpty();
    }

    private static List<String> copyOf(Set<String> values) {
        return values == null ? List.of() : new ArrayList<>(values);
    }

    private static void requireName(String name, String role) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("The " + role + " name must not be blank");
        }
    }
}
