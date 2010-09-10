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

package org.nabucco.framework.mda.model.java.ast.comparator;

import java.util.Comparator;

import org.eclipse.jdt.internal.compiler.classfmt.ClassFileConstants;

/**
 * ModifiersComparator
 * 
 * @author Thomas Annen, PRODYNA AG
 */
public enum ModifiersComparator implements Comparator<Integer> {
    PUBLIC_MODIFIER(ClassFileConstants.AccPublic),
    PRIVATE_MODIFIER(ClassFileConstants.AccPrivate),
    STATIC_MODIFIER(ClassFileConstants.AccStatic),
    FINAL_MODIFIER(ClassFileConstants.AccFinal);

    private int modifier = 0;

    private ModifiersComparator(int modifier) {
        this.modifier = modifier;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
     */
    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1 == null || o2 == null) {
            throw new IllegalArgumentException("Given values musn't be null.");
        }

        boolean modifierExist1 = (o1 & modifier) > 0;
        boolean modifierExist2 = (o2 & modifier) > 0;

        if (modifierExist1 && modifierExist2) {
            return 0;
        }
        if (modifierExist1) {
            return 1;
        }
        if (modifierExist2) {
            return -1;
        }

        return 0;
    }
}