package ui.engine.loggers;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.LayoutBase;
import ch.qos.logback.core.helpers.Transform;
import ch.qos.logback.core.pattern.Converter;

public class Layout_1 extends LayoutBase<ILoggingEvent> {

    @Override
    public String doLayout(ILoggingEvent event) {
        StringBuilder buf = new StringBuilder();
        boolean odd = true;

        String level = event.getLevel().toString().toLowerCase();
        buf.append(CoreConstants.LINE_SEPARATOR);
        buf.append("<tr class=\"");
        buf.append(level);
        if (odd) {
            buf.append(" odd\">");
        } else {
            buf.append(" even\">");
        }

        buf.append(CoreConstants.LINE_SEPARATOR);


        buf.append("</tr>");
        buf.append(CoreConstants.LINE_SEPARATOR);

        return buf.toString();
    }


}
