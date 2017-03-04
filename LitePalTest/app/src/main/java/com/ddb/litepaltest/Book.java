package com.ddb.litepaltest;

import org.litepal.crud.DataSupport;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by deepin on 17-3-4.
 */

@Getter@Setter
public class Book extends DataSupport {
    private int id;
    private String author;
    private double price;
    private int pages;
    private String name;
    private String press;
}
