package com.qzw.common.page;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Page
{
	private static final int DEFAULT_PAGE_SIZE = 10;
	
	// 当前页
	private int currentPage;
	
	// 上一页
	private int previousPage;
	
	// 下一页
	private int nextPage;
	
	// 总页数
	private int pageCount;
	
	// 总记录条数
	private int recordCount;
	
	// 每页显示的条数
	private int pageSize;
	
	// 分页第一条
	private int firstResult;
	
	// 分页最多条数
	private int maxResults;
	
	// 返回的结果集 map
	private List<Map<String, Object>> resultList;

	// 返回的结果集 list
	private List list;

	// 页码列表
	private List<Integer> pageNumList;
	
	// 当前页起始记录
	private int startRecord;
	
	// 当前页结束记录
	private int endRecord;
	
	// 首页
	private boolean firstPage;
	
	// 尾页
	private boolean lastPage;

	// 封装页面提交的参数
	private Map<String, Object> args = new HashMap<String, Object>();

	public Page()
	{
		
	}

	public Page(Map<String, Object> args)
	{
		String currentPage = (String) args.get("currentPage");
		String pageSize = (String) args.get("pageSize");
		this.currentPage = handlePage(currentPage, 1);
		this.pageSize = handlePage(pageSize, DEFAULT_PAGE_SIZE);
		this.args = args;
	}
	
	private int handlePage(String page, int defa)
	{
		int pageInt = 0;
		try {
			pageInt = Integer.parseInt(page);
		} catch (Exception e) {
			return defa;
		}
		pageInt = Math.abs(pageInt);
		return pageInt == 0 ? defa : pageInt;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPreviousPage() {
		return previousPage;
	}

	public void setPreviousPage(int previousPage) {
		this.previousPage = previousPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
		if( this.recordCount > 0 )
		{
			this.pageCount = (this.recordCount % this.pageSize == 0 ? 
					(this.recordCount / this.pageSize) : (this.recordCount / this.pageSize + 1));
			this.currentPage = this.currentPage > this.pageCount ? this.pageCount : this.currentPage;
			this.previousPage = this.currentPage - 1;
			this.nextPage = this.currentPage + 1;
			this.firstResult = (this.currentPage - 1) * this.pageSize;
			this.maxResults = this.pageSize;
			this.startRecord = this.firstResult + 1;
			this.endRecord = (this.currentPage * this.pageSize) < this.recordCount ? this.currentPage * this.pageSize : this.recordCount;
			this.firstPage = this.currentPage == 1;
			this.lastPage = this.currentPage == this.pageCount;

			this.args.put("firstResult", this.firstResult);
			this.args.put("maxResults", this.maxResults);
			
			int perNum = 9;
			int perNum2 = (perNum - 1) / 2;
			int startPage = 0;
			int endPage = 0;
			if( this.pageCount <= perNum )
			{
				startPage = 1;
				endPage = this.pageCount;
			}
			else 
			{
				if( this.currentPage <= perNum2 )
				{
					startPage = 1;
					endPage = perNum;
				}
				else if( this.currentPage >= (this.pageCount - perNum2) )
				{
					startPage = this.pageCount - perNum2 - perNum2;
					endPage = this.pageCount;
				}
				else 
				{
					startPage = this.currentPage - perNum2;
					endPage  = this.currentPage + perNum2;
				}
			}
			this.pageNumList = new ArrayList<Integer>();
			for( int i = startPage; i <= endPage; i++ )
			{
				this.pageNumList.add(new Integer(i));
			}
		}
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<Map<String, Object>> getResultList() {
		return resultList;
	}

	public void setResultList(List<Map<String, Object>> resultList) {
		this.resultList = resultList;
	}

	public int getFirstResult() {
		return firstResult;
	}

	public void setFirstResult(int firstResult) {
		this.firstResult = firstResult;
	}

	public int getMaxResults() {
		return maxResults;
	}

	public void setMaxResults(int maxResults) {
		this.maxResults = maxResults;
	}

	public List<Integer> getPageNumList() {
		return pageNumList;
	}

	public void setPageNumList(List<Integer> pageNumList) {
		this.pageNumList = pageNumList;
	}

	public int getStartRecord() {
		return startRecord;
	}

	public void setStartRecord(int startRecord) {
		this.startRecord = startRecord;
	}

	public int getEndRecord() {
		return endRecord;
	}

	public void setEndRecord(int endRecord) {
		this.endRecord = endRecord;
	}

	public boolean isFirstPage() {
		return firstPage;
	}

	public void setFirstPage(boolean firstPage) {
		this.firstPage = firstPage;
	}

	public boolean isLastPage() {
		return lastPage;
	}

	public void setLastPage(boolean lastPage) {
		this.lastPage = lastPage;
	}

	public Map<String, Object> getArgs() {
		return args;
	}

	public void setArgs(Map<String, Object> args) {
		this.args = args;
	}
}
