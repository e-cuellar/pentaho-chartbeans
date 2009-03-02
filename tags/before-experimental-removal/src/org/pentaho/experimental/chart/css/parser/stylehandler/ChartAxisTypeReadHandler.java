/*
 * Copyright 2007 Pentaho Corporation.  All rights reserved. 
 * This software was developed by Pentaho Corporation and is provided under the terms 
 * of the Mozilla Public License, Version 1.1, or any later version. You may not use 
 * this file except in compliance with the license. If you need a copy of the license, 
 * please go to http://www.mozilla.org/MPL/MPL-1.1.txt. The Original Code is the Pentaho 
 * BI Platform.  The Initial Developer is Pentaho Corporation.
 *
 * Software distributed under the Mozilla Public License is distributed on an "AS IS" 
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or  implied. Please refer to 
 * the license for the specific language governing your rights and limitations.
 *
 * Created 3/25/2008 
 * @author Ravi Hasija 
 */
package org.pentaho.experimental.chart.css.parser.stylehandler;

import java.util.HashMap;
import java.util.Map;

import org.pentaho.experimental.chart.css.keys.ChartStyleKeys;
import org.pentaho.reporting.libraries.css.model.StyleKey;
import org.pentaho.reporting.libraries.css.parser.CSSCompoundValueReadHandler;
import org.pentaho.reporting.libraries.css.values.CSSValue;
import org.w3c.css.sac.LexicalUnit;

/**
 * The style parser for the <code>-x-pentaho-chart-axis-type compound type</code> style.
 * This style comprises of three values (in given order): 
 *   -x-pentaho-chart-axis-type-dimension
 *   -x-pentaho-chart-axis-type-position
 *   -x-pentaho-chart-axis-type-order
 *   
 *   For eg: -x-pentaho-chart-axis-type: domain primary 1
 *           -x-pentaho-chart-axis-type: range secondary 2
 *           
 * @author Ravi Hasija
 */
public class ChartAxisTypeReadHandler implements CSSCompoundValueReadHandler {

    private final ChartAxisDimensionReadHandler axisDimension;
    private final ChartAxisPositionReadHandler axisPosition;
    private final ChartAxisOrderReadHandler axisOrder;

    public ChartAxisTypeReadHandler() {
      axisDimension = new ChartAxisDimensionReadHandler();
      axisPosition = new ChartAxisPositionReadHandler();
      axisOrder    = new ChartAxisOrderReadHandler();
    }

    public StyleKey[] getAffectedKeys() {
      return new StyleKey[]{
          ChartStyleKeys.AXIS_DIMENSION,
          ChartStyleKeys.AXIS_POSITION,
          ChartStyleKeys.AXIS_ORDER
      };      
    }
    /**
     * Parses the LexicalUnit and returns a map of (StyleKey, CSSValue) pairs.
     *
     * @param unit
     * @return
     */
    public Map createValues(final LexicalUnit unit) {
      CSSValue dimension = null;
      LexicalUnit positionUnit = null;
      if (unit != null) {
        dimension = axisDimension.createValue(null, unit);
        if (dimension != null) {
          positionUnit = unit.getNextLexicalUnit();
        } 
      }  
      
      //System.out.println("" + dimension);
      LexicalUnit orderUnit = null;
      CSSValue position = null;
      if (positionUnit != null) {
        position = axisPosition.createValue(null, positionUnit);
        
        if (position != null) {
          orderUnit = positionUnit.getNextLexicalUnit();
        } 
      }

      //System.out.println("," + position);
      
      CSSValue order = null;
      if (orderUnit != null) {
        order = axisOrder.createValue(null, orderUnit);
      }
      
      //System.out.println("," + order);
      final Map<StyleKey, CSSValue> map;
      if (dimension != null && position != null && order != null) {
        map = new HashMap<StyleKey, CSSValue>();
        map.put(ChartStyleKeys.AXIS_DIMENSION, dimension);      
        map.put(ChartStyleKeys.AXIS_POSITION, position);
        map.put(ChartStyleKeys.AXIS_ORDER, order);
      } else {
        map = null;
      }
      return map;
    }
  }