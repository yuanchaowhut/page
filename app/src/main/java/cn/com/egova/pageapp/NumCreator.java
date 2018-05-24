package cn.com.egova.pageapp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuanchao on 2018/5/24.
 */

public class NumCreator {
    public static int totalPage = 20;
    public static int currentPage = 0;
    public static int totalRecord = 385;
    public static int currentRecord = 20;
    public static int numPerPage = 20;


    public static List<Integer> create(int page) {
        List<Integer> list = new ArrayList<>();
        int startNum = (page - 1) * numPerPage;    //包括
        int endNum = 0;                            //不包括
        if(startNum + numPerPage <= totalRecord){
            endNum = startNum + numPerPage;
        }else{
            endNum = totalRecord;
        }
        currentPage = page;
        currentRecord = endNum - startNum;

        for (int i = startNum; i < endNum; i++) {
            list.add(i);
        }
        return list;
    }
}
