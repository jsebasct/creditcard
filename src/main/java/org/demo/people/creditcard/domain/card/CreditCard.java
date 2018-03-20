package org.demo.people.creditcard.domain.card;

import java.time.LocalDate;
import java.util.Objects;

public abstract class CreditCard {



    private CardBrand brand;
    private Long number;
    private String cardHolder;
    private LocalDate expirationDate;



    public CreditCard() {
    }

    public CreditCard(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public CreditCard(Long number, LocalDate expirationDate) {
        this(expirationDate);
        this.number = number;
    }


    public abstract CardBrand getBrand();

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



    public boolean isValidToOperate(LocalDate someDate) {
        return someDate.compareTo(this.getExpirationDate()) < 0;
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
