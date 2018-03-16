package org.demo.people.creditcard.domain;

import java.time.LocalDate;
import java.util.Objects;

public abstract class CreditCard {

    private String brand;
    private Long number;
    private String cardHolder;
    private LocalDate expirationDate;

    private static final Long LIMIT = 1000L;

    public CreditCard() {
    }

    public CreditCard(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public CreditCard(Long number, LocalDate expirationDate) {
        this.number = number;
        this.expirationDate = expirationDate;
    }

    public abstract String getBrand();

    public abstract double serviceFee();

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public Long getNumber() {
        return number;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    @Override
    public String toString() {
        return getBrand()+"Card{" +
                "brand='" + this.getBrand() + '\'' +
                ", number=" + this.getNumber() +
                ", cardHolder='" + getCardHolder() + '\'' +
                ", expirationDate=" + getExpirationDate() +
                '}';
    }

    public boolean isValidOperation(long amount) {
        return amount < LIMIT;
    }

    public boolean isValidToOperate(LocalDate now) {
        return now.compareTo(this.getExpirationDate()) < 0;
    }

    @Override
    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
        if (o == null)  return false;
        CreditCard that = (CreditCard) o;
        return Objects.equals(getBrand(), that.getBrand()) &&
                Objects.equals(getNumber(), that.getNumber());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getBrand(), getNumber());
    }
}
