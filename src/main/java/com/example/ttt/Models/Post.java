package com.example.ttt.Models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID guid;
    private String vehicleType, marque, modell, engine, status, dateInsert, datePurchase;
    private int enginePowerBhp, topSpeedMph, costUsd, price;

    public Post(){
    }

    public Post(String vehicleType, String marque, String modell, String engine, int enginePowerBhp, int topSpeedMph,String datePurchase, int costUsd, int price) {
        this.vehicleType=vehicleType;
        this.marque=marque;
        this.modell=modell;
        this.engine=engine;
        this.enginePowerBhp=enginePowerBhp;
        this.topSpeedMph=topSpeedMph;
        this.datePurchase=datePurchase;
        this.costUsd=costUsd;
        this.price=price;
    }




    public UUID getUuid() {
        return guid;
    }

    public void setUuid(UUID guid) {
        this.guid = guid;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public int getEnginePowerBhp() {
        return enginePowerBhp;
    }

    public void setEnginePowerBhp(int enginePowerBhp) {
        this.enginePowerBhp = enginePowerBhp;
    }

    public int getTopSpeedMph() {
        return topSpeedMph;
    }

    public void setTopSpeedMph(int topSpeedMph) {
        this.topSpeedMph = topSpeedMph;
    }

    public int getCostUsd() {
        return costUsd;
    }

    public void setCostUsd(int costUsd) {
        this.costUsd = costUsd;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDateInsert() {
        return dateInsert;
    }

    public void setDateInsert(String dateInsert) {
        this.dateInsert = dateInsert;
    }

    public String getDatePurchase() {
        return datePurchase;
    }

    public void setDatePurchase(String datePurchase) {
        this.datePurchase = datePurchase;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
