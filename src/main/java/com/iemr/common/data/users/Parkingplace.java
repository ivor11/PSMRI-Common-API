/*
* AMRIT – Accessible Medical Records via Integrated Technology 
* Integrated EHR (Electronic Health Records) Solution 
*
* Copyright (C) "Piramal Swasthya Management and Research Institute" 
*
* This file is part of AMRIT.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see https://www.gnu.org/licenses/.
*/
package com.iemr.common.data.users;

import java.sql.Date;

import com.google.gson.annotations.Expose;
import com.iemr.common.data.location.Country;
import com.iemr.common.data.location.DistrictBlock;
import com.iemr.common.data.location.DistrictBranchMapping;
import com.iemr.common.data.location.Districts;
import com.iemr.common.data.location.States;
import com.iemr.common.utils.mapper.OutputMapper;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Table(name = "m_parkingplace")
@Data
public class Parkingplace
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name = "ParkingPlaceID")
	private Integer parkingPlaceID;

	@Expose
	@Column(name = "ParkingPlaceName")
	private String parkingPlaceName;

	@Expose
	@Column(name = "ParkingPlaceDesc")
	private String parkingPlaceDesc;

	@Expose
	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapID;
	@Expose
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(updatable = false, insertable = false, name = "ProviderServiceMapID")
	private ProviderServiceMapping m_providerServiceMapping;

	@Expose
	@Column(name = "CountryID")
	private Integer countryID;
	@Expose
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(updatable = false, insertable = false, name = "countryID")
	private Country m_country;
	@Expose
	@Transient
	String countryName;

	@Expose
	@Column(name = "StateID")
	private Integer stateID;
	@Expose
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(updatable = false, insertable = false, name = "stateID")
	private States state;
	@Expose
	@Transient
	String stateName;

	@Expose
	@Column(name = "DistrictID")
	private Integer districtID;
	@Expose
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(updatable = false, insertable = false, name = "districtID")
	private Districts m_district;
	@Expose
	@Transient
	String districtName;

	@Expose
	@Column(name = "DistrictBlockID")
	private Integer districtBlockID;
	@Expose
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(updatable = false, insertable = false, name = "districtBlockID")
	private DistrictBlock districtBlock;
	@Expose
	@Transient
	String blockName;

	@Expose
	@Column(name = "DistrictBranchID")
	private Integer districtBranchID;
	@Expose
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(updatable = false, insertable = false, name = "districtBranchID")
	private DistrictBranchMapping districtBranchMapping;
	@Expose
	@Transient
	String villageName;

	@Expose
	@Column(name = "AreaHQAddress")
	private String areaHQAddress;

	@Expose
	@Column(name = "Deleted", insertable = false, updatable = true)
	private Boolean deleted;
	@Expose
	@Column(name = "Processed", insertable = false, updatable = true)
	private String processed;
	@Expose
	@Column(name = "CreatedBy")
	private String createdBy;
	@Expose
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Date createdDate;
	@Expose
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	@Expose
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Date lastModDate;

	public Parkingplace getDefaultConstructor()
	{
		return this;
	}

	public Parkingplace getParkingPlace(Integer parkingPlaceID, String parkingPlaceName, String parkingPlaceDesc,
			String areaHQAddress, Integer providerServiceMapID, Boolean deleted, Integer countryID, String countryName,
			Integer stateID, String stateName, Integer districtID, String districtName, Integer districtBlockID,
			String blockName, Integer districtBranchID, String villageName,
			ProviderServiceMapping m_providerServiceMapping, Integer serviceID, String serviceName)
	{
		this.parkingPlaceID = parkingPlaceID;
		this.parkingPlaceName = parkingPlaceName;
		this.parkingPlaceDesc = parkingPlaceDesc;
		this.providerServiceMapID = providerServiceMapID;
		this.m_providerServiceMapping = m_providerServiceMapping;
		this.countryID = countryID;
		this.countryName = countryName;
		this.stateID = stateID;
		this.stateName = stateName;
		this.districtID = districtID;
		this.districtName = districtName;
		this.districtBlockID = districtBlockID;
		this.blockName = blockName;
		this.districtBranchID = districtBranchID;
		this.villageName = villageName;
		this.areaHQAddress = areaHQAddress;
		this.deleted = deleted;
		return this;
	}

	public String getParkingPlaceName()
	{
		return parkingPlaceName;
	}

	public void setParkingPlaceName(String parkingPlaceName)
	{
		this.parkingPlaceName = parkingPlaceName;
	}

	public String getParkingPlaceDesc()
	{
		return parkingPlaceDesc;
	}

	public void setParkingPlaceDesc(String parkingPlaceDesc)
	{
		this.parkingPlaceDesc = parkingPlaceDesc;
	}

	public Integer getProviderServiceMapID()
	{
		return providerServiceMapID;
	}

	public void setProviderServiceMapID(Integer providerServiceMapID)
	{
		this.providerServiceMapID = providerServiceMapID;
	}

	// public ProviderServiceMapping getM_providerServiceMapping()
	// {
	// return m_providerServiceMapping;
	// }
	//
	// public void setM_providerServiceMapping(ProviderServiceMapping m_providerServiceMapping) {
	// this.m_providerServiceMapping = m_providerServiceMapping;
	// }

	public Integer getCountryID()
	{
		return countryID;
	}

	public void setCountryID(Integer countryID)
	{
		this.countryID = countryID;
	}

	// public Country getM_country() {
	// return m_country;
	// }
	//
	// public void setM_country(Country m_country) {
	// this.m_country = m_country;
	// }

	public String getCountryName()
	{
		return countryName;
	}

	public void setCountryName(String countryName)
	{
		this.countryName = countryName;
	}

	public Integer getStateID()
	{
		return stateID;
	}

	public void setStateID(Integer stateID)
	{
		this.stateID = stateID;
	}

	public States getState()
	{
		return state;
	}

	public void setState(States state)
	{
		this.state = state;
	}

	public String getStateName()
	{
		return stateName;
	}

	public void setStateName(String stateName)
	{
		this.stateName = stateName;
	}

	public Integer getDistrictID()
	{
		return districtID;
	}

	public void setDistrictID(Integer districtID)
	{
		this.districtID = districtID;
	}

	// public Districts getM_district()
	// {
	// return m_district;
	// }
	//
	// public void setM_district(Districts m_district)
	// {
	// this.m_district = m_district;
	// }

	public String getDistrictName()
	{
		return districtName;
	}

	public void setDistrictName(String districtName)
	{
		this.districtName = districtName;
	}

	public Integer getDistrictBlockID()
	{
		return districtBlockID;
	}

	public void setDistrictBlockID(Integer districtBlockID)
	{
		this.districtBlockID = districtBlockID;
	}

	public DistrictBlock getDistrictBlock()
	{
		return districtBlock;
	}

	public void setDistrictBlock(DistrictBlock districtBlock)
	{
		this.districtBlock = districtBlock;
	}

	public String getBlockName()
	{
		return blockName;
	}

	public void setBlockName(String blockName)
	{
		this.blockName = blockName;
	}

	public Integer getDistrictBranchID()
	{
		return districtBranchID;
	}

	public void setDistrictBranchID(Integer districtBranchID)
	{
		this.districtBranchID = districtBranchID;
	}

	public DistrictBranchMapping getDistrictBranchMapping()
	{
		return districtBranchMapping;
	}

	public void setDistrictBranchMapping(DistrictBranchMapping districtBranchMapping)
	{
		this.districtBranchMapping = districtBranchMapping;
	}

	public String getVillageName()
	{
		return villageName;
	}

	public void setVillageName(String villageName)
	{
		this.villageName = villageName;
	}

	public String getAreaHQAddress()
	{
		return areaHQAddress;
	}

	public void setAreaHQAddress(String areaHQAddress)
	{
		this.areaHQAddress = areaHQAddress;
	}

	public Boolean getDeleted()
	{
		return deleted;
	}

	public void setDeleted(Boolean deleted)
	{
		this.deleted = deleted;
	}

	public String getProcessed()
	{
		return processed;
	}

	public void setProcessed(String processed)
	{
		this.processed = processed;
	}

	public String getCreatedBy()
	{
		return createdBy;
	}

	public void setCreatedBy(String createdBy)
	{
		this.createdBy = createdBy;
	}

	public Date getCreatedDate()
	{
		return createdDate;
	}

	public void setCreatedDate(Date createdDate)
	{
		this.createdDate = createdDate;
	}

	public String getModifiedBy()
	{
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy)
	{
		this.modifiedBy = modifiedBy;
	}

	public Date getLastModDate()
	{
		return lastModDate;
	}

	public void setLastModDate(Date lastModDate)
	{
		this.lastModDate = lastModDate;
	}

	public Integer getParkingPlaceID()
	{
		return parkingPlaceID;
	}

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString()
	{
		return OutputMapper.gson().toJson(this);
	}

}
