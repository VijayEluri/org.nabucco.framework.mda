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
package org.nabucco.framework.mda.model.text.confluence.ast;

import java.util.ArrayList;
import java.util.List;

import org.nabucco.framework.mda.model.text.confluence.ast.util.ConfluencePrintVisitor;

/**
 * ConfluenceComposite
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public abstract class ConfluenceComposite extends ConfluenceElement {

    private static final long serialVersionUID = 1L;

    private List<ConfluenceElement> children = new ArrayList<ConfluenceElement>();

    /**
     * Add an element to the child list.
     * 
     * @param element
     *            the element to add
     */
    public void addElement(ConfluenceElement element) {
        this.children.add(element);
    }

    /**
     * Getter for the children.
     * 
     * @return Returns the children.
     */
    public List<ConfluenceElement> getChildren() {
        return this.children;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        this.accept(new ConfluencePrintVisitor(), builder);
        return builder.toString();
    }
}
