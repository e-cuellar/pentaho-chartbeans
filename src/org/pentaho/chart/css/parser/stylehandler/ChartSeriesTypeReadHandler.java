/*!
* This program is free software; you can redistribute it and/or modify it under the
* terms of the GNU Lesser General Public License, version 2.1 as published by the Free Software
* Foundation.
*
* You should have received a copy of the GNU Lesser General Public License along with this
* program; if not, you can obtain a copy at http://www.gnu.org/licenses/old-licenses/lgpl-2.1.html
* or from the Free Software Foundation, Inc.,
* 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
*
* This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
* without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
* See the GNU Lesser General Public License for more details.
*
* Copyright (c) 2002-2013 Pentaho Corporation..  All rights reserved.
*/

package org.pentaho.chart.css.parser.stylehandler;

import org.pentaho.chart.css.styles.ChartSeriesType;
import org.pentaho.reporting.libraries.css.parser.stylehandler.OneOfConstantsReadHandler;

/**
 * The style parser for the <code>-x-pentaho-chart-series-type</code> style.
 *
 * @author Ravi Hasija
 */
public class ChartSeriesTypeReadHandler extends OneOfConstantsReadHandler {
  public ChartSeriesTypeReadHandler() {
    super(false);
    addValue(ChartSeriesType.BAR);
    addValue(ChartSeriesType.LINE);
    addValue(ChartSeriesType.PIE);
    addValue(ChartSeriesType.AREA);
    addValue(ChartSeriesType.MULTI);
    addValue(ChartSeriesType.DIAL);
   
  }
}
