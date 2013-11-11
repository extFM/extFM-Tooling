/**
 * 
 */
package org.feature.model.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author <a href=mailto:info@juliaschroeter.de>Julia Schroeter</a>
 * 
 */
public final class DateUtil {

   public static String getFormattedCurrentTime() {
      Date d = new Date();
      SimpleDateFormat sdf = new SimpleDateFormat();
      sdf.applyPattern("yyyy'-'MM'-'dd'-'hhmmssSS");
      return sdf.format(d);
   }

}
