package com.dardan.rrafshi.vinyl.api.endpoint.parameter;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.dardan.rrafshi.commons.Strings;
import com.dardan.rrafshi.vinyl.api.Constants;


public final class Paging
{
	private int page = Constants.MIN_PAGE;
	private int pageSize = Constants.MIN_PAGE_SIZE;
	private String sortOrder = Constants.DEFAULT_SORT_ORDER;
	private String sortBy;


	@Override
	public String toString()
	{
		return "Paging [page=" + this.page + ", pageSize=" + this.pageSize
				+ ", sortOrder=" + this.sortOrder + ", sortBy=" + this.sortBy + "]";
	}

	public Pageable toPageRequest()
	{
		final int page =  this.page < Constants.MIN_PAGE ?  Constants.MIN_PAGE - 1 : this.page - 1;

		final int size = this.pageSize < Constants.MIN_PAGE_SIZE ?  Constants.MIN_PAGE_SIZE :
				   		 this.pageSize > Constants.MAX_PAGE_SIZE ?  Constants.MAX_PAGE_SIZE :
				   	     this.pageSize;

		if(Strings.isNotEmpty(this.sortBy)) {
			final Direction direction = Direction.fromString(this.sortOrder);
			final Sort sort = Sort.by(direction, this.sortBy);
			return PageRequest.of(page, size, sort);
		}

		return PageRequest.of(page, size);
	}


	public int getPage()
	{
		return this.page;
	}

	public void setPage(final int page)
	{
		this.page = page;
	}

	public int getPageSize()
	{
		return this.pageSize;
	}

	public void setPageSize(final int pageSize)
	{
		this.pageSize = pageSize;
	}

	public String getSortOrder()
	{
		return this.sortOrder;
	}

	public void setSortOrder(final String sortOrder)
	{
		this.sortOrder = sortOrder;
	}

	public String getSortBy()
	{
		return this.sortBy;
	}

	public void setSortBy(final String sortBy)
	{
		this.sortBy = sortBy;
	}
}
