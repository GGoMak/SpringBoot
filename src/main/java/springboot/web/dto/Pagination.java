package springboot.web.dto;

import lombok.Getter;

@Getter
public class Pagination {

    private int page;
    private int perPageNum;

    private String searchType;
    private String keyword;

    public int getPageStart() {
        return (this.page-1)*perPageNum;
    }

    public Pagination() {
        this.page = 1;
        this.perPageNum = 10;
        this.searchType = "";
        this.keyword = "";
    }

    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        if(page <= 0) {
            this.page = 1;
        } else {
            this.page = page;
        }
    }
    public int getPerPageNum() {
        return perPageNum;
    }
    public void setPerPageNum(int pageCount) {
        int cnt = this.perPageNum;
        if(pageCount != cnt) {
            this.perPageNum = cnt;
        } else {
            this.perPageNum = pageCount;
        }
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public void setKeyword(String keyword){
        this.keyword = keyword;
    }
}

