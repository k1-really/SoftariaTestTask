package org.example.statistic.model;

import java.util.Set;

public class Statistic {
    private Set<String> added;
    private Set<String> removed;
    private Set<String> changed;

    public Statistic(Set<String> added, Set<String> removed, Set<String> changed) {
        this.added = added;
        this.removed = removed;
        this.changed = changed;
    }

    public Set<String> getAdded() {
        return added;
    }

    public void setAdded(Set<String> added) {
        this.added = added;
    }

    public Set<String> getRemoved() {
        return removed;
    }

    public void setRemoved(Set<String> removed) {
        this.removed = removed;
    }

    public Set<String> getChanged() {
        return changed;
    }

    public void setChanged(Set<String> changed) {
        this.changed = changed;
    }
}
