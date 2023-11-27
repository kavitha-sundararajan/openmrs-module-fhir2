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

import org.hl7.fhir.r4.model.MedicationAdministration;
import org.openmrs.module.fhir2.model.FhirMedicationAdministration;
import org.openmrs.module.fhir2.model.FhirMedicationAdministrationDosage;
import org.openmrs.module.fhir2.model.FhirMedicationAdministrationPerformer;

import javax.annotation.Nonnull;

public interface MedicationAdministrationDosageTranslator extends OpenmrsFhirTranslator<FhirMedicationAdministrationDosage, MedicationAdministration.MedicationAdministrationDosageComponent> {

    /**
     * Maps an {@link FhirMedicationAdministrationDosage} to a {@link MedicationAdministration.MedicationAdministrationDosageComponent}
     * resource
     *
     * @param fhirMedicationAdministrationDosage the OpenMRS drugOrder to translate
     * @return the corresponding FHIR resource
     */
    @Override
    MedicationAdministration.MedicationAdministrationDosageComponent toFhirResource(@Nonnull FhirMedicationAdministrationDosage fhirMedicationAdministrationDosage);

    /**
     * Maps a {@link MedicationAdministration.MedicationAdministrationDosageComponent} medicationAdministration to an existing
     * {@link FhirMedicationAdministrationDosage}
     *
     * @param medicationAdministrationDosage the medicationAdministration to map
     * @return an updated version of the existingDrugOrder
     */
    @Override
    FhirMedicationAdministrationDosage toOpenmrsType(@Nonnull MedicationAdministration.MedicationAdministrationDosageComponent medicationAdministrationDosage);
}
