package org.brapi.test.BrAPITestServer.model.entity.pheno;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;

@Entity
@Table(name="observation_variable_context")
public class ObservationVariableContextEntity extends BrAPIBaseEntity {
	@Column
	private String observationVariableDbId;
	@Column
	private String context;
	
	public String getObservationVariableDbId() {
		return observationVariableDbId;
	}
	public void setObservationVariableDbId(String observationVariableDbId) {
		this.observationVariableDbId = observationVariableDbId;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
}