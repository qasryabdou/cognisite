package com.cognicap.site.repository.support;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;

/**
 * Holds extra informations to be displayed and filled by the spring mvc {@link Controller}.
 */
public class SearchParameters implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(SearchParameters.class);

    public static final String ASCENDING = "ascending";
    public static final String DESCENDING = "descending";

    private int pageNumber = 1;
    private int pageSize = 15;
    private String sortColumnKey;
    private String sortOrder = ASCENDING;
    private String searchPattern;

    /**
     * Limit the search to the passed page number. Must be positive (starts at 1). Its default value is 1.
     */
    public void setPageNumber(int pageNumber) {
        if (pageNumber <= 0) {
            log.warn("trying to access invalid page number: " + pageNumber);
            pageNumber = 1;
        }

        this.pageNumber = pageNumber;
    }

    /**
     * Returns the page number used to limit the search. It is always positive (starts at 1).
     */
    public int getPageNumber() {
        return this.pageNumber;
    }

    /**
     * Set the max number of items that can be displayed per page. The page size must be positive (starts at 1). It is used to limit the search.
     */
    public void setPageSize(int pageSize) {
        if (pageSize > 0) {
            this.pageSize = pageSize;
        } else {
            log.warn("trying to set an invalid page size: " + pageSize);
        }
    }

    /**
     * Return the max number of search items that can be displayed per page.
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * Indicates that search result must be sort by the passed sortColumnKey.
     *
     * @param sortColumnKey
     */
    public void setSortColumnKey(String sortColumnKey) {
        this.sortColumnKey = sortColumnKey;
    }

    /**
     * Returns the column name used to sort the search result.
     */
    public String getSortColumnKey() {
        return sortColumnKey;
    }

    public boolean hasSortColumnKey() {
        return StringUtils.isNotBlank(sortColumnKey);
    }

    /**
     * Set the sort order.
     *
     * @param sortOrder either ASCENDING, DESCENDING or an empty String
     */
    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    /**
     * Return the sort order that is ASCENDING, DESCENDING or an empty String.
     */
    public String getSortOrder() {
        return sortOrder;
    }

    /**
     * Return the Sort Order for the passed columns. It is used by the view.
     */
    public String getSortOrderFor(String sortColumnKey) {
        if (getSortColumnKey().equalsIgnoreCase(sortColumnKey)) {
            return getSortOrder();
        }

        return "";
    }

    /**
     * Return the reverse Sort Order for the passed columns. It is used by the view.
     *
     * @return DESCENDING if sort order is ASCENDING; ASCENDING otherwise.
     */
    public String getReverseSortOrderFor(String sortColumnKey) {
        if (ASCENDING.equals(getSortOrderFor(sortColumnKey))) {
            return DESCENDING;
        }

        return ASCENDING;
    }

    /**
     * Set the search pattern to apply to all string fields for executing the search.
     *
     * @param searchPattern
     */
    public void setSearchPattern(String searchPattern) {
        this.searchPattern = searchPattern;
    }

    /**
     * Returns the search pattern that must be applied to all string fields when executing the search.
     */
    public String getSearchPattern() {
        return searchPattern;
    }

    public boolean hasSearchPattern() {
        return StringUtils.isNotBlank(searchPattern);
    }

    /**
     * Applies the passed parameters to the passed SearchTemplate.
     * Note: filters are not supported for the moment
     * @return the passed searchTemplate
     */
    public PageRequest toPageRequest() {
        if (hasSortColumnKey()) {
            return new PageRequest(pageNumber - 1, pageSize, convert(sortOrder), sortColumnKey);
        } else {
            return new PageRequest(pageNumber - 1, pageSize);
        }
    }

    /**
     * Convert PrimeFaces SortOrder to our OrderByDirection.
     */
    public static Direction convert(String sortOrder) {
        // TODO: auto converter
        if (DESCENDING.equalsIgnoreCase(sortOrder))
            return Direction.DESC;
        else
            return Direction.ASC;
    }
}