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
package com.iemr.common.data.helpline104history;

import java.sql.Date;
import java.sql.Timestamp;

import com.google.gson.annotations.Expose;
import com.iemr.common.data.location.Districts;
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
@Data
@Table(name="T_BloodRequest")
public class T_BloodRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	private Long bloodReqID;
	@Expose
	private String requestID;
	@Expose
	@Column(name = "BenCallID")
	private Long benCallID;
	@Expose
	private Long beneficiaryRegID;
	@Expose
	private Long recipientBeneficiaryID;
	@Expose
	private String recipientName;
	@Expose
	private Integer recipientAge;
	@Expose
	private Short recipientGenderID;
	@Expose
	private String typeOfRequest;
	@Expose
	private Integer bloodGroupID;
	@Expose
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(updatable = false, insertable = false, name = "bloodGroupID")
	private M_BloodGroup m_bloodGroup;
	@Expose
	private Integer componentTypeID;
	@Expose
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(updatable = false, insertable = false, name = "componentTypeID")
	private M_ComponentType m_componentType;

	@Expose
	private String unitRequired;
	@Expose
	private String hospitalAdmitted;
	@Expose
	private Integer districtID;
	@Expose
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(updatable = false, insertable = false, name = "districtID")
	private Districts m_district;
	@Expose
	private Boolean outboundNeeded;
	@Expose
	private Timestamp outboundDate;
	@Expose
	private String bloodBankAddress;
	@Expose
	private String bbPersonName;
	@Expose
	private String bbPersonDesignation;
	@Expose
	private String bbMobileNo;
	@Expose
	private String remarks;
	@Expose
	private String feedback;
	
	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapID;
	@Expose
	@Column(name = "CreatedDate", insertable=false, updatable=false)
	private Date createdDate;
	
	@Column(name = "Deleted", insertable = false, updatable = true)
	private Boolean deleted;
	
	@Transient
	private OutputMapper outputMapper = new OutputMapper();
	
	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}
}
