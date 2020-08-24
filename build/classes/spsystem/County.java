/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spsystem;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Uğur
 */
@Entity
@Table(name = "county", catalog = "placement", schema = "")
@NamedQueries({
    @NamedQuery(name = "County.findAll", query = "SELECT c FROM County c")
    , @NamedQuery(name = "County.findByCountyID", query = "SELECT c FROM County c WHERE c.countyID = :countyID")
    , @NamedQuery(name = "County.findByCityID", query = "SELECT c FROM County c WHERE c.cityID = :cityID")
    , @NamedQuery(name = "County.findByCountyName", query = "SELECT c FROM County c WHERE c.countyName = :countyName")})
public class County implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "county_ID")
    private Integer countyID;
    @Basic(optional = false)
    @Column(name = "city_ID")
    private int cityID;
    @Basic(optional = false)
    @Column(name = "county_name")
    private String countyName;

    public County() {
    }

    public County(Integer countyID) {
        this.countyID = countyID;
    }

    public County(Integer countyID, int cityID, String countyName) {
        this.countyID = countyID;
        this.cityID = cityID;
        this.countyName = countyName;
    }

    public Integer getCountyID() {
        return countyID;
    }

    public void setCountyID(Integer countyID) {
        Integer oldCountyID = this.countyID;
        this.countyID = countyID;
        changeSupport.firePropertyChange("countyID", oldCountyID, countyID);
    }

    public int getCityID() {
        return cityID;
    }

    public void setCityID(int cityID) {
        int oldCityID = this.cityID;
        this.cityID = cityID;
        changeSupport.firePropertyChange("cityID", oldCityID, cityID);
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        String oldCountyName = this.countyName;
        this.countyName = countyName;
        changeSupport.firePropertyChange("countyName", oldCountyName, countyName);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (countyID != null ? countyID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof County)) {
            return false;
        }
        County other = (County) object;
        if ((this.countyID == null && other.countyID != null) || (this.countyID != null && !this.countyID.equals(other.countyID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "student.placement.system.County[ countyID=" + countyID + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
