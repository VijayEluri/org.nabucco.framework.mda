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
package org.nabucco.framework.mda.template.java.extract.statement;

import org.nabucco.framework.mda.template.java.extract.JavaAstStatementExtractor;

/**
 * JavaAstStatementExtractorFactory
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class JavaAstStatementExtractorFactory {

    /**
     * Singleton instance.
     */
    private static JavaAstStatementExtractorFactory instance = new JavaAstStatementExtractorFactory();

    /**
     * Private constructor.
     */
    private JavaAstStatementExtractorFactory() {
    }

    /**
     * Singleton access.
     * 
     * @return the JavaAstStatementExtractorFactory instance.
     */
    public static JavaAstStatementExtractorFactory getInstance() {
        return instance;
    }

    /**
     * Returns a {@link JavaAstStatementExtractor} implementation instance.
     * 
     * @return a {@link JavaAstStatementExtractor} implementation instance.
     */
    public JavaAstStatementExtractor getJavaAstExpressionExtractor() {
        return JavaAstStatementExtractorImpl.getInstance();
    }

}