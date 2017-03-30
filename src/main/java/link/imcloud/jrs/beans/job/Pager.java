package link.imcloud.jrs.beans.job;

import link.imcloud.jrs.beans.IBeanOperation;

import java.util.List;

/**
 * Created by 44247 on 2016/11/20 0020.
 */
public class Pager extends IBeanOperation{
    private int pageSize = 10;

    private int pageNum = 1;

    private int pageCount;

    private long total;

    private List result;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageCount() {
        if(total>0){
            pageCount = (int)(total%pageSize>0?total/pageSize+1:total/pageSize);
        }
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List getResult() {
        return result;
    }

    public void setResult(List result) {
        this.result = result;
    }
}

