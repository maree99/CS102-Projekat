package sample.dto;

public class VehicleDTO {
    private String bikeBrandTitle;
    private String bikeModelTitle;
    private Double power;
    private Double pricePerDay;
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBikeBrandTitle() {
        return bikeBrandTitle;
    }

    public void setBikeBrandTitle(String bikeBrandTitle) {
        this.bikeBrandTitle = bikeBrandTitle;
    }

    public String getBikeModelTitle() {
        return bikeModelTitle;
    }

    public void setBikeModelTitle(String bikeModelTitle) {
        this.bikeModelTitle = bikeModelTitle;
    }

    public Double getPower() {
        return power;
    }

    public void setPower(Double power) {
        this.power = power;
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public VehicleDTO() {
    }


}
