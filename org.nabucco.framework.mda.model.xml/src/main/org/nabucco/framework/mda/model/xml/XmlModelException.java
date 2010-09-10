/*
 * Copyright 2010 PRODYNA AG
 *
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco-source.org/nabucco-license.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.nabucco.framework.mda.model.xml;

import org.nabucco.framework.mda.model.ModelException;

/**
 * XmlModelException
 * 
 * @author Frank Ratschinski, PRODYNA AG
 */
public class XmlModelException extends ModelException {

    private static final long serialVersionUID = 1L;

    public XmlModelException() {
    }

    /**
     * @param message
     * @param throwable
     */
    public XmlModelException(String message, Throwable throwable) {
        super(message, throwable);
    }

    /**
     * @param messages
     */
    public XmlModelException(String messages) {
        super(messages);
    }

    /**
     * @param throwable
     */
    public XmlModelException(Throwable throwable) {
        super(throwable);
    }

}
