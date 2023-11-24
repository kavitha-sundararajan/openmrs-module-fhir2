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

import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.openmrs.BaseOpenmrsMetadata;
import org.openmrs.Concept;

/**
 * FHIR MedicationAdministration.dosage -
 * https://hl7.org/fhir/R4/medicationadministration-definitions.html#MedicationAdministration.dosage
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Entity
@Table(name = "fhir_medication_administration_dosage")
public class FhirMedicationAdministrationDosage extends BaseOpenmrsMetadata {
	
	private static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "dosage_id")
	private Integer id;
	
	@Column(name = "text")
	private String text;
	
	@OneToOne
	@JoinColumn(name = "site", referencedColumnName = "concept_id", nullable = false)
	private Concept site;
	
	@OneToOne
	@JoinColumn(name = "route", referencedColumnName = "concept_id", nullable = false)
	private Concept route;
	
}
