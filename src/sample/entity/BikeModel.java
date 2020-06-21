/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.entity;

import java.io.Serializable;
import java.util.List;
public class BikeModel implements Serializable {

    private Integer id;
    private String title;
    private BikeBrand idBikeBrand;
    private List<Vehicle> vehicleList;

    public BikeModel() {
    }

    public BikeModel(Integer id) {
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

    public BikeBrand getIdCarBrand() {
        return idBikeBrand;
    }

    public void setIdCarBrand(BikeBrand idCarBrand) {
        this.idBikeBrand = idBikeBrand;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BikeModel)) {
            return false;
        }
        BikeModel other = (BikeModel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
}
