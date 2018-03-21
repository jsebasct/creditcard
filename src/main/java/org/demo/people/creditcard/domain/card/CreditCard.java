package org.demo.people.creditcard.domain.card;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.time.LocalDate;
import java.util.Objects;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value=PERECard.class, name = "pere"),
        @JsonSubTypes.Type(value=SCOCard.class, name = "sco"),
        @JsonSubTypes.Type(value=SQUACard.class, name = "squa")
})
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

    public CreditCard(CardBrand brand, Long number, String cardHolder, LocalDate expirationDate) {
        this.brand = brand;
        this.number = number;
        this.cardHolder = cardHolder;
        this.expirationDate = expirationDate;
    }

    public abstract CardBrand getBrand();

    public void setBrand(CardBrand brand) {
        this.brand = brand;
    }

    public abstract double serviceFee();


    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setNumber(Long number) {
        this.number = number;
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

    @Override
    public String toString() {
        return getBrand()+"Card{" +
                "brand='" + this.getBrand() + '\'' +
                ", number=" + this.getNumber() +
                ", cardHolder='" + getCardHolder() + '\'' +
                ", expirationDate=" + getExpirationDate() +
                '}';
    }
}
