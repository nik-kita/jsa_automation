package ui.engine.loggers;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.LayoutBase;

public class MdFileLogger extends LayoutBase<ILoggingEvent> {

    @Override
    public String doLayout(ILoggingEvent e) {
        StringBuffer sb = new StringBuffer();
        if (e.getMarker() != null) {
            if (e.getMarker().contains("test name")) {
                sb.append(e.getMarker());
            } else if (e.getMarker().contains("test link")) {
                sb.append(e.getMarker());
            }
        } else {
            sb
                    .append("[")
                    .append(e.getTimeStamp())
                    .append("] [")
                    .append(e.getLevel())
                    .append("] ")
                    .append(e.getLoggerName())
                    .append(" ")
                    .append(e.getThreadName())
                    .append(" - ")
                    .append(e.getMessage())
                    .append("\n")
                    .append(e.getCallerData()[0]);
        }


        return sb.toString();
    }
}
