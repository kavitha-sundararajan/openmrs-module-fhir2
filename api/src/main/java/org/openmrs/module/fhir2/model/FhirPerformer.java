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

import java.util.Date;
import java.util.UUID;

import lombok.*;
import org.openmrs.Auditable;
import org.openmrs.Concept;
import org.openmrs.User;

/**
 * FHIR MedicationAdministration.dosage -
 * https://hl7.org/fhir/R4/medicationadministration-definitions.html#MedicationAdministration.performer
 */
@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class FhirPerformer implements Auditable {
	
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
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "creator", updatable = false)
	protected User creator;
	
	@Column(name = "date_created", nullable = false, updatable = false)
	private Date dateCreated;
	
	@ManyToOne
	@JoinColumn(name = "changed_by")
	private User changedBy;
	
	@Column(name = "date_changed")
	private Date dateChanged;
	
	@Column(name = "uuid", unique = true, nullable = false, length = 36)
	private String uuid = UUID.randomUUID().toString();
	
}
