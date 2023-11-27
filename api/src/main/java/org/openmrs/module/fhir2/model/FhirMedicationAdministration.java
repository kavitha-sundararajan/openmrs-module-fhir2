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
import java.util.Set;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.openmrs.BaseOpenmrsMetadata;

@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Entity
@Table(name = "fhir_medication_administration")
public class FhirMedicationAdministration extends BaseOpenmrsMetadata {
	
	// Based on https://www.hl7.org/fhir/task.html v4.0.1
	public enum MedicationAdministrationStatus {
		IN_PROGRESS,
		ON_HOLD,
		STOPPED,
		COMPLETED,
		NOT_DONE,
		ENTERED_IN_ERROR,
		UNKNOWN
	}
	
	private static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "medication_administration_id")
	private Integer id;
	
	/**
	 * The current status of the medication administration. Will generally be set to show that the
	 * administration has been completed. For some long running administrations such as infusions, it is
	 * possible for an administration to be started but not completed or it may be paused while some
	 * other process is under way.
	 */
	@Column(name = "status", nullable = false)
	@Enumerated(EnumType.STRING)
	private MedicationAdministrationStatus status;

	/**
	 * A specific date/time or interval of time during which the administration took place (or did not take place,
	 * when the 'notGiven' attribute is true). For many administrations, such as swallowing a tablet the use of
	 * dateTime is more appropriate.
	 */
	@Column(name = "effective_date_time", nullable = false)
	private Date effectiveDateTime;
	
	/**
	 * Identifies the medication that was administered. This is either a link to a resource representing
	 * the details of the medication or a simple attribute carrying a code that identifies the
	 * medication from a known list of medications.
	 */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "medication_reference_id", referencedColumnName = "reference_id")
	private FhirReference medicationReference;
	
	/**
	 * The person or animal or group receiving the medication.
	 */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "subject_reference_id", referencedColumnName = "reference_id")
	private FhirReference subjectReference;
	
	/**
	 * Indicates who or what performed the medication administration and how they were involved.
	 */
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "medication_administration_id")
	private Set<FhirMedicationAdministrationPerformer> performer;
	
	/**
	 * The original request, instruction or authority to perform the administration.
	 */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "request_reference_id", referencedColumnName = "reference_id")
	private FhirReference requestReference;
	
	/**
	 * Describes the medication dosage information details e.g. dose, rate, site, route, etc.
	 */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "dosage_id", referencedColumnName = "dosage_id")
	private FhirMedicationAdministrationDosage dosage;
	
	/**
	 * Extra information about the medication administration that is not conveyed by the other
	 * attributes.
	 */
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "medication_administration_id")
	private Set<FhirAnnotation> note;
	
}
