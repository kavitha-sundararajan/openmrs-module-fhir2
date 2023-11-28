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
import org.openmrs.module.fhir2.api.translators.ConceptTranslator;
import org.openmrs.module.fhir2.api.translators.MedicationAdministrationDosageTranslator;
import org.openmrs.module.fhir2.model.FhirMedicationAdministrationDosage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Setter(AccessLevel.PACKAGE)
public class MedicationAdministrationDosageTranslatorImpl implements MedicationAdministrationDosageTranslator {
	
	@Autowired
	private ConceptTranslator conceptTranslator;
	
	@Override
	public MedicationAdministration.MedicationAdministrationDosageComponent toFhirResource(
	        @Nonnull FhirMedicationAdministrationDosage fhirMedicationAdministrationDosage) {
		MedicationAdministration.MedicationAdministrationDosageComponent dosageComponent = null;
		
		if (fhirMedicationAdministrationDosage != null) {
			dosageComponent = new MedicationAdministration.MedicationAdministrationDosageComponent();
			dosageComponent.setText(fhirMedicationAdministrationDosage.getText());
			dosageComponent.setSite(conceptTranslator.toFhirResource(fhirMedicationAdministrationDosage.getSite()));
			dosageComponent.setRoute(conceptTranslator.toFhirResource(fhirMedicationAdministrationDosage.getRoute()));
		}
		
		return dosageComponent;
	}
	
	@Override
	public FhirMedicationAdministrationDosage toOpenmrsType(
	        @Nonnull MedicationAdministration.MedicationAdministrationDosageComponent medicationAdministrationDosage) {
		FhirMedicationAdministrationDosage dosage = null;
		
		if (medicationAdministrationDosage != null) {
			dosage = new FhirMedicationAdministrationDosage();
			dosage.setText(medicationAdministrationDosage.getText());
			dosage.setSite(conceptTranslator.toOpenmrsType(medicationAdministrationDosage.getSite()));
			dosage.setRoute(conceptTranslator.toOpenmrsType(medicationAdministrationDosage.getRoute()));
		}
		
		return dosage;
	}
}
