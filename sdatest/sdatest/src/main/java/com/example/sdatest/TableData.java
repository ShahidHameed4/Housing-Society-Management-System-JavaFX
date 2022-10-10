package com.example.sdatest;

import javafx.beans.property.SimpleStringProperty;
public class TableData {

        SimpleStringProperty data1=new SimpleStringProperty();
        SimpleStringProperty data2=new SimpleStringProperty();
        SimpleStringProperty data3=new SimpleStringProperty();
        SimpleStringProperty data4=new SimpleStringProperty();;
        SimpleStringProperty data5=new SimpleStringProperty();;

    public String getData1() {
        return data1.get();
    }

    public SimpleStringProperty data1Property() {
        return data1;
    }

    public void setData1(String data1) {
        this.data1.set(data1);
    }

    public String getData2() {
        return data2.get();
    }

    public SimpleStringProperty data2Property() {
        return data2;
    }

    public void setData2(String data2) {
        this.data2.set(data2);
    }

    public String getData3() {
        return data3.get();
    }

    public SimpleStringProperty data3Property() {
        return data3;
    }

    public void setData3(String data3) {
        this.data3.set(data3);
    }

    public String getData4() {
        return data4.get();
    }

    public SimpleStringProperty data4Property() {
        return data4;
    }

    public void setData4(String data4) {
        this.data4.set(data4);
    }

    public String getData5() {
        return data5.get();
    }

    public SimpleStringProperty data5Property() {
        return data5;
    }

    public void setData5(String data5) {
        this.data5.set(data5);
    }

    TableData(String data1, String data2, String data3, String data4) {
        this.data1 = new SimpleStringProperty(data1);
        this.data2 = new SimpleStringProperty(data2);
        this.data3 = new SimpleStringProperty(data3);
        this.data4 = new SimpleStringProperty(data4);
    }
    TableData(String data1, String data2, String data3, String data4, String data5) {
        this.data1 = new SimpleStringProperty(data1);
        this.data2 = new SimpleStringProperty(data2);
        this.data3 = new SimpleStringProperty(data3);
        this.data4 = new SimpleStringProperty(data4);
        this.data5=  new SimpleStringProperty(data5);
    }

    TableData(String data1, String data2) {
        this.data1 = new SimpleStringProperty(data1);
        this.data2 = new SimpleStringProperty(data2);
    }


}
