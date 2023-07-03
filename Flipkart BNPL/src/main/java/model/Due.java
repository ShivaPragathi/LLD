package model;

import model.enums.DueStatus;

import java.util.Date;

public class Due {
    public int amount;
    public DueStatus status;
    public Date clearingDate;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public DueStatus getStatus() {
        return status;
    }

    public void setStatus(DueStatus status) {
        this.status = status;
    }

    public Date getClearingDate() {
        return clearingDate;
    }

    public void setClearingDate(Date clearingDate) {
        this.clearingDate = clearingDate;
    }
}
