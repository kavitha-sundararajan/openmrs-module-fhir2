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

import org.hl7.fhir.r4.model.Annotation;
import org.openmrs.module.fhir2.model.FhirAnnotation;

import javax.annotation.Nonnull;

public interface AnnotationTranslator extends OpenmrsFhirTranslator<FhirAnnotation, Annotation> {

    /**
     * Maps an {@link FhirAnnotation} to a {@link Annotation}
     * resource
     *
     * @param fhirAnnotation the OpenMRS drugOrder to translate
     * @return the corresponding FHIR resource
     */
    @Override
    Annotation toFhirResource(@Nonnull FhirAnnotation fhirAnnotation);

    /**
     * Maps a {@link Annotation} medicationAdministration to an existing
     * {@link FhirAnnotation}
     *
     * @param annotation the medicationAdministration to map
     * @return an updated version of the existingDrugOrder
     */
    @Override
    FhirAnnotation toOpenmrsType(@Nonnull Annotation annotation);
}
