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

import lombok.*;
import org.openmrs.BaseOpenmrsMetadata;
import org.openmrs.Concept;

import javax.persistence.*;

/**
 * FHIR MedicationAdministration.dosage -
 * https://hl7.org/fhir/R4/medicationadministration-definitions.html#MedicationAdministration.dosage
 */
@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class FhirPerformer extends BaseOpenmrsMetadata {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "performer_id")
	protected Integer id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "actor_reference_id", referencedColumnName = "reference_id", nullable = false)
	protected FhirReference actorReference;

	@OneToOne
	@JoinColumn(name = "function", referencedColumnName = "concept_id")
	protected Concept function;
	
}
