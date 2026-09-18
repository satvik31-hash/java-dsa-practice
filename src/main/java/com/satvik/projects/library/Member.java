package com.satvik.projects.library;

import java.util.Objects;

/** Somebody who can borrow from the library. */
public class Member {

    private final int memberId;
    private final String name;

    public Member(int memberId, String name) {
        this.memberId = memberId;
        this.name = Objects.requireNonNull(name, "name");
    }

    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Member #%d %s".formatted(memberId, name);
    }
}
