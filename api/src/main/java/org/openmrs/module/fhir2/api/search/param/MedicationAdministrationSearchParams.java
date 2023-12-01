/*
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.fhir2.api.search.param;

import java.util.HashSet;

import ca.uhn.fhir.model.api.Include;
import ca.uhn.fhir.rest.param.DateParam;
import ca.uhn.fhir.rest.param.DateRangeParam;
import ca.uhn.fhir.rest.param.ReferenceAndListParam;
import ca.uhn.fhir.rest.param.TokenAndListParam;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.openmrs.module.fhir2.FhirConstants;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MedicationAdministrationSearchParams extends BaseResourceSearchParams {
	
	private ReferenceAndListParam patientReference;
	
	private ReferenceAndListParam supportingInfoReference;
	
	private ReferenceAndListParam performerReference;
	
	private ReferenceAndListParam medicationReference;
	
	private TokenAndListParam status;
	
	private DateParam effectiveDate;
	
	@Builder
	public MedicationAdministrationSearchParams(ReferenceAndListParam patientReference,
	    ReferenceAndListParam supportingInfoReference, ReferenceAndListParam performerReference,
	    ReferenceAndListParam medicationReference, TokenAndListParam id, TokenAndListParam status, DateParam effectiveDate,
	    DateRangeParam lastUpdated, HashSet<Include> includes, HashSet<Include> revIncludes) {
		
		super(id, lastUpdated, null, includes, revIncludes);
		
		this.patientReference = patientReference;
		this.supportingInfoReference = supportingInfoReference;
		this.performerReference = performerReference;
		this.medicationReference = medicationReference;
		this.effectiveDate = effectiveDate;
		this.status = status;
	}
	
	@Override
	public SearchParameterMap toSearchParameterMap() {
		return baseSearchParameterMap().addParameter(FhirConstants.PATIENT_REFERENCE_SEARCH_HANDLER, getPatientReference())
		        .addParameter(FhirConstants.MEDICATION_REFERENCE_SEARCH_HANDLER, getMedicationReference())
		        .addParameter(FhirConstants.STATUS_SEARCH_HANDLER, getStatus());
	}
}
