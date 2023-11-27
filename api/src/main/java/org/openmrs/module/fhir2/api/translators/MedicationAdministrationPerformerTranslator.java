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
import org.openmrs.module.fhir2.model.FhirMedicationAdministrationPerformer;

import javax.annotation.Nonnull;

public interface MedicationAdministrationPerformerTranslator extends OpenmrsFhirTranslator<FhirMedicationAdministrationPerformer, MedicationAdministration.MedicationAdministrationPerformerComponent> {

    /**
     * Maps an {@link FhirMedicationAdministrationPerformer} to a {@link MedicationAdministration.MedicationAdministrationPerformerComponent}
     * resource
     *
     * @param fhirMedicationAdministrationPerformer the OpenMRS drugOrder to translate
     * @return the corresponding FHIR resource
     */
    @Override
    MedicationAdministration.MedicationAdministrationPerformerComponent toFhirResource(@Nonnull FhirMedicationAdministrationPerformer fhirMedicationAdministrationPerformer);

    /**
     * Maps a {@link MedicationAdministration} medicationAdministration to an existing
     * {@link FhirMedicationAdministration}
     *
     * @param medicationAdministrationPerformer the medicationAdministration to map
     * @return an updated version of the existingDrugOrder
     */
    @Override
    FhirMedicationAdministrationPerformer toOpenmrsType(@Nonnull MedicationAdministration.MedicationAdministrationPerformerComponent medicationAdministrationPerformer);

}
