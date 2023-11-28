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

import static org.apache.commons.lang3.Validate.notNull;
import static org.openmrs.module.fhir2.api.translators.impl.FhirTranslatorUtils.getLastUpdated;
import static org.openmrs.module.fhir2.api.translators.impl.FhirTranslatorUtils.getVersionId;

import javax.annotation.Nonnull;

import java.util.stream.Collectors;

import lombok.AccessLevel;
import lombok.Setter;
import org.hl7.fhir.r4.model.DateTimeType;
import org.hl7.fhir.r4.model.MedicationAdministration;
import org.openmrs.module.fhir2.api.translators.AnnotationTranslator;
import org.openmrs.module.fhir2.api.translators.MedicationAdministrationDosageTranslator;
import org.openmrs.module.fhir2.api.translators.MedicationAdministrationPerformerTranslator;
import org.openmrs.module.fhir2.api.translators.MedicationAdministrationStatusTranslator;
import org.openmrs.module.fhir2.api.translators.MedicationAdministrationTranslator;
import org.openmrs.module.fhir2.api.translators.ReferenceTranslator;
import org.openmrs.module.fhir2.model.FhirMedicationAdministration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Setter(AccessLevel.PACKAGE)
public class MedicationAdministrationTranslatorImpl extends BaseReferenceHandlingTranslator implements MedicationAdministrationTranslator {
	
	@Autowired
	private MedicationAdministrationStatusTranslator statusTranslator;
	
	@Autowired
	private ReferenceTranslator referenceTranslator;
	
	@Autowired
	private MedicationAdministrationPerformerTranslator performerTranslator;
	
	@Autowired
	private MedicationAdministrationDosageTranslator dosageTranslator;
	
	@Autowired
	private AnnotationTranslator annotationTranslator;
	
	@Override
	public MedicationAdministration toFhirResource(@Nonnull FhirMedicationAdministration fhirMedicationAdministration) {
		notNull(fhirMedicationAdministration, "The FhirMedicationAdministration object should not be null");
		
		MedicationAdministration medicationAdministration = new MedicationAdministration();
		medicationAdministration.setId(fhirMedicationAdministration.getUuid());
		medicationAdministration.setEffective(new DateTimeType(fhirMedicationAdministration.getEffectiveDateTime()));
		medicationAdministration.setStatus(statusTranslator.toFhirResource(fhirMedicationAdministration.getStatus()));
		medicationAdministration
		        .setSubject(referenceTranslator.toFhirResource(fhirMedicationAdministration.getSubjectReference()));
		
		if (fhirMedicationAdministration.getPerformer() != null && !fhirMedicationAdministration.getPerformer().isEmpty()) {
			medicationAdministration.setPerformer(fhirMedicationAdministration.getPerformer().stream()
			        .map(performerTranslator::toFhirResource).filter(obj -> obj != null).collect(Collectors.toList()));
		}
		
		medicationAdministration
		        .setRequest(referenceTranslator.toFhirResource(fhirMedicationAdministration.getRequestReference()));
		medicationAdministration.setDosage(dosageTranslator.toFhirResource(fhirMedicationAdministration.getDosage()));
		
		if (fhirMedicationAdministration.getNote() != null && !fhirMedicationAdministration.getNote().isEmpty()) {
			medicationAdministration.setNote(fhirMedicationAdministration.getNote().stream()
			        .map(annotationTranslator::toFhirResource).filter(obj -> obj != null).collect(Collectors.toList()));
		}
		
		medicationAdministration.getMeta().setLastUpdated(getLastUpdated(fhirMedicationAdministration));
		medicationAdministration.getMeta().setVersionId(getVersionId(fhirMedicationAdministration));
		
		return medicationAdministration;
	}
	
	@Override
	public FhirMedicationAdministration toOpenmrsType(@Nonnull MedicationAdministration medicationAdministration) {
		notNull(medicationAdministration, "The MedicationAdministration object should not be null");
		return toOpenmrsType(new FhirMedicationAdministration(), medicationAdministration);
	}
	
	@Override
	public FhirMedicationAdministration toOpenmrsType(
	        @Nonnull FhirMedicationAdministration existingFhirMedicationAdministration,
	        @Nonnull MedicationAdministration medicationAdministration) {
		notNull(existingFhirMedicationAdministration, "The existing DrugOrder object should not be null");
		notNull(medicationAdministration, "The MedicationAdministration object should not be null");
		
		if (medicationAdministration.hasId()) {
			existingFhirMedicationAdministration.setUuid(medicationAdministration.getIdElement().getIdPart());
		}
		
		if (medicationAdministration.hasEffectiveDateTimeType()) {
			existingFhirMedicationAdministration
			        .setEffectiveDateTime(medicationAdministration.getEffectiveDateTimeType().getValue());
		}
		
		if (medicationAdministration.hasStatus()) {
			existingFhirMedicationAdministration
			        .setStatus(statusTranslator.toOpenmrsType(medicationAdministration.getStatus()));
		}
		
		existingFhirMedicationAdministration
		        .setSubjectReference(referenceTranslator.toOpenmrsType(medicationAdministration.getSubject()));
		if (medicationAdministration.getPerformer() != null && !medicationAdministration.getPerformer().isEmpty()) {
			existingFhirMedicationAdministration.setPerformer(medicationAdministration.getPerformer().stream()
			        .map(performerTranslator::toOpenmrsType).filter(obj -> obj != null).collect(Collectors.toSet()));
		}
		
		existingFhirMedicationAdministration
		        .setRequestReference(referenceTranslator.toOpenmrsType(medicationAdministration.getRequest()));
		existingFhirMedicationAdministration.setDosage(dosageTranslator.toOpenmrsType(medicationAdministration.getDosage()));
		
		if (medicationAdministration.getNote() != null && !medicationAdministration.getNote().isEmpty()) {
			existingFhirMedicationAdministration.setNote(medicationAdministration.getNote().stream()
			        .map(annotationTranslator::toOpenmrsType).filter(obj -> obj != null).collect(Collectors.toSet()));
		}
		
		return existingFhirMedicationAdministration;
		
	}
}
