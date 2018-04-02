package org.jboss.unimbus.config.impl.interpolation;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Created by bob on 4/2/18.
 */
class EvaluationContext {

    EvaluationContext(Interpolator interpolator, String eval) {
        this.interpolator = interpolator;
        this.eval = eval;
    }

    int incr() {
        return (++this.uses);
    }

    int decr() {
        return (--this.uses);
    }

    int uses() {
        return this.uses;
    }

    void markSeen(String varName) {
        if (this.seen.contains(varName)) {
            throw new IllegalArgumentException("recursive uses of '" + varName + "'");
        }
        this.seen.add(varName);
    }

    String getValue(String name) {
        return this.interpolator.config.getValue(name, String.class);
    }

    Optional<String> getOptionalValue(String name) {
        return this.interpolator.config.getOptionalValue(name, String.class);
    }

    private final String eval;

    private Interpolator interpolator;

    private Set<String> seen = new HashSet<>();

    private volatile int uses;
}