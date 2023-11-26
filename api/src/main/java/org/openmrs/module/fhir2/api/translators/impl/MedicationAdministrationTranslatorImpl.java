/*
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.fhir2.api.translators.impl;

import lombok.AccessLevel;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.hl7.fhir.r4.model.*;
import org.openmrs.Encounter;
import org.openmrs.*;
import org.openmrs.module.fhir2.api.translators.*;
import org.openmrs.module.fhir2.model.FhirMedicationAdministration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;
import java.util.Collections;

import static org.apache.commons.lang3.Validate.notNull;
import static org.openmrs.module.fhir2.FhirConstants.OPENMRS_FHIR_EXT_MEDICATION_REQUEST_FULFILLER_STATUS;
import static org.openmrs.module.fhir2.api.translators.impl.FhirTranslatorUtils.getLastUpdated;
import static org.openmrs.module.fhir2.api.translators.impl.FhirTranslatorUtils.getVersionId;

@Component
@Setter(AccessLevel.PACKAGE)
public class MedicationAdministrationTranslatorImpl extends BaseReferenceHandlingTranslator implements MedicationAdministrationTranslator {

    @Autowired
    private MedicationAdministrationStatusTranslator statusTranslator;

    @Autowired
    private PractitionerReferenceTranslator<Provider> practitionerReferenceTranslator;

    @Autowired
    private MedicationRequestPriorityTranslator medicationRequestPriorityTranslator;

    @Autowired
    private MedicationReferenceTranslator medicationReferenceTranslator;

    @Autowired
    private EncounterReferenceTranslator<Encounter> encounterReferenceTranslator;

    @Autowired
    private PatientReferenceTranslator patientReferenceTranslator;

    @Autowired
    private ConceptTranslator conceptTranslator;

    @Autowired
    private DosageTranslator dosageTranslator;

    @Autowired
    private OrderIdentifierTranslator orderIdentifierTranslator;

    @Autowired
    private MedicationRequestDispenseRequestComponentTranslator medicationRequestDispenseRequestComponentTranslator;

    @Override
    public MedicationAdministration toFhirResource(@Nonnull FhirMedicationAdministration fhirMedicationAdministrationTranslatorImpl) {
        notNull(fhirMedicationAdministrationTranslatorImpl, "The FhirMedicationAdministrationTranslatorImpl object should not be null");

          MedicationAdministration medicationAdministration = new MedicationAdministration();
//        medicationAdministration.setId(drugOrder.getUuid());
//        medicationAdministration.setAuthoredOn(drugOrder.getDateCreated());
//        medicationAdministration.setStatus(statusTranslator.toFhirResource(drugOrder));
//
//        if (drugOrder.getDrug() != null) {
//            medicationAdministration.setMedication(medicationReferenceTranslator.toFhirResource(drugOrder.getDrug()));
//        } else {
//            CodeableConcept medicationConcept = conceptTranslator.toFhirResource(drugOrder.getConcept());
//            if (StringUtils.isNotBlank(drugOrder.getDrugNonCoded())) {
//                medicationConcept.setText(drugOrder.getDrugNonCoded());
//            }
//            medicationAdministration.setMedication(medicationConcept);
//        }
//
//        if (drugOrder.getUrgency() != null) {
//            medicationAdministration.setPriority(medicationRequestPriorityTranslator.toFhirResource(drugOrder.getUrgency()));
//        }
//        medicationAdministration.setRequester(practitionerReferenceTranslator.toFhirResource(drugOrder.getOrderer()));
//        medicationAdministration.setEncounter(encounterReferenceTranslator.toFhirResource(drugOrder.getEncounter()));
//        medicationAdministration.setSubject(patientReferenceTranslator.toFhirResource(drugOrder.getPatient()));
//
//        medicationAdministration.setIntent(MedicationRequest.MedicationRequestIntent.ORDER);
//        medicationAdministration.addNote(new Annotation().setText(drugOrder.getCommentToFulfiller()));
//        medicationAdministration.addReasonCode(conceptTranslator.toFhirResource(drugOrder.getOrderReason()));
//        medicationAdministration.addDosageInstruction(dosageTranslator.toFhirResource(drugOrder));
//
//        medicationAdministration.setDispenseRequest(medicationRequestDispenseRequestComponentTranslator.toFhirResource(drugOrder));
//
//        if (drugOrder.getPreviousOrder() != null
//                && (drugOrder.getAction() == Order.Action.DISCONTINUE || drugOrder.getAction() == Order.Action.REVISE)) {
//            medicationAdministration.setPriorPrescription(createOrderReference(drugOrder.getPreviousOrder())
//                    .setIdentifier(orderIdentifierTranslator.toFhirResource(drugOrder.getPreviousOrder())));
//        } else if (drugOrder.getPreviousOrder() != null && drugOrder.getAction() == Order.Action.RENEW) {
//            medicationAdministration.setBasedOn(Collections.singletonList(createOrderReference(drugOrder.getPreviousOrder())
//                    .setIdentifier(orderIdentifierTranslator.toFhirResource(drugOrder.getPreviousOrder()))));
//        }
//
//        if (drugOrder.getFulfillerStatus() != null) {
//            Extension extension = new Extension();
//            extension.setUrl(OPENMRS_FHIR_EXT_MEDICATION_REQUEST_FULFILLER_STATUS);
//            extension.setValue(new CodeType(drugOrder.getFulfillerStatus().toString()));
//            medicationAdministration.addExtension(extension);
//        }
//
//        medicationAdministration.getMeta().setLastUpdated(getLastUpdated(drugOrder));
//        medicationAdministration.getMeta().setVersionId(getVersionId(drugOrder));

        return medicationAdministration;
    }

    @Override
    public FhirMedicationAdministration toOpenmrsType(@Nonnull MedicationAdministration medicationAdministration) {
        notNull(medicationAdministration, "The MedicationAdministration object should not be null");
        return toOpenmrsType(new FhirMedicationAdministration(), medicationAdministration);
    }

    @Override
    public FhirMedicationAdministration toOpenmrsType(@Nonnull FhirMedicationAdministration existingFhirMedicationAdministration, @Nonnull MedicationAdministration medicationAdministration) {
//        notNull(existingDrugOrder, "The existing DrugOrder object should not be null");
//        notNull(medicationAdministration, "The MedicationAdministration object should not be null");
//
//        if (medicationAdministration.hasId()) {
//            existingDrugOrder.setUuid(medicationAdministration.getIdElement().getIdPart());
//        }
//
//        if (medicationAdministration.hasMedicationReference()) {
//            Drug drug = medicationReferenceTranslator.toOpenmrsType(medicationAdministration.getMedicationReference());
//            existingDrugOrder.setDrug(drug);
//        } else {
//            CodeableConcept codeableConcept = medicationAdministration.getMedicationCodeableConcept();
//            Concept concept = conceptTranslator.toOpenmrsType(codeableConcept);
//            existingDrugOrder.setConcept(concept);
//            if (codeableConcept.getText() != null) {
//                CodeableConcept referenceConcept = conceptTranslator.toFhirResource(concept);
//                if (!codeableConcept.getText().equals(referenceConcept.getText())) {
//                    existingDrugOrder.setDrugNonCoded(codeableConcept.getText());
//                }
//            }
//        }
//
//        if (medicationAdministration.getPriority() != null) {
//            existingDrugOrder.setUrgency(medicationRequestPriorityTranslator.toOpenmrsType(medicationAdministration.getPriority()));
//        }
//        existingDrugOrder.setOrderer(practitionerReferenceTranslator.toOpenmrsType(medicationAdministration.getRequester()));
//        existingDrugOrder.setEncounter(encounterReferenceTranslator.toOpenmrsType(medicationAdministration.getEncounter()));
//        existingDrugOrder.setPatient(patientReferenceTranslator.toOpenmrsType(medicationAdministration.getSubject()));
//
//        existingDrugOrder.setCommentToFulfiller(medicationAdministration.getNoteFirstRep().getText());
//        existingDrugOrder.setOrderReason(conceptTranslator.toOpenmrsType(medicationAdministration.getReasonCodeFirstRep()));
//        dosageTranslator.toOpenmrsType(existingDrugOrder, medicationAdministration.getDosageInstructionFirstRep());
//
//        medicationRequestDispenseRequestComponentTranslator.toOpenmrsType(existingDrugOrder,
//                medicationAdministration.getDispenseRequest());
//
//        if (medicationAdministration.getExtensionByUrl(OPENMRS_FHIR_EXT_MEDICATION_REQUEST_FULFILLER_STATUS) != null) {
//            if (!medicationAdministration.getExtensionByUrl(OPENMRS_FHIR_EXT_MEDICATION_REQUEST_FULFILLER_STATUS).getValue()
//                    .isEmpty()) {
//                existingDrugOrder.setFulfillerStatus(Order.FulfillerStatus
//                        .valueOf(medicationAdministration.getExtensionByUrl(OPENMRS_FHIR_EXT_MEDICATION_REQUEST_FULFILLER_STATUS)
//                                .getValue().toString().toUpperCase()));
//            } else {
//                existingDrugOrder.setFulfillerStatus(null);
//            }
//        }

        return existingFhirMedicationAdministration;

    }
}
