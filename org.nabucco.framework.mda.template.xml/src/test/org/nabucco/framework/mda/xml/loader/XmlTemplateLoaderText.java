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
package org.nabucco.framework.mda.xml.loader;

import org.junit.Test;
import org.nabucco.framework.mda.template.xml.provider.XmlTemplateFileProvider;

/**
 * XmlTemplateLoaderText
 * 
 * @author Silas Schwarz PRODYNA AG
 */
public class XmlTemplateLoaderText {

    @Test
    public void testXmlJavaTemplateFromDir() throws Exception {
        XmlTemplateFileProvider xmlTemplateFileProvider = new XmlTemplateFileProvider(
                "conf/test/data");

        // source path relative to conf/test/data

        // testfolder1/test.java
        xmlTemplateFileProvider.provideTemplate("test");
        // testfolder1/test.zip/test2.java
        xmlTemplateFileProvider.provideTemplate("test2");
        // testfolder2/depth1/depth2/test3.java
        xmlTemplateFileProvider.provideTemplate("test3");
        // testfolder2/depth1/depth2/archive.zip/depth3/test4.java
        xmlTemplateFileProvider.provideTemplate("test4");
        // testfolder2/depth1/sample.jar/testinjar.java
        xmlTemplateFileProvider.provideTemplate("testinjar");
        // testfolder2/depth1/sample2.jar/folder/injarinfolder.java
        xmlTemplateFileProvider.provideTemplate("injarinfolder");
    }

    @Test
    public void testXmlJavaTemplateFromZip() throws Exception {
        XmlTemplateFileProvider xmlTemplateFileProvider = new XmlTemplateFileProvider(
                "conf/test/data.zip");
        // source path relative to conf/test/data.zip

        // testfolder1/test.java
        xmlTemplateFileProvider.provideTemplate("test");
        // testfolder2/depth1/depth2/test3.java
        xmlTemplateFileProvider.provideTemplate("test3");
    }

}
