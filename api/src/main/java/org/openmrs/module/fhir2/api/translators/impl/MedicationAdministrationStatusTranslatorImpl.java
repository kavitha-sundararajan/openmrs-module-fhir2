/*
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.fhir2.api.translators.impl;

import javax.annotation.Nonnull;

import lombok.AccessLevel;
import lombok.Setter;
import org.hl7.fhir.r4.model.MedicationAdministration;
import org.openmrs.module.fhir2.api.translators.MedicationAdministrationStatusTranslator;
import org.openmrs.module.fhir2.model.FhirMedicationAdministration;
import org.springframework.stereotype.Component;

@Component
@Setter(AccessLevel.PACKAGE)
public class MedicationAdministrationStatusTranslatorImpl implements MedicationAdministrationStatusTranslator {
	
	@Override
	public MedicationAdministration.MedicationAdministrationStatus toFhirResource(
	        @Nonnull FhirMedicationAdministration.MedicationAdministrationStatus fhirMedicationAdministrationStatus) {
		if (fhirMedicationAdministrationStatus == null) {
			return null;
		}
		
		if (fhirMedicationAdministrationStatus
		        .equals(FhirMedicationAdministration.MedicationAdministrationStatus.IN_PROGRESS)) {
			return MedicationAdministration.MedicationAdministrationStatus.INPROGRESS;
		} else if (fhirMedicationAdministrationStatus
		        .equals(FhirMedicationAdministration.MedicationAdministrationStatus.ON_HOLD)) {
			return MedicationAdministration.MedicationAdministrationStatus.ONHOLD;
		} else if (fhirMedicationAdministrationStatus
		        .equals(FhirMedicationAdministration.MedicationAdministrationStatus.COMPLETED)) {
			return MedicationAdministration.MedicationAdministrationStatus.COMPLETED;
		} else if (fhirMedicationAdministrationStatus
		        .equals(FhirMedicationAdministration.MedicationAdministrationStatus.STOPPED)) {
			return MedicationAdministration.MedicationAdministrationStatus.STOPPED;
		} else if (fhirMedicationAdministrationStatus
		        .equals(FhirMedicationAdministration.MedicationAdministrationStatus.UNKNOWN)) {
			return MedicationAdministration.MedicationAdministrationStatus.UNKNOWN;
		} else if (fhirMedicationAdministrationStatus
		        .equals(FhirMedicationAdministration.MedicationAdministrationStatus.NOT_DONE)) {
			return MedicationAdministration.MedicationAdministrationStatus.NOTDONE;
		} else if (fhirMedicationAdministrationStatus
		        .equals(FhirMedicationAdministration.MedicationAdministrationStatus.ENTERED_IN_ERROR)) {
			return MedicationAdministration.MedicationAdministrationStatus.ENTEREDINERROR;
		}
		return MedicationAdministration.MedicationAdministrationStatus.NULL;
	}
	
	@Override
	public FhirMedicationAdministration.MedicationAdministrationStatus toOpenmrsType(
	        @Nonnull MedicationAdministration.MedicationAdministrationStatus medicationAdministrationStatus) {
		if (medicationAdministrationStatus == null) {
			return null;
		}
		
		if (medicationAdministrationStatus.equals(MedicationAdministration.MedicationAdministrationStatus.INPROGRESS)) {
			return FhirMedicationAdministration.MedicationAdministrationStatus.IN_PROGRESS;
		} else if (medicationAdministrationStatus.equals(MedicationAdministration.MedicationAdministrationStatus.ONHOLD)) {
			return FhirMedicationAdministration.MedicationAdministrationStatus.ON_HOLD;
		} else if (medicationAdministrationStatus
		        .equals(MedicationAdministration.MedicationAdministrationStatus.COMPLETED)) {
			return FhirMedicationAdministration.MedicationAdministrationStatus.COMPLETED;
		} else if (medicationAdministrationStatus.equals(MedicationAdministration.MedicationAdministrationStatus.STOPPED)) {
			return FhirMedicationAdministration.MedicationAdministrationStatus.STOPPED;
		} else if (medicationAdministrationStatus.equals(MedicationAdministration.MedicationAdministrationStatus.UNKNOWN)) {
			return FhirMedicationAdministration.MedicationAdministrationStatus.UNKNOWN;
		} else if (medicationAdministrationStatus.equals(MedicationAdministration.MedicationAdministrationStatus.NOTDONE)) {
			return FhirMedicationAdministration.MedicationAdministrationStatus.NOT_DONE;
		} else if (medicationAdministrationStatus
		        .equals(MedicationAdministration.MedicationAdministrationStatus.ENTEREDINERROR)) {
			return FhirMedicationAdministration.MedicationAdministrationStatus.ENTERED_IN_ERROR;
		}
		return FhirMedicationAdministration.MedicationAdministrationStatus.UNKNOWN;
	}
}
