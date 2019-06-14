/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2019 Databases and Information Systems Research Group, University of Basel, Switzerland
 *
 * Permission is hereby granted, free of charge, to any person obtaining a
 * copy of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package ch.unibas.dmi.dbis.polyphenydb.jdbc;


import java.util.Properties;
import org.apache.calcite.avatica.AvaticaConnection;
import org.apache.calcite.avatica.AvaticaFactory;
import org.apache.calcite.avatica.UnregisteredDriver;


/**
 * Extension of {@link org.apache.calcite.avatica.AvaticaFactory} for Polypheny-DB.
 */
public abstract class PolyphenyDbJdbcFactory implements AvaticaFactory {

    private final int major;
    private final int minor;


    /**
     * Creates a JDBC factory with given major/minor version number.
     *
     * @param major JDBC major version
     * @param minor JDBC minor version
     */
    protected PolyphenyDbJdbcFactory( final int major, final int minor ) {
        this.major = major;
        this.minor = minor;
    }


    public int getJdbcMajorVersion() {
        return major;
    }


    public int getJdbcMinorVersion() {
        return minor;
    }


    public abstract AvaticaConnection newConnection( UnregisteredDriver driver, AvaticaFactory factory, String url, Properties info );

}