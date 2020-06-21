/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.entity;

import java.io.Serializable;
import java.util.List;

public class BikeBrand implements Serializable {

    private Integer id;
    private String title;
    private List<BikeModel> bikeModelList;

    public BikeBrand() {
    }

    public BikeBrand(String title) {
        this.title = title;
    }

    public BikeBrand(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<BikeModel> getBikeModelList() {
        return bikeModelList;
    }

    public void setBikeModelList(List<BikeModel> bikeModelList) {
        this.bikeModelList = bikeModelList;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BikeBrand)) {
            return false;
        }
        BikeBrand other = (BikeBrand) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return title;
    }
}
