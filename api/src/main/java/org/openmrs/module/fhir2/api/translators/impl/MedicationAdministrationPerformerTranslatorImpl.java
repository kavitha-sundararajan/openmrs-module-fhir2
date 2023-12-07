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
import org.openmrs.module.fhir2.api.translators.MedicationAdministrationPerformerTranslator;
import org.openmrs.module.fhir2.api.translators.ReferenceTranslator;
import org.openmrs.module.fhir2.model.FhirMedicationAdministrationPerformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Setter(AccessLevel.PACKAGE)
public class MedicationAdministrationPerformerTranslatorImpl implements MedicationAdministrationPerformerTranslator {
	
	@Autowired
	private ReferenceTranslator referenceTranslator;
	
	@Autowired
	private ConceptTranslator conceptTranslator;
	
	@Override
	public MedicationAdministration.MedicationAdministrationPerformerComponent toFhirResource(
	        @Nonnull FhirMedicationAdministrationPerformer fhirMedicationAdministrationPerformer) {
		MedicationAdministration.MedicationAdministrationPerformerComponent performerComponent = null;
		
		if (fhirMedicationAdministrationPerformer != null) {
			performerComponent = new MedicationAdministration.MedicationAdministrationPerformerComponent();
			performerComponent
			        .setActor(referenceTranslator.toFhirResource(fhirMedicationAdministrationPerformer.getActorReference()));
			performerComponent
			        .setFunction(conceptTranslator.toFhirResource(fhirMedicationAdministrationPerformer.getFunction()));
		}
		
		return performerComponent;
	}
	
	@Override
	public FhirMedicationAdministrationPerformer toOpenmrsType(
	        @Nonnull MedicationAdministration.MedicationAdministrationPerformerComponent medicationAdministrationPerformer) {
		FhirMedicationAdministrationPerformer performer = null;
		
		if (medicationAdministrationPerformer != null) {
			performer = new FhirMedicationAdministrationPerformer();
			performer.setActorReference(referenceTranslator.toOpenmrsType(medicationAdministrationPerformer.getActor()));
			performer.setFunction(conceptTranslator.toOpenmrsType(medicationAdministrationPerformer.getFunction()));
		}
		
		return performer;
	}
	
}
