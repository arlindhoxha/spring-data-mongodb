package com.ah.customer.entity;

/**
 * Created by Arlind Hoxha on 9/24/2018.
 */
public class CustomerResponse {

    private boolean status;
    private String message;
    private Customer[] customers;

    public CustomerResponse() {}

    public CustomerResponse(boolean status, String message, Customer[] customers) {
        this.status = status;
        this.message = message;
        this.customers = customers;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Customer[] getCustomers() {
        return customers;
    }

    public void setCustomers(Customer[] customers) {
        this.customers = customers;
    }
}
