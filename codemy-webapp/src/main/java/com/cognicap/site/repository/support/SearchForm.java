package com.cognicap.site.repository.support;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * Holds informations to be displayed and filled by the spring mvc {@link Controller}.
 * <p>
 * This class return its information as a template that will be consummed by the {@link CustomRepository}
 */
public abstract class SearchForm<E> implements Serializable {
    private static final long serialVersionUID = 1L;
    private SearchParameters searchParameters = new SearchParameters();

    public abstract E getForm();

    /**
     * @return the {@link SearchParameters} controlling search meta attributes (order, pagination, etc.)
     */
    public SearchParameters getSp() {
        return searchParameters;
    }

    /**
     * Override it in subclass in order to provide specific {@link Range} criteria to search.
     */
    public List<Range<E, ?>> getRanges() {
        return Collections.emptyList();
    }

    /**
     * Override it in subclass in order to provide specific {@link NullRestriction} criteria in search.
     */
    protected List<NullRestriction> getNullRestrictions() {
        return Collections.emptyList();
    }
}