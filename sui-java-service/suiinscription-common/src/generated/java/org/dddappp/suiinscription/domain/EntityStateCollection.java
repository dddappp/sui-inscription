// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddappp.suiinscription.domain;

import java.util.Collection;
import java.util.stream.Stream;

public interface EntityStateCollection<TId, TState> extends Iterable<TState> {

    /**
     * Get entity state.
     * @param entityId entity Id.
     * @return If not found, return null.
     */
    TState get(TId entityId);

    boolean isLazy();

    boolean isAllLoaded();

    Collection<TState> getLoadedStates();

    Stream<TState> stream();

    interface ModifiableEntityStateCollection<TId, TState> extends EntityStateCollection<TId, TState> {

        /**
         * Get existed entity state or add new default entity state.
         * @param entityId entity Id.
         * @return The entity state that must not be null.
         */
        TState getOrAddDefault(TId entityId);

        boolean add(TState e);

        boolean removeState(TState state);
    }

    interface RemovalLoggedEntityStateCollection<TId, TState> extends ModifiableEntityStateCollection<TId, TState> {
        Collection<TState> getRemovedStates();
    }
}


