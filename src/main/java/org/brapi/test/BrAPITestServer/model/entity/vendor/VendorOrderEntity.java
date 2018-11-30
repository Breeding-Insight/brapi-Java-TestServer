package org.brapi.test.BrAPITestServer.model.entity.vendor;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BaseEntity;
import org.brapi.test.BrAPITestServer.model.entity.SampleEntity;

@Entity
@Table(name="plate")
public class VendorOrderEntity extends BaseEntity{
	@Column
    private String clientPlateDbId;
	@Column
    private String clientPlateBarcode;
	@Column
    private String sampleSubmissionFormat;
	@Column
    private Date statusTimeStamp;
	@OneToMany(mappedBy="plate", cascade = CascadeType.ALL)
    private List<SampleEntity> samples;
	@OneToMany(mappedBy="plateDbId")
	private List<VendorFileEntity> files;
	
	
	public String getClientPlateDbId() {
		return clientPlateDbId;
	}
	public void setClientPlateDbId(String clientPlateDbId) {
		this.clientPlateDbId = clientPlateDbId;
	}
	public String getClientPlateBarcode() {
		return clientPlateBarcode;
	}
	public void setClientPlateBarcode(String clientPlateBarcode) {
		this.clientPlateBarcode = clientPlateBarcode;
	}
	public String getSampleSubmissionFormat() {
		return sampleSubmissionFormat;
	}
	public void setSampleSubmissionFormat(String sampleSubmissionFormat) {
		this.sampleSubmissionFormat = sampleSubmissionFormat;
	}
	public Date getStatusTimeStamp() {
		return statusTimeStamp;
	}
	public void setStatusTimeStamp(Date statusTimeStamp) {
		this.statusTimeStamp = statusTimeStamp;
	}
	public List<SampleEntity> getSamples() {
		return samples;
	}
	public void setSamples(List<SampleEntity> samples) {
		this.samples = samples;
	}
	public List<VendorFileEntity> getFiles() {
		return files;
	}
	public void setFiles(List<VendorFileEntity> files) {
		this.files = files;
	}
	
	
}