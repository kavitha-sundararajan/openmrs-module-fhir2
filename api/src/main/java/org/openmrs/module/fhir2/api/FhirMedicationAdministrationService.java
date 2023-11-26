package org.openmrs.module.fhir2.api;

import ca.uhn.fhir.rest.api.server.IBundleProvider;
import org.hl7.fhir.r4.model.MedicationAdministration;
import org.openmrs.module.fhir2.api.search.param.MedicationAdministrationSearchParams;

import javax.annotation.Nonnull;

public interface FhirMedicationAdministrationService extends FhirService<MedicationAdministration> {

    @Override
    MedicationAdministration get(@Nonnull String uuid);

    IBundleProvider searchForMedicationAdministration(MedicationAdministrationSearchParams medicationAdministrationSearchParams);
}