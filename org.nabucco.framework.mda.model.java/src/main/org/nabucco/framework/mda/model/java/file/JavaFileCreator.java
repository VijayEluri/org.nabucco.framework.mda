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
package org.nabucco.framework.mda.model.java.file;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import org.nabucco.framework.mda.logger.MdaLogger;
import org.nabucco.framework.mda.logger.MdaLoggingFactory;
import org.nabucco.framework.mda.model.MdaModel;
import org.nabucco.framework.mda.model.ModelException;
import org.nabucco.framework.mda.model.file.MdaFileCreator;
import org.nabucco.framework.mda.model.java.JavaCompilationUnit;
import org.nabucco.framework.mda.model.java.JavaModel;
import org.nabucco.framework.mda.model.java.JavaModelException;

/**
 * JavaFileCreator
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public final class JavaFileCreator extends MdaFileCreator<JavaModel> {

    private static MdaLogger logger = MdaLoggingFactory.getInstance().getLogger(
            JavaFileCreator.class);

    private String formatterConfigFile;

    /**
     * Constructs a new {@link JavaFileCreator} instance.
     * 
     * @param model
     *            the java model to create files for.
     * @param rootDir
     *            the root directory
     */
    public JavaFileCreator(MdaModel<JavaModel> model, String rootDir, String formatterFile) {
        super(model, rootDir);

        this.formatterConfigFile = formatterFile;
    }

    @Override
    protected synchronized void createConcreteFiles() throws JavaModelException {

        JavaModel model = super.getModel();
        JavaCodeFormatter codeFormatter = new JavaCodeFormatter();

        for (JavaCompilationUnit unit : model.getUnitList()) {

            String name = unit.getFileName();
            String path = this.getPath(unit);
            String formattedCode = codeFormatter.formatCode(unit.getUnitDeclaration(),
                    this.formatterConfigFile);

            try {
                boolean noChange = super.compareFileContent(path + name, formattedCode);

                if (!noChange) {
                    this.createFile(name, path, formattedCode);
                } else {
                    logger.debug("Java file already exists: ", path, name);
                }
            } catch (JavaModelException jme) {
                logger.error("Java file ", name, " cannot be created.");
                throw jme;
            } catch (ModelException me) {
                logger.error("Java file ", name, " cannot be created.");
                throw new JavaModelException("Error creating Java file '" + name + "'.", me);
            } catch (Exception e) {
                logger.error("Java file ", name, " cannot be created.");
                throw new JavaModelException("Error creating Java file '" + name + "'.", e);
            }

        }
    }

    /**
     * Retrieve the file path depending on the package declartion of the comilation unit.
     * 
     * @param unit
     *            the java compilation unit
     * 
     * @return the file path
     * 
     * @throws JavaModelException
     *             when the compilation unit is not valid
     */
    private String getPath(JavaCompilationUnit unit) throws JavaModelException {
        StringBuilder path = new StringBuilder();
        path.append(super.getRootDir());
        path.append(File.separatorChar);
        path.append(unit.getProjectName());
        path.append(File.separatorChar);
        path.append(unit.getSourceFolder());
        path.append(File.separatorChar);
        path.append(unit.getPackage());
        return path.toString();
    }

    /**
     * Creates or updates the java file.
     * 
     * @param fileName
     *            the file name
     * @param path
     *            the file path
     * @param content
     *            the file content
     * 
     * @throws JavaModelException
     *             when the file cannot be saved
     */
    private void createFile(String fileName, String path, String content) throws JavaModelException {

        PrintWriter writer;

        File file = new File(path);
        file.mkdirs();
        file = new File(path + fileName);

        boolean exists = file.exists();
        
        try {
            writer = new PrintWriter(file);
        } catch (IOException e) {
            logger.error("Java file ", fileName, " cannot be created.");
            throw new JavaModelException("Error creating Java file '" + fileName + "'.", e);
        }

        writer.print(content);
        writer.flush();
        writer.close();

        if (!exists) {
            logger.info("Java file created: ", fileName);
        } else {
            logger.info("Java file updated: ", fileName);
        }
        super.getFileList().add(file);
    }

}
