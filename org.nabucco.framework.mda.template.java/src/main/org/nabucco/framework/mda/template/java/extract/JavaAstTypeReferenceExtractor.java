/*
 * Copyright 2012 PRODYNA AG
 *
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco.org/License.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.nabucco.framework.mda.template.java.extract;

import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.nabucco.framework.mda.template.java.JavaTemplateException;

/**
 * JavaAstTypeReferenceExtractor
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public interface JavaAstTypeReferenceExtractor {

    /**
     * Extracts and copies a {@link TypeReference}.
     * 
     * @param typeReference
     *            the {@link TypeReference}
     * 
     * @return the copied {@link TypeReference}
     * 
     * @throws JavaTemplateException
     */
    <T extends TypeReference> T extractTypeReference(T typeReference) throws JavaTemplateException;

    /**
     * Extracts and copies an array of {@link TypeReference}.
     * 
     * @param typeReferences
     *            the array of {@link TypeReference}
     * 
     * @return the extracted {@link TypeReference} array.
     * 
     * @throws JavaTemplateException
     */
    TypeReference[] extractTypeReferences(TypeReference[] typeReferences)
            throws JavaTemplateException;

}
