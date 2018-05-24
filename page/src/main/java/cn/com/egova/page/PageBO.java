package cn.com.egova.page;

/**
 * Created by yuanchao on 2018/5/10.
 */

public class PageBO {

    /**
     * totalPage : 8
     * currentPage : 1
     * totalRecord : 798
     * currentRecord : 100
     * numPerPage : 100
     */

    private int totalPage;
    private int currentPage;
    private int totalRecord;
    private int currentRecord;
    private int numPerPage;

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public void setCurrentRecord(int currentRecord) {
        this.currentRecord = currentRecord;
    }

    public void setNumPerPage(int numPerPage) {
        this.numPerPage = numPerPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public int getCurrentRecord() {
        return currentRecord;
    }

    public int getNumPerPage() {
        return numPerPage;
    }
}
