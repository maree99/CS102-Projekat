/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.entity;

import java.io.Serializable;
import java.util.List;
public class Client implements Serializable {

    private Integer id;
    private String fullName;
    private String email;
    private String telephone;
    private List<Reservation> reservationList;
    private List<User> userList;

    public Client() {
    }

    public Client(String fullName, String email, String telephone) {
        this.fullName = fullName;
        this.email = email;
        this.telephone = telephone;
    }

    public Client(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    
}
