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
package org.nabucco.framework.mda.template;

import org.nabucco.framework.mda.model.ModelImplementation;

/**
 * MdaTemplate
 * 
 * @author Frank Ratschinski, PRODYNA AG
 */
public abstract class MdaTemplate<M extends ModelImplementation> {

    private M model;

    /**
     * Creates a new {@link MdaTemplate} instance.
     * 
     * @param model
     *            the model instance
     */
    public MdaTemplate(M model) {
        this.model = model;
    }

    /**
     * Getter for the model implementation
     * 
     * @return the model implementation
     */
    public M getModel() {
        return model;
    }

    /**
     * Setter for the model implementation
     * 
     * @param model
     */
    public void setModel(M model) {
        this.model = model;
    }

    /**
     * Extracts and copies the contained model implementation.
     * 
     * @return the copied model implementation
     * 
     * @throws MdaTemplateException
     */
    public abstract M extractModel() throws MdaTemplateException;

    /**
     * Copies an existing template.
     * 
     * @return the copied template
     * 
     * @throws MdaTemplateException
     */
    public abstract MdaTemplate<M> copyTemplate() throws MdaTemplateException;

}
