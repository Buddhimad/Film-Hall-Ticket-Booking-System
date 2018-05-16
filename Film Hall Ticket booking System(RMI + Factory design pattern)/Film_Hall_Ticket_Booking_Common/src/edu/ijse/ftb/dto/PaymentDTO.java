package edu.ijse.ftb.dto;

import java.io.Serializable;

public class PaymentDTO  extends SuperDTO{
    private String pid;
    private double amount;
    private PaymentDTO paymentdto;

    public PaymentDTO() {
    }

    public PaymentDTO(String pid, double amount) {
        this.pid = pid;
        this.amount = amount;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public PaymentDTO getPaymentdto() {
        return paymentdto;
    }

    public void setPaymentdto(PaymentDTO paymentdto) {
        this.paymentdto = paymentdto;
    }

   
    
    
    
}
