package com.smart.domain;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {

    private int orderId;

    private double payment;

    private int paymentType;

    private int paymentStatus;

    private Date createTime;


    private Date paymentTime;

    private int userId;

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public void setPaymentType(int paymentType) {
        this.paymentType = paymentType;
    }

    public void setCreateTime(Date createtime) {
        this.createTime = createtime;
    }

    public void setPaymentStatus(int paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }


    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getPayment() {
        return payment;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getPaymentType() {
        return paymentType;
    }

    public int getPaymentStatus() {
        return paymentStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public int getUserId() {
        return userId;
    }
}
