package springboot.web.dto;

import lombok.Getter;

@Getter
public class PageMaker {

    private Pagination page;
    private int totalCount;
    private int startPage;
    private int endPage;
    private boolean prev;
    private boolean next;
    private int displayPageNum = 5;

    public Pagination getPage() {
        return page;
    }
    public void setPage(Pagination cri) {
        this.page = cri;
    }
    public int getTotalCount() {
        return totalCount;
    }
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        calcData();
    }

    private void calcData() {

        endPage = (int) (Math.ceil(page.getPage() / (double) displayPageNum) * displayPageNum);

        startPage = (endPage - displayPageNum) + 1;
        if(startPage <= 0) startPage = 1;

        int tempEndPage = (int) (Math.ceil(totalCount / (double) page.getPerPageNum()));
        if (endPage > tempEndPage) {
            endPage = tempEndPage;
        }

        prev = startPage == 1 ? false : true;
        next = endPage * page.getPerPageNum() < totalCount ? true : false;

    }

}
