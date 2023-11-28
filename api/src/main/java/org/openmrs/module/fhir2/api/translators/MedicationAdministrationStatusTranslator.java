/*
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.fhir2.api.translators;

import javax.annotation.Nonnull;

import org.hl7.fhir.r4.model.MedicationAdministration;
import org.openmrs.module.fhir2.model.FhirMedicationAdministration;

public interface MedicationAdministrationStatusTranslator extends OpenmrsFhirTranslator<FhirMedicationAdministration.MedicationAdministrationStatus, MedicationAdministration.MedicationAdministrationStatus> {

    /**
     * Maps an {@link org.openmrs.module.fhir2.model.FhirMedicationAdministration} to a {@link MedicationAdministration.MedicationAdministrationStatus}
     * resource
     *
     * @param fhirMedicationAdministrationStatus the OpenMRS drugOrder to translate
     * @return the corresponding FHIR resource
     */
    @Override
    MedicationAdministration.MedicationAdministrationStatus toFhirResource(@Nonnull FhirMedicationAdministration.MedicationAdministrationStatus fhirMedicationAdministrationStatus);

    /**
     * Maps a {@link MedicationAdministration} medicationAdministration to an existing
     * {@link FhirMedicationAdministration}
     *
     * @param medicationAdministrationStatus the medicationAdministration to map
     * @return an updated version of the existingDrugOrder
     */
    @Override
    FhirMedicationAdministration.MedicationAdministrationStatus toOpenmrsType(@Nonnull MedicationAdministration.MedicationAdministrationStatus medicationAdministrationStatus);

}
