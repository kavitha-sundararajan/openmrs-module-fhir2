/*
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.fhir2.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.openmrs.BaseOpenmrsMetadata;
import org.openmrs.Concept;

import javax.persistence.*;

/**
 * FHIR MedicationAdministration.dosage -
 * https://hl7.org/fhir/R4/medicationadministration-definitions.html#MedicationAdministration.dosage
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@Entity
@Table(name = "fhir_medication_administration_performer")
public class FhirMedicationAdministrationPerformer extends FhirPerformer {
	
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "medication_administration_id", nullable = false)
	private FhirMedicationAdministration medicationAdministration;
	
}
