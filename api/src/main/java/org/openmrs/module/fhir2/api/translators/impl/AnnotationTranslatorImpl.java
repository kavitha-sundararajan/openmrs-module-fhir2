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

import javax.annotation.Nonnull;

import lombok.AccessLevel;
import lombok.Setter;
import org.hl7.fhir.r4.model.Annotation;
import org.openmrs.module.fhir2.api.translators.AnnotationTranslator;
import org.openmrs.module.fhir2.api.translators.ReferenceTranslator;
import org.openmrs.module.fhir2.model.FhirAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Setter(AccessLevel.PACKAGE)
public class AnnotationTranslatorImpl implements AnnotationTranslator {
	
	@Autowired
	private ReferenceTranslator referenceTranslator;
	
	@Override
	public Annotation toFhirResource(@Nonnull FhirAnnotation fhirAnnotation) {
		Annotation annotation = null;
		
		if (fhirAnnotation != null) {
			annotation = new Annotation();
			annotation.setText(fhirAnnotation.getText());
			annotation.setAuthor(referenceTranslator.toFhirResource(fhirAnnotation.getAuthorReference()));
			annotation.setTime(fhirAnnotation.getDateCreated());
		}
		
		return annotation;
	}
	
	@Override
	public FhirAnnotation toOpenmrsType(@Nonnull Annotation annotation) {
		FhirAnnotation fhirAnnotation = null;
		
		if (annotation != null) {
			fhirAnnotation = new FhirAnnotation();
			fhirAnnotation.setText(annotation.getText());
			//fhirAnnotation.setAuthorReference(referenceTranslator.toOpenmrsType(annotation.getAuthorReference()));
			fhirAnnotation.setDateCreated(annotation.getTime());
		}
		
		return fhirAnnotation;
	}
}
