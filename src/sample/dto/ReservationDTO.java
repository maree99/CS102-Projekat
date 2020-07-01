package sample.dto;

public class ReservationDTO {

    private String startDate;
    private String endDate;
    private String client;
    private String bikeBrandTitle;
    private Integer id;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getBike() {
        return bikeBrandTitle;
    }

    public void setBike(String bikeBrandTitle) {
        this.bikeBrandTitle = bikeBrandTitle;
    }


    public ReservationDTO() {
    }

}
