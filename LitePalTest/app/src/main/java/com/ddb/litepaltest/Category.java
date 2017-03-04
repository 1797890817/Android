package com.ddb.litepaltest;

import org.litepal.crud.DataSupport;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by deepin on 17-3-4.
 */
@Getter@Setter
public class Category extends DataSupport{
    private int id;
    private String categoryName;
    private int categoryCode;
}
