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

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.openmrs.Auditable;
import org.openmrs.Concept;
import org.openmrs.User;

/**
 * FHIR MedicationAdministration.dosage -
 * https://hl7.org/fhir/R4/medicationadministration-definitions.html#MedicationAdministration.dosage
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Entity
@Table(name = "fhir_medication_administration_dosage")
public class FhirMedicationAdministrationDosage implements Auditable {
	
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
